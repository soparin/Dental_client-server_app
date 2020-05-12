package com.Reception;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Comparator;
import java.util.List;
import java.util.logging.Logger;

@Repository
public class ReceptionDao {

    @Autowired
    private SessionFactory sessionFactory;
    public void setSessionFactory(SessionFactory sf) {
        this.sessionFactory = sf;
    }

    Logger logger = Logger.getLogger(ReceptionDao.class.getName());

    public void addRec(Reception reception) {
        Session session = this.sessionFactory.getCurrentSession();
        logger.info("Reception saving. Reception details: " + reception.toString());
        session.persist(reception);
        logger.info("Reception successfully saved. Reception details: " + reception.toString());
    }


    public void updateRec(Reception reception) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(reception);
        logger.info("Reception successfully update. Reception details: " + reception.toString());
    }

    public void removeRec(Integer id) {
        Session session = this.sessionFactory.getCurrentSession();
        Reception reception = (Reception) session.load(Reception.class, new Integer(id));

        if(reception!=null){
            session.delete(reception);
        }
        logger.info("Reception successfully removed. Reception details: " + reception.toString());
    }

    public Reception getRecById(Integer id) {
        Session session =this.sessionFactory.getCurrentSession();
        Reception reception = (Reception) session.load(Reception.class, new Integer(id));
        logger.info("Reception successfully loaded. Reception details: " + reception.toString());

        return reception;
    }

    @Transactional
    public Reception getRecByPhone(Integer ID, String Time) {
        Session session = this.sessionFactory.getCurrentSession();
        List<Reception> inValidReceptList;

        if(ID != null) {
            inValidReceptList = session.createQuery("SELECT r FROM Reception r " +
                    "WHERE r.recTime = '" + Time + "' AND NOT r.dentistId = " + ID.toString()).list();
        }
        else{
            inValidReceptList = session.createQuery("SELECT r FROM Reception r" +
                    "WHERE r.recTime = '" + Time + "'").list();
        }

        if (inValidReceptList.isEmpty())
            return null;
        else
            return inValidReceptList.get(0);
    }

    @SuppressWarnings("unchecked")
    public List<Reception> listReception() {
        logger.info("Reception list: !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        Session session = this.sessionFactory.getCurrentSession();
        List<Reception> receptionList = session.createQuery("from Reception ").list();
        receptionList.sort(Comparator.comparingInt(Reception::getRecCount));
        for(Reception reception: receptionList){
            logger.info("Reception list: " + reception.toString());
        }

        return receptionList;
    }
}
