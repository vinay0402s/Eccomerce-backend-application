package com.example.springsecurity.Repository;


import com.example.springsecurity.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findById(Long userId);

    Optional<Object> findByUsername(String username);

    User save(User user);
    // User findByUsername(Long userId, WishlistItem wishlistItem);
}
