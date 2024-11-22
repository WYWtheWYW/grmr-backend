package wow.grmr.domain.destination.domain.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import wow.grmr.domain.destination.domain.Destination;

import java.util.List;

public interface DestinationRepository extends JpaRepository<Destination, Long> {

        List<Destination> findAllByJourneyId(Long journeyId);
}
