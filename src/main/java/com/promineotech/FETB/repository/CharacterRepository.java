package com.promineotech.FETB.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.promineotech.FETB.model.GameCharacter;

@Repository
public interface CharacterRepository extends JpaRepository<GameCharacter, Integer>{

}
