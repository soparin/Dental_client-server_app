package com.Schedule;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Comparator;
import java.util.List;
import java.util.logging.Logger;

@Repository
public class ScheduleDao {

    @Autowired
    private SessionFactory sessionFactory;
    public void setSessionFactory(SessionFactory sf) {
        this.sessionFactory = sf;
    }

    Logger logger = Logger.getLogger(ScheduleDao.class.getName());

    public void addSched(Schedule schedule) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(schedule);
        logger.info("Schedule successfully saved. Schedule details: " + schedule.toString());
    }

    public void updateSched(Schedule schedule) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(schedule);
        logger.info("Schedule successfully update. Schedule details: " + schedule.toString());
    }

    public void removeSched(Integer id) {
        Session session = this.sessionFactory.getCurrentSession();
        Schedule schedule = (Schedule) session.load(Schedule.class, new Integer(id));

        if(schedule!=null){
            session.delete(schedule);
        }
        logger.info("Schedule successfully removed. Schedule details: " + schedule.toString());
    }

    public Schedule getSchedById(Integer id) {
        Session session =this.sessionFactory.getCurrentSession();
        Schedule schedule = (Schedule) session.load(Schedule.class, new Integer(id));
        logger.info("Schedule successfully loaded. Schedule details: " + schedule.toString());

        return schedule;
    }

    @Transactional
    public Schedule getSchedByDent(Integer ID, Integer dent) {
        Session session = this.sessionFactory.getCurrentSession();
        List<Schedule> inValidScheduleList;

        if(ID != null) {
            inValidScheduleList = session.createQuery("SELECT s FROM Schedule s " +
                    "WHERE s.dentistId = '" + dent + "' AND NOT s.id = " + ID.toString()).list();
        }
        else{
            inValidScheduleList = session.createQuery("SELECT s FROM Schedule s " +
                    "WHERE s.dentistId = '" + dent + "'").list();
        }

        if (inValidScheduleList.isEmpty())
            return null;
        else
            return inValidScheduleList.get(0);
    }

    @SuppressWarnings("unchecked")
    public List<Schedule> listSchedule() {
        Session session = this.sessionFactory.getCurrentSession();
        List<Schedule> scheduleList = session.createQuery("from Schedule ").list();
        scheduleList.sort(Comparator.comparingInt(Schedule::getSchNum));
        for(Schedule schedule: scheduleList){
            logger.info("Schedule list: " + schedule.toString());
        }

        return scheduleList;
    }
}
