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
import com.promineotech.FETB.model.Weapon;
import com.promineotech.FETB.service.WeaponService;

@RestController
@RequestMapping("/fet_db/weapons")
public class WeaponController {

  private WeaponService weaponService;
  
  public WeaponController(WeaponService weaponService) {
    super();
    this.weaponService = weaponService;
  }

  @PostMapping()
  public ResponseEntity<Weapon> saveWeapon(@RequestBody Weapon weapon) {
    return new ResponseEntity<Weapon>(
        weaponService.saveWeapon(weapon), HttpStatus.CREATED);
  }
  @GetMapping
  public List<Weapon> getAllWeapons(){
    return weaponService.getAllWeapons();
  }
  
  @GetMapping("{weapon_id}")
  public ResponseEntity<Weapon> getWeaponById(@PathVariable("weapon_id") int weaponID){
    return new ResponseEntity<Weapon>(
        weaponService.getWeaponByID(weaponID), HttpStatus.OK);
  }
  @PutMapping("{weapon_id}")
  public ResponseEntity<Weapon> updateWeapon(
      @PathVariable("weapon_id") int weaponId, @RequestBody Weapon weapon){
    return new ResponseEntity<Weapon>(
        weaponService.updateWeapon(weapon, weaponId), HttpStatus.OK);
  }
  @DeleteMapping("{weapon_id}")
  public ResponseEntity<String> deleteWeapon(@PathVariable("weapon_id") int weaponId){
    weaponService.deleteWeapon(weaponId);
    return new ResponseEntity<String>("Weapon Broken!!", HttpStatus.OK);
  }
}
