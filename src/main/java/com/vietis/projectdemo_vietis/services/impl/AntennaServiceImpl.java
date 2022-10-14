package com.vietis.projectdemo_vietis.services.impl;

import com.vietis.projectdemo_vietis.models.entities.Antenna;
import com.vietis.projectdemo_vietis.repositories.AntennaRepository;
import com.vietis.projectdemo_vietis.services.AntennaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AntennaServiceImpl implements AntennaService {

    @Autowired
    private AntennaRepository antennaRepository;

    @Override
    public Antenna saveAntenna(Antenna antenna) {
        return antennaRepository.save(antenna);
    }

    @Override
    public List<Antenna> findAll() {
        return antennaRepository.findAll();
    }

    @Override
    public List<Antenna> search(Integer id) {
        List<Antenna> antennas;
        if(id==null){
            antennas = antennaRepository.findAll();
        }else {
            antennas = antennaRepository.getAntennaById(id);
        }
        return antennas;
    }

    @Override
    public Antenna getById(Integer id) {
        return antennaRepository.findById(id).get();
    }


}
