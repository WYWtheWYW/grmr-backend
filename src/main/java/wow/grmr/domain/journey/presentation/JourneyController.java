package wow.grmr.domain.journey.presentation;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Slice;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;
import wow.grmr.domain.attraction.domain.Attraction;
import wow.grmr.domain.attraction.service.AttractionService;
import wow.grmr.domain.journey.domain.Journey;
import wow.grmr.domain.journey.presentation.dto.request.CreateJourneyRequest;
import wow.grmr.domain.journey.presentation.dto.response.MyJourneyResponse;
import wow.grmr.domain.journey.service.JourneyService;
import wow.grmr.domain.user.domain.User;
import wow.grmr.domain.user.presentation.dto.response.LoginResponse;
import wow.grmr.domain.user.service.UserService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/journey")
@RequiredArgsConstructor
public class JourneyController {

    private final JourneyService journeyService;

    @PostMapping("/create")
    public void createJourney(@RequestBody CreateJourneyRequest journeyRequest, HttpSession session) {
        LoginResponse user = (LoginResponse)session.getAttribute("user");
        journeyService.createJourney(user, journeyRequest);
    }

    @GetMapping("/my")
    public Slice<MyJourneyResponse> getJourney(
            @RequestParam(value = "page", defaultValue = "0") Integer page,
            @RequestParam(value = "size", defaultValue = "10") Integer size,
            HttpSession session) {
        LoginResponse loginUser = (LoginResponse)session.getAttribute("user");
        PageRequest pageRequest = PageRequest.of(page,size, Sort.Direction.DESC,"createdDate");
        return journeyService.getMyJourney(loginUser,pageRequest);
    }

    @DeleteMapping("/delete")
    public void deleteJourney(@RequestBody CreateJourneyRequest journeyRequest, HttpSession session) {
        LoginResponse user = (LoginResponse)session.getAttribute("user");
        journeyService.createJourney(user, journeyRequest);
    }

}
