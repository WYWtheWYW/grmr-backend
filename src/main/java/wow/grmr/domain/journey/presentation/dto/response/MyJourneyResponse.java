package wow.grmr.domain.journey.presentation.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class MyJourneyResponse {

    private Long journeyId;
    private String title;
}
