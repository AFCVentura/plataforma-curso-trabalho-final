package org.example.trabalhofinal.repository;

import org.example.trabalhofinal.model.Videoaula;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VideoaulaRepository extends JpaRepository<Videoaula, Long> {
}