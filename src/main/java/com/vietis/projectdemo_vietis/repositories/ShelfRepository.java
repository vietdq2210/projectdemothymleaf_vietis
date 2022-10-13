package com.vietis.projectdemo_vietis.repositories;

import com.vietis.projectdemo_vietis.models.entities.Shelf;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShelfRepository extends JpaRepository<Shelf,Integer> {
}
