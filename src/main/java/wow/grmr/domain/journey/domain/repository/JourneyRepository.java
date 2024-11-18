package wow.grmr.domain.journey.domain.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import wow.grmr.domain.journey.domain.Journey;

public interface JourneyRepository extends JpaRepository<Journey, Long> {
//    @Override
//    Optional<Reservation> findById(Long id);
//
//    Slice<Reservation> findSliceByOrderByLastModifyDateDesc(Pageable pageable);
//
//    List<Reservation> findByDepartureDateBefore(LocalDateTime currentDate);
//
//    List<Reservation> findTop5ByOrderByIdDesc();
//
//    @Query("select distinct r from Journey r"+
//            " join fetch r.participations p"+
//            " where p.user.id = :userId order by r.lastModifyDate desc")
//    List<Reservation> findParticipatedReservation(@Param("userId") Long userId);
//
//    @Query("select distinct r from Journey r"+
//            " where r.user.id = :userId order by r.lastModifyDate desc")
//    List<Reservation> findReservedByMe(@Param("userId") Long userId);

}
