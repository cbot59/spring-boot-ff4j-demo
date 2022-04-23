package dev.rivaldi.springbootff4jdemo;

import java.util.List;

import lombok.RequiredArgsConstructor;
import org.ff4j.FF4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/customers")
class CustomerController {

    private final FF4j ff4j;
    private final CustomerService service;

    @GetMapping
    List<CustomerDto> getCustomers() {
        if(ff4j.check("getAllCustomer")) {
            return service.getCustomers();
        }

        throw new UnsupportedOperationException("get all customer is not ready!");
    }

    @GetMapping("/{id}")
    CustomerDto getCustomerById(@PathVariable String id) {
        return service.getCustomerById(id);
    }
}
