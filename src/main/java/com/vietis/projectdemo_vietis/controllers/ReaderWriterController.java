package com.vietis.projectdemo_vietis.controllers;

import com.vietis.projectdemo_vietis.models.entities.ReaderWriter;
import com.vietis.projectdemo_vietis.models.entities.Warehouse;
import com.vietis.projectdemo_vietis.services.impl.ReaderWriterServiceImpl;
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
@RequestMapping("/readerWriter")
public class ReaderWriterController {
    @Autowired
    private ReaderWriterServiceImpl readerWriterService;

    @Autowired
    private WarehouseServiceImpl warehouseService;

    @GetMapping("")
    public String getReaderWriterPage(Model model){
        ReaderWriter readerWriter = new ReaderWriter();
        model.addAttribute("readerWriterWh", readerWriter);
        List<Warehouse> warehouseList = warehouseService.getListWarehouse();
        model.addAttribute("warehouse",warehouseList);
        return "reader_writer";
    }

    @PostMapping("/save")
    public String addReaderWriter(@ModelAttribute("readerWriterWh") ReaderWriter readerWriter, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "error";
        }
        readerWriterService.saveReaderWriter(readerWriter);
        return "reader_writer";
    }
}
