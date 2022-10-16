package com.vietis.projectdemo_vietis.services.impl;

import com.vietis.projectdemo_vietis.models.entities.ReaderWriter;
import com.vietis.projectdemo_vietis.repositories.ReaderWriterRepository;
import com.vietis.projectdemo_vietis.services.ReaderWriterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReaderWriterServiceImpl implements ReaderWriterService {

    @Autowired
    private ReaderWriterRepository readerWriterRepository;

    @Override
    public ReaderWriter saveReaderWriter(ReaderWriter readerWriter) {
        return readerWriterRepository.save(readerWriter);
    }

    @Override
    public List<ReaderWriter> getListReaderWriter() {
        return readerWriterRepository.findAll();
    }

    @Override
    public List<ReaderWriter> getByWarehouseId(int warehouseId) {
        return readerWriterRepository.findById(warehouseId).stream().toList();
    }

    @Override
    public List<ReaderWriter> search(Integer warehouseId) {
        List<ReaderWriter> readerWriters;
        if(warehouseId==null){
            readerWriters = readerWriterRepository.findAll();
        }
        else{
            readerWriters = readerWriterRepository.getReaderWriterById(warehouseId);
        }
        return readerWriters;
    }

    @Override
    public void deleteById(Integer id) {
        readerWriterRepository.deleteById(id);
    }
}
