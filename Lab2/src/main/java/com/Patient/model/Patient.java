package com.Patient.model;
import javax.persistence.*;
import java.math.BigInteger;
import java.sql.Date;
import java.util.Objects;
@Entity
@Embeddable
@Table(name = "patient")
public class Patient {
    @Id
    @Column(name = "patient_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private BigInteger patientId;
    @Column(name = "first_name")
    private String surname;
    @Column(name = "last_name")
    private String name;
    @Column(name = "birthday")
    private Date birth;
    @Column(name = "medical_policy")
    private String policy;
    @Column(name = "snils")
    private String snils;
    @Column(name = "last_recept")
    private Date last_rec;
    @Column(name = "phone")
    private String phone;

    public BigInteger getPatientId() {
        return patientId;
    }
    public void setPatientId(BigInteger patient_id) {
        this.patientId = patient_id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getSurname() {
        return surname;
    }
    public void setSurname(String surname) {
        this.surname = surname;
    }
    public Date getBirth() {
        return birth;
    }
    public void setBirth(Date birth) {
        this.birth = birth;
    }
    public String getPolicy() {
        return policy;
    }
    public void setPolicy(String policy){
        this.policy = policy;
    }
    public String getSnils(){
        return snils;
    }
    public void setSnils(String snils){
        this.snils = snils;
    }
    public  Date getLast_rec(){
        return last_rec;
    }
    public void setLast_rec(Date l_recept){
        this.last_rec = l_recept;
    }
    public String getPhone(){
        return phone;
    }
    public void setPhone(String patient_phone){
        this.phone = patient_phone;
    }
    public Patient(BigInteger patientId, String name, String surname, Date birth, String policy, String snils, Date last_rec, String phone) {
        this.patientId = patientId;
        this.name = name;
        this.surname = surname;
        this.birth = birth;
        this.policy = policy;
        this.snils = snils;
        this.last_rec = last_rec;
        this.phone = phone;
    }
    public Patient() { }
    @Override
    public String toString() {
        return "Patient{" + "ID=" + patientId + ", name: '" + name + '\'' + ", surname: '" + surname + '\'' + ", birth: '" + birth +
                '\'' + ", Medical policy: '" + policy + '\'' + ", SNILS: '" + snils + '\'' + ", last reception: '" + last_rec + '\'' + '}';
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Patient))
            return false;
        Patient patient = (Patient) o;
        return Objects.equals(getPatientId(), patient.getPatientId());
    }
    @Override
    public int hashCode() {
        int result = getPatientId().hashCode();
        result = 31 * result + name.hashCode();
        result = 31 * result + surname.hashCode();
        result = 31 * result + phone.hashCode();
        return result;
    }
}
