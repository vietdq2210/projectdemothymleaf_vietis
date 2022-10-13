package com.vietis.projectdemo_vietis.services;

import com.vietis.projectdemo_vietis.models.entities.ReaderWriter;

import java.util.List;

public interface ReaderWriterService {
    ReaderWriter saveReaderWriter(ReaderWriter readerWriter);

    List<ReaderWriter> getListReaderWriter();

    List<ReaderWriter> getByWarehouseId(int warehouseId);

    List<ReaderWriter> search(Integer id);
}
