package app.tasty.domain.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@NamedEntityGraph(
        name = "recipe-with-images",
        attributeNodes = @NamedAttributeNode("images")
)
public class Recipe {
    @Id
    @GeneratedValue
    private Integer id;

    @Column(length = 255)
    private String article;

    @Column(columnDefinition = "TEXT")
    private String preparationSteps;

    @Column(columnDefinition = "TEXT")
    private String ingredients;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonIgnore
    private User user;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "recipe")
    @JsonIgnore
    private List<Image> images;
}
