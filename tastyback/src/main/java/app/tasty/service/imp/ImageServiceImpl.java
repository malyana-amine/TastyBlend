package app.tasty.service.imp;

import app.tasty.domain.entities.Image;
import app.tasty.domain.entities.Recipe;
import app.tasty.repository.ImageRepository;
import app.tasty.repository.RecipeRepository;
import app.tasty.service.ImageService;
import jakarta.servlet.ServletContext;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Component
public class ImageServiceImpl implements ImageService {
    private final ImageRepository imageRepository;
    private final RecipeRepository recipeRepository;
    private final ServletContext servletContext;


    public ImageServiceImpl(ImageRepository imageRepository, RecipeRepository recipeRepository, ServletContext servletContext) {
        this.imageRepository = imageRepository;
        this.recipeRepository = recipeRepository;
        this.servletContext = servletContext;
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
    public List<String> uploadImages(List<MultipartFile> files, Recipe recipe) throws IOException {
        // Get the root directory of your project
        String rootDirectory = System.getProperty("user.dir");

        // Construct the directory path relative to the root directory
        String directoryPath = rootDirectory + File.separator + "images";

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

            System.out.println("fqsdfsdfqsdfqsfqsdf");
            System.out.println(imageFile);
            System.out.println("fqsdfsdfqsdfqsfqsdf");

            // Transfer the uploaded file to the specified path
            file.transferTo(imageFile);

            // Save the relative image path to the list
            String relativePath = filePath.substring(rootDirectory.length() + 1);
            imageUrls.add(relativePath);

            System.out.println("fqsdfsdfqsdfqsfqsdf");
            System.out.println(relativePath);
            System.out.println("fqsdfsdfqsdfqsfqsdf");

            Integer id = recipe.getId();
            System.out.println(id);

            // Save the image URL to the database (assuming imageService is properly autowired)
            this.saveImage(relativePath, id);
        }

        return imageUrls;
    }
    @Override
    public Optional<Image> delete(Long aLong) {
        return Optional.empty();
    }
}
