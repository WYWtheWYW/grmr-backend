//package wow.grmr.domain.participation.presentation.dto.response;
//
//import lombok.Getter;
//import ohsoontaxi.backend.domain.participation.domain.Participation;
//
//import java.util.List;
//import java.util.stream.Collectors;
//
//@Getter
//public class ParticipationListResponse {
//
//    private boolean iParticipation;
//    private Long myParticipationId;
//    private List<ParticipationInfoDto> participationInfoList;
//
//    public ParticipationListResponse(boolean result, Long participationId, List<Participation> participationList) {
//        iParticipation = result;
//        myParticipationId = participationId;
//        participationInfoList = participationList.stream().map(participation -> new ParticipationInfoDto(participation)).collect(Collectors.toList());
//    }
//}
