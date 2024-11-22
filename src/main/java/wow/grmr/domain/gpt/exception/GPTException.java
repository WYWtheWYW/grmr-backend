package wow.grmr.domain.gpt.exception;

import wow.grmr.global.error.exception.ErrorCode;
import wow.grmr.global.error.exception.GRMRException;

public class GPTException extends GRMRException {
    public static final GRMRException EXCEPTION = new GPTException();
    private GPTException() {
        super(ErrorCode.INTERNAL_GPT_ERROR);
    }
}
