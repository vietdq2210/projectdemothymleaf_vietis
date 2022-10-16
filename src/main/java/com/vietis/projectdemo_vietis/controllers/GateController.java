package com.vietis.projectdemo_vietis.controllers;

import com.vietis.projectdemo_vietis.models.entities.Antenna;
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
        Gate gate = new Gate();
        model.addAttribute("gateWh",gate);
        List<Warehouse> warehouseList = warehouseService.getListWarehouse();
        model.addAttribute("listWarehouse",warehouseList);
        List<Gate> gateList = gateService.getListAllGate();
        model.addAttribute("listGate",gateList);
        return "gateForm";
    }

    @PostMapping("/search")
    public String getGateById(@RequestParam(name = "id",required=false) Integer id , Model model){
        Gate gate = new Gate();
        model.addAttribute("gateWh",gate);
        List<Warehouse> warehouseList = warehouseService.getListWarehouse();
        model.addAttribute("listWarehouse", warehouseList);
        List<Gate> gateList = gateService.search(id);
        model.addAttribute("listGate",gateList);
        return "gateForm";
    }

    @PostMapping("/save")
    public String addGate(Model model,@ModelAttribute("gateWh") Gate gate,BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            System.out.println("There was a error " + bindingResult);
            return "403";
        }
        gateService.addGate(gate);
        List<Warehouse> warehouseList = warehouseService.getListWarehouse();
        model.addAttribute("listWarehouse", warehouseList);
        List<Gate> gateList = gateService.getListAllGate();
        model.addAttribute("listGate",gateList);
        return "gateForm";
    }

    @GetMapping("/update/{id}")
    public String getEditGateModal(Model model, @PathVariable Integer id){
        Gate gate = new Gate();
        model.addAttribute("gateWh",gate);
        List<Warehouse> warehouseList = warehouseService.getListWarehouse();
        model.addAttribute("listWarehouse", warehouseList);
        List<Gate> gateList = gateService.getListAllGate();
        model.addAttribute("listGate",gateList);
        return "gateForm";
    }

    @PostMapping("/update/{id}")
    public String updateAntenna(Model model, @ModelAttribute("gateWh") Gate gate) {
        gateService.addGate(gate);
        List<Warehouse> warehouseList = warehouseService.getListWarehouse();
        model.addAttribute("listWarehouse", warehouseList);
        List<Gate> gateList = gateService.getListAllGate();
        model.addAttribute("listGate",gateList);
        return "gateForm";
    }

    @GetMapping("/delete")
    public String deleteGate(Model model,@RequestParam(name = "gateId",required=true) Integer id){
        gateService.deleteById(id);
        return "redirect:" + "/gate";
    }
}
