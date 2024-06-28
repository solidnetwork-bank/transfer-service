package xyz.solidnetwork.service.transfer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class TransferController {
    @Autowired
    private TransferService transferService;

    @PostMapping("/self")
    public Message transfer() {
        log.info("transfer is requested");
        return transferService.transfer();
    }
}
