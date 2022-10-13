package com.vietis.projectdemo_vietis.controllers;

import com.vietis.projectdemo_vietis.models.entities.Antenna;
import com.vietis.projectdemo_vietis.models.entities.ReaderWriter;
import com.vietis.projectdemo_vietis.models.entities.Warehouse;
import com.vietis.projectdemo_vietis.services.impl.AntennaServiceImpl;
import com.vietis.projectdemo_vietis.services.impl.ReaderWriterServiceImpl;
import com.vietis.projectdemo_vietis.services.impl.WarehouseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class AntennaController {

    @Autowired
    private AntennaServiceImpl antennaService;

    @Autowired
    private WarehouseServiceImpl warehouseService;

    @Autowired
    private ReaderWriterServiceImpl readerWriterService;

    @GetMapping("/antenna")
    @PreAuthorize("hasAnyRole('ADMIN')")
    public String getAntennaPage(Model model){
        Antenna antenna = new Antenna();
        model.addAttribute("antennaWh",antenna);
        List<Warehouse> warehouseList = warehouseService.getListWarehouse();
        model.addAttribute("listWarehouse",warehouseList);
        List<ReaderWriter> readerWriterList = readerWriterService.getListReaderWriter();
        model.addAttribute("listReaderWriter",readerWriterList);
        return "antenna";
    }

    @PostMapping("/getReaderWriter")
    public @ResponseBody
    Map<String, String> getStateCityValues(@RequestParam("warehouse") Integer warehouseId) {
        Map<String, String> readerWriterValue = new HashMap<>();

        List<ReaderWriter> readerWriters = readerWriterService.getByWarehouseId(warehouseId);

        for(ReaderWriter readerWriter : readerWriters){
            readerWriterValue.put(String.valueOf(readerWriter.getId()), readerWriter.getAddress());
        }

        return readerWriterValue;
    }
}
