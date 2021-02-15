package com.example.demo.respository;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.model.User;

@Repository
@Transactional
public interface UserDetailsRepository extends JpaRepository<User, Integer>{
 Optional <User>findByUsername(String username);
 
 @Query("UPDATE User u SET u.failedAttempt = ?1 WHERE u.username = ?2")
 @Modifying
 public void updateFailedAttempts(int failAttempts, String username);
}
