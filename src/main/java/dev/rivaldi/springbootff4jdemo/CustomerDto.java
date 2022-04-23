package dev.rivaldi.springbootff4jdemo;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
class CustomerDto {
    String id;
    String name;
    String address;

    public static <R> CustomerDto from(Customer customer) {
        return builder()
            .id(customer.getId())
            .name(customer.getName())
            .address(customer.getAddress())
            .build();
    }
}
