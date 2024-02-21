package app.tasty.service.imp;

import app.tasty.domain.entities.Recipe;
import app.tasty.domain.entities.User;
import app.tasty.repository.RecipeRepository;
import app.tasty.service.JwtService;
import app.tasty.service.RecipeService;
import app.tasty.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
@Component
public class RecipeServiceImpl implements RecipeService {
    private final RecipeRepository recipeRepository;
    private final JwtService jwtService;
    private final UserService userService;

    public RecipeServiceImpl(RecipeRepository recipeRepository, JwtService jwtService, UserService userService) {
        this.recipeRepository = recipeRepository;
        this.jwtService = jwtService;
        this.userService = userService;
    }

    @Override
    public List<Recipe> findAll() {
        return recipeRepository.findAll();
    }

    @Override
    public List<Recipe> findAllWithImages() {
        return recipeRepository.findAllWithImages();
    }

    @Override
    public Optional<Recipe> findById(Long aLong) {
        return recipeRepository.findById(aLong);
    }

    @Override
    public Recipe save(Recipe entityDTO) {
        return null;
    }

    @Override
    public Recipe saveRecipe(Recipe entityDTO, HttpServletRequest request) {

        final String authHeader = request.getHeader(HttpHeaders.AUTHORIZATION);
        final String refreshToken;
        final String userEmail;
        if (authHeader == null ||!authHeader.startsWith("Bearer ")) {
            return null;
        }
        refreshToken = authHeader.substring(7);
        userEmail = jwtService.extractUsername(refreshToken);
        System.out.println(userEmail + "sqdfqsdfqsdfqsdfqsdfqsdfqsdfqsdfqsdfqsdfsqdfqsdfqsdfqsdf");
        User user = userService.findByEmail(userEmail);
        entityDTO.setUser(user);
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
