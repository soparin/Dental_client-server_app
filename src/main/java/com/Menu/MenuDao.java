package com.Menu;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

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

    @Transactional
    public List<PatientMenu> infoForPatients(String spec, String date) {
        Session session = this.sessionFactory.getCurrentSession();
        List<PatientMenu> q = session.createQuery(
                "SELECT d.surname, d.name, d.stDate, s.dateTickets,tbd.stTime, d.workPhone " +
                        "From Dentist as d " +
                        "INNER JOIN Schedule s on d.dentistId = s.dentistId " +
                        "INNER JOIN Tickets as tbd on s.scheduleNum = tbd.scheduleNum " +
                        "where d.spec = " + spec + " and tbd.engaged = false " +
                        " and s.dateTickets >= '" + date + "' order by tbd.stTime").list();
        return q;
    }

    @Transactional
    public List<DentistMenu> infoForDentist(Integer id, String date) {
        Session session = this.sessionFactory.getCurrentSession();
        List<DentistMenu> q = session.createQuery(
                "SELECT .dateTickets,tbd.stTime, d.workPhone " +
                        "From Schedule as s " +
                        " INNER JOIN Tickets as tbd on s.schNum = tbd.schNum " +
                        "where s.dentistId = " + id.toString() + " and tbd.engaged = true " +
                        " and s.dateTickets >= '" + date + "' order by tbd.stTime").list();
        return q;
    }
}
