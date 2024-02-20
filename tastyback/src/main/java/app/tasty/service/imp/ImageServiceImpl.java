package app.tasty.service.imp;

import app.tasty.domain.entities.Image;
import app.tasty.repository.ImageRepository;
import app.tasty.service.ImageService;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
@Component
public class ImageServiceImpl implements ImageService {
    private final ImageRepository imageRepository;

    public ImageServiceImpl(ImageRepository imageRepository) {
        this.imageRepository = imageRepository;
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
    public void saveImage(String imageUrl) {
        Image imageEntity = new Image();
        imageEntity.setImageUrl(imageUrl);
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
