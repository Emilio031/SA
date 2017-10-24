package com.sample.store.dao;

import java.util.List;

import com.sample.store.entity.Attendence;

public interface AttendenceDAO {
	
	public void add_attendence(Attendence aAttendence);
    public void delete_attendence(Attendence aAttendence);
    public List<Attendence> search_attendence(Attendence aAttendence);
    
    public void modify_attendence(Attendence aAttendence);
	
	public List<Attendence> getList();
//	public List<Attendence> getReorderList();
//	public List<Attendence> getAvailableList();

	public Attendence get_attendence(Attendence aAttendence);
	
}
