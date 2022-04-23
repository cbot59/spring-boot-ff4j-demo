package dev.rivaldi.springbootff4jdemo;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
class SellerService {

    private final SellerRepository repository;

    SellerDto getSellerById(String id) {
        return repository.findById(id)
            .map(SellerDto::from)
            .orElseThrow(() -> new IllegalArgumentException("seller not found"));
    }
}
