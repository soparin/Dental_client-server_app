package com.Patient;


import com.Patient.PatientDao;
import com.Patient.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@Service
public class PatientService {

    @Autowired
    private PatientDao patientDao;
    Logger logger = Logger.getLogger(PatientDao.class.getName());
    public void setPatientDAO(PatientDao patientDAO) {
        this.patientDao = patientDAO;
    }

    @Transactional
    public List<Patient> listPatient(){
        return this.patientDao.listPatient();
    }

    @Transactional
    public List<Patient> listPatientFilter(String surname) {
        List<Patient> filteredListOfPat = new ArrayList<>();
        for (Patient patient : this.patientDao.listPatient()) {
            if (patient.getSurname().contains(surname)) {
                filteredListOfPat.add(patient);
            }
        }
        for(Patient p : filteredListOfPat){
            logger.info(p.toString());
        }
        return filteredListOfPat;
    }

    @Transactional
    public void addPat(Patient patient) {
        this.patientDao.addPat(patient);
    }
    @Transactional
    public void updatePat(Patient patient) {
        this.patientDao.updatePat(patient);
    }
    @Transactional
    public void removePat(Integer id) {
        this.patientDao.removePat(id);
    }
    @Transactional
    public Patient getPatById(Integer id) {
        return this.patientDao.getPatById(id);
    }
}
