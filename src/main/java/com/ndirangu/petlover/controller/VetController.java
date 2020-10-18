package com.ndirangu.petlover.controller;

import com.ndirangu.petlover.model.Vet;
import com.ndirangu.petlover.service.VetService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Set;

@Controller
public class VetController {
    private final VetService vetService;

    public VetController(VetService vetService) {
        this.vetService = vetService;
    }

    @RequestMapping({"/vets","vets.html"})
    public String listVets(Model model){
        model.addAttribute("vets", vetService.findAll());
        return "vet/vetList";
    }

    @GetMapping("/api/vets")
    public @ResponseBody Set<Vet> list(){
        return vetService.findAll();
    }
}
