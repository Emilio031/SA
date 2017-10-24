package com.sample.store.dao;

import com.sample.store.entity.Employee;
import com.sample.store.entity.Firm;

import java.util.List;

public interface FirmDAO {
	public void add_firm(Firm aFirm);

	public void delete_firm(Firm aFirm);

	public void modify_firm(Firm aFirm);

	public List<Firm> getList();
	public Firm get_firm(Firm firm);
}
