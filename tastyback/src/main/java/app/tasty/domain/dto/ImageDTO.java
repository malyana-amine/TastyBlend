package app.tasty.domain.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;
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
