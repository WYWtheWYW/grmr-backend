package wow.grmr.domain.user.presentation;


import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.*;
import wow.grmr.domain.user.domain.User;
import wow.grmr.domain.user.presentation.dto.request.LoginRequest;
import wow.grmr.domain.user.presentation.dto.request.RegisterRequest;
import wow.grmr.domain.user.presentation.dto.response.LoginResponse;
import wow.grmr.domain.user.service.UserService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/user")
public class UserController {

    private final UserService userService;

    @PostMapping("/user/login")
    public void login(@RequestBody LoginRequest loginRequest, HttpSession session) {
        LoginResponse loginResponse = userService.authenticateUser(loginRequest);
        session.setAttribute("user", loginResponse);
    }

    @PostMapping("/user/register")
    public void signUp(@RequestBody RegisterRequest registerRequest) {
        userService.register(registerRequest);
    }


    @PostMapping("/logout")
    public void logout() {
    }

 }
