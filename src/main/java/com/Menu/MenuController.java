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
import java.util.List;
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
        model.addAttribute("MenuInput", new MenuInput());
        model.addAttribute("MenuForDent", new MenuInput());
        return "index";
    }

    @RequestMapping(value = "/run/pat", method = RequestMethod.POST)
    public String PatQuery(@ModelAttribute MenuInput mp, Model model) {
        model.addAttribute("qList", this.menuService.patQuery(mp.getSpec(), mp.getDate()));
        return "patQ";
    }

    @RequestMapping(value = "/run/dent", method = RequestMethod.POST)
    public String DentQuery(@ModelAttribute MenuInput mp, Model model) {
        model.addAttribute("qList", this.menuService.dentQuery(mp.getNum(), mp.getDate()));
        return "dentQ";
    }

}