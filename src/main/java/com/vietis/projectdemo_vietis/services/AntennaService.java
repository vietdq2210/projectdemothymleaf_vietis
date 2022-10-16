package com.vietis.projectdemo_vietis.services;

import com.vietis.projectdemo_vietis.models.entities.Antenna;

import java.util.List;

public interface AntennaService {
    Antenna saveAntenna(Antenna antenna);
    List<Antenna> findAll();

    List<Antenna> search(Integer id);

    Antenna getById(Integer id);

    void deleteById(Integer id);
}
