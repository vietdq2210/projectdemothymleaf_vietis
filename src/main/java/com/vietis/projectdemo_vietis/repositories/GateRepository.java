package com.vietis.projectdemo_vietis.repositories;

import com.vietis.projectdemo_vietis.models.entities.Gate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GateRepository extends JpaRepository<Gate,Integer> {

}
