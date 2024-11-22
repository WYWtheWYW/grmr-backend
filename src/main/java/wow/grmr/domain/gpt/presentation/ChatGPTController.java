package wow.grmr.domain.gpt.presentation;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import wow.grmr.domain.gpt.presentation.dto.response.ContentResponse;
import wow.grmr.domain.gpt.service.GptService;
import wow.grmr.domain.user.presentation.dto.response.LoginResponse;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("api/v1/chat-gpt")
public class ChatGPTController {

    private final GptService gptService;

    @GetMapping("/ask")
    public ContentResponse askGpt(HttpSession session) {
        LoginResponse loginResponse = (LoginResponse)session.getAttribute("user");
        return gptService.getGptResponse(loginResponse);
    }
}
