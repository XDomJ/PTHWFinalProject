package com.promineotech.FETB.service.impl;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.promineotech.FETB.exception.ResourceNotFoundException;
import com.promineotech.FETB.model.GameCharacter;
import com.promineotech.FETB.model.Weapon;
import com.promineotech.FETB.repository.CharacterRepository;
import com.promineotech.FETB.repository.WeaponRepository;
import com.promineotech.FETB.service.GCharacterService;
@Service
public class GCharacterServiceImpl implements GCharacterService{

  private CharacterRepository characterRepository;
  private WeaponRepository weaponRepository; //secondary repository
  
  @Autowired
  public GCharacterServiceImpl(CharacterRepository characterRepository, WeaponRepository weaponRepository) {
    super();
    this.characterRepository = characterRepository;
    this.weaponRepository = weaponRepository;
  }
  
  @Override
  public GameCharacter saveGChar(GameCharacter gChar) {
    return characterRepository.save(gChar);
  }

  @Override
  public List<GameCharacter> getAllChars() {
    return characterRepository.findAll();
  }

  @Override
  public GameCharacter getGCharById(int id) {
    return characterRepository.findById(id).orElseThrow(() 
        -> new ResourceNotFoundException("Character","ID", id));
  }

  @Override
  public GameCharacter updateGChar(GameCharacter gChar, int id) {
    
    GameCharacter foundGuy = characterRepository.findById(id).orElseThrow(() 
        -> new ResourceNotFoundException("Character","ID", id));
    
    foundGuy.setChar_name(gChar.getChar_name());
    foundGuy.setChar_hp(gChar.getChar_hp());
    foundGuy.setChar_mgt(gChar.getChar_mgt());
    foundGuy.setChar_skl(gChar.getChar_skl());
    foundGuy.setChar_spd(gChar.getChar_spd());
    foundGuy.setChar_lck(gChar.getChar_lck());
    foundGuy.setChar_def(gChar.getChar_def());
    foundGuy.setChar_res(gChar.getChar_res());
    foundGuy.setChar_class(gChar.getChar_class());
    foundGuy.setChar_con(gChar.getChar_con());
  
    
    characterRepository.save(foundGuy);
    return foundGuy;
  }

  @Override
  public GameCharacter equipGChar(GameCharacter gChar, int id,
      Optional<Weapon> weapon, int weaponId) {
    
    GameCharacter foundGuy = characterRepository.findById(id).orElseThrow(() 
        -> new ResourceNotFoundException("Character","ID", id));
    Weapon foundWeapon = weaponRepository.findById(weaponId).orElseThrow(
        () -> new ResourceNotFoundException("Weapon", "ID", weaponId));
    
    foundGuy.setChar_weapon_id(foundWeapon);    
    return foundGuy;
  }

  @Override
  public void deleteGChar(int id) {
    GameCharacter foundGuy = characterRepository.findById(id).orElseThrow(() 
        -> new ResourceNotFoundException("Character","ID", id));
    characterRepository.deleteById(id);    
  }

}
