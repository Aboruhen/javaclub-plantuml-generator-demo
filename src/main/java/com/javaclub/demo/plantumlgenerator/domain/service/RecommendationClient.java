package com.javaclub.demo.plantumlgenerator.domain.service;

import java.util.List;
import java.util.UUID;

public interface RecommendationClient {

    List<Long> findTweets(UUID userId, String userDetails);

}
