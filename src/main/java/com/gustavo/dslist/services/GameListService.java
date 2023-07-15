package com.gustavo.dslist.services;

import com.gustavo.dslist.dto.GameDTO;
import com.gustavo.dslist.dto.GameListDTO;
import com.gustavo.dslist.dto.GameMinDTO;
import com.gustavo.dslist.entities.Game;
import com.gustavo.dslist.entities.GameList;
import com.gustavo.dslist.projections.GameMinProjection;
import com.gustavo.dslist.repositories.GameListRepository;
import com.gustavo.dslist.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GameListService {
    @Autowired
    private GameListRepository gameListRepository;
    @Autowired
    private GameRepository gameRepository;

    @Transactional(readOnly = true)
    public List<GameListDTO> findAll(){
        List<GameList> result = gameListRepository.findAll();
        return result.stream().map(GameListDTO::new).toList();
    }

    @Transactional
    public void move(Long listId, int sourceIndex, int destinationIndex){
        List<GameMinProjection> list = gameRepository.searchByList(listId);

        GameMinProjection obj = list.remove(sourceIndex);
        list.add(destinationIndex, obj);

        int min = Math.min(sourceIndex, destinationIndex);
        int max = Math.max(sourceIndex, destinationIndex);

        for(int i = min; i <= max; i++){
            gameListRepository.updateBelongingPosition(listId, list.get(i).getId(), i);
        }

        //list.forEach(game ->
        //       gameListRepository.updateBelongingPosition(listId, game.getId(), list.indexOf(game)));
    }
}
