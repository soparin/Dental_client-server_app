package com.Reception;

import com.Reception.ReceptionDao;
import com.Reception.Reception;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@Service
public class ReceptionService {

    @Autowired
    private ReceptionDao receptionDao;
    Logger logger = Logger.getLogger(ReceptionDao.class.getName());
    public void setReceptionDAO(ReceptionDao receptionDAO) {
        this.receptionDao = receptionDAO;
    }

    @Transactional
    public List<Reception> listReception(){
        for(Reception r:receptionDao.listReception()){
            logger.info(r.toString() + "HERE !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        }
        return this.receptionDao.listReception();
    }

    @Transactional
    public List<Reception> listReceptionFilter(String address) {
        List<Reception> filteredListOfRec = new ArrayList<>();
//        for (Reception reception : this.receptionDao.listReception()) {
//            if (reception.getOfficeAdrs().contains(address)) {
//                filteredListOfRec.add(reception);
//            }
//        }
        for(Reception r : filteredListOfRec){
            logger.info(r.toString());
        }
        return filteredListOfRec;
    }

    @Transactional
    public void addRec(Reception reception) {
        this.receptionDao.addRec(reception);
    }
    @Transactional
    public void updateRec(Reception reception) {
        this.receptionDao.updateRec(reception);
    }
    @Transactional
    public void removeRec(Integer id) {
        this.receptionDao.removeRec(id);
    }
    @Transactional
    public Reception getRecById(Integer id) {return this.receptionDao.getRecById(id); }
}