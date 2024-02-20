package app.tasty.service;


import app.tasty.domain.entities.Image;
import app.tasty.domain.entities.Recipe;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.awt.*;
import java.io.IOException;
import java.util.List;

@Service
public interface ImageService extends CrudService<Image, Long>{



    java.util.List<Image> findImagesByImageUrls(List<String> imageUrls);

    void saveImage(String imageUrl, Integer integer);

    List<String> uploadImages(List<MultipartFile> files, Recipe recipe) throws IOException;
}
