package com.vietis.projectdemo_vietis.controllers;

import com.vietis.projectdemo_vietis.models.entities.Gate;
import com.vietis.projectdemo_vietis.models.entities.Warehouse;
import com.vietis.projectdemo_vietis.services.impl.GateServiceImpl;
import com.vietis.projectdemo_vietis.services.impl.WarehouseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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
        Gate gate = new Gate();
        model.addAttribute("gateWh",gate);
        List<Warehouse> warehouseList = warehouseService.getListWarehouse();
        model.addAttribute("warehouse",warehouseList);
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
