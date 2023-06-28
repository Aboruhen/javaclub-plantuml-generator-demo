package com.javaclub.demo.plantumlgenerator.domain.repository;

import com.javaclub.demo.plantumlgenerator.domain.entity.Tweet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TweetsRepository extends JpaRepository<Tweet, Long> {

}
