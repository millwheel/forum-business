package com.example.forum_back.sender;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

import java.util.List;

@Component
@RequiredArgsConstructor
public class OpenaiApiSender {

    private final OpenaiProperties openaiProperties;

    private final String apiKey = openaiProperties.key;

    private final RestClient restClient = RestClient.builder()
            .baseUrl("https://api.openai.com/v1/chat/completions")
            .defaultHeader("Authorization", "Bearer " + apiKey)
            .defaultHeader("Content-Type", "application/json")
            .build();

    public void sendTranslateRequest(String text) {
        String result = restClient.post()
                .body(buildRequestBody(text))
                .retrieve()
                .onStatus(HttpStatusCode::is4xxClientError, ((request, response) -> {
                    throw new RuntimeException("error with code" + response.getStatusCode() + ", with header: " + response.getHeaders());
                }))
                .body(String.class);
        System.out.println(result);
    }

    private ChatCompletionRequest buildRequestBody(String text) {
        return new ChatCompletionRequest(
                "gpt-4o-mini",
                List.of(
                        new ChatMessage("system", "You are a helpful assistant."),
                        new ChatMessage("user", text)
                )
        );
    }

}
