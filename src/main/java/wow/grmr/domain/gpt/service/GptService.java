package wow.grmr.domain.gpt.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import wow.grmr.domain.gpt.exception.GPTException;
import wow.grmr.domain.gpt.presentation.dto.response.ContentResponse;
import wow.grmr.domain.user.domain.User;
import wow.grmr.domain.user.presentation.dto.response.LoginResponse;
import wow.grmr.domain.user.service.UserService;

@Slf4j
@Service
@RequiredArgsConstructor
public class GptService {

    @Value("${openai.api.key}")
    private String apiKey;

    private final RestTemplate restTemplate;
    private final ObjectMapper objectMapper;
    private final UserService userService;

    public ContentResponse getGptResponse(LoginResponse loginResponse) {
        final String url = "https://api.openai.com/v1/chat/completions";

        User user = userService.findUser(loginResponse);

        String prompt = "너는 이 시대 최고의 점쟁이야. 네가 말하는 게 나에게 크게 의미가 있진 않아. 그냥 재미로 보는 거니까. " +
                "나는 " + user.getBirthday() +
                "에 태어났어. 오늘 피하면 좋을 상황들을 재미있게 말해줘. 점쟁이 말투로, 예를 들어 '접신 중............... 아기 동자님이 말하신다!' 같은 식으로 시작해 줘. 마지막으로 엄청 강한 말투로 반말로 해주고, 삐딱한 태도로 말해줘. 그리고 한 만디만 해";


        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer " + apiKey);
        headers.set("Content-Type", "application/json");

        String requestBody = String.format("{\"model\":\"gpt-3.5-turbo\",\"messages\":[{\"role\":\"user\",\"content\":\"%s\"}],\"max_tokens\":100}", prompt);

        HttpEntity<String> entity = new HttpEntity<>(requestBody, headers);

        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.POST, entity, String.class);

        try {
            JsonNode jsonNode = objectMapper.readTree(response.getBody());
            String content = jsonNode.path("choices").get(0).path("message").path("content").asText();
            return new ContentResponse(content);
        } catch (Exception g) {
            throw GPTException.EXCEPTION;
        }

    }

}
