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
@RequestMapping("/api/sellers")
class SellerController {

    private final FF4j ff4j;
    private final SellerService service;

    @GetMapping
    List<SellerDto> getSellers() {
        if(ff4j.check(FeatureConstants.FEAT_GET_ALL_SELLER)) {
            return service.getSellers();
        }

        throw new UnsupportedOperationException("get all seller is not ready!");
    }

    @GetMapping("/{id}")
    SellerDto getCustomerById(@PathVariable String id) {
        return service.getSellerById(id);
    }
}
