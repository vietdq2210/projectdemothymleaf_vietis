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
import org.springframework.validation.BindingResult;
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
        Antenna antenna = new Antenna();
        model.addAttribute("antennaWh",antenna);
        getData(model);
        List<Antenna> antennaList = antennaService.findAll();
        model.addAttribute("listAntenna",antennaList);
        model.addAttribute("check",0);
        return "antennaForm";
    }

    @PostMapping("/search")
    public String getAntennaById(Model model,@RequestParam(name = "id",required=false) Integer id ){
        Antenna antenna = new Antenna();
        model.addAttribute("antennaWh",antenna);
        getData(model);
        List<Antenna> antennaList = antennaService.search(id);
        model.addAttribute("listAntenna",antennaList);
        return "antennaForm";
    }

    @PostMapping("/save")
    public String addAntenna(Model model, @ModelAttribute("antennaWh") Antenna antenna, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            System.out.println("There was a error " + bindingResult);
            return "403";
        }
        antennaService.saveAntenna(antenna);
        getData(model);
        List<Antenna> antennaList = antennaService.findAll();
        model.addAttribute("listAntenna",antennaList);
        return "antennaForm";
    }

    @GetMapping("/update/{id}")
    public String getEditAntennaModal(Model model, @PathVariable Integer id){
        getData(model);
        List<Antenna> antennaList = antennaService.findAll();
        model.addAttribute("listAntenna",antennaList);
        return "antennaForm";
    }

    @PostMapping("/update/{id}")
    public String updateAntenna(Model model, @ModelAttribute("antennaWh") Antenna antenna) {
        antennaService.saveAntenna(antenna);
        getData(model);
        List<Antenna> antennaList = antennaService.findAll();
        model.addAttribute("listAntenna",antennaList);
        return "antennaForm";
    }

    @GetMapping("/delete")
    public String deleteAntenna(Model model,@RequestParam(name = "antennaId",required=true) Integer id){
        antennaService.deleteById(id);
        getData(model);
        return "redirect:" + "/antenna";
    }

    public void getData(Model model){
        List<Warehouse> warehouseList = warehouseService.getListWarehouse();
        model.addAttribute("listWarehouse",warehouseList);
        List<ReaderWriter> readerWriterList = readerWriterService.getListReaderWriter();
        model.addAttribute("listReaderWriter",readerWriterList);
    }
}
