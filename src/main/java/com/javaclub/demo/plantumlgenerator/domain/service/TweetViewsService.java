package com.javaclub.demo.plantumlgenerator.domain.service;

import com.javaclub.demo.plantumlgenerator.domain.dto.TweetView;
import java.util.List;
import java.util.UUID;

public interface TweetViewsService {

    List<TweetView> userRecommendations(UUID userId);

}
