package wow.grmr.domain.attraction.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import wow.grmr.domain.attraction.domain.Attraction;
import wow.grmr.domain.attraction.domain.repository.AttractionRepository;
import wow.grmr.domain.attraction.presentation.dto.response.AttractionDto;
import wow.grmr.domain.destination.service.DestinationUtil;
import wow.grmr.domain.journey.presentation.dto.response.MyJourneyResponse;
import wow.grmr.domain.user.domain.User;
import wow.grmr.domain.user.presentation.dto.response.LoginResponse;
import wow.grmr.domain.user.service.UserService;
import wow.grmr.global.common.Area;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class AttractionService implements AttractionUtils {

    private final AttractionRepository attractionRepository;
    private final UserService userService;

    @Override
    public List<AttractionDto> getRandomAttractions(Integer areaCode ,LoginResponse loginResponse) {

        User user = userService.findUser(loginResponse);

        List<Attraction> attraction = attractionRepository.findRandomAttractionByAreaCode(areaCode);

        return attraction.stream().map(att -> new AttractionDto(
                user.getNickname(),
                att.getNo(),
                att.getTitle(),
                att.getContentTypeId(),
                att.getAreaCode(),
                att.getFirstImage1(),
                att.getLatitude(),
                att.getLongitude(),
                att.getAddr1())).collect(Collectors.toList());
    }

    public List<AttractionDto> getAttractionList(LoginResponse loginResponse, Long journeyId) {

        User user = userService.findUser(loginResponse);
        List<Attraction> attraction = attractionRepository.findAttractionsByJourneyId(journeyId,loginResponse.getId());

        return attraction.stream().map(att -> new AttractionDto(
                user.getNickname(), 
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
