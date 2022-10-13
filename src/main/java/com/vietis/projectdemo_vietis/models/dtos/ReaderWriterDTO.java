package com.vietis.projectdemo_vietis.models.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReaderWriterDTO {
    private Integer id;
    private String ipAddress;
    private String address;
    private Integer warehouseId;
}
