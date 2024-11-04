package com.rasa.staff_id.service;

import com.rasa.staff_id.Constants;
import com.rasa.staff_id.Staff;
import com.rasa.staff_id.repository.StaffRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

//@Component
@Service
public class StaffService {
    //StaffRepository staffRepository = new StaffRepository();

    @Autowired
    StaffRepository staffRepository;

    public Staff getStaffByIndex(int index){
        return staffRepository.getStaffByIndex(index);
    }

    public Staff getStaffById(String id){
        int index = getStaffIndex(id);
        return index == Constants.NO_MATCH ? new Staff() : getStaffByIndex(index);
    }

    public void addStaff(Staff staff){
        staffRepository.addStaff(staff);
    }

    public void updateStaff(Staff staff, int index){
        staffRepository.updateStaff(staff,index);
    }

    public void submitStaff(Staff staff ){
        int index = getStaffIndex(staff.getId());
        if(index == Constants.NO_MATCH){
            addStaff(staff);
        }
        else {
            updateStaff(staff,index);
        }
    }

    public List<Staff> getAllStaff(){
        return staffRepository.getAllStaff();
    }

    public int getStaffIndex(String id) {
        for (int i = 0; i < getAllStaff().size(); i++) {
            if(getStaffByIndex(i).getId().equals(id)) return i;

        }
        return Constants.NO_MATCH;
    }
}
