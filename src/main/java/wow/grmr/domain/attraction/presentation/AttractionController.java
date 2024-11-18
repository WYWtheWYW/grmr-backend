package wow.grmr.domain.attraction.presentation;


import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import wow.grmr.domain.attraction.domain.Attraction;
import wow.grmr.domain.attraction.service.AttractionService;

import java.util.List;


@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/attraction")
public class AttractionController {

    private final AttractionService attractionService;

    // 지역 코드가 들어 왔을 때 랜덤으로 명소를 주는 api
    @GetMapping("/random/{areaCode}")
    public List<Attraction> randomAttraction(@PathVariable Integer areaCode) {
        return attractionService.getRandomAttractions(areaCode);
    }

}