package com.vietis.projectdemo_vietis.controllers;

import com.vietis.projectdemo_vietis.models.entities.Shelf;
import com.vietis.projectdemo_vietis.models.entities.Warehouse;
import com.vietis.projectdemo_vietis.services.WarehouseService;
import com.vietis.projectdemo_vietis.services.impl.ShelfServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
@RequestMapping("/shelf")
public class ShelfController {
    @Autowired
    private ShelfServiceImpl shelfService;

    @Autowired
    private WarehouseService warehouseService;


    @GetMapping("")
    public String getShelfPage(Model model) {
        Shelf shelf = new Shelf();
        model.addAttribute("shelfWh", shelf);
        List<Warehouse> warehouseList = warehouseService.getListWarehouse();
        model.addAttribute("listWarehouse", warehouseList);
        List<Shelf> shelfList = shelfService.getListShelf();
        model.addAttribute("listShelf",shelfList);
        return "shelfForm";
    }

    @PostMapping("/save")
    public String addShelf(Model model,@ModelAttribute("shelfWh") Shelf shelf,BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            System.out.println("There was a error " + bindingResult);
            return "403";
        }
        shelfService.addShelf(shelf);
        List<Warehouse> warehouseList = warehouseService.getListWarehouse();
        model.addAttribute("listWarehouse", warehouseList);
        List<Shelf> shelfList = shelfService.getListShelf();
        model.addAttribute("listShelf",shelfList);
        return "shelfForm";
    }

    @GetMapping("/search")
    public String getShelfById(Model model, @RequestParam(name = "id",required=false) Integer id ){
        List<Warehouse> warehouseList = warehouseService.getListWarehouse();
        model.addAttribute("listWarehouse", warehouseList);
        List<Shelf> shelfList = shelfService.search(id);
        model.addAttribute("listShelf",shelfList);
        return "shelfForm";
    }
}
