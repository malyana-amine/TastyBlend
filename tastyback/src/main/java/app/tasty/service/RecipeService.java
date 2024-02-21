package app.tasty.service;

import app.tasty.domain.entities.Recipe;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface RecipeService extends CrudService<Recipe , Long>{
    List<Recipe> findAllWithImages();

    Recipe saveRecipe(Recipe entityDTO, HttpServletRequest request);
}
