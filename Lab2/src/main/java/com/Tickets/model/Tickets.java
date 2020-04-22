package com.Tickets.model;
import javax.persistence.*;
import java.math.BigInteger;
import java.sql.Time;
import java.util.Objects;
@Entity
@Embeddable
@Table(name = "tickets_by_date")
public class Tickets {
    @Id
    @Column(name = "schedule_num")
    private BigInteger sch_num;
    @Column(name = "start_time")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Time st_time;
    @Column(name = "finish_time")
    private Time fn_time;
    @Column(name = "engaged")
    private boolean engaged = false;

    public BigInteger getSch_num() {
        return sch_num;
    }
    public void setSchNum(BigInteger sch_num) {
        this.sch_num = sch_num;
    }
    public Time getStartTime() {
        return st_time;
    }
    public void setStartTime(Time st_time) {
        this.st_time = st_time;
    }
    public Time getFinishTime() {
        return fn_time;
    }
    public void setFinishTime(Time fn_time) {
        this.fn_time = fn_time;
    }
    public boolean getEngage() {
        return engaged;
    }
    public void setFree() {
        this.engaged = false;
    }
    public void setEngaged(){
        this.engaged = true;
    }

    public Tickets(BigInteger sch_num, Time st_time, Time fn_time, boolean engaged) {
        this.sch_num = sch_num;
        this.st_time = st_time;
        this.fn_time = fn_time;
        this.engaged = engaged;
    }
    public Tickets() { }
    @Override
    public String toString() {
        if(this.engaged)
            return "Tickets info {" + "Schedule #" + sch_num + ", start in '" + st_time + '\'' + ", finish in '" + fn_time + '\'' + " engaged"+ '}';
        else
            return "Tickets info {" + "Schedule #" + sch_num + ", start in '" + st_time + '\'' + ", finish in '" + fn_time + '\'' + " free"+ '}';
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Tickets))
            return false;
        Tickets ticket = (Tickets) o;
        return Objects.equals(getStartTime(), ticket.getStartTime());
    }
    @Override
    public int hashCode() {
        int result = getStartTime().hashCode();
        result = 31 * result + getFinishTime().hashCode();
        result = 31 * result + getSch_num().hashCode();
        return result;
    }
}

