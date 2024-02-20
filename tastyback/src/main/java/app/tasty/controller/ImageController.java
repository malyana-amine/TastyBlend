package app.tasty.controller;

import app.tasty.domain.entities.Image;
import app.tasty.service.ImageService;
import jakarta.servlet.ServletContext;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;
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





}
