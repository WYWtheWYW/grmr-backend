//package wow.grmr.domain.journey.presentation.dto.request;
//
//import jakarta.validation.constraints.Future;
//import jakarta.validation.constraints.NotBlank;
//import jakarta.validation.constraints.Size;
//import lombok.AllArgsConstructor;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//import ohsoontaxi.backend.domain.reservation.service.dto.UpdateReservationDto;
//
//import java.time.LocalDateTime;
//
//@Getter
//@AllArgsConstructor
//@NoArgsConstructor
//public class UpdateReservationRequest {
//
//    @NotBlank
//    @Size(min = 1, max = 18)
//    private String title;
//
//    @NotBlank
//    private String startPoint;
//
//    @NotBlank
//    private String destination;
//
//    @Future
//    private LocalDateTime departureDate;
//
//    private Double startLatitude;
//
//    private Double startLongitude;
//
//    private Double destinationLatitude;
//
//    private Double destinationLongitude;
//
//    public UpdateReservationDto toUpdateReservationDto() {
//        return new UpdateReservationDto(
//                title,
//                startPoint,
//                destination,
//                departureDate,
//                startLatitude,
//                startLongitude,
//                destinationLatitude,
//                destinationLongitude);
//    }
//}
