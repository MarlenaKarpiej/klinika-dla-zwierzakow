package com.sad.klinika.dla.zwierzakow.controller;


import com.sad.klinika.dla.zwierzakow.domain.entity.OwnerEntity;
import com.sad.klinika.dla.zwierzakow.domain.repository.OwnerRepository;
import com.sad.klinika.dla.zwierzakow.model.FilterForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class OwnerController {

    private OwnerRepository ownerRepository;

    @Autowired
    public OwnerController(OwnerRepository ownerRepository) {
        this.ownerRepository = ownerRepository;
    }

    @GetMapping("/index")
    public String homePage() {
        return "index";
    }

    @GetMapping("/form")
    public String addOwner(Model model) {
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

    @GetMapping("/delete-owner/{ownerId}")
    public String deleteOwner(@PathVariable("ownerId") Long id) {
        ownerRepository.deleteById(id);
        return "delete-owner";
    }

    @GetMapping("/edit-owner/{ownerId}")
    public String editOwner(@PathVariable("ownerId") Long id, Model model){
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

    @GetMapping("/search")
    public String searchFirstNameAndLastName(Model model) {
        model.addAttribute("filterForm", new FilterForm());
        return "search";
    }

    @PostMapping("/search")
    public String searchFilter(@ModelAttribute("filterForm") FilterForm filterForm, Model model) {
        List<OwnerEntity> foundOwner = ownerRepository.findByFirstNameOrLastNameContaining(
                filterForm.getFirstName(), filterForm.getLastName());
        model.addAttribute("allOwners", foundOwner);
        return "list-owner";
    }




}
