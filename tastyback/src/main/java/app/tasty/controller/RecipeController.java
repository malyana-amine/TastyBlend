package app.tasty.controller;

import app.tasty.domain.dto.request.RecipeRequest;
import app.tasty.domain.dto.response.RecipeDTO;
import app.tasty.domain.entities.Image;
import app.tasty.domain.entities.Recipe;
import app.tasty.service.ImageService;
import app.tasty.service.RecipeService;
import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpServletRequest;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.UUID;
import java.util.ArrayList;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/recipe")
public class RecipeController {
    private final RecipeService recipeService;
    private final ImageService imageService;
    private final ServletContext servletContext;
    ModelMapper modelMapper = new ModelMapper();

    public RecipeController(RecipeService recipeService, ImageService imageService, ServletContext servletContext) {
        this.recipeService = recipeService;
        this.imageService = imageService;
        this.servletContext = servletContext;
    }

    @PostMapping(value = "/add", consumes = "multipart/form-data")
    public void saveRecipe(@RequestParam("imageUrl") List<MultipartFile> imageFiles,
                           @ModelAttribute RecipeRequest recipeDTO,
                           HttpServletRequest request) throws IOException {


        Recipe recipe = modelMapper.map(recipeDTO, Recipe.class);
        recipeService.saveRecipe(recipe, request);
        List<String> imageUrls = imageService.uploadImages(imageFiles , recipe);

        List<Image> images = imageService.findImagesByImageUrls(imageUrls);
        recipe.setImages(images);
    }
    @GetMapping("")
    public ResponseEntity<List<RecipeDTO>> getAllRecipes() {
        try {
            List<Recipe> recipes = recipeService.findAllWithImages(); // Use findAllWithImages instead of findAll
            List<RecipeDTO> recipeDTOS = recipes.stream()
                    .map(recipe -> modelMapper.map(recipe, RecipeDTO.class))
                    .collect(Collectors.toList());
            return new ResponseEntity<>(recipeDTOS, HttpStatus.OK);
        } catch (Exception e) {
            // Handle exceptions and return an appropriate response
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
