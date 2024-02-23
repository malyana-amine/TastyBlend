package app.tasty.domain.dto.request;

import app.tasty.domain.entities.User;
import app.tasty.domain.enums.RequestStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FriendRequestRequest {
    private User sender;
    private User receiver;
    private RequestStatus requestStatus;
}
