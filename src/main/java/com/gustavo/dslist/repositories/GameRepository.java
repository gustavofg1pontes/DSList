package com.gustavo.dslist.repositories;

import com.gustavo.dslist.entities.Game;
import org.springframework.data.jpa.repository.JpaRepository;


public interface GameRepository extends JpaRepository<Game, Long> {
}
