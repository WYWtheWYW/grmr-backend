package wow.grmr.domain.journey.service;


import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import wow.grmr.domain.journey.domain.repository.JourneyRepository;


@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
@Slf4j
public class JourneyService {

    private final JourneyRepository journeyRepository;
    //private final UserUtils userUtils;



}
