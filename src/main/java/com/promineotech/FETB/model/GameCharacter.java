package com.promineotech.FETB.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "characters")
public class GameCharacter {
  
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int char_PK;
  
  @Column(name = "char_name")
  private String char_name;
  @Column(name = "char_hp")
  private int char_hp;
  @Column(name = "char_mgt")
  private int char_mgt;
  @Column(name = "char_skl")
  private int char_skl;
  @Column(name = "char_spd")
  private int char_spd;
  @Column(name = "char_lck")
  private int char_lck;
  @Column(name = "char_def")
  private int char_def;
  @Column(name = "char_res")
  private int char_res;
  @Column(name = "char_class")
  private String char_class;
  @Column(name = "char_con")
  private int char_con;
  
  @ManyToOne  //double check relationships
  @JoinColumn(name = "char_weapon_id")
  private Weapon char_weapon_id;
  
  
}
  