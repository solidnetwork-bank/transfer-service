package xyz.solidnetwork.service.aws.sqs;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import io.awspring.cloud.sqs.operations.SendResult;
import io.awspring.cloud.sqs.operations.SqsTemplate;
import lombok.extern.slf4j.Slf4j;
import xyz.solidnetwork.service.Const;

@Service
@Slf4j
public class Producer {

    @Autowired
    private SqsTemplate sqsTemplate;

    @Value("${aws.transaction.request.queue.name}")
    private String queueName;

    public void send(Request request) {

        final String messageGroupId = "transfer-service";

        Map<String, Object> headers = new HashMap<>();

        headers.put(Const.USER_ID, MDC.get(Const.USER_ID));
        headers.put(Const.TRACE_ID, MDC.get(Const.TRACE_ID));

        SendResult<Request> result = sqsTemplate.send(to -> to.queue(queueName)
                .payload(request)
                .headers(headers)
                .messageGroupId(messageGroupId)
                .messageDeduplicationId(MDC.get(Const.TRACE_ID)));

        log.info("message sent to queue {}", result);

    }

}