package com.Schedule;

import com.Dentist.Dentist;
import com.Tickets.Tickets;

import javax.persistence.*;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Objects;
import java.util.Set;

@Entity
@Embeddable
@Table(name = "work_schedule", schema = "public")
public class Schedule {
    @Id
    @Column(name = "schedule_num")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @DecimalMax(value="2000000000", message = "You need to update your base")
    private Integer scheduleNum;

    @Column(name = "dentist_id")
    @DecimalMin(value="1", message="ID must be in range 1 - 2*10^9")
    @DecimalMax(value="2000000000", message = "You need to update your base")
    private Integer dentistId;

    @Column(name = "tickets_by_date")
    @NotBlank(message = "Date is required")
    @Size(max = 10, message = "Use other format (yyyy-mm-dd)")
    private String dateTickets;

    @Column(name = "cabinet")
    @DecimalMin(value="1", message="Wrong value")
    private int cab;

    @ManyToOne
    @JoinColumn(name = "dentist_id", nullable = false, updatable = false, insertable = false)
    private Dentist dentist;

    public Integer getScheduleNum() { return scheduleNum; }
    public void setScheduleNum(Integer scheduleNum) { this.scheduleNum = scheduleNum; }
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
    public void setCab(int cab) { this.cab = cab; }

    public Dentist getDentist() {
        return dentist;
    }
    public void setDentist(Dentist dentist) {
        this.dentist = dentist;
    }

    public Schedule(Integer scheduleNum, Integer dentistId, String dateTickets,
                    Integer cab, Dentist dent) {
        this.scheduleNum = scheduleNum;
        this.dentistId = dentistId;
        this.dateTickets = dateTickets;
        this.cab = cab;
        this.dentist = dent;
    }
    public Schedule() { }
    @Override
    public String toString() {
        return "Schedule{" + "Schedule #" + scheduleNum + ", Dentist ID: '" + dentistId + '\'' +
                '\'' + ", on the day: '" + dateTickets + '\'' + ", in cabinet #" + cab + '\'' + ", on " + '}';
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Schedule))
            return false;
        Schedule schedule = (Schedule) o;
        return Objects.equals(getScheduleNum(), schedule.getScheduleNum());
    }
    @Override
    public int hashCode() {
        int result = getScheduleNum().hashCode();
        result = 31 * result + getDateTickets().hashCode();
        return result;
    }
}

