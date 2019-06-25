package com.sad.klinika.dla.zwierzakow.controller;

import com.sad.klinika.dla.zwierzakow.domain.entity.OwnerEntity;
import com.sad.klinika.dla.zwierzakow.service.OwnerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@RestController
@RequiredArgsConstructor
@RequestMapping("/owner")
@Slf4j
public class OwnerController {

    private final OwnerService ownerService;

    @GetMapping("/create")
    public String createOwnerForm(Model model) {
        model.addAttribute("owner", new OwnerEntity());
        return "owner/form";
    }

    @PostMapping("/create")
    public String createOwner(@ModelAttribute("owner") OwnerEntity ownerEntity) {
        ownerService.createOwner(ownerEntity);
        log.info("Created new owner {}", ownerEntity);

        return "redirect:/owner/list";
    }

    @GetMapping("/list")
    public String ownerList(Model model) {
        Iterable<OwnerEntity> owners = ownerService.getAllOwners();
        model.addAttribute("owners", owners);

        return "owner/list";
    }

}
