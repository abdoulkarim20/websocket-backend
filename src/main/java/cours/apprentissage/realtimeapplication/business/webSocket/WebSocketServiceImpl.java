package cours.apprentissage.realtimeapplication.business.webSocket;

import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

@Service
public class WebSocketServiceImpl implements IWebSocketService {
    private final SimpMessagingTemplate messagingTemplate;

    public WebSocketServiceImpl(SimpMessagingTemplate messagingTemplate) {
        this.messagingTemplate = messagingTemplate;
    }

    /*@Override
    public void sendMessage(String topicSuffix) {
        messagingTemplate.convertAndSend("/topic/" + topicSuffix, "Default message from our WS service");
    }*/

    @Override
    public void sendMessage(String topicSuffix, String payload) {
        messagingTemplate.convertAndSend("/topic/" + topicSuffix, payload);
    }
}
