package com.vietis.projectdemo_vietis.services.impl;

import com.vietis.projectdemo_vietis.models.entities.Shelf;
import com.vietis.projectdemo_vietis.repositories.ShelfRepository;
import com.vietis.projectdemo_vietis.services.ShelfService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
        List<Shelf> shelfs;
        if(warehouseId==null){
            shelfs = shelfRepository.findAll();
        }
        else{
            shelfs = shelfRepository.getShelfById(warehouseId);
        }
        return shelfs;
    }

    @Override
    public void deleteById(Integer id) {
        shelfRepository.deleteById(id);
    }
}
