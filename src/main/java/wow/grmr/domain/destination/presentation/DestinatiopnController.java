package wow.grmr.domain.destination.presentation;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import wow.grmr.domain.destination.service.DestinationService;

@RestController
@RequestMapping("/api/v1/destination")
@RequiredArgsConstructor
public class DestinatiopnController {

    private final DestinationService destinationService;

//    @PostMapping("/create/{reservationId}")
//    public void createParticipation(
//            @PathVariable("reservationId") Long reservationId,
//            @Valid @RequestBody CreateParticipationRequest createParticipationRequest) {
//        participationService.createParticipation(reservationId, createParticipationRequest);
//    }
//
//    @PatchMapping("/update/{reservationId}")
//    public void updateParticipation(
//            @PathVariable("reservationId") Long reservationId,
//            @Valid @RequestBody UpdateSeatPositionRequest updateSeatPositionRequest) {
//        participationService.updateSeatPosition(reservationId, updateSeatPositionRequest);
//    }
//
//    @DeleteMapping("/delete/{reservationId}")
//    public void deleteParticipation(@PathVariable("reservationId") Long reservationId) {
//        participationService.deleteParticipation(reservationId);
//    }
//
//    @GetMapping("/getParticipationList/{reservationId}")
//    public ParticipationListResponse getParticipationList(@PathVariable("reservationId") Long reservationId) {
//        return participationService.getParticipationList(reservationId);
//    }
}
