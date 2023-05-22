package cours.apprentissage.realtimeapplication.business.webSocket;

public interface IWebSocketService {
    /*void sendMessage(String topicSuffix);*/
    void sendMessage(String topicSuffix,String payload);
}
