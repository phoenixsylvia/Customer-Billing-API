package com.phoenix.customerservice;

import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/customer")
public class CustomerController {

    private final CustomerService customerService;

    @PostMapping("/sendBillingRequest")
    public String sendBillingRequest(@RequestBody CustomerBillingResponse customerBillingResponse) throws JsonProcessingException {
    return customerService.sendBillingRequest(customerBillingResponse);
}
}
