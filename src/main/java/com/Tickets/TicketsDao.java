package com.Tickets;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Comparator;
import java.util.List;
import java.util.logging.Logger;

@Repository
public class TicketsDao {
    @Autowired
    private SessionFactory sessionFactory;
    public void setSessionFactory(SessionFactory sf) {
        this.sessionFactory = sf;
    }

    Logger logger = Logger.getLogger(TicketsDao.class.getName());

    public void addTick(Tickets tickets) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(tickets);
        logger.info("Ticket successfully saved. Ticket details: " + tickets.toString());
    }

    public void updateTick(Tickets tickets) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(tickets);
        logger.info("Tickets successfully update. Tickets details: " + tickets.toString());
    }

    public void removeTick(Integer id) {
        Session session = this.sessionFactory.getCurrentSession();
        Tickets tickets = (Tickets) session.load(Tickets.class, new Integer(id));

        if(tickets!=null){
            session.delete(tickets);
        }
        logger.info("Tickets successfully removed. Tickets details: " + tickets.toString());
    }

    public Tickets getTickById(Integer id) {
        Session session =this.sessionFactory.getCurrentSession();
        Tickets tickets = (Tickets) session.load(Tickets.class, id);
        logger.info("Tickets successfully loaded. Tickets details: " + tickets.toString());

        return tickets;
    }
    public Tickets getTickByTime(String startTime) {
        Session session =this.sessionFactory.getCurrentSession();
        Tickets tickets = (Tickets) session.load(Tickets.class, startTime);
        logger.info("Tickets successfully loaded. Tickets details: " + tickets.toString());

        return tickets;
    }

//    @Transactional
//    public Tickets getTickByStartTime(String stTime) {
//        Session session = this.sessionFactory.getCurrentSession();
//        List<Tickets> inValidTickList;
//
//        if(ID != null) {
//            inValidTickList = session.createQuery("SELECT t FROM Tickets t " +
//                    "WHERE t.stTime = '" + stTime + "' AND NOT t.id = " + ID.toString()).list();
//        }
//        else{
//            inValidTickList = session.createQuery("SELECT t FROM Tickets t " +
//                    "WHERE t.stTime = '" + stTime + "'").list();
//        }
//
//        if (inValidTickList.isEmpty())
//            return null;
//        else
//            return inValidTickList.get(0);
//    }


    @SuppressWarnings("unchecked")
    public List<Tickets> listTickets() {
        Session session = this.sessionFactory.getCurrentSession();
        List<Tickets> ticketsList = session.createQuery("from Tickets ").list();
        ticketsList.sort(Comparator.comparingInt(Tickets::getTickId));
        for(Tickets tickets: ticketsList){
            logger.info("Tickets list: " + tickets.toString());
        }

        return ticketsList;
    }


}
