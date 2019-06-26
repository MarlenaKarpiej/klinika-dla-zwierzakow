package com.sad.klinika.dla.zwierzakow.view;


import com.sad.klinika.dla.zwierzakow.domain.entity.OwnerEntity;
import com.sad.klinika.dla.zwierzakow.domain.repository.OwnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
public class OwnerView {

    @Autowired
    private OwnerRepository ownerRepository;

    @Autowired
    public OwnerView(OwnerRepository ownerRepository) {
        this.ownerRepository = ownerRepository;
    }

    @GetMapping("/index")
    public String homePage() {
        return "index";
    }

    @GetMapping("/form")
    public String addOwners(Model model) {
        model.addAttribute("newOwner", new OwnerEntity());
        return "form";
    }

    @PostMapping("/registered-owner")
    public String saveOwner(@ModelAttribute("owner") OwnerEntity ownerEntity){
        ownerRepository.save(ownerEntity);
        System.out.println(ownerEntity);
        return "registered-owner";
    }

    @GetMapping("/list-owner")
    public String ownerList(Model model){
        model.addAttribute("allOwners", ownerRepository.findAll());
        return "list-owner";
    }

    @GetMapping("/delete-owner")
    public String deleteAnimal(@RequestParam("id") Long id) {
        ownerRepository.deleteById(id);
        return "delete-owner";
    }

    @GetMapping("/edit-owner")
    public String editOwner(@RequestParam("id") Long id, Model model){
        Optional<OwnerEntity> maybeOwner = ownerRepository.findById(id);

        if(maybeOwner.isPresent()){
            model.addAttribute("owner", maybeOwner.get());
            return "edit-owner";
        } else{
            return "redirect:/form";
        }
    }

    @PostMapping("/edit-owner")
    public String editOwnerPost (@ModelAttribute("owner") OwnerEntity ownerEntity){
        ownerRepository.save(ownerEntity);
        return "redirect:/list-owner";
    }




}
