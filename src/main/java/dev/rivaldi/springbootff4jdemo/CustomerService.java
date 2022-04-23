package dev.rivaldi.springbootff4jdemo;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
class CustomerService {

    private final CustomerRepository repository;

    List<CustomerDto> getCustomers() {
        return StreamSupport.stream(repository.findAll().spliterator(), false)
            .map(CustomerDto::from)
            .collect(Collectors.toList());
    }

    CustomerDto getCustomerById(String id) {
        return repository.findById(id)
            .map(CustomerDto::from)
            .orElseThrow(() -> new IllegalArgumentException("customer not found"));
    }
}
