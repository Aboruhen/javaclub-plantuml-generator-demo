package com.javaclub.demo.plantumlgenerator.domain.service.impl;

import com.javaclub.demo.plantumlgenerator.domain.service.RecommendationClient;
import com.javaclub.demo.plantumlgenerator.domain.service.UserRecommendationService;
import java.util.List;
import java.util.UUID;
import org.springframework.stereotype.Service;

@Service
public class UserRecommendationServiceImpl implements UserRecommendationService {

    private final RecommendationClient recommendationClient;

    public UserRecommendationServiceImpl(RecommendationClient recommendationClient) {
        this.recommendationClient = recommendationClient;
    }

    @Override
    public List<Long> calculateRecommendationsTweets(UUID userId) {
        return recommendationClient.findTweets(userId);
    }

}
