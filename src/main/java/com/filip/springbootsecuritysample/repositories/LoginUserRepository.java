package com.filip.springbootsecuritysample.repositories;

import com.filip.springbootsecuritysample.domain.models.security.LoginUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoginUserRepository extends JpaRepository<LoginUser, Long> {

    LoginUser findByEmail(String email);
}
