package com.example.FacebookClone.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.FacebookClone.domain.Message;

public interface MessageRepo extends JpaRepository<Message, Long>{

}
