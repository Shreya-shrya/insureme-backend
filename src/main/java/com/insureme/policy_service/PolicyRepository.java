package com.insureme.policy_service;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PolicyRepository extends JpaRepository<Policy, Long> {
    // Spring Boot will automatically create methods like:
    // save(), findById(), deleteById(), findAll() etc.
}