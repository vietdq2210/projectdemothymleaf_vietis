package com.vietis.projectdemo_vietis.services;

import com.vietis.projectdemo_vietis.models.entities.Gate;

import java.util.List;

public interface GateService {
    Gate addGate(Gate gate);
    List<Gate> getListAllGate();

    List<Gate> search(Integer id);
    void deleteById(Integer id);
}
