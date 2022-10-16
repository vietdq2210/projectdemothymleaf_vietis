package com.vietis.projectdemo_vietis.services.impl;

import com.vietis.projectdemo_vietis.models.entities.Gate;
import com.vietis.projectdemo_vietis.repositories.GateRepository;
import com.vietis.projectdemo_vietis.services.GateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GateServiceImpl implements GateService {
    @Autowired
    private GateRepository gateRepository;

    @Override
    public Gate addGate(Gate gate) {
        return gateRepository.save(gate);
    }

    @Override
    public List<Gate> getListAllGate() {
        return gateRepository.findAll();
    }

    @Override
    public List<Gate> search(Integer warehouseId) {
        List<Gate> gates;
        if(warehouseId==null){
            gates = gateRepository.findAll();
        }
        else{
            gates = gateRepository.getGateById(warehouseId);
        }
        return gates;
    }

    @Override
    public void deleteById(Integer id) {
        gateRepository.deleteById(id);
    }
}
