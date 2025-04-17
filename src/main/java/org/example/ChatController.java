package org.example;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/chat")
public class ChatController {

        private final ChatService chatGptService;

        public ChatController(ChatService chatGptService) {
            this.chatGptService = chatGptService;
        }

        @PostMapping
        public ResponseEntity<String> chat(@RequestBody Map<String, String> request) {
            System.out.println("Chat Bot Service");
            String userMessage = request.get("message");
            String response = chatGptService.askChatGpt(userMessage);
            return ResponseEntity.ok(response);
        }

}
