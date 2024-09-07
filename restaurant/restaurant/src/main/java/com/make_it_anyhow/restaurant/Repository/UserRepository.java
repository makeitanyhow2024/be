package com.make_it_anyhow.restaurant.Repository;

import com.make_it_anyhow.restaurant.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
  User findByEmail(String email);
}
