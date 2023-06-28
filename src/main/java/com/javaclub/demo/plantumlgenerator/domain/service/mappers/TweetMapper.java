package com.javaclub.demo.plantumlgenerator.domain.service.mappers;

import com.javaclub.demo.plantumlgenerator.domain.dto.TweetView;
import com.javaclub.demo.plantumlgenerator.domain.entity.Tweet;
import java.util.List;

public class TweetMapper {

    public List<TweetView> map(List<Tweet> tweets) {
        return tweets.stream().map(t -> new TweetView(t.getId().toString(), t.getNote(), t.getContent())).toList();
    }

}
