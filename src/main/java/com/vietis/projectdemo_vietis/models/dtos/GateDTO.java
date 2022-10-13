package com.vietis.projectdemo_vietis.models.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GateDTO {
    private Integer id;
    private String name;
    private String ipAddress;
    private Integer warehouseId;
    private String warehouseName;
}
