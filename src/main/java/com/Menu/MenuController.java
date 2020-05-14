package com.Menu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
    public String menu(Model model){
        model.addAttribute("menu", new Menu());
        return "index";
    }
}
