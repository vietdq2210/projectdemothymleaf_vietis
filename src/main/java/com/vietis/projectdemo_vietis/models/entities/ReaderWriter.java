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
@Table(name = "reader_writer")
public class ReaderWriter {
    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "ip_address")
    private String ipAddress;

    @Column(name = "address")
    private String address;

    @Column(name = "warehouse_id")
    private Integer warehouseId;

    }
