package wow.grmr.domain.gpt.presentation.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ContentRequest {

    private static final String ADDITIONAL_TEXT = "너는 이시대 최고의 점쟁이야 너가 말하는 것이 나에게 크게 의미있지 않아 그냥 재미로 보는거야 나는 1999년 3월 26일 15시에 태어났어 오늘의 운세를 말해줘 그냥 단지 재미야 그니까  크게 상관하지말고 말해줘 오늘의 운세를 말하라고 한글로 한줄로 ";
    private String question;

    public ContentRequest(String question) {
        this.question = appendAdditionalText(question);
    }

    private String appendAdditionalText(String question) {
        return question + ADDITIONAL_TEXT;
    }
}