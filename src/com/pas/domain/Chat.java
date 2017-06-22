package com.pas.domain;

import java.util.ArrayList;

public class Chat extends Entity {
    private String alias;
    private ArrayList<Message> messages;

    public Chat() {}

    public Chat(String alias, ArrayList<Message> messages) {
            this.alias = alias;
            this.messages = messages;
    }

    public String getAlias() {
            return alias;
    }

    public void setAlias(String alias) {
            this.alias = alias;
    }

    public ArrayList<Message> getMessages() {
            return messages;
    }

    public void setMessages(ArrayList<Message> messages) {
            this.messages = messages;
    }
}