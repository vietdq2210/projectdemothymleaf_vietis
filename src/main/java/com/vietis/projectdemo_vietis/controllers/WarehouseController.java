package com.vietis.projectdemo_vietis.controllers;

import com.vietis.projectdemo_vietis.models.entities.Warehouse;
import com.vietis.projectdemo_vietis.services.impl.WarehouseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class WarehouseController {
    @Autowired
    private WarehouseServiceImpl warehouseService;


    @GetMapping("/warehouse")
    public String getWarehousePage(Model model) {
        List<Warehouse> warehouseList = warehouseService.getListWarehouse();
        model.addAttribute("listWarehouse",warehouseList);
        return "warehouseForm";
    }

    @GetMapping("/addWarehouse")
    public String getAddWarehousePage() {
        return "warehouse";
    }
    @PostMapping("/warehouse/save")
    public String saveWarehouse(@RequestParam("wh_id") Integer id, @RequestParam("wh_name") String name,
                                @RequestParam("address") String address, Warehouse warehouse, Model model, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "error";
        }
        warehouse.setId(id);
        warehouse.setName(name);
        warehouse.setAddress(address);
        warehouseService.saveWarehouse(warehouse);
        model.addAttribute("addWarehouse", "add thành công warehouse");
        return "warehouse";
    }
}
