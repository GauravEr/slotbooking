
package com.gaurav.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="SLOT")
public class Slot {
	
	@Id
	@GeneratedValue
	@Column(name="ID")
	private Integer id;
	
	@Column(name="ITEM_COUNT")
	private Integer itemCount;
	
	@Column(name="SLOT_DATE")
	private String slotDate;
	
	@Column(name="SLOT_TIME")
	private String slotTime;
	
	@Column(name="IS_BOOKED")
	private Boolean isBooked;
	
	@Column(name="ORDER_NAME")
	private String orderName;


	public Integer getId() {
		return id;
	}

	
	public void setId(Integer id) {
		this.id = id;
	}

	
	public Integer getItemCount() {
		return itemCount;
	}

	
	public void setItemCount(Integer itemCount) {
		this.itemCount = itemCount;
	}

	
	@Override
	public String toString() {
		return "Slot [id=" + id + ", itemCount=" + itemCount + ", slotDate="
				+ slotDate + ", slotTime=" + slotTime + ", isBooked="
				+ isBooked + ", orderName=" + orderName + "]";
	}


	public String getSlotDate() {
		return slotDate;
	}

	
	public void setSlotDate(String slotDate) {
		this.slotDate = slotDate;
	}


	public String getSlotTime() {
		return slotTime;
	}

	
	public void setSlotTime(String slotTime) {
		this.slotTime = slotTime;
	}

	
	public Boolean getIsBooked() {
		return isBooked;
	}

	
	public void setIsBooked(Boolean isBooked) {
		this.isBooked = isBooked;
	}

	
	public String getOrderName() {
		return orderName;
	}

	
	public void setOrderName(String orderName) {
		this.orderName = orderName;
	}

}
