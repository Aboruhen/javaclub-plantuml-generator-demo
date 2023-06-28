package com.javaclub.demo.plantumlgenerator.domain.service.impl;

import com.javaclub.demo.plantumlgenerator.domain.dto.TweetView;
import com.javaclub.demo.plantumlgenerator.domain.repository.TweetsRepository;
import com.javaclub.demo.plantumlgenerator.domain.service.TweetViewsService;
import com.javaclub.demo.plantumlgenerator.domain.service.UserRecommendationService;
import com.javaclub.demo.plantumlgenerator.domain.service.mappers.TweetMapper;
import java.util.List;
import java.util.UUID;
import org.springframework.stereotype.Service;

@Service
public class TweetViewsServiceImpl implements TweetViewsService {

    private final UserRecommendationService userRecommendationService;
    private final TweetsRepository tweetsRepository;
    private final TweetMapper tweetMapper = new TweetMapper();

    public TweetViewsServiceImpl(UserRecommendationService userRecommendationService, TweetsRepository tweetsRepository) {
        this.userRecommendationService = userRecommendationService;
        this.tweetsRepository = tweetsRepository;
    }

    @Override
    public List<TweetView> userRecommendations(UUID userId) {
        List<Long> tweetIds = userRecommendationService.calculateRecommendationsTweets(userId);
        return tweetMapper.map(tweetsRepository.findAllById(tweetIds));
    }

}
