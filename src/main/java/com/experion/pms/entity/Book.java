/**
 * 
 */
package com.experion.pms.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author AneeshChandran
 *
 */

@Entity
@Table(name = "BOOK")
public class Book implements Serializable {

	private static final long serialVersionUID = 5110000555475069551L;

	
	/*@GeneratedValue(strategy=GenerationType.AUTO)
	//@GeneratedValue(strategy = GenerationType.AUTO, generator = "LTS_EMP_DETAILS")
	//@SequenceGenerator(name = "LTS_EMP_DETAILS", sequenceName = "LTS_EMP_ID_SEQ")
	@Column(name = "book_ID")
	private Long bookID;*/
	
	@Id
	@Column(name = "item_number")
	private String itemNumber;
	
	@Column(name = "item_desc")
	private String itemDesc;
	
	@Column(name = "received_date")
	private String receivedDate;
	
	@Column(name = "shipping_method")
	private String shippingMethod;
	
	@Column(name = "shipping_notes")
	private String shippingNotes;
	
	@Column(name = "shipping_priority")
	private Integer shippingPriority;
	
	@Column(name = "packaging_instr")
	private String packagingInstructions;
	
	@Column(name = "delivered_on")
	private String deliveredOn;
	
	@Column(name = "delivered_by")
	private String deliveredBy;
	
	@Column(name = "delivery_track_no")
	private String trackingNumber;
	
	
	public String getItemNumber() {
		return itemNumber;
	}
	public void setItemNumber(String itemNumber) {
		this.itemNumber = itemNumber;
	}
	public String getItemDesc() {
		return itemDesc;
	}
	public void setItemDesc(String itemDesc) {
		this.itemDesc = itemDesc;
	}
	public String getReceivedDate() {
		return receivedDate;
	}
	public void setReceivedDate(String receivedDate) {
		this.receivedDate = receivedDate;
	}
	public String getShippingMethod() {
		return shippingMethod;
	}
	public void setShippingMethod(String shippingMethod) {
		this.shippingMethod = shippingMethod;
	}
	public String getShippingNotes() {
		return shippingNotes;
	}
	public void setShippingNotes(String shippingNotes) {
		this.shippingNotes = shippingNotes;
	}
	public Integer getShippingPriority() {
		return shippingPriority;
	}
	public void setShippingPriority(Integer shippingPriority) {
		this.shippingPriority = shippingPriority;
	}
	public String getPackagingInstructions() {
		return packagingInstructions;
	}
	public void setPackagingInstructions(String packagingInstructions) {
		this.packagingInstructions = packagingInstructions;
	}
	public String getDeliveredOn() {
		return deliveredOn;
	}
	public void setDeliveredOn(String deliveredOn) {
		this.deliveredOn = deliveredOn;
	}
	public String getDeliveredBy() {
		return deliveredBy;
	}
	public void setDeliveredBy(String deliveredBy) {
		this.deliveredBy = deliveredBy;
	}
	public String getTrackingNumber() {
		return trackingNumber;
	}
	public void setTrackingNumber(String trackingNumber) {
		this.trackingNumber = trackingNumber;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Book [itemNumber= ").append(itemNumber)
		.append("itemDesc= ").append(itemDesc)
		.append("receivedDate= ").append(receivedDate)
		.append("shippingMethod= ").append(shippingMethod)
		.append("shippingNotes= ").append(shippingNotes)
		.append("shippingPriority= ").append(shippingPriority)
		.append("packagingInstructions= ").append(packagingInstructions)
		.append("deliveredOn= ").append(deliveredOn)
		.append("deliveredBy= ").append(deliveredBy)
		.append("trackingNumber= ").append(trackingNumber);
		return  builder.toString();
	}
	
}
