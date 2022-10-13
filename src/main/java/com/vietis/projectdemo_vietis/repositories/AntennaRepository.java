package com.vietis.projectdemo_vietis.repositories;


import com.vietis.projectdemo_vietis.models.entities.Antenna;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AntennaRepository extends JpaRepository<Antenna,Integer> {
    @Query("select a from Antenna a inner join Warehouse w on a.warehouseId = w.id where a.warehouseId = :id")
    List<Antenna> getAntennaById(@Param("id") Integer id);
}
