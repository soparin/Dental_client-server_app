package com.Reception.util;

import com.Reception.dao.ReceptionDao;
import com.Reception.model.Reception;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.logging.Logger;

@Component
public class ReceptionValidator implements Validator {

    @Autowired
    private ReceptionDao receptionDao;
    Logger logger = Logger.getLogger(com.Reception.util.ReceptionValidator.class.getName());
    @Override
    public boolean supports(Class<?> clazz){
        return Reception.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors){
        Reception reception = (Reception) target;

    }
}

