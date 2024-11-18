package wow.grmr.domain.journey.exception;

import wow.grmr.global.error.exception.ErrorCode;
import wow.grmr.global.error.exception.GRMRException;

public class JourneyNotFoundException extends GRMRException {
    public static final GRMRException EXCEPTION = new JourneyNotFoundException();
    private JourneyNotFoundException() {
        super(ErrorCode.JOURNEY_NOT_FOUND);
    }
}
