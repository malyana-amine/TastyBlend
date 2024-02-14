package app.tasty.domain.dto;

import app.tasty.domain.entities.Image;
import app.tasty.domain.entities.User;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.CascadeType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
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
    private User user;
    private List<Image> images;
}
