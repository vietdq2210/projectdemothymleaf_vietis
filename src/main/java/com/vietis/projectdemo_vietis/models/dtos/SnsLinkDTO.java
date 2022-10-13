package com.vietis.projectdemo_vietis.models.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SnsLinkDTO {
    private Integer id;
    private String message;
    private Integer lineWorksId;
    private Integer statusId;
}
