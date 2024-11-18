package wow.grmr.domain.user.exception;

import wow.grmr.global.error.exception.ErrorCode;
import wow.grmr.global.error.exception.GRMRException;

public class UserNotFoundException extends GRMRException {

    public static final GRMRException EXCEPTION = new UserNotFoundException();
    private UserNotFoundException() {
        super(ErrorCode.USER_NOT_FOUND);
    }
}
