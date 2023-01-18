package com.cloudofgoods.order.controller;

import com.cloudofgoods.order.business.OrderStatusService;
import com.cloudofgoods.order.controller.controllconfig.ResponseHandler;
import com.cloudofgoods.order.dto.OrderStatusDTO;
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

@RestController
@Slf4j
@RequestMapping("/order/status")
@RequiredArgsConstructor
public class OrderStatusController {
    private final OrderStatusService orderStatusService;
    @PostMapping(value ="${server.servlet.saveOrder}", produces = MediaType.APPLICATION_JSON_VALUE)
    @Description("Save Delivery (If Send With ID It Will Update)")
    public ResponseEntity <Object> saveOrderStatus(@RequestBody OrderStatusDTO orderStatusDTO) {
        log.info("LOG::Inside the OrderStatusController saveOrderStatus " + orderStatusDTO.getStatus ());
        try {
            log.info("LOG::Inside the OrderStatusController saveOrderStatus Inside try");
            OrderStatusDTO postResponse = orderStatusService.saveOrderStatus(orderStatusDTO);
            return ResponseHandler.responseBuilder("Success", "2000", HttpStatus.OK, postResponse);
        } catch (Exception e) {
            log.info("LOG::Inside the OrderStatusController saveOrderStatus Exception :: " + e.getMessage());
            return ResponseHandler.responseBuilder("Fail", "5000", HttpStatus.INTERNAL_SERVER_ERROR, null);
        }
    }
}
