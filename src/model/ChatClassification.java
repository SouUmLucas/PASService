package model;

/**
 * Created by lucas on 22/05/2017.
 */
public class ChatClassification extends ClassificationEntity {
    private Chat chat;

    public ChatClassification() {}

    public ChatClassification(Chat chat, String classification, double accuracy) {
        super(classification, accuracy);

        this.chat = chat;
    }

    public Chat getChat() {
        return chat;
    }
}
