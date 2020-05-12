package com.Validator;

import com.DAO.DentistDao;
import com.Models.Dentist;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.logging.Logger;

@Component
public class DentistValidator implements Validator {

    @Autowired
    private DentistDao dentistDao;
    Logger logger = Logger.getLogger(DentistValidator.class.getName());
    @Override
    public boolean supports(Class<?> clazz){
        return Dentist.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors){
        Dentist dentist = (Dentist) target;
        if(dentistDao.getDentByPhone(dentist.getDentistId(), dentist.getWorkPhone()) != null){
            errors.rejectValue("workPhone", "", "This phone is already in use");
        }
        if(dentist.getBirth() == null){
            errors.rejectValue("birth", "", "Birth is required");
        }
        if(dentist.getStDate() == null){
            errors.rejectValue("stDate", "", "Do you have any dentist experience?");
        }

    }
}
