package wow.grmr.domain.user.domain;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import wow.grmr.domain.destination.domain.Destination;
import wow.grmr.domain.journey.domain.Journey;
import wow.grmr.global.database.BaseEntity;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static jakarta.persistence.GenerationType.IDENTITY;
import static lombok.AccessLevel.PROTECTED;

@Entity
@Getter
@NoArgsConstructor(access = PROTECTED)
public class User extends BaseEntity {

    @Id @GeneratedValue(strategy = IDENTITY)
    @Column(name = "user_id")
    private Long id;
    private String nickname;
    private String loginId;
    private String password;
    private String favoriteFood;
    private String hatePerson;
    private LocalDate birthday;

    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
    private List<Journey> journeyList = new ArrayList<>();

    @Builder
    public User(Long id, String nickname, String loginId, String password, String favoriteFood, String hatePerson, LocalDate birthday) {
        this.id = id;
        this.nickname = nickname;
        this.loginId = loginId;
        this.password = password;
        this.favoriteFood = favoriteFood;
        this.hatePerson = hatePerson;
        this.birthday = birthday;
    }
}
