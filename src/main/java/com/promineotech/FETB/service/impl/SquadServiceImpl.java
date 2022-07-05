package com.promineotech.FETB.service.impl;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.promineotech.FETB.exception.ResourceNotFoundException;
import com.promineotech.FETB.model.GameCharacter;
import com.promineotech.FETB.model.Squad;
import com.promineotech.FETB.repository.CharacterRepository;
import com.promineotech.FETB.repository.SquadRepository;
import com.promineotech.FETB.service.SquadService;

@Service
public class SquadServiceImpl implements SquadService {

private SquadRepository squadRepository;
private CharacterRepository characterRepository; //secondary repository

  @Autowired
  public SquadServiceImpl(SquadRepository squadRepository,CharacterRepository characterRepository) {
    super();
    this.squadRepository = squadRepository;
    this.characterRepository = characterRepository;
  }
  
  @Override
  public Squad saveSquad(Squad squad) {
    return squadRepository.save(squad);
  }

  @Override
  public List<Squad> getAllSquads() {
    return squadRepository.findAll();
  }

  @Override
  public Squad getSquadById(int id) {
    return squadRepository.findById(id).orElseThrow(
        () -> new ResourceNotFoundException("Squad","Id",id));
  }

  @Override
  public void deleteSquad(int id) {
   Squad foundSquad = squadRepository.findById(id).orElseThrow(
       () -> new ResourceNotFoundException("Squad","Id",id));
   squadRepository.deleteById(id);    
  }
    //messy, but it's working. Clean up later
  @Override 
  public Squad populateSquad(int squadId, int[] gCharIds) {
        
    List<GameCharacter> gCharList = new ArrayList<GameCharacter>();
    Squad foundSquad = squadRepository.findById(squadId).orElseThrow(
        () -> new ResourceNotFoundException("Squad","Id",squadId)); 
    
    for (int j =0; j < gCharIds.length; j++) {
      int tempId = gCharIds[j];
      GameCharacter tempGuy = characterRepository.findById(
          tempId).orElseThrow(() -> 
          new ResourceNotFoundException("Character", "ID", tempId));
      gCharList.add((tempGuy));
    }
    
    foundSquad.setSquadChars(gCharList);    
    return squadRepository.save(foundSquad);
  }

}
