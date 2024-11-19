package wow.grmr.domain.destination.presentation;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import wow.grmr.domain.destination.service.DestinationService;

@RestController
@RequestMapping("/api/v1/destination")
@RequiredArgsConstructor
public class DestinatiopnController {

    private final DestinationService destinationService;

//    @GetMapping("/journey/{journeyId}")
//    public ParticipationListResponse getParticipationList(@PathVariable("reservationId") Long reservationId) {
//        return participationService.getParticipationList(reservationId);
//    }
}
