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
    private final AttractionService attractionService;


    // 여정을 생성하는 것


    // 그대로 줘
    @PostMapping("/create")
    public void createJourney(@RequestBody CreateJourneyRequest journeyRequest, HttpSession session) {

        LoginResponse user = (LoginResponse)session.getAttribute("user");
        journeyService.createJourney(user, journeyRequest);
    }

    @GetMapping("/my")
    public List<MyJourneyResponse> getJourney(HttpSession session) {
        LoginResponse loginUser = (LoginResponse)session.getAttribute("user");
        return journeyService.getMyJourney(loginUser);
    }



//    @Operation(summary = "방 생성")
//    @PostMapping("/create")
//    public ReservationResponse createReservation(
//            @Valid @RequestBody CreateReservationRequest createReservationRequest) {
//        return reservationService.createReservation(createReservationRequest);
//    }
//
//    @Operation(summary = "방 삭제")
//    @DeleteMapping("/{id}")
//    public void deleteGroup(@Parameter(description = "방 Id", in = PATH)
//                            @PathVariable("id") Long reservationId) {
//        reservationService.deleteReservation(reservationId);
//    }
//
//    @Operation(summary = "방 수정")
//    @PatchMapping("/{id}")
//    public ReservationResponse updateReservation(
//            @Parameter(description = "방 Id", in = PATH)
//            @PathVariable("id") Long reservationId,
//            @Valid @RequestBody UpdateReservationRequest updateReservationRequest) {
//
//        return reservationService.updateReservation(reservationId, updateReservationRequest);
//    }
//
//    // 방 상세조회
//    @Operation(summary = "방 상세 조회")
//    @GetMapping("/{id}")
//    public ReservationResponse getReservationDetail(
//            @Parameter(description = "방 Id", in = PATH)
//            @PathVariable("id") Long reservationId) {
//        return reservationService.getReservationDetailById(reservationId);
//    }
//
//    @Operation(summary = "방 리스트 조회")
//    @GetMapping("/list")
//    @Parameters({
//            @Parameter(name = "page", description = "Page number", example = "0", required = false),
//            @Parameter(name = "size", description = "Page size", example = "10", required = false)
//    })
//    public Slice<ReservationBriefInfoDto> getReservations(
//            @RequestParam(value = "page", defaultValue = "0") Integer page,
//            @RequestParam(value = "size", defaultValue = "10") Integer size) {
//
//        PageRequest pageRequest = PageRequest.of(page,size, Sort.Direction.DESC,"createdDate");
//        return reservationService.findAllReservation(pageRequest);
//    }
//
//    @Operation(summary = "생성한 방 조회")
//    @GetMapping("/my")
//    public List<ReservationBriefInfoDto> getReservedByMe() {
//
//        return reservationService.reservedByMe();
//    }
//


//
//    @Operation(summary = "검색")
//    @GetMapping("/search")
//    @Parameters({
//            @Parameter(name = "word", description = "word", example = "text"),
//            @Parameter(name = "page", description = "Page number", example = "0", required = false),
//            @Parameter(name = "size", description = "Page size", example = "10", required = false)
//    })
//    public Slice<ReservationBriefInfoDto> searchReservation(
//            @RequestParam(value = "word") String word,
//            @RequestParam(value = "page", defaultValue = "0") Integer page,
//            @RequestParam(value = "size", defaultValue = "10") Integer size) {
//
//        PageRequest pageRequest = PageRequest.of(page, size);
//
//        return reservationService.search(word,pageRequest);
//    }
//
//    @Operation(summary = "키워드 검색")
//    @GetMapping("/search/keyword")
//    @Parameters({
//            @Parameter(name = "word", description = "word", example = "text"),
//            @Parameter(name = "page", description = "Page number", example = "0", required = false),
//            @Parameter(name = "size", description = "Page size", example = "10", required = false)
//    })
//    public Slice<KeywordDto> searchKeyword(
//            @RequestParam(value = "word") String word,
//            @RequestParam(value = "page", defaultValue = "0") Integer page,
//            @RequestParam(value = "size", defaultValue = "10") Integer size) {
//
//        PageRequest pageRequest = PageRequest.of(page, size);
//
//        return reservationService.getKeyword(word,pageRequest);
//    }
//
//    @Operation(summary = "검색어 추천")
//    @GetMapping("/search/recommend")
//    public List<KeywordDto> recommendKeyword() {
//
//        return reservationService.getRecommendWord();
//    }
//
//    @Operation(summary = "채팅방 조회")
//    @GetMapping("/chat/room")
//    public List<ChatRoomBriefInfoDto> getChatRoom(){
//        return reservationService.getChatRoom();
//    }
//
//    @GetMapping("/")
//    public void healthCheck(){
//
//    }

}
