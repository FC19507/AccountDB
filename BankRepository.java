package com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BankRepository extends JpaRepository<Account, Integer> {

}

