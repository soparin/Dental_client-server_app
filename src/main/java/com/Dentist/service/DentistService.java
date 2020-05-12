package com.Dentist.service;

import com.Dentist.dao.DentistDao;
import com.Dentist.model.Dentist;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@Service
public class DentistService {

    @Autowired
    private DentistDao dentistDao;
    Logger logger = Logger.getLogger(DentistDao.class.getName());
    public void setDentistDAO(DentistDao dentistDAO) {
        this.dentistDao = dentistDAO;
    }

    @Transactional
    public List<Dentist> listDentist(){
        return this.dentistDao.listDentist();
    }

    @Transactional
    public List<Dentist> listDentistFilter(String surname) {
        List<Dentist> filteredListOfDent = new ArrayList<>();
        for (Dentist dentist : this.dentistDao.listDentist()) {
            if (dentist.getSurname().contains(surname)) {
                filteredListOfDent.add(dentist);
            }
        }
        for(Dentist d : filteredListOfDent){
            logger.info(d.toString());
        }
        return filteredListOfDent;
    }

    @Transactional
    public void addDent(Dentist dentist) {
        this.dentistDao.addDent(dentist);
    }
    @Transactional
    public void updateDent(Dentist dentist) {
        this.dentistDao.updateDent(dentist);
    }
    @Transactional
    public void removeDent(Integer id) { this.dentistDao.removeDent(id); }
    @Transactional
    public Dentist getDentById(Integer id) {
        return this.dentistDao.getDentById(id);
    }
}