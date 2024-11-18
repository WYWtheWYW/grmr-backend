package wow.grmr.domain.attraction.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import wow.grmr.domain.attraction.domain.Attraction;

import java.util.List;
import java.util.Optional;

public interface AttractionRepository extends JpaRepository<Attraction, Long> {
//

    @Query(value = "SELECT * FROM attractions WHERE area_code = :areaCode ORDER BY RAND() LIMIT 3", nativeQuery = true)
    List<Attraction> findRandomAttractionByAreaCode(@Param("areaCode") Integer areaCode);

    //Boolean existsByImageUrl(String profileUrl);
}
