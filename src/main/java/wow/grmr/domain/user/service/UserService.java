package wow.grmr.domain.user.service;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import wow.grmr.domain.user.domain.User;
import wow.grmr.domain.user.domain.repository.UserRepository;
import wow.grmr.domain.user.exception.UserNotFoundException;
import wow.grmr.domain.user.presentation.dto.request.LoginRequest;
import wow.grmr.domain.user.presentation.dto.request.RegisterRequest;
import wow.grmr.domain.user.presentation.dto.response.LoginResponse;

import java.time.LocalDate;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    @Transactional
    public LoginResponse authenticateUser(LoginRequest loginRequest ) {
        User user = userRepository
                .findByLoginIdAndPassword(loginRequest.getLoginId(), loginRequest.getPassword())
                .orElseThrow(() -> UserNotFoundException.EXCEPTION);
        return new LoginResponse(user.getId(), user.getLoginId());
    }

    @Transactional
    public void register(RegisterRequest registerRequest) {

        User user =
                User.builder()
                        .loginId(registerRequest.getLoginId())
                        .nickname(registerRequest.getNickname())
                        .favoriteFood(registerRequest.getFavoriteFood())
                        .password(registerRequest.getPassword())
                        .hatePerson(registerRequest.getHatePerson())
                        .birthday(registerRequest.getBirthday())
                        .build();
        userRepository.save(user);
    }

    @Transactional
    public void delete(LoginResponse loginResponse) {

        User user = findUser(loginResponse);
        userRepository.delete(user);
    }

    @Transactional
    public void update(LoginResponse loginResponse) {

        User user = findUser(loginResponse);
        userRepository.delete(user);
    }

    public User findUser(LoginResponse loginResponse) {
        return userRepository.findById(loginResponse.getId())
                .orElseThrow(() -> UserNotFoundException.EXCEPTION);
    }


}
