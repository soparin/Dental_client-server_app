package com.Dentist;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.logging.Logger;

@Controller
public class DentistController {

    @Autowired
    private DentistValidator dentistValidator;

    @Autowired()
    @Qualifier(value = "dentistService")
    private DentistService dentistService;
    Logger logger = Logger.getLogger(DentistController.class.getName());
    public void setDentistService(DentistService ps) {
        this.dentistService = ps;
    }

    @RequestMapping(value = "/dentists", method = RequestMethod.GET)
    public String listDentist(Model model) {
        model.addAttribute("dentist", new Dentist());
        model.addAttribute("listDentist", this.dentistService.listDentist());
        return "Dentist";
    }

    @RequestMapping(value = "/dentists/add", method = RequestMethod.POST)
    public String addDent(@ModelAttribute @Valid Dentist dentist, BindingResult result, Model model){
        dentistValidator.validate(dentist, result);
        if(result.hasErrors()){
            model.addAttribute("listDentist", this.dentistService.listDentist());
            return "Dentist";
        }
        if(dentist.getDentistId() == null){
            this.dentistService.addDent(dentist);
        }else {
            this.dentistService.updateDent(dentist);
        }
        return "redirect:/dentists";
    }
    @RequestMapping(value = "/dent/edit", method = RequestMethod.POST)
    public String editDent(@ModelAttribute Dentist dentist, Model model){
        dentist = this.dentistService.getDentById(dentist.getDentistId());
        model.addAttribute("dentist", dentist);
        model.addAttribute("listDentist", this.dentistService.listDentist());

        return "Dentist";
    }

    @RequestMapping(value = "/dent/remove", method = RequestMethod.POST)
    public String deleteCl(@ModelAttribute Dentist dentist)
    {
        this.dentistService.removeDent(dentist.getDentistId());
        return "redirect:/dentists";
    }

}