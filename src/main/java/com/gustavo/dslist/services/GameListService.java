package com.gustavo.dslist.services;

import com.gustavo.dslist.dto.GameDTO;
import com.gustavo.dslist.dto.GameListDTO;
import com.gustavo.dslist.dto.GameMinDTO;
import com.gustavo.dslist.entities.Game;
import com.gustavo.dslist.entities.GameList;
import com.gustavo.dslist.repositories.GameListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GameListService {
    @Autowired
    private GameListRepository gameListRepository;

    @Transactional(readOnly = true)
    public List<GameListDTO> findAll(){
        List<GameList> result = gameListRepository.findAll();
        return result.stream().map(GameListDTO::new).toList();
    }
}
