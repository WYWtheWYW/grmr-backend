package wow.grmr.domain.destination.domain;

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

    private Integer attractionId;

    @Builder
    public Destination(User user, Journey journey, Integer attractionId) {
        journey.getDestinations().add(this);
        this.user = user;
        this.journey = journey;
        this.attractionId = attractionId;

    }
}
