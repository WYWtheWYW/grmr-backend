package wow.grmr.domain.journey.presentation.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CreateJourneyRequest {

    private String title;
    private List<Integer> attractions;

}
