package com.vietis.projectdemo_vietis.services.impl;

import com.vietis.projectdemo_vietis.models.entities.Shelf;
import com.vietis.projectdemo_vietis.repositories.ShelfRepository;
import com.vietis.projectdemo_vietis.services.ShelfService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ShelfServiceImpl implements ShelfService {

    @Autowired
    private ShelfRepository shelfRepository;

    @Override
    public Shelf addShelf(Shelf shelf) {
        return shelfRepository.save(shelf);
    }

    @Override
    public List<Shelf> getListShelf() {
        return shelfRepository.findAll();
    }

    @Override
    public List<Shelf> search(Integer warehouseId) {
        List<Shelf> shelf;
        if(warehouseId==null){
            shelf = shelfRepository.findAll();
        }
        else{
            shelf = shelfRepository.findById(warehouseId).stream().toList();
        }
        return shelf;
    }
}
