package app.tasty.domain.dto.response;

import app.tasty.domain.entities.Image;
import app.tasty.domain.entities.User;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import java.util.List;

@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RecipeDTO {
    private Integer id;
    private String article;
    private String preparationSteps;
    private String ingredients;
    private UserDTO user;
    private List<ImageDTO> images; // Use ImageDTO instead of Image
}
