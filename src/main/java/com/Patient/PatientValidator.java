package com.Patient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.logging.Logger;

@Component
public class PatientValidator implements Validator {

    @Autowired
    private PatientDao patientDao;
    Logger logger = Logger.getLogger(PatientValidator.class.getName());
    @Override
    public boolean supports(Class<?> clazz){
        return Patient.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors){
        Patient patient = (Patient) target;
        if(patientDao.getPatByPhone(patient.getPatientId(), patient.getPPhone()) != null){
            errors.rejectValue("pPhone", "", "This phone is already in use");
        }
    }
}
