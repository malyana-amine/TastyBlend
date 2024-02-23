package app.tasty.service.imp;

import app.tasty.domain.dto.request.FriendRequestRequest;
import app.tasty.domain.entities.FriendRequest;
import app.tasty.domain.entities.User;
import app.tasty.domain.enums.RequestStatus;
import app.tasty.repository.FriendRequestRepository;
import app.tasty.service.FriendRequestService;
import app.tasty.service.JwtService;
import app.tasty.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
@Component
public class FriendRequestServiceImpl implements FriendRequestService {

    private final FriendRequestRepository friendRequestRepository;
    private final JwtService jwtService;
    private final UserService userService;
    ModelMapper modelMapper = new ModelMapper();
    FriendRequestRequest friendRequestRequest = new FriendRequestRequest();

    public FriendRequestServiceImpl(FriendRequestRepository friendRequestRepository, JwtService jwtService, UserService userService) {
        this.friendRequestRepository = friendRequestRepository;
        this.jwtService = jwtService;
        this.userService = userService;
    }

    @Override
    public List<FriendRequest> findAll() {
        return null;
    }

    @Override
    public Optional<FriendRequest> findById(Long aLong) {
        return Optional.empty();
    }

    @Override
    public FriendRequest save(FriendRequest entityDTO) {
        friendRequestRepository.save(entityDTO);
        return friendRequestRepository.save(entityDTO);
    }
    private boolean areAlreadyFriends(User user, User otherUser) {
        return friendRequestRepository.existsBySenderAndReceiverAndRequestStatus(
                user, otherUser, RequestStatus.ACCEPTED)
                || friendRequestRepository.existsBySenderAndReceiverAndRequestStatus(
                otherUser, user, RequestStatus.ACCEPTED);
    }

    @Override
    public FriendRequest saveReq(Long id , HttpServletRequest request){
        final String authHeader = request.getHeader(HttpHeaders.AUTHORIZATION);
        final String refreshToken;
        final String userEmail;
        if (authHeader == null ||!authHeader.startsWith("Bearer ")) {
            return null;
        }
        refreshToken = authHeader.substring(7);
        userEmail = jwtService.extractUsername(refreshToken);
        System.out.println(userEmail + "sqdfqsdfqsdfqsdfqsdfqsdfqsdfqsdfqsdfqsdfsqdfqsdfqsdfqsdf");
        User user = userService.findByEmail(userEmail);
        User user1 = userService.findById(id);
        if (areAlreadyFriends(user, user1)) {
            // Users are already friends, you can handle this case accordingly
            return null;
        }
        if (friendRequestRepository.existsBySenderAndReceiverAndRequestStatus(user, user1, RequestStatus.PENDING)) {
            // Friend request already exists, you can handle this case accordingly
            return null;
        }

        friendRequestRequest.setSender(user);
        friendRequestRequest.setReceiver(user1);
        friendRequestRequest.setRequestStatus(RequestStatus.PENDING);

        FriendRequest friendRequest = modelMapper.map(friendRequestRequest , FriendRequest.class);

        return friendRequestRepository.save(friendRequest);
    }

    @Override
    public FriendRequest update(FriendRequest entityDTO) {
        return null;
    }

    @Override
    public Optional<FriendRequest> delete(Long aLong) {
        return Optional.empty();
    }
}
