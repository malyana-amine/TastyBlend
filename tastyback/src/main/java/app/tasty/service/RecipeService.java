package app.tasty.service;

import app.tasty.domain.entities.Recipe;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Service;

@Service
public interface RecipeService extends CrudService<Recipe , Long>{
    Recipe saveRecipe(Recipe entityDTO, HttpServletRequest request);
}
