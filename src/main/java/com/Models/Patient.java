package com.Models;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Objects;
@Entity
@Embeddable
@Table(name = "patient")
public class Patient {
    @Id
    @Column(name = "patient_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer patientId;
    @Column(name = "first_name")
    @NotBlank(message = "Surname is required")
    @Size(max = 20, message = "Surname should be from 1 to 50 symbols")
    private String surname;
    @Column(name = "last_name")
    @NotBlank(message = "Name is required")
    @Size(max = 20, message = "Name should be from 1 to 50 symbols")
    private String name;
    @Column(name = "birthday")
    @NotBlank(message = "Birth is required")
    @Size(max = 10, message = "Use other format (yyyy-mm-dd)")
    private String birth;
    @Column(name = "medical_policy")
    @NotBlank(message = "Policy is required")
    @Size(max = 20, message = "Name should be from 1 to 20 symbols")
    private String policy;
    @Column(name = "snils")
    @NotBlank(message = "SNILS is required")
    @Size(max = 20, message = "Name should be from 1 to 20 symbols")
    private String snils;
    @Column(name = "last_recept")
    @NotBlank(message = "Birth is required")
    @Size(max = 10, message = "Use other format (yyyy-mm-dd)")
    private String lastRec;
    @Column(name = "phone")
    @NotBlank(message = "Contact number is required")
    @Size(max = 15, message = "Too long number")
    private String pPhone;

    public Integer getPatientId() {
        return patientId;
    }
    public void setPatientId(Integer patientId) {
        this.patientId = patientId;
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
    public String getBirth() {
        return birth;
    }
    public void setBirth(String birth) {this.birth = birth;}
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
    public  String getLastRec(){
        return lastRec;
    }
    public void setLastRec(String lastRec){ this.lastRec = lastRec;}
    public String getPPhone(){
        return pPhone;
    }
    public void setPPhone(String pPhone){
        this.pPhone = pPhone;
    }
    public Patient(Integer patientId, String name, String surname, String  birth, String policy, String snils, String lastRec, String phone) {
        this.patientId = patientId;
        this.name = name;
        this.surname = surname;
        this.birth = birth;
        this.policy = policy;
        this.snils = snils;
        this.lastRec = lastRec;
        this.pPhone = phone;
    }
    public Patient() { }
    @Override
    public String toString() {
        return "Patient{" + "ID=" + patientId + ", name: '" + name + '\'' + ", surname: '" + surname + '\'' + ", birth: '" + birth +
                '\'' + ", Medical policy: '" + policy + '\'' + ", SNILS: '" + snils + '\'' + ", last reception: '" + lastRec + '\'' + '}';
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
        int result = name.hashCode();
        result = 31 * result + surname.hashCode();
        result = 31 * result + pPhone.hashCode();
        return result;
    }
}
