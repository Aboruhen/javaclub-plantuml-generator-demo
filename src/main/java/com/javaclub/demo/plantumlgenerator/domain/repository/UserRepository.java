package com.javaclub.demo.plantumlgenerator.domain.repository;

import com.javaclub.demo.plantumlgenerator.domain.entity.User;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, UUID> {

}
