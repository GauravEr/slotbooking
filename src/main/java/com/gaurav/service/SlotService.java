package com.gaurav.service;

import java.util.List;

import com.gaurav.entity.Slot;

public interface SlotService {

	public List<Slot> getAllSlotsForDate(String date);
	public List<Slot> createSlots(String date);
	public void updateSlot(Slot slot);
	public List<Slot> getSlotsForOrder(String order);
	public List<String> getAllOrders();
}
