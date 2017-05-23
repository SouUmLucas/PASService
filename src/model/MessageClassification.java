package model;

/**
 * Created by lucas on 22/05/2017.
 */
public class MessageClassification extends ClassificationEntity {
    private Message message;

    public MessageClassification() {}

    public MessageClassification(Message message, String classification, double accuracy) {
        super(classification, accuracy);

        this.message = message;
    }

    public Message getMessage() {
        return message;
    }
}
