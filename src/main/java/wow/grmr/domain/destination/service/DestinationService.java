package wow.grmr.domain.destination.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import wow.grmr.domain.attraction.domain.Attraction;
import wow.grmr.domain.destination.domain.Destination;
import wow.grmr.domain.destination.domain.repository.DestinationRepository;
import wow.grmr.domain.journey.domain.Journey;
import wow.grmr.domain.journey.presentation.dto.request.CreateJourneyRequest;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class DestinationService implements DestinationUtil{

    private final DestinationRepository destinationRepository;

    @Override
    public void createDestination(Journey journey, CreateJourneyRequest createJourneyRequest) {

        List<Integer> attractions = createJourneyRequest.getAttractions();

        for (Integer attractionId : attractions) {

            Destination destination = Destination.builder()
                    .journey(journey)
                    .user(journey.getUser())
                    .attractionId(attractionId)
                    .build();

            System.out.println("destination.getAttractionId() = " + destination.getAttractionId());

            destinationRepository.save(destination);
        }

    }

    @Override
    public List<Integer> getDestination(Long journeyId) {
        List<Destination> destinations = destinationRepository.findAllByJourneyId(journeyId);

        return destinations.stream()
                .map(Destination::getAttractionId)
                .toList();
    }
}