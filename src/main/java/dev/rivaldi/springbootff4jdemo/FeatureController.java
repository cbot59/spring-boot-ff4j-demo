package dev.rivaldi.springbootff4jdemo;

import java.util.Collections;
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
        if (!ff4j.exist(FeatureConstants.FEAT_GET_ALL_CUSTOMER)) {
            Feature getAllCustomersFeature = new Feature(FeatureConstants.FEAT_GET_ALL_CUSTOMER, true,
                FeatureConstants.DESC_GET_ALL_CUSTOMER,
                FeatureConstants.GROUP_API,
                Collections.singletonList(FeatureConstants.AUTH_CUSTOMER)
            );
            ff4j.createFeature(getAllCustomersFeature);
        }

        if (!ff4j.exist(FeatureConstants.FEAT_GET_ALL_SELLER)) {
            Feature getAllSellersFeature = new Feature(FeatureConstants.FEAT_GET_ALL_SELLER, true,
                FeatureConstants.DESC_GET_ALL_SELLER,
                FeatureConstants.GROUP_API,
                Collections.singletonList(FeatureConstants.AUTH_SELLER)
            );
            ff4j.createFeature(getAllSellersFeature);
        }
    }
}
