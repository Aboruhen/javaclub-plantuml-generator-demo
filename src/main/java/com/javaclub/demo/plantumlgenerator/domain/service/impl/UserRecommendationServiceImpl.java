package com.javaclub.demo.plantumlgenerator.domain.service.impl;

import com.javaclub.demo.plantumlgenerator.domain.entity.User;
import com.javaclub.demo.plantumlgenerator.domain.repository.UserRepository;
import com.javaclub.demo.plantumlgenerator.domain.service.RecommendationClient;
import com.javaclub.demo.plantumlgenerator.domain.service.UserRecommendationService;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.springframework.stereotype.Service;

@Service
public class UserRecommendationServiceImpl implements UserRecommendationService {

    private final UserRepository userRepository;
    private final RecommendationClient recommendationClient;

    public UserRecommendationServiceImpl(UserRepository userRepository, RecommendationClient recommendationClient) {
        this.userRepository = userRepository;
        this.recommendationClient = recommendationClient;
    }

    @Override
    public List<Long> calculateRecommendationsTweets(UUID userId) {
        Optional<User> byId = userRepository.findById(userId);
        User notExistUser = byId.orElseThrow(() -> new RuntimeException("Not exist user"));
        return recommendationClient.findTweets(userId, notExistUser.getDetails());
    }

}
