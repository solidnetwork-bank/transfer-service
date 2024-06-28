package xyz.solidnetwork.service.transfer;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

public class Message {
    private String message;

    public Message(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @JsonProperty(access = Access.WRITE_ONLY)
    @Override
    public String toString() {
        return "Message [message=" + message + "]";
    }

}