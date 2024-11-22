package wow.grmr.domain.journey.domain;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import wow.grmr.domain.destination.domain.Destination;
import wow.grmr.domain.user.domain.User;
import wow.grmr.global.database.BaseEntity;

import java.util.ArrayList;
import java.util.List;

import static jakarta.persistence.FetchType.LAZY;
import static jakarta.persistence.GenerationType.IDENTITY;
import static lombok.AccessLevel.PROTECTED;

@Entity
@Getter
@NoArgsConstructor(access = PROTECTED)
public class Journey extends BaseEntity {

    @Id @GeneratedValue(strategy = IDENTITY)
    @Column(name = "journey_id")
    private Long id;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(mappedBy = "journey",cascade = CascadeType.ALL)
    private List<Destination> destinations = new ArrayList<>();


    private String title;

    @Builder
    public Journey(Long id, User user, List<Destination> destinations, String title) {
        this.id = id;
        this.user = user;
        this.destinations = destinations;
        this.title = title;
    }

}
