package xyz.solidnetwork.service.aws.sqs;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

public class Response {
    private String message;
    private int code;

    public Response() {
        super();
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    @JsonProperty(access = Access.WRITE_ONLY)
    @Override
    public String toString() {
        return "Response [message=" + message + ", code=" + code + "]";
    }

}
