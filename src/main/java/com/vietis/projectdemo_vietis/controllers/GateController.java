package com.vietis.projectdemo_vietis.controllers;

import com.vietis.projectdemo_vietis.models.entities.Gate;
import com.vietis.projectdemo_vietis.models.entities.Shelf;
import com.vietis.projectdemo_vietis.models.entities.Warehouse;
import com.vietis.projectdemo_vietis.services.impl.GateServiceImpl;
import com.vietis.projectdemo_vietis.services.impl.WarehouseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/gate")
public class GateController {

    @Autowired
    private GateServiceImpl gateService;

    @Autowired
    private WarehouseServiceImpl warehouseService;

    @GetMapping("")
    public String getGatePage(Model model){
        List<Warehouse> warehouseList = warehouseService.getListWarehouse();
        model.addAttribute("listWarehouse",warehouseList);
        List<Gate> gateList = gateService.getListAllGate();
        model.addAttribute("listGate",gateList);
        return "gateForm";
    }

    @GetMapping("/search")
    public String getGateById(@RequestParam(name = "id",required=false) Integer id , Model model){
        List<Warehouse> warehouseList = warehouseService.getListWarehouse();
        model.addAttribute("listWarehouse", warehouseList);
        List<Gate> gateList = gateService.search(id);
        model.addAttribute("listGate",gateList);
        return "gateForm";
    }

    @GetMapping("/addGate")
    public String getAddShelfPage(Model model){
        Gate gate = new Gate();
        model.addAttribute("gateWh",gate);
        return "gate";
    }

    @PostMapping("/save")
    public String addGate(@ModelAttribute("gateWh") Gate gate, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "error";
        }
        gateService.addGate(gate);
        return "gate";
    }
}
