package com.promineotech.FETB.service;

import java.util.List;
import com.promineotech.FETB.model.Weapon;

public interface WeaponService {
  Weapon saveWeapon(Weapon weapon);  
  List<Weapon> getAllWeapons();
  Weapon getWeaponByID(int id);
  Weapon updateWeapon(Weapon weapon, int id);
  void deleteWeapon(int id);
}
