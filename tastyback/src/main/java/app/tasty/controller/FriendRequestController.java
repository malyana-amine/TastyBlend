package app.tasty.controller;

import app.tasty.domain.dto.response.FriendReqDTO;
import app.tasty.domain.dto.response.RecipeDTO;
import app.tasty.domain.entities.FriendRequest;
import app.tasty.service.FriendRequestService;
import jakarta.servlet.http.HttpServletRequest;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/api/v1/Request")
public class FriendRequestController {

    private final FriendRequestService friendRequestService;
    ModelMapper modelMapper = new ModelMapper();



    public FriendRequestController(FriendRequestService friendRequestService) {
        this.friendRequestService = friendRequestService;
    }

    @PostMapping("/{id}")
    public void saveRecipe(@PathVariable Long id , HttpServletRequest request) {
        friendRequestService.saveReq(id,request);
    }

    @GetMapping("/all")
    public ResponseEntity<List<FriendReqDTO>> getAllRequests(HttpServletRequest request) {
        try {
            List<FriendRequest> friendRequest = friendRequestService.getAllRequestSender(request);
            List<FriendReqDTO> friendReqDTOS = friendRequest.stream()
                    .map(friendRequest1 -> modelMapper.map(friendRequest1, FriendReqDTO.class))
                    .collect(Collectors.toList());
            System.out.println(friendReqDTOS);
            System.out.println(friendRequest);
            return new ResponseEntity<>(friendReqDTOS, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/demande")
    public ResponseEntity<List<FriendReqDTO>> getAllDemonde(HttpServletRequest request) {
        try {
            List<FriendRequest> friendRequest = friendRequestService.getAllRequestReciver(request);
            List<FriendReqDTO> friendReqDTOS = friendRequest.stream()
                    .map(friendRequest1 -> modelMapper.map(friendRequest1, FriendReqDTO.class))
                    .collect(Collectors.toList());
            System.out.println(friendReqDTOS);
            System.out.println(friendRequest);
            return new ResponseEntity<>(friendReqDTOS, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @PutMapping("/accept/{requestId}")
    public FriendRequest acceptRequest(@PathVariable Long requestId,HttpServletRequest request) {
        friendRequestService.acceptRequest(requestId,request);
        return null;
    }
    @PutMapping("/reject/{requestId}")
    public FriendRequest rejectRequest(@PathVariable Long requestId, HttpServletRequest request) {
        friendRequestService.rejectRequest(requestId ,request);
        return null;
    }
}
