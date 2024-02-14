package app.tasty.service;

import app.tasty.domain.entities.Recipe;
import org.springframework.stereotype.Service;

@Service
public interface RecipeService extends CrudService<Recipe , Long>{
}
