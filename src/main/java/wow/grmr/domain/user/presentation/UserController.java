package wow.grmr.domain.user.presentation;


import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import wow.grmr.domain.user.domain.User;
import wow.grmr.domain.user.presentation.dto.request.LoginRequest;
import wow.grmr.domain.user.presentation.dto.request.RegisterRequest;
import wow.grmr.domain.user.presentation.dto.response.LoginResponse;
import wow.grmr.domain.user.service.UserService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/user")
@Slf4j
public class UserController {

    private final UserService userService;

    @PostMapping("/login")
    public void login(@RequestBody LoginRequest loginRequest, HttpSession session) {

        log.info("loginuser = {}", loginRequest.getLoginId());
        log.info("loginuserPw = {}", loginRequest.getPassword());
        LoginResponse loginResponse = userService.authenticateUser(loginRequest);
        session.setAttribute("user", loginResponse);
        log.info("se={}",session.getId());
    }
    @PostMapping("/register")
    public void signUp(@RequestBody RegisterRequest registerRequest) {
        log.info("======= 제발 들어와줘 ======== ");
        log.info("test={}",registerRequest.getNickname());
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
