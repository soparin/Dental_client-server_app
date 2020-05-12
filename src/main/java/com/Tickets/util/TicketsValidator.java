package com.Tickets.util;

import com.Tickets.dao.TicketsDao;
import com.Tickets.model.Tickets;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.logging.Logger;

@Component
public class TicketsValidator implements Validator {
    @Autowired
    private TicketsDao ticketsDao;
    Logger logger = Logger.getLogger(TicketsValidator.class.getName());
    @Override
    public boolean supports(Class<?> clazz){
        return Tickets.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors){
        Tickets tickets = (Tickets) target;

    }
}
