package dev.rivaldi.springbootff4jdemo;

import java.util.List;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/sellers")
class SellerController {

    private final SellerService service;

    @GetMapping("/{id}")
    SellerDto getCustomerById(@PathVariable String id) {
        return service.getSellerById(id);
    }
}
