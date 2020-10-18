package com.ndirangu.petlover.controller;
import com.ndirangu.petlover.model.Owner;
import com.ndirangu.petlover.service.OwnerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RequestMapping("/owners")
@Controller
public class OwnerController {
    private static final String VIEWS_OWNER_CREATE_OR_UPDATE_FORM = "owner/createOrUpdateOwnerForm";

    private final OwnerService ownerService;

    public OwnerController(OwnerService ownerService) {
        this.ownerService = ownerService;
    }

    /**
     * This is an old school way of ensuring that no one can manipulate and change the id fields
     *
     */
    @InitBinder
    public void setAllowedFields(WebDataBinder webDataBinder){
        webDataBinder.setDisallowedFields("id");
    }


    @RequestMapping("/find")
    public String findOwners(Model model){
        model.addAttribute("owners", Owner.builder().build());
        return "owner/findOwners";
    }

    @GetMapping("/{ownerId}")
    public ModelAndView showOwner(@PathVariable("ownerId") Long ownerId) {
        ModelAndView mav = new ModelAndView("owner/ownerDetails");

        mav.addObject(ownerService.findById(ownerId));
        return mav;
    }
    @GetMapping
    public String processFindForm(Owner owner, BindingResult result, Model model){

        //allow parameterless GET request for /owners to return all records
        if (owner.getLastName() == null){
            owner.setLastName("");
        }

        //find owners by last name
        List<Owner> ownersList = ownerService.findAllByLastNameLike("%"+owner.getLastName()+"%");

        if (ownersList.isEmpty()){
            result.rejectValue("lastName", "notFound", "not found");
            return "owner/findOwners";

        }else if (ownersList.size() == 1){
            owner = ownersList.get(0);
            return "redirect:/owners/" + owner.getId();

        }else {
            model.addAttribute("selections", ownersList);
            return "owner/ownerList";
        }
    }

    @GetMapping("/new")
    public String initCreateOwnerForm (Model model){
        model.addAttribute("owner", Owner.builder().build());
        return VIEWS_OWNER_CREATE_OR_UPDATE_FORM;
    }

    @PostMapping("/new")
    public String processCreateOwnerForm( Owner owner, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return VIEWS_OWNER_CREATE_OR_UPDATE_FORM;
        }else {
            Owner savedOwner = ownerService.save(owner);
            return "redirect:/owners/" + savedOwner.getId();
        }
    }

    @GetMapping("/{ownerId}/edit")
    public String initUpdateOwnerForm (@PathVariable Long ownerId,  Model model){
        model.addAttribute(ownerService.findById(ownerId));
        return VIEWS_OWNER_CREATE_OR_UPDATE_FORM;
    }

    @PostMapping("/{ownerId}/edit")
    public String processUpdateOwnerForm(
            @PathVariable Long ownerId,
            Owner owner,
            BindingResult bindingResult) {

        if (bindingResult.hasErrors()){
            return VIEWS_OWNER_CREATE_OR_UPDATE_FORM;
        }else {
            owner.setId(ownerId);
            Owner savedOwner = ownerService.save(owner);
            return "redirect:/owners/" + savedOwner.getId();
        }
    }
}
