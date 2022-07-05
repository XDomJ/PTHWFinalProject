package com.promineotech.FETB.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.promineotech.FETB.model.Squad;

@Repository
public interface SquadRepository extends JpaRepository<Squad, Integer> {

}
