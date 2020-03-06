package com.example.painting.controller;


import com.example.painting.pojo.Catalog;
import com.example.painting.repository.CatalogRepo;
import com.example.painting.service.CatalogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
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
    public ModelAndView showCatalogView(Model model) {
        String user = SecurityContextHolder.getContext ( ).getAuthentication ( ).getName ( );
        model.addAttribute ("user", user);
        ModelAndView view = new ModelAndView();
        view.setViewName("catalog");
        return view;
    }

    @GetMapping("/catalog/{id}/image")
    public @ResponseBody
    byte [] catalogImage( @PathVariable Long id, Model model) {
        String user = SecurityContextHolder.getContext ( ).getAuthentication ( ).getName ( );
        model.addAttribute ("user", user);
        return catalogService.findCatalog (id).getProductImage ();
    }



    @GetMapping("/mainCatalog")
    public ModelAndView showCatalogViewMainCatalog(Model model) {
        String user = SecurityContextHolder.getContext ( ).getAuthentication ( ).getName ( );
        model.addAttribute ("user", user);
        ModelAndView view = new ModelAndView();
        List<Catalog> items =  catalogRepo.findAll ();
        model.addAttribute("result", items);
        view.setViewName("mainCatalog");
        return view;
    }
    @GetMapping("/price")
    public ModelAndView showCatalogViewPrice(Model model) {
        String user = SecurityContextHolder.getContext ( ).getAuthentication ( ).getName ( );
        model.addAttribute ("user", user);
        ModelAndView view = new ModelAndView();
        List<Catalog> items =  catalogRepo.findAll ();
        model.addAttribute("result", items);
        view.setViewName("price");
        return view;
    }
    @GetMapping("/body_repair")
    public ModelAndView showCatalogViewBodyRepair(Model model) {
        String user = SecurityContextHolder.getContext ( ).getAuthentication ( ).getName ( );
        model.addAttribute ("user", user);
        ModelAndView view = new ModelAndView();
        List<Catalog> items =  catalogRepo.findAll ();
        model.addAttribute("result", items);
        view.setViewName("body_repair");
        return view;
    }
    @GetMapping("/painting_car")
    public ModelAndView showCatalogViewPaintingCar(Model model) {
        String user = SecurityContextHolder.getContext ( ).getAuthentication ( ).getName ( );
        model.addAttribute ("user", user);
        ModelAndView view = new ModelAndView();
        List<Catalog> items =  catalogRepo.findAll ();
        model.addAttribute("result", items);
        view.setViewName("painting_car");
        return view;
    }
    @GetMapping("/rust_removal")
    public ModelAndView showCatalogViewRustRemoval(Model model) {
        String user = SecurityContextHolder.getContext ( ).getAuthentication ( ).getName ( );
        model.addAttribute ("user", user);
        ModelAndView view = new ModelAndView();
        List<Catalog> items =  catalogRepo.findAll ();
        model.addAttribute("result", items);
        view.setViewName("rust_removal");
        return view;
    }
    @GetMapping("/body_polishing")
    public ModelAndView showCatalogViewBodyPolishing(Model model) {
        String user = SecurityContextHolder.getContext ( ).getAuthentication ( ).getName ( );
        model.addAttribute ("user", user);
        ModelAndView view = new ModelAndView();
        List<Catalog> items =  catalogRepo.findAll ();
        model.addAttribute("result", items);
        view.setViewName("body_polishing");
        return view;
    }
    @GetMapping("/headlight_polishing")
    public ModelAndView showCatalogViewHeadlightPolishing(Model model) {
        String user = SecurityContextHolder.getContext ( ).getAuthentication ( ).getName ( );
        model.addAttribute ("user", user);
        ModelAndView view = new ModelAndView();
        List<Catalog> items =  catalogRepo.findAll ();
        model.addAttribute("result", items);
        view.setViewName("headlight_polishing");
        return view;
    }
    @GetMapping("/bumper_repair")
    public ModelAndView showCatalogViewBumperRepair(Model model) {
        String user = SecurityContextHolder.getContext ( ).getAuthentication ( ).getName ( );
        model.addAttribute ("user", user);
        ModelAndView view = new ModelAndView();
        List<Catalog> items =  catalogRepo.findAll ();
        model.addAttribute("result", items);
        view.setViewName("bumper_repair");
        return view;
    }
    @GetMapping("/painting_discs")
    public ModelAndView showCatalogViewPaintingDiscs(Model model) {
        String user = SecurityContextHolder.getContext ( ).getAuthentication ( ).getName ( );
        model.addAttribute ("user", user);
        ModelAndView view = new ModelAndView();
        List<Catalog> items =  catalogRepo.findAll ();
        model.addAttribute("result", items);
        view.setViewName("painting_discs");
        return view;
    }
    @GetMapping("/contacts")
    public ModelAndView showCatalogViewContacts(Model model) {
        String user = SecurityContextHolder.getContext ( ).getAuthentication ( ).getName ( );
        model.addAttribute ("user", user);
        ModelAndView view = new ModelAndView();
        List<Catalog> items =  catalogRepo.findAll ();
        model.addAttribute("result", items);
        view.setViewName("contacts");
        return view;
    }

    @GetMapping("/login")
    public ModelAndView showCatalogViewMain(Model model) {
        String user = SecurityContextHolder.getContext ( ).getAuthentication ( ).getName ( );
        int resultRandom2 = catalogService.randomNumber();
        model.addAttribute ("resultRandom", resultRandom2);
        model.addAttribute ("user", user);
        ModelAndView view = new ModelAndView();
        view.setViewName("login");
        return view;
    }


    @PostMapping
    public String submitCatalogForm(
            @RequestParam String itName,
            @ModelAttribute Catalog item,
            @RequestParam("file") MultipartFile file,
             Model model ) throws IOException{
        String user = SecurityContextHolder.getContext ( ).getAuthentication ( ).getName ( );
        model.addAttribute ("user", user);
        List<Catalog> items =  catalogRepo.findAll ();
        model.addAttribute("result", items);
        item.setItName (itName);
        item.setProductImage(file.getBytes());
        catalogRepo.save(item);
        return "catalog";
    }
}
