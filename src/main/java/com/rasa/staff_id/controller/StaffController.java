package com.rasa.staff_id.controller;


import com.rasa.staff_id.Constants;
import com.rasa.staff_id.Staff;
import com.rasa.staff_id.repository.StaffRepository;
import com.rasa.staff_id.service.StaffService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;



@Controller
public class StaffController {

    //List<Staff> AllStaff = new ArrayList<>();
    //StaffRepository staffRepository = new StaffRepository();
        //StaffService staffService = new StaffService();

        @Autowired
        StaffService staffService;


    @GetMapping("/")
    public String addNewStaff(Model model, @RequestParam (required = false) String id){
        Staff myStaff = new Staff();
        //int index = staffService.getStaffIndex(id);
        /*model.addAttribute("newStaff",index == Constants.NO_MATCH ?
                myStaff : AllStaff.get(index));*/
//        model.addAttribute("newStaff",index == Constants.NO_MATCH ?
//                myStaff : staffService.getStaffByIndex(index));
        model.addAttribute("newStaff",staffService.getStaffById(id));
        return "addnewstaff";
    }



    @PostMapping("/datasubmitform")
    public String dataSubmitForm(@Valid @ModelAttribute("newStaff") Staff staff, BindingResult result){
        if(result.hasErrors()){
            return "addnewstaff";
        }

        /*int index = staffService.getStaffIndex(staff.getId());
        if(index == Constants.NO_MATCH){
            staffService.addStaff(staff);
        }
        else {
            staffService.updateStaff(staff,index);
        }*/

        staffService.submitStaff(staff);

        return "redirect:/allstaff";
    }

    @GetMapping("/allstaff")
    public String getAllStaffDetails(Model model){

        model.addAttribute("allStaff",staffService.getAllStaff());
        return "allstaff";
    }
}
