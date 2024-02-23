package app.tasty.service;

import app.tasty.domain.entities.FriendRequest;
import app.tasty.domain.entities.Image;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Service;

@Service
public interface FriendRequestService extends CrudService<FriendRequest, Long>{
    FriendRequest saveReq(Long id, HttpServletRequest request);
}
