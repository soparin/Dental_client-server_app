package com.Menu;

import com.Dentist.Dentist;
import com.Menu.PatientMenu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.logging.Logger;

@Controller
public class MenuController {

    @Autowired()
    @Qualifier(value = "menuService")
    private MenuService menuService;
    Logger logger = Logger.getLogger(MenuController.class.getName());

    public void setMenuService(MenuService ms) {
        this.menuService = ms;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String menu(Model model) {
        model.addAttribute("PatientMenu", new MenuInput());
        model.addAttribute("patient", new PatientMenu());
        model.addAttribute("DentistMenu", new DentistMenu());
//        model.addAttribute("spec", new String());
        model.addAttribute("date", new String());
        model.addAttribute("policy", new String());
        return "index";
    }

    @RequestMapping(value = "/run/pat", method = RequestMethod.POST)
    public String query(@ModelAttribute @Valid String spec, String date, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "redirect:/run/pat";
        }
        model.addAttribute("qList", this.menuService.patQuery(spec, date));

        return "patQ";
    }

}