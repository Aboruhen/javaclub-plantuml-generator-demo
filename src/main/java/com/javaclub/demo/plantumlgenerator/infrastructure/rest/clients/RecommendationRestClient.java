package com.javaclub.demo.plantumlgenerator.infrastructure.rest.clients;

import java.util.List;
import java.util.UUID;

public interface RecommendationRestClient {

    List<Long> callRest(UUID userId);

}
