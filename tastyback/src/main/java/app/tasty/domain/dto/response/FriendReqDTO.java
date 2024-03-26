package app.tasty.domain.dto.response;

import app.tasty.domain.entities.User;
import app.tasty.domain.enums.RequestStatus;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.*;

@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class FriendReqDTO {
    private Long id;
    private UserDTO sender;
    private UserDTO receiver;
    private RequestStatus requestStatus;
}
