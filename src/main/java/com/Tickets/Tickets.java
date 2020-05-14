package com.Tickets;

import com.Schedule.Schedule;

import javax.persistence.*;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Objects;

@Entity
@Embeddable
@Table(name = "tickets_by_date")
public class Tickets {
    @Id
    @Column(name = "ticket_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer tickId;

    @Column(name = "schedule_num")
    @DecimalMin(value = "1", message = "Shift must be bigger then 0")
    @DecimalMax(value = "1440", message = "Too match shifts in list")
    private int scheduleNum;

    @Column(name = "start_time")
    @Size(max = 5, message = "Use other format (hh-mm)")
    @NotBlank(message = "Start time is required")
    private String stTime;

    @Column(name = "finish_time")
    @Size(max = 5, message = "Use other format (hh-mm)")
    @NotBlank(message = "Finish time is required")
    private String fnTime;

    @Column(name = "engaged")
    private boolean engaged = false;

    public Integer getTickId(){return tickId;}
    public void setTickId(Integer tickId){this.tickId = tickId;}
    public int getScheduleNum() {
        return scheduleNum;
    }
    public void setScheduleNum(int scheduleNum) {
        this.scheduleNum = scheduleNum;
    }
    public String getStTime() {
        return stTime;
    }
    public void setStTime(String stTime) {
        this.stTime = stTime;
    }
    public String getFnTime() {
        return fnTime;
    }
    public void setFnTime(String fnTime) {this.fnTime = fnTime; }
    public boolean isEngaged() {return engaged; }
    public void setEngaged(boolean engaged) {
        this.engaged = engaged;
    }

    public Tickets(Integer tickId, int scheduleNum, String  stTime, String  fnTime,
                   boolean engaged) {
        this.tickId = tickId;
        this.scheduleNum = scheduleNum;
        this.stTime = stTime;
        this.fnTime = fnTime;
        this.engaged = engaged;
    }
    public Tickets() { }
    @Override
    public String toString() {
        if(this.engaged)
            return "Tickets info {" + "Ticket " + tickId + " in schedule #" + scheduleNum + ", start in '" + stTime + '\'' + ", finish in '" + fnTime + '\'' + " engaged"+ '}';
        else
            return "Tickets info {" + "Ticket " + tickId + " in schedule #" + scheduleNum + ", start in '" + stTime + '\'' + ", finish in '" + fnTime + '\'' + " free"+ '}';
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Tickets))
            return false;
        Tickets ticket = (Tickets) o;
        return Objects.equals(getStTime(), ticket.getStTime());
    }
    @Override
    public int hashCode() {
        int result = getStTime().hashCode();
        result = 31 * result + getFnTime().hashCode();
        return result;
    }
}

