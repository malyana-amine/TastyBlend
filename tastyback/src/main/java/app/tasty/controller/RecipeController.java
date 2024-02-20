package app.tasty.controller;

import app.tasty.domain.entities.Image;
import app.tasty.domain.entities.Recipe;
import app.tasty.service.ImageService;
import app.tasty.service.RecipeService;
import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpServletRequest;
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

    public RecipeController(RecipeService recipeService, ImageService imageService, ServletContext servletContext) {
        this.recipeService = recipeService;
        this.imageService = imageService;
        this.servletContext = servletContext;
    }

    @PostMapping(value = "/add", consumes = "multipart/form-data")
    public void saveRecipe(@RequestParam("imageUrl") List<MultipartFile> imageFiles,
                           @ModelAttribute Recipe recipe,
                           HttpServletRequest request) throws IOException {
        // Your existing code to upload images and save the recipe
        recipeService.saveRecipe(recipe, request);
        List<String> imageUrls = uploadImages(imageFiles , recipe);

        // Set the image URLs in the recipe entity
        List<Image> images = imageService.findImagesByImageUrls(imageUrls);
        recipe.setImages(images);

        // Save the recipe (assuming recipeService is properly autowired)

    }



    private List<String> uploadImages(List<MultipartFile> files, Recipe recipe) throws IOException {
        // Get the real path of the web application's root directory
        String realPath = servletContext.getRealPath("/");

        // Construct the full file path within a subdirectory named "images" in the root directory
        String directoryPath = realPath + File.separator + "images";

        // Create the "images" directory if it doesn't exist
        File directory = new File(directoryPath);
        if (!directory.exists()) {
            directory.mkdirs();
        }

        // List to store image URLs
        List<String> imageUrls = new ArrayList<>();

        for (MultipartFile file : files) {
            // Generate a unique filename for each image
            String fileName = UUID.randomUUID() + "_" + file.getOriginalFilename();
            String filePath = directoryPath + File.separator + fileName;

            // Create the File object for the image
            File imageFile = new File(filePath);

            // Transfer the uploaded file to the specified path
            file.transferTo(imageFile);

            // Save the image URL to the list
            imageUrls.add(filePath);

            Integer id = recipe.getId();
            System.out.println(id);

            // Save the image URL to the database (assuming imageService is properly autowired)
            imageService.saveImage(filePath,id);
        }

        return imageUrls;
    }
}
