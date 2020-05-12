package com.Validator;

import com.DAO.ScheduleDao;
import com.Models.Schedule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.logging.Logger;

@Component
public class ScheduleValidator implements Validator {

    @Autowired
    private ScheduleDao scheduleDao;
    Logger logger = Logger.getLogger(ScheduleValidator.class.getName());
    @Override
    public boolean supports(Class<?> clazz){
        return Schedule.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors){
        Schedule schedule = (Schedule) target;
    }
}
