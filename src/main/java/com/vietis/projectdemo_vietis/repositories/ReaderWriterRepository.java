package com.vietis.projectdemo_vietis.repositories;

import com.vietis.projectdemo_vietis.models.entities.ReaderWriter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReaderWriterRepository extends JpaRepository<ReaderWriter,Integer> {
    @Query("select rw from ReaderWriter rw inner join Warehouse w on rw.warehouseId = w.id where rw.warehouseId = :id")
    List<ReaderWriter> getReaderWriterById(@Param("id") Integer id);
}
