package com.Reception;

import com.Dentist.Dentist;
import com.Patient.Patient;

import javax.persistence.*;

import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Objects;

@Entity
@Embeddable
@Table(name = "reception", schema = "public")
public class Reception {

    @Id
    @Column(name = "reception_count")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer recCount;

    @Column(name = "id_patient")
    @DecimalMin(value="1", message="ID must be in range 1 - 2*10^9")
    @DecimalMax(value="2000000000", message = "You need to update your base")
    private Integer patientId;

    @Column(name = "id_dentist")
    @DecimalMin(value="1", message="ID must be in range 1 - 2*10^9")
    @DecimalMax(value="2000000000", message = "You need to update your base")
    private Integer dentistId;

    @Column(name = "reception_date")
    @NotBlank(message = "Id is required")
    @Size(max = 10, message = "Use other format (yyyy-mm-yy)")
    private String recDate;

    @Column(name = "reception_time")
    @Size(max = 5, message = "Use other format (hh-mm-ss)")
    @NotBlank(message = "Time is required")
    private String recTime;

    @ManyToOne
    @JoinColumn(name = "id_patient", nullable = false, insertable = false, updatable = false)
    private Patient patient;
    @ManyToOne
    @JoinColumn(name = "id_dentist", nullable = false, insertable = false, updatable = false)
    private Dentist dentist;


    public Integer getRecCount() {
        return recCount;
    }
    public void setRecCount(Integer recCount) {
        this.recCount = recCount;
    }
    public Integer getPatientId() {
        return patientId;
    }
    public void setPatientId(Integer patId) {
        this.patientId = patId;
    }
    public Integer getDentistId() {
        return dentistId;
    }
    public void setDentistId(Integer dentId) {
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
    public Patient getPatient() {
        return patient;
    }
    public void setPatient(Patient patient) {
        this.patient = patient;
    }
    public Dentist getDentist() {
        return dentist;
    }
    public void setDentist(Dentist dentist) {
        this.dentist = dentist;
    }



    public Reception(Integer recCount, Integer patientId, Integer dentistId, String recDate,
                     String recTime, Patient pat, Dentist dent) {
        this.recCount = recCount;
        this.patientId = patientId;
        this.dentistId = dentistId;
        this.recDate = recDate;
        this.recTime = recTime;
        this.dentist = dent;
        this.patient = pat;
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

