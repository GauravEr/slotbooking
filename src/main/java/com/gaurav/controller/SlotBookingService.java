package com.gaurav.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.gaurav.entity.Slot;
import com.gaurav.service.SlotService;

@RestController
public class SlotBookingService {
	
	
	@Resource
	private SlotService slotService;	
	
	
	@RequestMapping(value = "/getAllSlotsForDate", method = RequestMethod.POST, produces={"application/json","application/xml"})
	public List<Slot> createSlotsForDate(@RequestParam(value = "date") String date){		
		List<Slot> slotList = slotService.getAllSlotsForDate(date);
		if(slotList == null || slotList.isEmpty()){
			slotList = slotService.createSlots(date);
		}
		return slotList;
	}
	
	@RequestMapping(value = "/bookslot", method = RequestMethod.POST, consumes = "application/x-www-form-urlencoded")
	public String bookSlot(@RequestParam(value = "slot") String slot){
		
		ObjectMapper mapper = new ObjectMapper();
		Slot slotObj = null;
		try{
			slotObj = mapper.readValue(slot, Slot.class);
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
		slotService.updateSlot(slotObj);
		return "Slot detail :"+slotObj.toString();
	}
	
	@RequestMapping(value = "/getSlotsForOrder", method = RequestMethod.POST,produces={"application/json", "application/xml"})
	public List<Slot> getSlotsForOrder(@RequestParam(value="order") String order){		
		return slotService.getSlotsForOrder(order);
	}
	
	@RequestMapping(value = "/getAllOrders", method = RequestMethod.GET,produces={"application/json", "application/xml"})
	public List<String> getAllOrders(){		
		return slotService.getAllOrders();
	}
	
}
