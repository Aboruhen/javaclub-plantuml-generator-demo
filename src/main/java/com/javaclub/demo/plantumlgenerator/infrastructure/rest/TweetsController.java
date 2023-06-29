package com.javaclub.demo.plantumlgenerator.infrastructure.rest;

import com.javaclub.demo.plantumlgenerator.domain.dto.TweetView;
import com.javaclub.demo.plantumlgenerator.domain.service.TweetViewsService;
import java.util.List;
import java.util.UUID;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TweetsController {

    private final TweetViewsService tweetViewsService;

    public TweetsController(TweetViewsService tweetViewsService) {
        this.tweetViewsService = tweetViewsService;
    }

    @GetMapping
    public ResponseEntity<List<TweetView>> recommendations() {
        final Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        UserDetails userDetails = (UserDetails) auth.getDetails();
        String username = userDetails.getUsername();
        return ResponseEntity.ok(tweetViewsService.userRecommendations(UUID.fromString(username)));
    }

}
