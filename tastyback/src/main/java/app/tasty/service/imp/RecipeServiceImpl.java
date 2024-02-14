package app.tasty.service.imp;

import app.tasty.domain.entities.Recipe;
import app.tasty.repository.RecipeRepository;
import app.tasty.service.RecipeService;

import java.util.List;
import java.util.Optional;

public class RecipeServiceImpl implements RecipeService {
    private final RecipeRepository recipeRepository;

    public RecipeServiceImpl(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    @Override
    public List<Recipe> findAll() {
        return null;
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
        return recipeRepository.save(entityDTO);
    }

    @Override
    public Optional<Recipe> delete(Long aLong) {
        return Optional.empty();
    }
}
