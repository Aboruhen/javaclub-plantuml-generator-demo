package com.javaclub.demo.plantumlgenerator.infrastructure.rest.clients;

import com.javaclub.demo.plantumlgenerator.domain.service.RecommendationClient;
import java.util.List;
import java.util.UUID;
import org.springframework.stereotype.Service;

@Service
public class RecommendationClientImpl implements RecommendationClient {

    private final RecommendationRestClient recommendationRestClient;

    public RecommendationClientImpl(RecommendationRestClient recommendationRestClient) {
        this.recommendationRestClient = recommendationRestClient;
    }

    @Override
    public List<Long> findTweets(UUID userId, String userDetails) {
        return recommendationRestClient.callRest(userId, userDetails);
    }
}
