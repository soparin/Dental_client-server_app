package com.Models;

import javax.persistence.*;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Objects;

@Entity
@Embeddable
@Table(name = "work_schedule")
public class Schedule {
    @Id
    @Column(name = "schedule_num")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @DecimalMax(value="2000000000", message = "You need to update your base")
    private Integer schNum;

    @Column(name = "dentist_id")
    @DecimalMin(value="1", message="ID must be in range 1 - 2*10^9")
    @DecimalMax(value="2000000000", message = "You need to update your base")
    private int dentistId;

    @Column(name = "tickets_by_date")
    @NotBlank(message = "Date is required")
    @Size(max = 10, message = "Use other format (yyyy-mm-dd)")
    private String dateTickets;

    @Column(name = "cabinet")
    @DecimalMin(value="1", message="Wrong value")
    private int cab;

    public Integer getSchNum() {
        return schNum;
    }
    public void setSchNum(Integer schNum) {
        this.schNum = schNum;
    }
    public Integer getDentistId() {
        return dentistId;
    }
    public void setDentistId(Integer dentId) {
        this.dentistId = dentId;
    }
    public String getDateTickets() {
        return dateTickets;
    }
    public void setDateTickets(String dateTickets) {
        this.dateTickets = dateTickets;
    }
    public Integer getCab() {
        return cab;
    }
    public void setCab(Integer cabNum){
        this.cab = cabNum;
    }

    public Schedule(Integer schNum, Integer dentistId, String dateTickets, Integer cab) {
        this.schNum = schNum;
        this.dentistId = dentistId;
        this.dateTickets = dateTickets;
        this.cab = cab;
    }
    public Schedule() { }
    @Override
    public String toString() {
        return "Schedule{" + "Schedule #" + schNum + ", Dentist ID: '" + dentistId + '\'' +
                '\'' + ", on the day: '" + dateTickets + '\'' + ", in cabinet #" + cab + '\'' + ", on " + '}';
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Schedule))
            return false;
        Schedule schedule = (Schedule) o;
        return Objects.equals(getSchNum(), schedule.getSchNum());
    }
    @Override
    public int hashCode() {
        int result = getSchNum().hashCode();
        result = 31 * result + getDateTickets().hashCode();
        return result;
    }
}

