package wow.grmr.domain.journey.service;


import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import wow.grmr.domain.attraction.domain.Attraction;
import wow.grmr.domain.attraction.domain.repository.AttractionRepository;
import wow.grmr.domain.journey.domain.repository.JourneyRepository;
import wow.grmr.domain.user.domain.User;

import java.util.List;


@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
@Slf4j
public class JourneyService {

    private final JourneyRepository journeyRepository;
    private final AttractionRepository attractionRepository;

    public void createJourney(User user, List<Attraction> attractionList) {
        attractionRepository.saveAll(attractionList);
    }

}
