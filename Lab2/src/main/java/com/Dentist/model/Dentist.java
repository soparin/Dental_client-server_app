package com.Dentist.model;
import javax.persistence.*;
import java.math.BigInteger;
import java.sql.Date;
import java.util.Objects;
@Entity
@Embeddable
@Table(name = "dentist")
public class Dentist {
    @Id
    @Column(name = "dentist_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private BigInteger dentistId;
    @Column(name = "first_name")
    private String surname;
    @Column(name = "last_name")
    private String name;
    @Column(name = "birthday")
    private Date birth;
    @Column(name = "specialization")
    private String spec;
    @Column(name = "carier_start_date")
    private Date st_date;
    @Column(name = "work_phone")
    private String w_phone;

    public BigInteger getDentistId() {
        return dentistId;
    }
    public void setDentistId(BigInteger dentistId) {
        this.dentistId = dentistId;
        System.out.println("111");
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
    public void setBirth(String birth) {this.birth = Date.valueOf(birth);}
    public String getSpec() {
        return spec;
    }
    public void setSpec(String spec){
        this.spec = spec;
    }
    public Date getStDate(){
        return st_date;
    }
    public void setStDate(String start_date){this.st_date = Date.valueOf(start_date);}
    public  String getWPhone(){
        return w_phone;
    }
    public void setWPhone(String phone){
        this.w_phone = phone;
    }
    public Dentist(BigInteger dentistId, String name, String surname, String birth, String spec, String date_of_start, String work_phone) {
        this.dentistId = dentistId;
        this.name = name;
        this.surname = surname;
        this.birth = Date.valueOf(birth);
        this.spec = spec;
        this.st_date = Date.valueOf(date_of_start);
        this.w_phone = work_phone;
    }
    public Dentist() { }
    @Override
    public String toString() {
        return "Dentist{" + "ID=" + dentistId + ", name: '" + name + '\'' + ", surname: '" + surname + '\'' + ", birth: '" + birth +
                '\'' + ", specialization: '" + spec + '\'' + ", work phone: '" + w_phone + '\'' + ", start his/her career at: '" + st_date + '\'' + '}';
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Dentist))
            return false;
        Dentist dentist = (Dentist) o;
        return Objects.equals(getDentistId(), dentist.getDentistId());
    }
    @Override
    public int hashCode() {
        int result = dentistId.hashCode();
        result = 31 * result + name.hashCode();
        result = 31 * result + surname.hashCode();
        result = 31 * result + w_phone.hashCode();
        return result;
    }
}
