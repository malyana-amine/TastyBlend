package app.tasty.service;

import app.tasty.domain.entities.FriendRequest;
import app.tasty.domain.entities.Image;
import app.tasty.domain.entities.User;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface FriendRequestService extends CrudService<FriendRequest, Long>{
    FriendRequest saveReq(Long id, HttpServletRequest request);

    List<FriendRequest> getAllRequestSender(HttpServletRequest request);

    List<FriendRequest> getAllRequestReciver(HttpServletRequest request);

    FriendRequest acceptRequest(Long requestId, HttpServletRequest request);

    List<User> getAcceptedFriends(HttpServletRequest request);

    FriendRequest rejectRequest(Long requestId , HttpServletRequest request);
}
