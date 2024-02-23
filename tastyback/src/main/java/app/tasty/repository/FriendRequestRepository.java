package app.tasty.repository;

import app.tasty.domain.entities.FriendRequest;
import app.tasty.domain.entities.User;
import app.tasty.domain.enums.RequestStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FriendRequestRepository extends JpaRepository<FriendRequest, Long> {
    boolean existsBySenderAndReceiverAndRequestStatus(User user, User user1, RequestStatus requestStatus);
}
