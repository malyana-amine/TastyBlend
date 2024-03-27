package app.tasty.repository;

import app.tasty.domain.entities.FriendRequest;
import app.tasty.domain.entities.User;
import app.tasty.domain.enums.RequestStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FriendRequestRepository extends JpaRepository<FriendRequest, Long> {
    boolean existsBySenderAndReceiverAndRequestStatus(User user, User user1, RequestStatus requestStatus);

    List<FriendRequest> findAllBySenderAndRequestStatus(User receiver, RequestStatus status);

    List<FriendRequest> findAllByReceiverAndRequestStatus(User user, RequestStatus requestStatus);

    List<FriendRequest> findAllBySenderAndRequestStatusOrReceiverAndRequestStatus(User user, RequestStatus requestStatus, User user1, RequestStatus requestStatus1);
}
