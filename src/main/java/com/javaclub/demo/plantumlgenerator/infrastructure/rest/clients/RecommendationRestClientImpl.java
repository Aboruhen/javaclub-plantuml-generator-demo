package com.javaclub.demo.plantumlgenerator.infrastructure.rest.clients;

import java.util.List;
import java.util.Random;
import java.util.UUID;
import org.springframework.stereotype.Component;

@Component
public class RecommendationRestClientImpl implements
    RecommendationRestClient {

    @Override
    public List<Long> callRest(UUID userId) {
        return new Random().longs(50, 1, 10_000_000).boxed().toList();
    }
}
