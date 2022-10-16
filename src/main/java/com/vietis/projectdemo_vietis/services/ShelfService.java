package com.vietis.projectdemo_vietis.services;

import com.vietis.projectdemo_vietis.models.entities.Shelf;

import java.util.List;

public interface ShelfService {
    Shelf addShelf(Shelf shelf);
    List<Shelf> getListShelf();

    List<Shelf> search(Integer id);
    void deleteById(Integer id);
}
