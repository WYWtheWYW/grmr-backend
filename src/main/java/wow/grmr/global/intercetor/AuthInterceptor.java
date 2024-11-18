package wow.grmr.global.intercetor;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import wow.grmr.global.error.ErrorResponse;
import wow.grmr.global.error.exception.ErrorCode;

import java.io.IOException;

@Component
@RequiredArgsConstructor
public class AuthInterceptor implements HandlerInterceptor {

    private final ObjectMapper objectMapper;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws
            Exception {
        HttpSession session = request.getSession(false);
        if (session == null || session.getAttribute("user") == null) {

            writeErrorResponse(
                    response,
                    ErrorCode.ESSENTIAL_CERTIFICATION,
                    request.getRequestURL().toString());

            return false;
        }
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
