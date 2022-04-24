package dev.rivaldi.springbootff4jdemo;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

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

    List<SellerDto> getSellers() {
        return StreamSupport.stream(repository.findAll().spliterator(), false)
            .map(SellerDto::from)
            .collect(Collectors.toList());
    }
}
