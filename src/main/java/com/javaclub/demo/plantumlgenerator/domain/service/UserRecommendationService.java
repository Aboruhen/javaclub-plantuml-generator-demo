package com.javaclub.demo.plantumlgenerator.domain.service;

import java.util.List;
import java.util.UUID;

public interface UserRecommendationService {

    List<Long> calculateRecommendationsTweets(UUID userId);

}
