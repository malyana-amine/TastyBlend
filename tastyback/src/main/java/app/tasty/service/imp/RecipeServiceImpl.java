package app.tasty.service.imp;

import app.tasty.domain.entities.Recipe;
import app.tasty.repository.RecipeRepository;
import app.tasty.service.RecipeService;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
@Component
public class RecipeServiceImpl implements RecipeService {
    private final RecipeRepository recipeRepository;

    public RecipeServiceImpl(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    @Override
    public List<Recipe> findAll() {
        return recipeRepository.findAll();
    }

    @Override
    public Optional<Recipe> findById(Long aLong) {
        return recipeRepository.findById(aLong);
    }

    @Override
    public Recipe save(Recipe entityDTO) {
        return recipeRepository.save(entityDTO);
    }

    @Override
    public Recipe update(Recipe entityDTO) {
        // Assuming you don't have a specific update method, use save for updating
        return recipeRepository.save(entityDTO);
    }

    @Override
    public Optional<Recipe> delete(Long aLong) {
        Optional<Recipe> recipeOptional = recipeRepository.findById(aLong);
        if (recipeOptional.isPresent()) {
            recipeRepository.delete(recipeOptional.get());
        }
        return recipeOptional;
    }
}
