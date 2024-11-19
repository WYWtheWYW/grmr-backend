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
import wow.grmr.domain.destination.service.DestinationUtil;
import wow.grmr.domain.journey.domain.Journey;
import wow.grmr.domain.journey.domain.repository.JourneyRepository;
import wow.grmr.domain.journey.presentation.dto.request.CreateJourneyRequest;
import wow.grmr.domain.journey.presentation.dto.response.MyJourneyResponse;
import wow.grmr.domain.user.domain.User;
import wow.grmr.domain.user.presentation.dto.response.LoginResponse;
import wow.grmr.domain.user.service.UserService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
@Slf4j
public class JourneyService {

    private final JourneyRepository journeyRepository;
    private final DestinationUtil destinationUtil;
    private final UserService userService;

    @Transactional
    public void createJourney(LoginResponse loginUser, CreateJourneyRequest createJourneyRequest) {

        User user = userService.findUser(loginUser);

        System.out.println("user.getNickname() = " + user.getNickname());

        Journey journey = Journey.builder()
                .user(user)
                .title(createJourneyRequest.getTitle())
                .destinations(new ArrayList<>())
                .build();

        journeyRepository.save(journey);
        System.out.println("journey.getUser().getPassword() = " + journey.getUser().getPassword());
        destinationUtil.createDestination(journey, createJourneyRequest);
    }

//    public void getJourneys(LoginResponse loginUser) {
//
//        User user = userService.findUser(loginUser);
//
//        List<Journey> journeys = journeyRepository.findJourneys(user.getId());
//
//        System.out.println("journey.getUser().getPassword() = " + journey.getUser().getPassword());
//
//        destinationUtil.createDestination(journey, createJourneyRequest);
//    }

    @Transactional
    public List<MyJourneyResponse> getMyJourney(LoginResponse loginUser) {

        User user = userService.findUser(loginUser);
        List<Journey> journeys = journeyRepository.findByUserId(user.getId());
        return  journeys.stream()
                        .map(reservation -> new MyJourneyResponse(reservation.getId(),reservation.getTitle())).collect(Collectors.toList());
    }



}
