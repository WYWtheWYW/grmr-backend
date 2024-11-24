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

    @GetMapping("/login")
    public void login(@RequestBody LoginRequest loginRequest, HttpSession session) {
        LoginResponse loginResponse = userService.authenticateUser(loginRequest);
        session.setAttribute("user", loginResponse);
    }

//    @GetMapping("/check/longinId")
//    public void checkLoginId(@RequestParam("longinId") String longinId) {
//
//    }

    @PostMapping("/register")
    public void signUp(@RequestBody RegisterRequest registerRequest) {
        userService.register(registerRequest);
    }

    @DeleteMapping("/delete")
    public void delete(HttpSession session) {
        LoginResponse loginResponse = (LoginResponse)session.getAttribute("user");
        userService.delete(loginResponse);
    }

    @PatchMapping("/update")
    public void update(HttpSession session) {
        LoginResponse loginResponse = (LoginResponse)session.getAttribute("user");
        userService.update(loginResponse);
    }

    @GetMapping("/logout")
    public void logout( HttpSession session) {
        session.invalidate();
    }

 }
