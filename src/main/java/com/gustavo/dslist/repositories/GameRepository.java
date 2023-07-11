package com.gustavo.dslist.repositories;

import com.gustavo.dslist.entities.Game;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GameRepository extends JpaRepository<Game, Long> {
}
