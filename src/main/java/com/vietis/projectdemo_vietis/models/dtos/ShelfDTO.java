package com.vietis.projectdemo_vietis.models.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ShelfDTO {
    @NonNull
    private Integer id;
    @NonNull
    private String name;
    @NonNull
    private Integer stageNumber;

    private WarehouseDTO warehouseDTO;
}
