package wow.grmr.domain.destination.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import wow.grmr.domain.destination.domain.repository.DestinationRepository;

@Slf4j
@Service
@RequiredArgsConstructor
@Transactional
public class DestinationService{

    private final DestinationRepository destinationRepository;


}