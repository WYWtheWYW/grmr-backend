package wow.grmr.global.error.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class GRMRException extends RuntimeException{

    private ErrorCode errorCode;
}
