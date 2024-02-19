package app.tasty.controller;

import app.tasty.domain.entities.Image;
import app.tasty.service.ImageService;
import jakarta.servlet.ServletContext;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/image")
public class ImageController {

    private final ImageService imageService;
    private final ServletContext servletContext;

    public ImageController(ImageService imageService, ServletContext servletContext) {
        this.imageService = imageService;
        this.servletContext = servletContext;
    }


    @PostMapping("/save")
    public void saveImage(@RequestParam String imageUrl) {
        imageService.saveImage(imageUrl);
    }

    @PostMapping("/upload")
    public void uploadImage(@RequestParam("imageUrl") MultipartFile file) throws IOException {
        // Generate a unique filename for the image
        String fileName = UUID.randomUUID() + "_" + file.getOriginalFilename();

        // Get the real path of the web application's root directory
        String realPath = servletContext.getRealPath("/");

        // Construct the full file path within a subdirectory named "images" in the root directory
        String directoryPath = realPath + File.separator + "images";
        String filePath = directoryPath + File.separator + fileName;

        // Create the "images" directory if it doesn't exist
        File directory = new File(directoryPath);
        if (!directory.exists()) {
            directory.mkdirs();
        }

        // Create the File object for the image
        File imageFile = new File(filePath);

        // Transfer the uploaded file to the specified path
        file.transferTo(imageFile);

        // Save the image URL to the database (assuming imageService is properly autowired)
        imageService.saveImage(filePath);
    }

}
