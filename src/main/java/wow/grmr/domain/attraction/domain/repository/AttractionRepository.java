package wow.grmr.domain.attraction.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import wow.grmr.domain.attraction.domain.Attraction;
import wow.grmr.domain.journey.domain.Journey;

import java.util.List;
import java.util.Optional;

public interface AttractionRepository extends JpaRepository<Attraction, Long> {
//

    @Query(value = "SELECT * FROM attractions WHERE area_code = :areaCode ORDER BY RAND() LIMIT 3", nativeQuery = true)
    List<Attraction> findRandomAttractionByAreaCode(@Param("areaCode") Integer areaCode);

    List<Attraction> findByNoIn(List<Integer> attractionIds);

//    @Query("select a from Destination d " +
//            "join Attraction a on d.attractionId = a.no " +
//            "where d.journey.id = :journeyId and d.user.id = :userId")
//    List<Attraction> findAttractionsByJourneyId(@Param("journeyId") Long journeyId,@Param("userId") Long userId);

    @Query("select a from Destination d " +
            "join Attraction a on d.attractionId = a.no " +
            "where d.journey.id = :journeyId and d.user.id = :userId")
    List<Attraction> findAttractionsByJourneyId(@Param("journeyId") Long journeyId,@Param("userId") Long userId);

}
