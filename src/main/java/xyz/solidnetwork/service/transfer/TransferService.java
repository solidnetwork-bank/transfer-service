package xyz.solidnetwork.service.transfer;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import xyz.solidnetwork.service.aws.sqs.Consumer;
import xyz.solidnetwork.service.aws.sqs.Producer;
import xyz.solidnetwork.service.aws.sqs.Request;
import xyz.solidnetwork.service.transaction.Transaction;

@Service
@Slf4j
public class TransferService {

    @Autowired
    private Producer producer;

    @Autowired
    private Consumer consumer;

    public Message transfer() {

        log.info("microservice transaction-service called through fifo queue");

        Transaction transfer = new Transaction();
        transfer.setAmount(5.36);
        transfer.setDate(LocalDate.now());
        transfer.setDesc("Online scheduled transfer from CHK 2244 Confirmation # 997755441");
        transfer.setId("56");

        Request request = new Request();
        request.setTransaction(transfer);
        producer.send(request);

        log.info("microservice transaction-service answered through fifo queue");

        return new Message(consumer.receive().getMessage());

    }

}
