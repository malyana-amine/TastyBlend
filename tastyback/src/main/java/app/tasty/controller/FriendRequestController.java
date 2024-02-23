package app.tasty.controller;

import app.tasty.domain.dto.request.RecipeRequest;
import app.tasty.service.FriendRequestService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/v1/Request")
public class FriendRequestController {

    private final FriendRequestService friendRequestService;

    public FriendRequestController(FriendRequestService friendRequestService) {
        this.friendRequestService = friendRequestService;
    }

    @PostMapping("/{id}")
    public void saveRecipe(@PathVariable Long id , HttpServletRequest request) {

        friendRequestService.saveReq(id,request);

    }

    }
