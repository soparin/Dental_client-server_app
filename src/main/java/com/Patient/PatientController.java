package com.Patient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.logging.Logger;

@Controller
public class PatientController {

    @Autowired
    private PatientValidator patientValidator;

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
    public String addPat(@ModelAttribute @Valid Patient patient, BindingResult result, Model model){
        patientValidator.validate(patient, result);;
        if(result.hasErrors()){
            model.addAttribute("listPatient", this.patientService.listPatient());
            return "Patient";
        }
        if(patient.getPatientId() == null){
            this.patientService.addPat(patient);
        }else {
            this.patientService.updatePat(patient);
        }
        return "redirect:/patients";
    }

    @RequestMapping(value = "/pat/edit", method = RequestMethod.POST)
    public String editPat(@ModelAttribute Patient patient, Model model){
        patient = this.patientService.getPatById(patient.getPatientId());
        model.addAttribute("patient", patient);
        model.addAttribute("listPatient", this.patientService.listPatient());

        return "Patient";
    }

    @RequestMapping(value = "/pat/remove", method = RequestMethod.POST)
    public String deletePat(@ModelAttribute Patient patient)
    {
        this.patientService.removePat(patient.getPatientId());
        return "redirect:/patients";
    }
}