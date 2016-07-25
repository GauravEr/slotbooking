
package com.gaurav.dao;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;

import com.gaurav.entity.Slot;


@Component
public class SlotDaoImpl implements SlotDao{

	@Resource
	private SessionFactory sessionFactory;
	
	@Override
	public List<Slot> getAllSlotsForDate(String date) {		
		return sessionFactory.getCurrentSession().createQuery("from Slot where slotDate='"+date+"'").list();
	}

	@Override
	public void createSlots(List<Slot> slots) {

		for(Slot slot : slots){
			sessionFactory.getCurrentSession().save(slot);
		}
	}

	@Override
	public void updateSlot(Slot slot) {
		
		sessionFactory.getCurrentSession().update(slot);
	}
	
	@Override
	public List<String> getAllOrders() {		
		return sessionFactory.getCurrentSession().createQuery("select distinct orderName from Slot where orderName is not null").list();
	}
	
	@Override
	public List<Slot> getSlotsForOrder(String order) {		
		return sessionFactory.getCurrentSession().createQuery("from Slot where orderName='"+order+"'").list();
	}
	
	public void setSessionFactory(SessionFactory sessionFactory){
		this.sessionFactory = sessionFactory;
	}

}
