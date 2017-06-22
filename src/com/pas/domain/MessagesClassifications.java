package com.pas.domain;

import java.util.ArrayList;

public class MessagesClassifications extends Entity {
    private ArrayList<MessageClassification> messagesClassification = new ArrayList<>();

    public ArrayList<MessageClassification> getMessagesClassification() {
        return messagesClassification;
    }

    public void setMessagesClassification(ArrayList<MessageClassification> messagesClassification) {
        this.messagesClassification = messagesClassification;
    }
}
