package com.Reception;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.logging.Logger;

@Controller
public class ReceptionController {

    @Autowired
    private ReceptionValidator receptionValidator;

    @Autowired()
    @Qualifier(value = "receptionService")
    private ReceptionService receptionService;
    Logger logger = Logger.getLogger(ReceptionController.class.getName());
    public void setReceptionService(ReceptionService ps) {
        this.receptionService = ps;
    }

    @RequestMapping(value = "/receptions", method = RequestMethod.GET)
    public String listReception(Model model) {
        model.addAttribute("reception", new Reception());
        model.addAttribute("listReception", this.receptionService.listReception());
        return "Reception";
    }

    @RequestMapping(value = "/receptions/add", method = RequestMethod.POST)
    public String addRec(@ModelAttribute @Valid Reception reception, BindingResult result, Model model){
        receptionValidator.validate(reception, result);
        if(result.hasErrors()){
            model.addAttribute("listReception", this.receptionService.listReception());
            return "Reception";
        }
        if(reception.getRecCount() == null){
            this.receptionService.addRec(reception);
        }else {
            this.receptionService.updateRec(reception);
        }
        return "redirect:/receptions";
    }

    @RequestMapping(value = "/rec/edit", method = RequestMethod.POST)
    public String editRec(@ModelAttribute Reception reception, Model model){
        reception = this.receptionService.getRecById(reception.getRecCount());
        model.addAttribute("reception", reception);
        model.addAttribute("listReception", this.receptionService.listReception());

        return "Reception";
    }

    @RequestMapping(value = "/rec/remove", method = RequestMethod.POST)
    public String deleteRec(@ModelAttribute Reception reception)
    {
        this.receptionService.removeRec(reception.getRecCount());
        return "redirect:/receptions";
    }
}
