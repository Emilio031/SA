package com.sample.store.dao;

import java.util.List;

import com.sample.store.entity.Employee;
import com.sample.store.entity.Inventory;


public interface InventoryDAO {
	public void add_inventory(Inventory aInventory);

	public void delete_inventory(Inventory aInventory);

	public void modify_inventory(Inventory aInventory);

	public List<Inventory> getList();
	public Inventory get_inventory(Inventory aInventory);
	public void minus_inventory(Inventory aInventory);
	public void clearUse(Inventory aInventory);
	public void plus_inventory(Inventory aInventory);
	public void use_inventory(Inventory aInventory);
//	public Inventory get_inventory();
}
