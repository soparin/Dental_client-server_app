package com.Dentist.model;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.Objects;

@Entity
@Embeddable
@Table(name = "dentist")
public class Dentist {
    @Id
    @Column(name = "dentist_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer dentistId;
    @Column(name = "first_name")
    @NotBlank(message = "Surname is required")
    @Size(max = 50, message = "Surname should be from 1 to 50 symbols")
    private String surname;
    @Column(name = "last_name")
    @NotBlank(message = "Name is required")
    @Size(max = 50, message = "Name should be from 1 to 50 symbols")
    private String name;
    @Column(name = "birthday")
    @NotBlank(message = "Birth is required")
    @Size(max = 10, message = "Use other format (yyyy-mm-dd)")
    private String birth;
    @Column(name = "specialization")
    @NotBlank(message = "Specialization is required")
    @Size(max = 30, message = "Specialization name should be from 1 to 30 symbols")
    private String spec;
    @Column(name = "carier_start_date")
    @NotBlank(message = "Date of career start is required")
    @Size(max = 10, message = "Use other format (yyyy-mm-dd)")
    private String stDate;
    @Column(name = "work_phone")
    @NotBlank(message = "Get your work phone at the clinic administration")
    @Size(max = 15, message = "Too long number")
    private String workPhone;

    public Integer getDentistId() {
        return dentistId;
    }
    public void setDentistId(Integer dentistId) {
        this.dentistId = dentistId;
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
    public String getBirth() { return birth; }
    public void setBirth(String birth){this.birth = birth;}
    public String getSpec() {
        return spec;
    }
    public void setSpec(String spec){
        this.spec = spec;
    }
    public String getStDate(){return stDate;}
    public void setStDate(String startDate){this.stDate = startDate;}
    public  String getWorkPhone(){
        return workPhone;
    }
    public void setWorkPhone(String phone){
        this.workPhone = phone;
    }
    public Dentist(Integer dentistId, String name, String surname, String birth, String spec, String dateOfStart, String workPhone) {
        this.dentistId = dentistId;
        this.name = name;
        this.surname = surname;
        this.birth = birth;
        this.spec = spec;
        this.stDate = dateOfStart;
        this.workPhone = workPhone;
    }

    public Dentist() { }

    @Override
    public String toString() {
        return "Dentist{" + "ID=" + dentistId + ", name: '" + name + '\'' + ", surname: '" + surname + '\'' + ", birth: '" + birth +
                '\'' + ", specialization: '" + spec + '\'' + ", work phone: '" + workPhone + '\'' + ", start his/her career at: '" + stDate + '\'' + '}';
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
        int result = name.hashCode();
        result = 31 * result + surname.hashCode();
        result = 31 * result + workPhone.hashCode();
        return result;
    }
}
