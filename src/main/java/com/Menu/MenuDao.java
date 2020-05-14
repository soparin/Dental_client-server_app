package com.Menu;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.logging.Logger;

@Repository
public class MenuDao {

    @Autowired
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sf) {
        this.sessionFactory = sf;
    }

    Logger logger = Logger.getLogger(MenuDao.class.getName());

    public List<String> infoForPatients(String spec, String date) {
        Session session = this.sessionFactory.getCurrentSession();
        List<String> q = session.createQuery(
                "SELECT d.surname, d.name, d.stDate, s.dateTickets,tbd.stTime, d.workPhone " +
                        "From Dentist as d " +
                        "INNER JOIN Schedule s on d.dentistId = s.dentistId " +
                        "INNER JOIN Tickets as tbd on s.schNum = tbd.schNum " +
                        "where d.spec = " + spec + " and tbd.engaged = false " +
                        " and s.dateTickets >= " + date + " order by tbd.stTime").list();
        for (String str : q) {
            logger.info("HUI " + str);
        }
        return q;
    }

    public List<String> infoForDentist(Integer id, String date) {
        Session session = this.sessionFactory.getCurrentSession();
        List<String> q = session.createQuery(
                "SELECT .dateTickets,tbd.stTime, d.workPhone " +
                        "From Schedule as s " +
                        " INNER JOIN Tickets as tbd on s.schNum = tbd.schNum " +
                        "where s.dentistId = " + id.toString() + " and tbd.engaged = true " +
                        " and s.dateTickets >= " + date + " order by tbd.stTime").list();
        for (String str : q) {
            logger.info("HUI2 " + str);
        }
        return q;
    }
}
