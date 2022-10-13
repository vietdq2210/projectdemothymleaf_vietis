package com.vietis.projectdemo_vietis.models.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AntennaDTO {
    private Integer id;
    private Integer portNo;
    private Integer stageNumber;
    private Integer warehouseId;
    private Integer statusId;
}
