package com.promineotech.FETB.controller;

import java.util.List;
import java.util.Optional;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.promineotech.FETB.model.GameCharacter;
import com.promineotech.FETB.model.Weapon;
import com.promineotech.FETB.service.GCharacterService;

@RestController
@RequestMapping("/fet_db/characters")
public class GCharacterController {
  
  private GCharacterService gCharService;
  
  public GCharacterController(GCharacterService gCharService) {
    super();
    this.gCharService = gCharService;
  }
  
  @PostMapping()
  public ResponseEntity<GameCharacter> saveGChar(@RequestBody GameCharacter gChar){
    return new ResponseEntity<GameCharacter>(
        gCharService.saveGChar(gChar), HttpStatus.CREATED);
  }
  
  @GetMapping
  public List<GameCharacter> getAllCharacters(){
    return gCharService.getAllChars();
  }
  
  @GetMapping("{char_id}")
  public ResponseEntity<GameCharacter> getGCharByID(
      @PathVariable("char_id") int charID){
    
    return new ResponseEntity<GameCharacter>(
        gCharService.getGCharById(charID), HttpStatus.OK);
  }
  
  @PutMapping("{char_id}")
  public ResponseEntity<GameCharacter> updateGChar(
      @PathVariable("char_id") int charID,@RequestBody GameCharacter GChar){
    return new ResponseEntity<GameCharacter>(gCharService.updateGChar(
        GChar, charID), HttpStatus.OK);
  }
  
  @PatchMapping("{char_id}/{char_weapon_id}")
  public ResponseEntity<GameCharacter> equipGChar(@PathVariable(
      "char_id") int charID, @RequestBody GameCharacter GChar,
      @PathVariable("char_weapon_id")int weaponID, @RequestBody Optional<Weapon> weapon){
    return new ResponseEntity<GameCharacter>(gCharService.equipGChar(
        GChar, charID, weapon, weaponID), HttpStatus.OK);
  }
  
  
  @DeleteMapping("{char_id}")
  public ResponseEntity<String> deleteGC(@PathVariable("char_id") int charID){
    gCharService.deleteGChar(charID);
    return new ResponseEntity<String>("Character Deleted!", HttpStatus.OK);
  }
  
 }