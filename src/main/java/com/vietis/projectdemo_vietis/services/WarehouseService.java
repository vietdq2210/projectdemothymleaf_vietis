package com.vietis.projectdemo_vietis.services;

import com.vietis.projectdemo_vietis.models.entities.Warehouse;

import java.util.List;

public interface WarehouseService {


    Warehouse saveWarehouse(Warehouse warehouse);

    List<Warehouse> getListWarehouse();
    void deleteById(Integer id);
}
