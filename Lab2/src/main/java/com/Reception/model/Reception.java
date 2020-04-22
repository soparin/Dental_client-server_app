package com.Reception.model;
import javax.persistence.*;
import java.math.BigInteger;
import java.sql.Date;
import java.sql.Time;
import java.util.Objects;
@Entity
@Embeddable
@Table(name = "reception")
public class Reception {
    @Id
    @Column(name = "reception_count")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private BigInteger rec_count;
    @Column(name = "patient_id")
    private BigInteger patient_id;
    @Column(name = "dentist_id")
    private BigInteger dentist_id;
    @Column(name = "reception_date")
    private Date rec_date;
    @Column(name = "reception_time")
    private Time rec_time;
    @Column(name = "office_address")
    private String ofce_adrs;

    public BigInteger getRecCount() {
        return rec_count;
    }
    public void setRecCount(BigInteger rec_count) {
        this.rec_count = rec_count;
    }
    public BigInteger getPatientId() {
        return patient_id;
    }
    public void setPatientId(BigInteger pat_id) {
        this.patient_id = pat_id;
    }
    public BigInteger getDentistId() {
        return dentist_id;
    }
    public void setDentistId(BigInteger dent_id) {
        this.dentist_id = dent_id;
    }
    public Date getRecDate() {
        return rec_date;
    }
    public void setRecDate(Date rec_date) {
        this.rec_date = rec_date;
    }
    public Time getRecTime() {
        return rec_time;
    }
    public void setRecTime(Time rec_time){
        this.rec_time = rec_time;
    }
    public String getAddress(){
        return ofce_adrs;
    }
    public void setAddress(String address){
        this.ofce_adrs = address;
    }

    public Reception(BigInteger rec_count, BigInteger patient_id, BigInteger dentist_id, Date rec_date, Time rec_time, String ofce_adrs) {
        this.rec_count = rec_count;
        this.patient_id = patient_id;
        this.dentist_id = dentist_id;
        this.rec_date = rec_date;
        this.rec_time = rec_time;
        this.ofce_adrs = ofce_adrs;
    }
    public Reception() { }
    @Override
    public String toString() {
        return "Reception{" + "Receptiont count:" + rec_count + ", Patient ID: '" + patient_id + '\'' + ", Dentist ID: '" + dentist_id + '\'' +
                '\'' + ", Reception day: '" + rec_date + '\'' + ", Reception time: '" + rec_time + '\'' + '}';
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Reception))
            return false;
        Reception reception = (Reception) o;
        return Objects.equals(getRecCount(), reception.getRecCount());
    }
    @Override
    public int hashCode() {
        int result = getRecCount().hashCode();
        result = 31 * result + getPatientId().hashCode();
        result = 31 * result + getDentistId().hashCode();
        result = 31 * result + getRecDate().hashCode();
        return result;
    }
}

