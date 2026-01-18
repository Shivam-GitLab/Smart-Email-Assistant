package com.sm.smartEmail.service;

import com.sm.smartEmail.entities.EmailRequest;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.stereotype.Service;

@Service
public class EmailGeneratorService {

    private final ChatClient chatClient;

    public EmailGeneratorService(ChatClient chatClient) {
        this.chatClient = chatClient;
    }

    public String generateEmailReply(EmailRequest emailRequest) {

        String prompt = buildPrompt(emailRequest);

        return chatClient.prompt()
                .user(prompt)
                .call()
                .content();
    }

    private String buildPrompt(EmailRequest emailRequest) {

        StringBuilder prompt = new StringBuilder();

        prompt.append("Generate a professional email reply for the following email content. ");
        prompt.append("Do not generate a subject line. ");

        if (emailRequest.getEmailTone() != null && !emailRequest.getEmailTone().isEmpty()) {
            prompt.append("Use a ").append(emailRequest.getEmailTone()).append(" tone. ");
        }

        prompt.append("\n\nOriginal Email:\n");
        prompt.append(emailRequest.getEmailContent());

        return prompt.toString();
    }
}

