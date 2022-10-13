package com.vietis.projectdemo_vietis.repositories;

import com.vietis.projectdemo_vietis.models.entities.Gate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GateRepository extends JpaRepository<Gate,Integer> {
    @Query("select g from Gate g inner join Warehouse w on g.warehouseId = w.id where g.warehouseId = :id")
    List<Gate> getGateById(@Param("id") Integer id);
}
