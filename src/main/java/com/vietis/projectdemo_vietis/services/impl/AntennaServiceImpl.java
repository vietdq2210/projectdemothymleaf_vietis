package com.vietis.projectdemo_vietis.services.impl;

import com.vietis.projectdemo_vietis.models.entities.Antenna;
import com.vietis.projectdemo_vietis.repositories.AntennaRepository;
import com.vietis.projectdemo_vietis.services.AntennaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AntennaServiceImpl implements AntennaService {

    @Autowired
    private AntennaRepository antennaRepository;

    @Override
    public Antenna saveAntenna(Antenna antenna) {
        return antennaRepository.save(antenna);
    }
}
