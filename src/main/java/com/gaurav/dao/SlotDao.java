package com.gaurav.dao;

import java.util.List;

import com.gaurav.entity.Slot;


public interface SlotDao {

	public List<Slot> getAllSlotsForDate(String date);
	public void createSlots(List<Slot> slots);
	public void updateSlot(Slot slot);
	public List<Slot> getSlotsForOrder(String order);
	public List<String> getAllOrders();
}
