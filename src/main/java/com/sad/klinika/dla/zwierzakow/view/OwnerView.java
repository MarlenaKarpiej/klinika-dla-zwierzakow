package com.sad.klinika.dla.zwierzakow.view;


import com.sad.klinika.dla.zwierzakow.domain.entity.OwnerEntity;
import com.sad.klinika.dla.zwierzakow.domain.repository.OwnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class OwnerView {
    private OwnerRepository ownerRepository;

    @Autowired
    public OwnerView(OwnerRepository ownerRepository) {
        this.ownerRepository = ownerRepository;
    }

    @GetMapping("/add-owner")
    public String addOwners(Model model) {
        model.addAttribute("newOwner", new OwnerEntity());
        return "add-owner";
    }

    @GetMapping("/index")
    public String homePage() {
        return "index";
    }

}
