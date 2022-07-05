package com.promineotech.FETB.service;

import java.util.List;
import com.promineotech.FETB.model.Squad;

public interface SquadService {
  Squad saveSquad(Squad squad);
  List<Squad> getAllSquads();
  Squad getSquadById(int id);
  void deleteSquad(int id);
  Squad populateSquad(int squadId, int[] gCharIds);
 }
