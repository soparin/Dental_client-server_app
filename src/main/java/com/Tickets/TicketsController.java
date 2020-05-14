package com.Tickets;

import com.Patient.Patient;
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
    public String addTick(@ModelAttribute @Valid Tickets tickets, BindingResult result, Model model){
        ticketsValidator.validate(tickets, result);
        if(result.hasErrors()){
            model.addAttribute("listTickets", this.ticketsService.listTickets());
            return "Ticket";
        }
        if(tickets.getTickId() == null){
            this.ticketsService.addTick(tickets);
        }else {
            this.ticketsService.updateTick(tickets);
        }
        return "redirect:/tickets";
    }

    @RequestMapping(value = "/tick/edit", method = RequestMethod.POST)
    public String editTick(@ModelAttribute Tickets ticket, Model model){
        ticket = this.ticketsService.getTickById(ticket.getTickId());
        model.addAttribute("tickets", ticket);
        model.addAttribute("listTickets", this.ticketsService.listTickets());

        return "Ticket";
    }

    @RequestMapping(value = "/tick/remove", method = RequestMethod.POST)
    public String deleteTick(@ModelAttribute Tickets ticket)
    {
        this.ticketsService.removeTick(ticket.getTickId());
        return "redirect:/tickets";
    }
//    @RequestMapping("/tick/remove/{id}")
//    public String removeTick(@PathVariable("id") Integer id){
//        this.ticketsService.removeTick(id);
//        return "redirect:/tickets";
//    }
//
//    @RequestMapping("/tick/edit/{id}")
//    public String editTick(@PathVariable("id") Integer id, Model model){
//        model.addAttribute("tickets", this.ticketsService.getTickById(id));
//        model.addAttribute("listTickets", this.ticketsService.listTickets());
//
//        return "Ticket";
//    }

    @RequestMapping(value = "/tick/act", method = RequestMethod.POST)
    public String actOnTick(@ModelAttribute Tickets ticket, Model model){
        model.addAttribute("tickets", ticket);
        model.addAttribute("listTickets", this.ticketsService.listTickets());
        this.ticketsService.actOnTick(ticket.getTickId());
        return "redirect:/tickets";
    }
//    @RequestMapping("/tick/act/{id}")
//    public String actOnTick(@PathVariable("id") Integer id){
//        this.ticketsService.updateTick(this.ticketsService.actOnTick(id));
//        return "redirect:/tickets";
//    }
}