package com.promineotech.FETB.controller;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.promineotech.FETB.model.Squad;
import com.promineotech.FETB.service.SquadService;

@RestController
@RequestMapping("/fet_db/squads")
public class SquadController {
    
  private SquadService squadService;
  
  public SquadController(SquadService squadService) {
    super();
    this.squadService = squadService;
  }
  
  @PostMapping()
  public ResponseEntity<Squad> saveSquad(@RequestBody Squad squad){
    return new ResponseEntity<Squad>(squadService.saveSquad(squad), HttpStatus.CREATED);
  }
  
  @GetMapping
  public List<Squad> getAllSquads(){
    return squadService.getAllSquads();
  }
  
  @GetMapping("{squad_pk}")
  public ResponseEntity<Squad> getSquadById(@PathVariable("squad_pk") int squadId){
    return new ResponseEntity<Squad>(squadService.getSquadById(squadId), HttpStatus.OK);
  }
  
  @DeleteMapping("{squad_pk}")
  public ResponseEntity<String> deleteSquad(@PathVariable("squad_pk") int squadId){
    squadService.deleteSquad(squadId);
    return new ResponseEntity<String>("Squad eliminated!", HttpStatus.OK);
  }
  
  @PutMapping("{squad_pk}")
  public ResponseEntity<Squad> populateSquad(
      @PathVariable("squad_pk")int squadID, int[] gCharIds){
    
    return new ResponseEntity<Squad>(
        squadService.populateSquad(squadID, gCharIds), HttpStatus.OK );    
  }
}
