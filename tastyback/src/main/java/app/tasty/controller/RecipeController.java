package app.tasty.controller;

import app.tasty.domain.dto.request.RecipeRequest;
import app.tasty.domain.entities.Image;
import app.tasty.domain.entities.Recipe;
import app.tasty.service.ImageService;
import app.tasty.service.RecipeService;
import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpServletRequest;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;
import java.util.ArrayList;

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

}
