package com.Dentist;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Comparator;
import java.util.List;
import java.util.logging.Logger;

@Repository
public class DentistDao {

    @Autowired
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sf) {
        this.sessionFactory = sf;
    }

    Logger logger = Logger.getLogger(DentistDao.class.getName());

    public void addDent(Dentist dentist) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(dentist);
        logger.info("Dentist successfully saved. Dentist details: " + dentist.toString());
    }

    public void updateDent(Dentist dentist) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(dentist);
        logger.info("Dentist successfully update. Dentist details: " + dentist.toString());
    }

    public void removeDent(Integer id) {
        Session session = this.sessionFactory.getCurrentSession();
        Dentist dentist = (Dentist) session.load(Dentist.class, new Integer(id));

        if(dentist!=null){
            session.delete(dentist);
        }
        logger.info("Dentist successfully removed. Dentist details: " + dentist.toString());
    }

    public Dentist getDentById(Integer id) {
        Session session =this.sessionFactory.getCurrentSession();
        Dentist dentist = (Dentist) session.load(Dentist.class, new Integer(id));
        logger.info("Dentist successfully loaded. Dentist details: " + dentist.toString());

        return dentist;
    }

    @Transactional
    public Dentist getDentByPhone(Integer ID, String WPhone) {
        Session session = this.sessionFactory.getCurrentSession();
        List<Dentist> inValidDentistList;

        if(ID != null) {
            inValidDentistList = session.createQuery("SELECT d FROM Dentist d " +
                    "WHERE d.workPhone = '" + WPhone + "' AND NOT d.dentistId = " + ID.toString()).list();
        }
        else{
            inValidDentistList = session.createQuery("SELECT d FROM Dentist d " +
                    "WHERE d.workPhone = '" + WPhone + "'").list();
        }

        if (inValidDentistList.isEmpty())
            return null;
        else
            return inValidDentistList.get(0);
    }

    @SuppressWarnings("unchecked")
    public List<Dentist> listDentist() {

        Session session = this.sessionFactory.getCurrentSession();
        List<Dentist> dentistList = session.createQuery("from Dentist ").list();
        dentistList.sort(Comparator.comparingInt(Dentist::getDentistId));
        for(Dentist dentist: dentistList){
            logger.info("Dentist list: " + dentist.toString());
        }

        return dentistList;
    }
}
