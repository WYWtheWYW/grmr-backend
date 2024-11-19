package wow.grmr.domain.journey.domain.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import wow.grmr.domain.journey.domain.Journey;
import wow.grmr.domain.user.domain.User;

import java.util.List;

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
    @Query("select distinct j from Journey j"+
            " join fetch j.destinations d"+
            " where d.user.id = :userId order by j.lastModifyDate desc")
    List<Journey> findJourneys(@Param("userId") Long userId);

    List<Journey> findByUserId(Long userId);
//
//    @Query("select distinct r from Journey r"+
//            " where r.user.id = :userId order by r.lastModifyDate desc")
//    List<Reservation> findReservedByMe(@Param("userId") Long userId);

}
