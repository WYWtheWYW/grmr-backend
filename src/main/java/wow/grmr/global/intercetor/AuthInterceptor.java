package wow.grmr.global.intercetor;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import wow.grmr.domain.user.presentation.dto.response.LoginResponse;
import wow.grmr.global.error.ErrorResponse;
import wow.grmr.global.error.exception.ErrorCode;

import java.io.IOException;

@Component
@RequiredArgsConstructor
@Slf4j
public class AuthInterceptor implements HandlerInterceptor {

    private final ObjectMapper objectMapper;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws
            Exception {
        HttpSession session = request.getSession(false);
        if (session == null || session.getAttribute("user") == null) {

            log.info("============== 세션이 없어요 ================");

            writeErrorResponse(
                    response,
                    ErrorCode.ESSENTIAL_CERTIFICATION,
                    request.getRequestURL().toString());

            return false;
        }

        LoginResponse loginResponse = (LoginResponse) session.getAttribute("user");

        log.info("userLoginID={}", loginResponse.getLoginId());
        log.info("requst url = {}", request.getRequestURL());
        return true;
    }

    private void writeErrorResponse(HttpServletResponse response, ErrorCode errorCode, String path) throws IOException {

        ErrorResponse errorResponse =
                new ErrorResponse(
                        errorCode.getStatus(), errorCode.getReason(), path);

        response.setStatus(errorCode.getStatus());
        response.setCharacterEncoding("UTF-8");
        response.setContentType(MediaType.APPLICATION_JSON_VALUE);
        response.getWriter().write(objectMapper.writeValueAsString(errorResponse));
    }
}
