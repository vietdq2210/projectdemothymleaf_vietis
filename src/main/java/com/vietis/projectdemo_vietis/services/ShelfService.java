package com.vietis.projectdemo_vietis.services;

import com.vietis.projectdemo_vietis.models.entities.Shelf;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

public interface ShelfService {
    Shelf addShelf(Shelf shelf);
    List<Shelf> getListShelf();

    List<Shelf> search(Integer id);
    void deleteById(Integer id);
}
