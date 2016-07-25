package com.gaurav.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gaurav.dao.SlotDao;
import com.gaurav.entity.Slot;
import com.gaurav.util.SlotFactory;


@Service
public class SlotServiceImpl implements SlotService{

	@Autowired
	private SlotDao slotDao;
	
	@Override
	@Transactional
	public List<Slot> getAllSlotsForDate(String date) {		
		return slotDao.getAllSlotsForDate(date);
	}

	@Override
	@Transactional
	public List<Slot> createSlots(String date) {
		List<Slot> slotList = SlotFactory.getInstance().createSlotsForGivenDate(date);
		slotDao.createSlots(slotList);
		return slotList;
	}

	@Override
	@Transactional
	public void updateSlot(Slot slot) {		
		Slot validSlot = SlotFactory.getInstance().validateSlot(slot);
		slotDao.updateSlot(validSlot);
	}

	@Override
	@Transactional
	public List<Slot> getSlotsForOrder(String order){		
		return slotDao.getSlotsForOrder(order);
	}
	
	@Override
	@Transactional
	public List<String> getAllOrders() {		
		return slotDao.getAllOrders();
	}
	
	public void setSlotDao(SlotDao slotDao){
		this.slotDao = slotDao;
	}

}
