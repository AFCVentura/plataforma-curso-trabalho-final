package com.example.demo.repository;


import com.example.demo.model.Videoaula;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VideoaulaRepository extends JpaRepository<Videoaula, Long> {
}