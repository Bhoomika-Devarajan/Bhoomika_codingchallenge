package com.example.hexaware.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.hexaware.entity.Player;
@Repository
public interface PlayerRepo extends JpaRepository<Player,Long> {

}
