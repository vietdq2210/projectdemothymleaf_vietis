package com.vietis.projectdemo_vietis.models.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "antenna")
public class Antenna {
    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "port_no")
    private Integer portNo;

    @Column(name = "stage_number")
    private Integer stageNumber;

    @Column(name = "warehouse_id")
    private Integer warehouseId;

    @Column(name = "reader_writer_id")
    private Integer readerWriterId;

    @Column(name = "status_id")
    private Integer statusId;

    @Column(name = "shelf_id")
    private Integer shelfId;
}
