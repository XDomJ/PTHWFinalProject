package com.promineotech.FETB.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.promineotech.FETB.exception.ResourceNotFoundException;
import com.promineotech.FETB.model.Weapon;
import com.promineotech.FETB.repository.WeaponRepository;
import com.promineotech.FETB.service.WeaponService;

@Service
public class WeaponServiceImpl implements WeaponService{

  private WeaponRepository weaponRepository;
  
  @Autowired
  public WeaponServiceImpl(WeaponRepository weaponRepository) {
    super();
    this.weaponRepository = weaponRepository;
  }
  @Override
  public Weapon saveWeapon(Weapon weapon) {
    return weaponRepository.save(weapon);
  }
  @Override
  public List<Weapon> getAllWeapons() {
    return weaponRepository.findAll();
  }
  @Override
  public Weapon getWeaponByID(int id) {
    return weaponRepository.findById(id).orElseThrow(
        () -> new ResourceNotFoundException("Weapon", "ID", id));
  }
  @Override
  public Weapon updateWeapon(Weapon weapon, int id) {
    
    Weapon foundWeapon = weaponRepository.findById(id).orElseThrow(
        () -> new ResourceNotFoundException("Weapon", "ID", id));
    
    foundWeapon.setWeapon_name(weapon.getWeapon_name());
    foundWeapon.setWeapon_rank(weapon.getWeapon_rank());
    foundWeapon.setWeapon_wt(weapon.getWeapon_wt());
    foundWeapon.setWeapon_dam(weapon.getWeapon_dam());
    foundWeapon.setWeapon_hit(weapon.getWeapon_hit());
    foundWeapon.setWeapon_crit(weapon.getWeapon_crit());
    
    weaponRepository.save(foundWeapon);
    return foundWeapon;
  }
  @Override
  public void deleteWeapon(int id) {
    Weapon foundWeapon = weaponRepository.findById(id).orElseThrow(
        () -> new ResourceNotFoundException("Weapon", "ID", id));
    weaponRepository.deleteById(id);    
  }
  
  

}
