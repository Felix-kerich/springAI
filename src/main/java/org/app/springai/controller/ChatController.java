package org.app.springai.controller;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.core.io.InputStreamResource;
import org.springframework.util.MimeTypeUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import reactor.core.publisher.Flux;

@RestController
public class ChatController {
    
    private final ChatClient chatClient;

    public ChatController(ChatClient chatClient) {
        this.chatClient = chatClient;
    }


    @GetMapping("/chat")
    public String chat(@RequestParam("message") String message) {
        return chatClient.prompt()
            .user(message)
            .call()
            .content();
        
    }

    @GetMapping("/stream-chat")
    public Flux<String> stream(@RequestParam("message") String message) {
        return chatClient.prompt()
            .user(message)
            .stream()
            .content();
        
    }


    @PostMapping("/chat-with-image")
    public String chat(@RequestPart("message") String message, @RequestPart("image") MultipartFile file) {
        return chatClient.prompt()
            .user(prompt -> prompt
                .text(message)
                .media(MimeTypeUtils.IMAGE_PNG, new InputStreamResource(file))
            )
            .call()
            .content();
        
    }

}
