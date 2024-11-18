package wow.grmr.domain.participation.domain.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import wow.grmr.domain.participation.domain.Destination;

import java.util.List;
import java.util.Optional;

public interface DestinationRepository extends JpaRepository<Destination, Long> {

//    Participation findByUserAndReservation(User user, Reservation reservation);
//    boolean existsByReservationAndUser(Reservation reservation, User user);
//    List<Participation> findAllByReservation(Reservation reservation);
//
//    boolean existsByReservationAndSeatPosition(Reservation reservation, SeatPosition seatPosition);
//    boolean existsByUserAndReservation(User user, Reservation reservation);
//
//    Optional<Participation> findByReservationAndUser(Reservation reservation, User user);
//
//    List<Participation> findByUserId(Long userId);




}
