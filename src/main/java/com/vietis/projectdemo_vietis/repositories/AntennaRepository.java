package com.vietis.projectdemo_vietis.repositories;


import com.vietis.projectdemo_vietis.models.entities.Antenna;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AntennaRepository extends JpaRepository<Antenna,Integer> {
}
