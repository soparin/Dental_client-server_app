package com.Validator;

import com.DAO.ScheduleDao;
import com.Models.Schedule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@Service
public class ScheduleService {

    @Autowired
    private ScheduleDao scheduleDao;
    Logger logger = Logger.getLogger(ScheduleDao.class.getName());
    public void setScheduleDAO(ScheduleDao scheduleDAO) {
        this.scheduleDao = scheduleDAO;
    }

    @Transactional
    public List<Schedule> listSchedule(){
        return this.scheduleDao.listSchedule();
    }

    @Transactional
    public List<Schedule> listScheduleFilter(int dentistId) {
        List<Schedule> filteredListOfSched = new ArrayList<>();
        for (Schedule schedule : this.scheduleDao.listSchedule()) {
            if (schedule.getDentistId() == dentistId) {
                filteredListOfSched.add(schedule);
            }
        }
        for(Schedule s : filteredListOfSched){
            logger.info(s.toString());
        }
        return filteredListOfSched;
    }

    @Transactional
    public void addSched(Schedule schedule) {
        this.scheduleDao.addSched(schedule);
    }
    @Transactional
    public void updateSched(Schedule schedule) {
        this.scheduleDao.updateSched(schedule);
    }
    @Transactional
    public void removeSched(Integer id) {
        this.scheduleDao.removeSched(id);
    }
    @Transactional
    public Schedule getSchedById(Integer id) {
        return this.scheduleDao.getSchedById(id);
    }
}