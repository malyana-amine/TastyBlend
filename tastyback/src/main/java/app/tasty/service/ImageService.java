package app.tasty.service;


import app.tasty.domain.entities.Image;
import org.springframework.stereotype.Service;

import java.awt.*;

@Service
public interface ImageService extends CrudService<Image, Long>{

    void saveImage(String imageUrl);
}
