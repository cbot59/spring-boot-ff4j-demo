package dev.rivaldi.springbootff4jdemo;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
class SellerDto {
    String id;
    String name;
    String address;

    public static <U> SellerDto from(Seller seller) {
        return builder()
            .id(seller.getId())
            .address(seller.getAddress())
            .name(seller.getName())
            .build();
    }
}
