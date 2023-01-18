package com.cloudofgoods.order.controller;

import com.cloudofgoods.order.business.OrderService;
import com.cloudofgoods.order.controller.controllconfig.ResponseHandler;
import com.cloudofgoods.order.dto.OrderDTO;
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
@RequestMapping("/order")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;
    @PostMapping(value ="${server.servlet.saveOrder}", produces = MediaType.APPLICATION_JSON_VALUE)
    @Description("Save Order (If Send With ID It Will Update)")
    public ResponseEntity <Object> saveOrder(@RequestBody OrderDTO orderDTO) {
        log.info("LOG::Inside the OrderController saveOrder " + orderDTO.getUserId ());
        try {
            log.info("LOG::Inside the OrderController saveOrder Inside try");
            OrderDTO postResponse = orderService.saveOrder(orderDTO);
            return ResponseHandler.responseBuilder("Success", "2000", HttpStatus.OK, postResponse);
        } catch (Exception e) {
            log.info("LOG::Inside the OrderController saveOrder Exception :: " + e.getMessage());
            return ResponseHandler.responseBuilder("Fail", "5000", HttpStatus.INTERNAL_SERVER_ERROR, null);
        }
    }
}
