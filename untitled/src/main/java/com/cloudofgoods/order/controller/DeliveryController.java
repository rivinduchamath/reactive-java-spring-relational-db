package com.cloudofgoods.order.controller;

import com.cloudofgoods.order.business.DeliveryService;
import com.cloudofgoods.order.controller.controllconfig.ResponseHandler;
import com.cloudofgoods.order.dto.DeliveryAreaDTO;
import jdk.jfr.Description;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@Slf4j
@RequestMapping("/delivery")
@RequiredArgsConstructor
public class DeliveryController {
    private final DeliveryService deliveryService;
    @PostMapping(value ="${server.servlet.saveOrder}", produces = MediaType.APPLICATION_JSON_VALUE)
    @Description("Save Delivery (If Send With ID It Will Update)")
    public ResponseEntity <Object> saveDelivery(@RequestBody DeliveryAreaDTO deliveryAreaDTO) {
        log.info("LOG::Inside the DeliveryController saveDelivery " + deliveryAreaDTO.getCityId ());
        try {
            log.info("LOG::Inside the DeliveryController saveDelivery Inside try");
            Mono<DeliveryAreaDTO> postResponse = deliveryService.saveDelivery(deliveryAreaDTO);
            return ResponseHandler.responseBuilder("Success", "2000", HttpStatus.OK, postResponse);
        } catch (Exception e) {
            log.info("LOG::Inside the DeliveryController saveDelivery Exception :: " + e.getMessage());
            return ResponseHandler.responseBuilder("Fail", "5000", HttpStatus.INTERNAL_SERVER_ERROR, null);
        }
    }
}
