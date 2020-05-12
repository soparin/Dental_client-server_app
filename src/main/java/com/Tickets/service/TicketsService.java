package com.Tickets.service;

import com.Tickets.dao.TicketsDao;
import com.Tickets.model.Tickets;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@Service
public class TicketsService {

    @Autowired
    private TicketsDao ticketsDao;
    Logger logger = Logger.getLogger(TicketsDao.class.getName());
    public void setTicketsDAO(TicketsDao ticketsDAO) {
        this.ticketsDao = ticketsDAO;
    }

    @Transactional
    public List<Tickets> listTickets(){
        return this.ticketsDao.listTickets();
    }

    @Transactional
    public List<Tickets> listTicketsFilter(String stTime) {
        List<Tickets> filteredListOfTick = new ArrayList<>();
        for (Tickets tickets : this.ticketsDao.listTickets()) {
            if (tickets.getStTime() == stTime) {
                filteredListOfTick.add(tickets);
            }
        }
        for(Tickets t : filteredListOfTick){
            logger.info(t.toString());
        }
        return filteredListOfTick;
    }

    @Transactional
    public void addTick(Tickets tickets) {
        this.ticketsDao.addTick(tickets);
    }
    @Transactional
    public void updateTick(Tickets tickets) {
        this.ticketsDao.updateTick(tickets);
    }
    @Transactional
    public void removeTick(Integer id) {
        this.ticketsDao.removeTick(id);
    }
    @Transactional
    public Tickets getTickById(Integer id) {
        return this.ticketsDao.getTickById(id);
    }
}
