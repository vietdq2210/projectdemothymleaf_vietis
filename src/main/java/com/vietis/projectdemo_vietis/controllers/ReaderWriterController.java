package com.vietis.projectdemo_vietis.controllers;

import com.vietis.projectdemo_vietis.models.entities.ReaderWriter;
import com.vietis.projectdemo_vietis.models.entities.Warehouse;
import com.vietis.projectdemo_vietis.services.impl.ReaderWriterServiceImpl;
import com.vietis.projectdemo_vietis.services.impl.WarehouseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/readerWriter")
public class ReaderWriterController {
    @Autowired
    private ReaderWriterServiceImpl readerWriterService;

    @Autowired
    private WarehouseServiceImpl warehouseService;

    @GetMapping("")
    public String getReaderWriterPage(Model model){
        List<Warehouse> warehouseList = warehouseService.getListWarehouse();
        model.addAttribute("listWarehouse",warehouseList);
        List<ReaderWriter> readerWriterList = readerWriterService.getListReaderWriter();
        model.addAttribute("listReaderWriter",readerWriterList);
        return "readerWriterForm";
    }

    @GetMapping("/search")
    public String getReaderWriterById(@RequestParam(name = "id",required=false) Integer id , Model model){
        List<Warehouse> warehouseList = warehouseService.getListWarehouse();
        model.addAttribute("listWarehouse", warehouseList);
        List<ReaderWriter> readerWriterList = readerWriterService.search(id);
        model.addAttribute("listReaderWriter",readerWriterList);
        return "readerWriterForm";
    }

    @PostMapping("/save")
    public String addReaderWriter(@ModelAttribute("readerWriterWh") ReaderWriter readerWriter, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "error";
        }
        readerWriterService.saveReaderWriter(readerWriter);
        return "readerWriter";
    }
}
