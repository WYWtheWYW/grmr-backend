package wow.grmr.domain.destination.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import wow.grmr.domain.attraction.domain.Attraction;
import wow.grmr.domain.destination.domain.repository.DestinationRepository;
import wow.grmr.domain.journey.domain.Journey;
import wow.grmr.domain.journey.presentation.dto.request.CreateJourneyRequest;

import java.util.List;


public interface DestinationUtil {
    void createDestination(Journey journey, CreateJourneyRequest createJourneyRequest);
    List<Integer> getDestination(Long journeyId);

}