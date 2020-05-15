package com.Menu;

import com.Dentist.Dentist;
import com.Patient.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Array;
import java.util.*;
import java.util.logging.Logger;

@Service
public class MenuService {

    @Autowired
    private MenuDao menuDao;
    Logger logger = Logger.getLogger(MenuDao.class.getName());

    public void setMenuDAO(MenuDao menuDao) {
        this.menuDao = menuDao;
    }

    @Transactional
    public ArrayList<ArrayList<String>> patQueryParsed(List<PatientMenu> QueryResult) {
        PatientMenu firstP = QueryResult.get(0);
        ArrayList<ArrayList<String>> ParsedTable = new ArrayList<>();
        ArrayList<String> Dates = new ArrayList<>();
        ArrayList<String> Specialization = new ArrayList<>();
        ArrayList<String> SurnameName = new ArrayList<>();
        ArrayList<String> DatesOfStart = new ArrayList<>();
        ArrayList<String> Times = new ArrayList<>();
        ArrayList<String> Phones = new ArrayList<>();


        for (int i = 0; i < QueryResult.size(); ++i) {
            PatientMenu p = QueryResult.get(i);
            if(!Dates.contains(p.getDateTicket()))
                Dates.add(p.getDateTicket());
            else Dates.add(" ");

            if(!Specialization.contains(p.getSpec())) Specialization.add(p.getSpec());
            else Specialization.add(" ");

            if(!SurnameName.contains(p.getSurnamename()))
                SurnameName.add(p.getSurnamename());
            else SurnameName.add(" ");

            if(!DatesOfStart.contains(p.getStartDate())) DatesOfStart.add(p.getStartDate());
            else DatesOfStart.add(" ");

            Times.add(p.getTime());

            if(!Phones.contains(p.getPhone())) Phones.add(p.getPhone());
            else Phones.add(" ");

        }
        ParsedTable.add(Dates);
        ParsedTable.add(Specialization);
        ParsedTable.add(SurnameName);
        ParsedTable.add(DatesOfStart);
        ParsedTable.add(Phones);
        ParsedTable.add(Times);
        return ParsedTable;
    }

    @Transactional
    public List<PatientMenu> patQuery(String spec, String date) {
        List<PatientMenu> PatMenu = new ArrayList<>();
        ArrayList<ArrayList<String>> ParsedList = patQueryParsed(this.menuDao.infoForPatients(spec, date));
        for (int i = 0; i < ParsedList.get(5).size(); i+=1) {
            PatientMenu OnePatMenu = new PatientMenu(
                    ParsedList.get(1).get(i), ParsedList.get(2).get(i),
                    ParsedList.get(3).get(i), ParsedList.get(0).get(i),
                    ParsedList.get(5).get(i), ParsedList.get(4).get(i));
            PatMenu.add(OnePatMenu);
        }
        for(PatientMenu p : PatMenu){
            logger.info("Patient menu return: " + p.toString());
        }
        return PatMenu;
    }

    @Transactional
    public ArrayList<ArrayList<String>> dentQueryParsed(List<DentistMenu> QueryResult) {

        ArrayList<ArrayList<String>> ParsedTable = new ArrayList<>();
        ArrayList<String> SurnameName = new ArrayList<>();
        ArrayList<String> Dates = new ArrayList<>();
        ArrayList<String> Time = new ArrayList<>();
        ArrayList<String> Phones = new ArrayList<>();


        for (int i = 0; i < QueryResult.size(); ++i) {
            DentistMenu d = QueryResult.get(i);

            if(!SurnameName.contains(d.getSurnamname()))
                SurnameName.add(d.getSurnamname());
            else SurnameName.add(" ");

            if(!Dates.contains(d.getDate()))
                Dates.add(d.getDate());
            else Dates.add(" ");

            if(!Time.contains(d.getTime())) Time.add(d.getTime());
            else Time.add(" ");

            if(!Phones.contains(d.getPhone()))
                Phones.add(d.getPhone());
            else Phones.add(" ");
        }
        ParsedTable.add(SurnameName);
        ParsedTable.add(Dates);
        ParsedTable.add(Phones);
        ParsedTable.add(Time);
        return ParsedTable;
    }

    @Transactional
    public List<DentistMenu> dentQuery(Integer id, String date) {
        List<DentistMenu> DentMenu = new ArrayList<>();
        ArrayList<ArrayList<String>> ParsedList = dentQueryParsed(this.menuDao.infoForDentist(id, date));
        for (int i = 0; i < ParsedList.get(2).size(); i+=1) {
            DentistMenu OneDentMenu = new DentistMenu(
                    ParsedList.get(0).get(i), ParsedList.get(1).get(i),
                    ParsedList.get(2).get(i), ParsedList.get(2).get(i));
            DentMenu.add(OneDentMenu);
        }
        for(DentistMenu d : DentMenu){
            logger.info("Dentist menu return " + d.toString());
        }

        return DentMenu;
    }
}
