package wow.grmr.domain.attraction.presentation;


import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import wow.grmr.domain.attraction.presentation.dto.response.AttractionDto;
import wow.grmr.domain.attraction.service.AttractionService;
import wow.grmr.domain.user.presentation.dto.response.LoginResponse;
import wow.grmr.global.common.Area;

import java.util.List;


@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/attraction")
public class AttractionController {

    private final AttractionService attractionService;

    // 지역 코드가 들어 왔을 때 랜덤으로 명소를 주는 api
    @GetMapping("/random/{areaCode}")
    public List<AttractionDto> randomAttraction(@PathVariable Integer areaCode, HttpSession session) {
        LoginResponse loginResponse = (LoginResponse)session.getAttribute("user");
        return attractionService.getRandomAttractions(areaCode,loginResponse);
    }

    @GetMapping("/journey/{journeyId}")
    public List<AttractionDto> getJourneyAttraction(@PathVariable Long journeyId , HttpSession session) {
        LoginResponse loginResponse = (LoginResponse)session.getAttribute("user");
        return attractionService.getAttractionList(loginResponse,journeyId);
    }

}
