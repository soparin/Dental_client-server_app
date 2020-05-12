package com.Reception.model;

import javax.persistence.*;
import org.hibernate.validator.*;

import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
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
    private Integer recCount;
    @Column(name = "patient_id")
    @DecimalMin(value="1", message="ID must be in range 1 - 2*10^9")
    @DecimalMax(value="2000000000", message = "You need to update your base")
    private int patientId;
    @Column(name = "dentist_id")
    @DecimalMin(value="1", message="ID must be in range 1 - 2*10^9")
    @DecimalMax(value="2000000000", message = "You need to update your base")
    private int dentistId;
    @Column(name = "reception_date")
    @NotBlank(message = "Id is required")
    @Size(min = 1, max = 10, message = "Use other format (yyyy-mm-yy)")
    private String recDate;
    @Column(name = "reception_time")
    @Size(min = 1, max = 8, message = "Use other format (hh-mm-ss)")
    @NotBlank(message = "Time is required")
    private String recTime;

    public Integer getRecCount() {
        return recCount;
    }
    public void setRecCount(Integer recCount) {
        this.recCount = recCount;
    }
    public int getPatientId() {
        return patientId;
    }
    public void setPatientId(int patId) {
        this.patientId = patId;
    }
    public int getDentistId() {
        return dentistId;
    }
    public void setDentistId(int dentId) {
        this.dentistId = dentId;
    }
    public String getRecDate() {
        return recDate;
    }
    public void setRecDate(String recDate) {
        this.recDate = recDate;
    }
    public String getRecTime() {
        return recTime;
    }
    public void setRecTime(String recTime){
        this.recTime = recTime;
    }

    public Reception(Integer recCount, int patientId, int dentistId, String recDate, String recTime, String officeAdrs) {
        this.recCount = recCount;
        this.patientId = patientId;
        this.dentistId = dentistId;
        this.recDate = recDate;
        this.recTime = recTime;
    }
    public Reception() { }

    @Override
    public String toString() {
        return "Reception{" + "Reception count:" + recCount + ", Patient ID: '" + patientId + '\'' + ", Dentist ID: '" + dentistId + '\'' +
                '\'' + ", Reception day: '" + recDate + '\'' + ", Reception time: '" + recTime + '\'' + '}';
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Reception))
            return false;
        Reception reception = (Reception) o;
        return Objects.equals(getRecCount(), reception.getRecCount());
    }
}

