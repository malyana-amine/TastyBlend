package app.tasty.service.imp;

import app.tasty.domain.entities.Image;
import app.tasty.domain.entities.Recipe;
import app.tasty.repository.ImageRepository;
import app.tasty.repository.RecipeRepository;
import app.tasty.service.ImageService;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
@Component
public class ImageServiceImpl implements ImageService {
    private final ImageRepository imageRepository;
    private final RecipeRepository recipeRepository;


    public ImageServiceImpl(ImageRepository imageRepository, RecipeRepository recipeRepository) {
        this.imageRepository = imageRepository;
        this.recipeRepository = recipeRepository;
    }

    @Override
    public List<Image> findAll() {
        return null;
    }

    @Override
    public Optional<Image> findById(Long aLong) {
        return Optional.empty();
    }

    @Override
    public List<Image> findImagesByImageUrls(List<String> imageUrls) {
        return imageRepository.findByImageUrlIn(imageUrls);
    }
    @Override
    public void saveImage(String imageUrl , Integer id) {
        Image imageEntity = new Image();
        imageEntity.setImageUrl(imageUrl);
        Optional<Recipe> recipe = recipeRepository.findById(Long.valueOf(id));
        imageEntity.setRecipe(recipe.get());
        imageRepository.save(imageEntity);
    }

    @Override
    public Image save(Image entityDTO) {
        return null;
    }

    @Override
    public Image update(Image entityDTO) {
        return null;
    }

    @Override
    public Optional<Image> delete(Long aLong) {
        return Optional.empty();
    }
}
