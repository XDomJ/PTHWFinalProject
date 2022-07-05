package com.promineotech.FETB.model;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Data;
@Data
@Entity
@Table(name ="Squads")
public class Squad {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int squad_PK;
  
  @ManyToOne // double check 
  @JoinColumn(name = "squad_user")
  private User squad_user;
  
  @Column(name = "squad_name")
  private String squad_name;
  
  @ManyToMany //check relationships
  @JoinTable(name = "squad_chars",
   joinColumns = { @JoinColumn(name = "squad_id", referencedColumnName = "squad_pk")},
   inverseJoinColumns = {@JoinColumn(name = "char_id", referencedColumnName = "char_pk")
  })
  private List<GameCharacter> squadChars;
}
