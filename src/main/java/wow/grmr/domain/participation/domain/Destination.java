package wow.grmr.domain.participation.domain;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import wow.grmr.domain.journey.domain.Journey;
import wow.grmr.domain.user.domain.User;
import wow.grmr.global.database.BaseEntity;

import static jakarta.persistence.FetchType.LAZY;
import static jakarta.persistence.GenerationType.IDENTITY;
import static lombok.AccessLevel.PROTECTED;

@Entity
@Getter
@NoArgsConstructor(access = PROTECTED)
public class Destination extends BaseEntity {

    @Id @GeneratedValue(strategy = IDENTITY)
    @Column(name = "destination")
    private Long id;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "journey_id")
    private Journey journey;

    @Builder
    public Destination(User user, Journey journey) {
        this.user = user;
        this.journey = journey;
        journey.getDestinations().add(this);
    }

    public static Destination createParticipation(User user, Journey journey) {
        return builder()
                .user(user)
                .journey(journey)
                .build();
    }
}
