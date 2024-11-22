package wow.grmr.domain.user.presentation.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Getter
@NoArgsConstructor
public class RegisterRequest {

    private String loginId;
    private String password;
    private String nickname;
    private String favoriteFood;
    private String hatePerson;
    private LocalDate birthday;
}
