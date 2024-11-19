package wow.grmr.domain.attraction.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import wow.grmr.domain.attraction.domain.Attraction;
import wow.grmr.domain.attraction.domain.repository.AttractionRepository;
import wow.grmr.domain.attraction.presentation.dto.response.AttractionDto;
import wow.grmr.domain.destination.service.DestinationUtil;
import wow.grmr.domain.journey.presentation.dto.response.MyJourneyResponse;
import wow.grmr.domain.user.presentation.dto.response.LoginResponse;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class AttractionService implements AttractionUtils {

    private final AttractionRepository attractionRepository;
    private final DestinationUtil destinationUtil;

    @Override
    public List<AttractionDto> getRandomAttractions(Integer areaCode) {
        List<Attraction> attraction = attractionRepository.findRandomAttractionByAreaCode(areaCode);

        return attraction.stream().map(att -> new AttractionDto(
                att.getNo(),
                att.getTitle(),
                att.getContentTypeId(),
                att.getAreaCode(),
                att.getFirstImage1(),
                att.getLatitude(),
                att.getLongitude(),
                att.getAddr1())).collect(Collectors.toList());
    }

    public List<AttractionDto> getAttractionList(Long journeyId) {

        List<Integer> attractionId = destinationUtil.getDestination(journeyId);

        for (Integer i : attractionId) {
            System.out.println("i = " + i);
        }

        System.out.println(attractionId.size());
        List<Attraction> attraction = attractionRepository.findByNoIn(attractionId);

        System.out.println("attraction = " + attraction.size());

        return attraction.stream().map(att -> new AttractionDto(
                att.getNo(),
                att.getTitle(),
                att.getContentTypeId(),
                att.getAreaCode(),
                att.getFirstImage1(),
                att.getLatitude(),
                att.getLongitude(),
                att.getAddr1())).collect(Collectors.toList());
    }

    public List<AttractionDto> getAttractionList2(LoginResponse loginResponse, Long journeyId) {


        List<Attraction> attraction = attractionRepository.findAttractionsByJourneyId(journeyId,loginResponse.getId());

        return attraction.stream().map(att -> new AttractionDto(
                att.getNo(),
                att.getTitle(),
                att.getContentTypeId(),
                att.getAreaCode(),
                att.getFirstImage1(),
                att.getLatitude(),
                att.getLongitude(),
                att.getAddr1())).collect(Collectors.toList());
    }

}
