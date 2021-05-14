package com.example.chatserver.repository;

import com.example.chatserver.pojo.User;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepository extends JpaRepository<User,Integer> {
}
