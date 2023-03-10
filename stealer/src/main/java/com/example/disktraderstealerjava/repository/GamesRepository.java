package com.example.disktraderstealerjava.repository;

import com.example.disktraderstealerjava.model.GameModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GamesRepository extends CrudRepository<GameModel, String> {

}
