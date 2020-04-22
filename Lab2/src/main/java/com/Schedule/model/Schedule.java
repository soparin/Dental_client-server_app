package com.Schedule.model;
import javax.persistence.*;
import java.math.BigInteger;
import java.sql.Date;
import java.util.Objects;
@Entity
@Embeddable
@Table(name = "work_schedule")
public class Schedule {
    @Id
    @Column(name = "schedule_num")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private BigInteger sch_num;
    @Column(name = "dentist_id")
    private BigInteger dentist_id;
    @Column(name = "tickets_by_date")
    private Date date_tickets;
    @Column(name = "cabinet")
    private int cab;
    @Column(name = "week_day")
    private int week_day;

    public BigInteger getSchNum() {
        return sch_num;
    }
    public void setSchNum(BigInteger sch_num) {
        this.sch_num = sch_num;
    }
    public BigInteger getDentistId() {
        return dentist_id;
    }
    public void setDentistId(BigInteger dent_id) {
        this.dentist_id = dent_id;
    }
    public Date getDateOfTickets() {
        return date_tickets;
    }
    public void setRecDate(Date date_tickets) {
        this.date_tickets = date_tickets;
    }
    public int getCab() {
        return cab;
    }
    public void setCab(int cab_num){
        this.cab = cab_num;
    }
    public int getAddress(){
        return week_day;
    }
    public void setAddress(int week_day){
        this.week_day = week_day;
    }

    public Schedule(BigInteger sch_num, BigInteger dentist_id, Date date_tickets, int cab, int week_day) {
        this.sch_num = sch_num;
        this.dentist_id = dentist_id;
        this.date_tickets = date_tickets;
        this.cab = cab;
        this.week_day = week_day;
    }
    public Schedule() { }
    @Override
    public String toString() {
        return "Reception{" + "Schedule #" + sch_num + ", Dentist ID: '" + dentist_id + '\'' +
                '\'' + ", on the day: '" + date_tickets + '\'' + ", in cabinet #" + cab + '\'' + ", on " + week_day + " day of week"+ '}';
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
        result = 31 * result + getDateOfTickets().hashCode();
        result = 31 * result + getDentistId().hashCode();
        return result;
    }
}

