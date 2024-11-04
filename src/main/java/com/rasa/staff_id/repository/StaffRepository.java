package com.rasa.staff_id.repository;

import com.rasa.staff_id.Staff;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

//@Component
@Repository
public class StaffRepository {
    private  List<Staff> AllStaff = new ArrayList<>();

    public  Staff getStaffByIndex(int index){
        return AllStaff.get(index);
    }

    public void addStaff(Staff staff){
        AllStaff.add(staff);
    }

    public void updateStaff(Staff staff, int index){
        AllStaff.set(index,staff);
    }

    public List<Staff> getAllStaff(){
        return AllStaff;
    }
}
