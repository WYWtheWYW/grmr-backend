package wow.grmr.global.api.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class UserInfoToOauthDto {
    private String email;
    private String id;
}
