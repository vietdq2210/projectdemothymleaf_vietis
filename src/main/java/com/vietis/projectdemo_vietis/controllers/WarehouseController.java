package com.vietis.projectdemo_vietis.controllers;

import com.vietis.projectdemo_vietis.models.entities.Shelf;
import com.vietis.projectdemo_vietis.models.entities.Warehouse;
import com.vietis.projectdemo_vietis.services.impl.WarehouseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("warehouse")
public class WarehouseController {
    @Autowired
    private WarehouseServiceImpl warehouseService;


    @GetMapping("")
    public String getWarehousePage(Model model) {
        Warehouse warehouse = new Warehouse();
        model.addAttribute("warehouse", warehouse);
        List<Warehouse> warehouseList = warehouseService.getListWarehouse();
        model.addAttribute("listWarehouse", warehouseList);
        return "warehouseForm";
    }

    @PostMapping("/save")
    public String saveWarehouse(@ModelAttribute("warehouse") Warehouse warehouse, Model model, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "403";
        } else {
            warehouseService.saveWarehouse(warehouse);
            List<Warehouse> warehouseList = warehouseService.getListWarehouse();
            model.addAttribute("listWarehouse", warehouseList);
        }
        return "warehouseForm";
    }

    @GetMapping("/update/{id}")
    public String getEditWarehouseModal(Model model, @PathVariable Integer id){
        Warehouse warehouse = new Warehouse();
        model.addAttribute("warehouse", warehouse);
        List<Warehouse> warehouseList = warehouseService.getListWarehouse();
        model.addAttribute("listWarehouse", warehouseList);
        return "warehouseForm";
    }

    @PostMapping("/update/{id}")
    public String updateWarehouse(Model model, @ModelAttribute("warehouse") Warehouse warehouse) {
        warehouseService.saveWarehouse(warehouse);
        List<Warehouse> warehouseList = warehouseService.getListWarehouse();
        model.addAttribute("listWarehouse", warehouseList);
        return "warehouseForm";
    }

    @GetMapping("/delete")
    public String deleteWarehouse(Model model,@RequestParam(name = "warehouseId",required=true) Integer id){
        warehouseService.deleteById(id);
        return "redirect:" + "/warehouse";
    }
}
