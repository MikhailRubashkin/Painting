package com.example.painting.controller;


import com.example.painting.pojo.Catalog;
import com.example.painting.repository.CatalogRepo;
import com.example.painting.service.CatalogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import java.io.IOException;
import java.util.List;

@Controller
public class CatalogController {

    @Autowired
    CatalogService catalogService;

    @Autowired
    CatalogRepo catalogRepo;

    @GetMapping
    public ModelAndView showCatalogView() {
        ModelAndView view = new ModelAndView();
        view.setViewName("catalog");
        return view;
    }

    @GetMapping("/catalog/{id}/image")
    public @ResponseBody
    byte [] catalogImage( @PathVariable Long id) {
        return catalogService.findCatalog (id).getProductImage ();
    }



    @GetMapping("/mainCatalog")
    public ModelAndView showCatalogViewMainCatalog(Model model) {
        ModelAndView view = new ModelAndView();
        List<Catalog> items =  catalogRepo.findAll ();
        model.addAttribute("result", items);
        view.setViewName("mainCatalog");
        return view;
    }

    @GetMapping("/main")
    public ModelAndView showCatalogViewMain() {
        ModelAndView view = new ModelAndView();
        view.setViewName("main");
        return view;
    }


    @PostMapping
    public String submitCatalogForm(
            @ModelAttribute Catalog item,
            @RequestParam("file") MultipartFile file,
            BindingResult result, Model model ) throws IOException{
        List<Catalog> items =  catalogRepo.findAll ();
        model.addAttribute("result", items);
        item.setItName ("??");
        item.setProductImage(file.getBytes());
        catalogRepo.save(item);
        return "mainCatalog";
    }
}
