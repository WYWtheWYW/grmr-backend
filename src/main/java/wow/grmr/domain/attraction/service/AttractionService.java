package wow.grmr.domain.attraction.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import wow.grmr.domain.attraction.domain.Attraction;
import wow.grmr.domain.attraction.domain.repository.AttractionRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class AttractionService implements AttractionUtils {

    private final AttractionRepository attractionRepository;

    @Override
    public List<Attraction> getRandomAttractions(Integer areaCode) {
        return attractionRepository.findRandomAttractionByAreaCode(areaCode);
    }

}
