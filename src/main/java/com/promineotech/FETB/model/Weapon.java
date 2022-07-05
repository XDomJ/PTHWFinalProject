package com.promineotech.FETB.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="weapons")
public class Weapon {
  
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int weapon_id;
  
  @Column(name = "weapon_name")
  private String weapon_name;
  @Column(name = "weapon_rank")
  private char weapon_rank;
  @Column(name = "weapon_wt")
  private int weapon_wt;
  @Column(name = "weapon_dam")
  private int weapon_dam;
  @Column(name = "weapon_hit")
  private int weapon_hit;
  @Column(name = "weapon_crit")
  private int weapon_crit;
    
}
