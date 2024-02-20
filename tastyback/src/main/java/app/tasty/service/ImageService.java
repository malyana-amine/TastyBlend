package app.tasty.service;


import app.tasty.domain.entities.Image;
import org.springframework.stereotype.Service;

import java.awt.*;
import java.util.List;

@Service
public interface ImageService extends CrudService<Image, Long>{



    java.util.List<Image> findImagesByImageUrls(List<String> imageUrls);

    void saveImage(String imageUrl, Integer integer);
}
