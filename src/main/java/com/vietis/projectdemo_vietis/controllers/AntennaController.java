package com.vietis.projectdemo_vietis.controllers;

import com.vietis.projectdemo_vietis.models.entities.Antenna;
import com.vietis.projectdemo_vietis.models.entities.Gate;
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
@RequestMapping("/antenna")
public class AntennaController {

    @Autowired
    private AntennaServiceImpl antennaService;

    @Autowired
    private WarehouseServiceImpl warehouseService;

    @Autowired
    private ReaderWriterServiceImpl readerWriterService;

    @GetMapping("")
//    @PreAuthorize("hasAnyRole('ADMIN')")
    public String getAntennaPage(Model model){
        List<Warehouse> warehouseList = warehouseService.getListWarehouse();
        model.addAttribute("listWarehouse",warehouseList);
        List<Antenna> antennaList = antennaService.findAll();
        model.addAttribute("listAntenna",antennaList);
        return "antennaForm";
    }

    @GetMapping("/search")
    public String getAntennaById(@RequestParam(name = "id",required=false) Integer id , Model model){
        List<Warehouse> warehouseList = warehouseService.getListWarehouse();
        model.addAttribute("listWarehouse", warehouseList);
        List<Antenna> antennaList = antennaService.search(id);
        model.addAttribute("listAntenna",antennaList);
        return "antennaForm";
    }

    @GetMapping("/addAntenna")
    public String getAddAntennaPage(Model model){
        Antenna antenna = new Antenna();
        model.addAttribute("antennaWh",antenna);
        return "antenna";
    }
}
