package com.vietis.projectdemo_vietis.repositories;

import com.vietis.projectdemo_vietis.models.entities.Shelf;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShelfRepository extends JpaRepository<Shelf,Integer> {
    @Query("select s from Shelf s inner join Warehouse w on s.warehouseId = w.id where s.warehouseId = :id")
    List<Shelf> getShelfById(@Param("id") Integer id);
}
