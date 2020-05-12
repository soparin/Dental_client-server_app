package com.DAO;

import com.Models.Patient;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Comparator;
import java.util.List;
import java.util.logging.Logger;

@Repository
public class
PatientDao {
    @Autowired
    private SessionFactory sessionFactory;
    public void setSessionFactory(SessionFactory sf) {
        this.sessionFactory = sf;
    }

    Logger logger = Logger.getLogger(PatientDao.class.getName());

    public void addPat(Patient patient) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(patient);
        logger.info("Patient successfully saved. Patient details: " + patient.toString());
    }

    public void updatePat(Patient patient) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(patient);
        logger.info("Patient successfully update. Patient details: " + patient.toString());
    }

    public void removePat(Integer id) {
        Session session = this.sessionFactory.getCurrentSession();
        Patient patient = (Patient) session.load(Patient.class, new Integer(id));

        if(patient!=null){
            session.delete(patient);
        }
        logger.info("Patient successfully removed. Patient details: " + patient.toString());
    }

    public Patient getPatById(Integer id) {
        Session session =this.sessionFactory.getCurrentSession();
        Patient patient = (Patient) session.load(Patient.class, new Integer(id));
        logger.info("Patient successfully loaded. Patient details: " + patient.toString());

        return patient;
    }

    @SuppressWarnings("unchecked")
    public List<Patient> listPatient() {
        Session session = this.sessionFactory.getCurrentSession();
        List<Patient> patientList = session.createQuery("from Patient ").list();
        patientList.sort(Comparator.comparingInt(Patient::getPatientId));
        for(Patient patient: patientList){
            logger.info("Patient list: " + patient.toString());
        }

        return patientList;
    }
}