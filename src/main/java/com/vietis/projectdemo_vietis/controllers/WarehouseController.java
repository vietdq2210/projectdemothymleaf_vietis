package com.vietis.projectdemo_vietis.controllers;

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
}
