package com.promineotech.FETB.service;

import java.util.List;
import java.util.Optional;
import com.promineotech.FETB.model.GameCharacter;
import com.promineotech.FETB.model.Weapon;

public interface GCharacterService {
  
  GameCharacter saveGChar(GameCharacter gChar);
  List<GameCharacter> getAllChars();
  GameCharacter getGCharById(int id);
  //put mapping
  GameCharacter updateGChar(GameCharacter gChar, int id);
  //patch Mapping
  GameCharacter equipGChar(GameCharacter gChar, int id,
                      Optional<Weapon> weapon, int weaponID);
  void deleteGChar(int id);
}
