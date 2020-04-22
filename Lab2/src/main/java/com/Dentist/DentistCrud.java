package com.Dentist;

import com.Dentist.model.Dentist;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

import java.math.BigInteger;
import java.util.List;

public class DentistCrud  {
    @Test
    public void crud() {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        create(session, "Andrey", "Ponin", "1989-04-10", "ortodontist","2010-02-06", "89109875734");
        read_by_id(session, get_cur_id());
        update_by_id(session, get_cur_id());
        read(session);
        delete_by_id(session, get_cur_id());
        read(session);
        session.close();
    }
    private Dentist dentist = null;

    private void create(Session session, String d_name, String d_surname, String d_birth,
                        String d_specialization, String d_start_work_date, String d_work_phone) {
        Dentist dentist = new Dentist();

        dentist.setName(d_name);
        dentist.setSurname(d_surname);
        dentist.setBirth(d_birth);
        dentist.setSpec(d_specialization);
        dentist.setStDate(d_start_work_date);
        dentist.setWPhone(d_work_phone);

        session.beginTransaction();
        session.save(dentist);
        session.getTransaction().commit();
        this.dentist = dentist;
    }
    private void read(Session session) {
        System.out.println("All rows: ");
        List<Dentist> dentistList = session.createQuery("SELECT s FROM Dentist s").list();
        for (Dentist d : dentistList) {
            System.out.println("List:" + d);
        }
    }
    private long get_cur_id() {
        if(this.dentist != null)
            return this.dentist.getDentistId().longValue();
        else
            return -1;
    }
    private void get_dent_by_id(Session session, long id) {
        List<Dentist> dentistList = session.createQuery("SELECT s FROM Dentist s ").list();
        for (Dentist d : dentistList) {
            if (d.getDentistId().longValue() == id);
                this.dentist = d;
        }
    }
    private void read_by_id(Session session, long id){
        List<Dentist> dentistList = session.createQuery("SELECT s FROM Dentist s ").list();
        for (Dentist d : dentistList) {
            if (d.getDentistId().longValue() == id)
                System.out.println("New row with ID = " + id + ": " + d.toString());
        }
    }
    private void update_by_id(Session session, long id){
        if(id == -1)
                System.out.println("ID doesn't exist");
        else{
            get_dent_by_id(session, id);
            if (id == this.dentist.getDentistId().longValue()) {
                get_dent_by_id(session, id);
                System.out.println("Updating ID " + id);
                dentist.setBirth("1989-04-11");
                System.out.println("Birthday was updated on " + dentist.getBirth().toString());
                Transaction tx = session.beginTransaction();
                session.merge(dentist);
                tx.commit();
            }
        }
    }
    private void delete_by_id(Session session, long id){
        if (id == -1)
            System.out.println("Wrong ID");
        else {
            get_dent_by_id(session, id);
            if (id == this.dentist.getDentistId().longValue()) {
                get_dent_by_id(session, id);
                System.out.println("Deleting ID " + id);
                Transaction tx = session.beginTransaction();
                session.delete(dentist);
                tx.commit();
            }
        }
    }
}

