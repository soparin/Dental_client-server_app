package com.Patient.client;

import com.Patient.dao.PatientDao;
import com.Patient.model.Patient;
import com.Patient.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.logging.Logger;

@Controller
public class PatientController {

    @Autowired()
    @Qualifier(value = "patientService")
    private PatientService patientService;
    Logger logger = Logger.getLogger(PatientController.class.getName());
    public void setPatientService(PatientService ps) {
        this.patientService = ps;
    }

    @RequestMapping(value = "/patients", method = RequestMethod.GET)
    public String listPatient(Model model) {
        model.addAttribute("patient", new Patient());
        model.addAttribute("listPatient", this.patientService.listPatient());
        return "Patient";
    }

    @RequestMapping(value = "/patients/add", method = RequestMethod.POST)
    public String addPat(@ModelAttribute @Valid Patient patient, BindingResult result){
        if(result.hasErrors()){
            return "Patient";
        }
        if(patient.getPatientId() == null){
            this.patientService.addPat(patient);
        }else {
            this.patientService.updatePat(patient);
        }
        return "redirect:/patients";
    }

    @RequestMapping("/pat/remove/{id}")
    public String removePat(@PathVariable("id") Integer id){
        this.patientService.removePat(id);
        return "redirect:/patients";
    }

    @RequestMapping("/pat/edit/{id}")
    public String editPat(@PathVariable("id") Integer id, Model model){
        model.addAttribute("patient", this.patientService.getPatById(id));
        model.addAttribute("listPatient", this.patientService.listPatient());
        return "Patient";
    }

    @RequestMapping("/")
    public String menu(){return "index";}
}