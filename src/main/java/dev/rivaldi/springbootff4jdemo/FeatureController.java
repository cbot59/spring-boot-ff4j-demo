package dev.rivaldi.springbootff4jdemo;

import javax.annotation.PostConstruct;

import lombok.RequiredArgsConstructor;
import org.ff4j.FF4j;
import org.ff4j.core.Feature;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
class FeatureController {

    private final FF4j ff4j;

    @PostConstruct
    void populateFeature() {
        if (!ff4j.exist(FeatureConstants.GET_ALL_CUSTOMER)) {
            ff4j.createFeature(new Feature(FeatureConstants.GET_ALL_CUSTOMER, true));
        }
    }
}
