package wow.grmr.domain.destination.exception;

import wow.grmr.global.error.exception.ErrorCode;
import wow.grmr.global.error.exception.GRMRException;

public class DestinationNotFoundException extends GRMRException {

    public static final GRMRException EXCEPTION = new DestinationNotFoundException();

    private DestinationNotFoundException() {
        super(ErrorCode.DESTINATION_NOT_FOUND);
    }
}
