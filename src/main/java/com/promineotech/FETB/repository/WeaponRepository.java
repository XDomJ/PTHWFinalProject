package com.promineotech.FETB.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.promineotech.FETB.model.Weapon;

@Repository
public interface WeaponRepository extends JpaRepository<Weapon, Integer> {

}
