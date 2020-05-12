package com.Controller;

import com.Models.Tickets;
import com.Service.TicketsService;
import com.Validator.TicketsValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.logging.Logger;

@Controller
public class TicketsController {

    @Autowired
    private TicketsValidator ticketsValidator;

    @Autowired()
    @Qualifier(value = "ticketsService")
    private TicketsService ticketsService;
    Logger logger = Logger.getLogger(TicketsController.class.getName());
    public void setTicketsService(TicketsService ps) {
        this.ticketsService = ps;
    }

    @RequestMapping(value = "/tickets", method = RequestMethod.GET)
    public String listTickets(Model model) {
        model.addAttribute("tickets", new Tickets());
        model.addAttribute("listTickets", this.ticketsService.listTickets());
        return "Ticket";
    }

    @RequestMapping(value = "/tickets/add", method = RequestMethod.POST)
    public String addTick(@ModelAttribute @Valid Tickets tickets, BindingResult result){
        ticketsValidator.validate(tickets, result);
        if(result.hasErrors()){
            return "Ticket";
        }
        if(tickets.getTickId() == null){
            this.ticketsService.addTick(tickets);
        }else {
            this.ticketsService.updateTick(tickets);
        }
        return "redirect:/tickets";
    }

    @RequestMapping("/tick/remove/{id}")
    public String removeTick(@PathVariable("id") Integer id){
        this.ticketsService.removeTick(id);
        return "redirect:/tickets";
    }

    @RequestMapping("/tick/edit/{id}")
    public String editTick(@PathVariable("id") Integer id, Model model){
        model.addAttribute("tickets", this.ticketsService.getTickById(id));
        model.addAttribute("listTickets", this.ticketsService.listTickets());

        return "Ticket";
    }

    @RequestMapping("/tick/act/{id}")
    public String actOnTick(@PathVariable("id") Integer id){
        this.ticketsService.updateTick(this.ticketsService.actOnTick(id));
        return "redirect:/tickets";
    }
}