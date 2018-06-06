package com.filip.springbootsecuritysample.repositories;

import com.filip.springbootsecuritysample.domain.models.security.Privilege;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PrivilegeRepository extends JpaRepository<Privilege, Long> {
}
