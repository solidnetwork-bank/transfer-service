package xyz.solidnetwork.service.aws.sqs;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import xyz.solidnetwork.service.transaction.Transaction;

public class Request {
    private Transaction transaction;

    public Request() {
        super();
    }

    public Transaction getTransaction() {
        return transaction;
    }

    public void setTransaction(Transaction transaction) {
        this.transaction = transaction;
    }

    @JsonProperty(access = Access.WRITE_ONLY)
    @Override
    public String toString() {
        return "Request [transaction=" + transaction + "]";
    }

}
