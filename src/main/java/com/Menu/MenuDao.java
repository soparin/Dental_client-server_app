package com.Menu;


import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.logging.Logger;

@Repository
public class MenuDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sf) {
        this.sessionFactory = sf;
    }

    Logger logger = Logger.getLogger(MenuDao.class.getName());

    @Transactional
    public List<PatientMenu> infoForPatients(String spec, String date) {

        if (spec != null && date != null) {
            return jdbcTemplate.query(
                    "SELECT d.first_name, d.last_name, d.career_start_date, s.tickets_by_date,tbd.start_time, d.work_phone " +
                            " From Dentist d, Work_schedule s, Tickets_by_date tbd" +
                            " where d.dentist_id=s.dentist_id and s.schedule_num = tbd.schedule_num and d.specialization = ? " +
                            " and tbd.engaged = false and s.tickets_by_date >= ? " +
                            " order by tbd.start_time",
                    new Object[]{spec, date},
                    (rs, i) -> {
                        PatientMenu pm = new PatientMenu();
                        pm.setSpec(spec);
                        pm.setSurnamename(rs.getString(1) + " " + rs.getString(2));
                        pm.setStartDate(rs.getString(3));
                        pm.setDateTicket(rs.getString(4));
                        pm.setTime(rs.getString(5));
                        pm.setPhone(rs.getString(6));
                        return pm;

                    });
        }
        else
            return null;
    }

    @Transactional
    public List<DentistMenu> infoForDentist(Integer id, String date) {
        if (id != null && date != null) {
            logger.info("+++++++++++" + id + date);
            List<DentistMenu> l = jdbcTemplate.query(
                    "SELECT d.first_name, d.last_name, s.tickets_by_date ,tbd.start_time, d.work_phone" +
                            "    From Work_schedule s, Tickets_by_date tbd, Dentist d" +
                            "    where d.dentist_id = s.dentist_id and s.schedule_num = tbd.schedule_num " +
                            "    and d.dentist_id = 2 and s.tickets_by_date >= ? " +
                            "    order by tbd.start_time and tbd.engaged = true",
                    new Object[]{ date},
                    (rs, i) -> {
                        DentistMenu dm = new DentistMenu();
                        dm.setDate(rs.getString(2));
                        dm.setSurnamname(rs.getString(0) + " " + rs.getString(1));
                        dm.setTime(rs.getString(3));
                        dm.setPhone(rs.getString(4));
                        logger.info(dm.toString());
                        return dm;
                    });
            return l;
        }
        else{
            return null;
        }

    }
}
