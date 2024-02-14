package app.tasty.domain.dto;

import app.tasty.domain.entities.Image;
import app.tasty.domain.entities.Recipe;
import app.tasty.domain.entities.User;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.*;

import java.util.List;

@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ImageDTO {
    private Long id;
    private String imageUrl;
}
