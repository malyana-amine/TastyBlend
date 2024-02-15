package app.tasty.controller;

import app.tasty.domain.entities.Recipe;
import app.tasty.service.RecipeService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/recipe")
public class RecipeController {
    private final RecipeService recipeService;

    public RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @PostMapping("/add")
    public void saveRecipe(@RequestBody Recipe recipe, HttpServletRequest request) {
        recipeService.saveRecipe(recipe, request);
    }
}
