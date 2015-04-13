package com.experion.pms.mvc.data;

import java.io.Serializable;

public class BookManagementForm implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -169626869927070996L;
	
	private String itemNumber;
	private String receivedDate;
	private String itemDescription;
	private String shippingMethod;
	private String shippingPriority;
	private String shippingNotes;
	private String packageInstruction;
	private String deliveredOn;
	private String deliveredBy;
	private String deliveryTrackingNo;
	private String gblMsg;
	private String queryItemNumber;
	private String emptyRecords;
	
	
	
	public String getItemNumber() {
		return itemNumber;
	}
	public void setItemNumber(String itemNumber) {
		this.itemNumber = itemNumber;
	}
	public String getReceivedDate() {
		return receivedDate;
	}
	public void setReceivedDate(String receivedDate) {
		this.receivedDate = receivedDate;
	}
	public String getItemDescription() {
		return itemDescription;
	}
	public void setItemDescription(String itemDescription) {
		this.itemDescription = itemDescription;
	}
	public String getShippingMethod() {
		return shippingMethod;
	}
	public void setShippingMethod(String shippingMethod) {
		this.shippingMethod = shippingMethod;
	}
	public String getShippingPriority() {
		return shippingPriority;
	}
	public void setShippingPriority(String shippingPriority) {
		this.shippingPriority = shippingPriority;
	}
	public String getShippingNotes() {
		return shippingNotes;
	}
	public void setShippingNotes(String shippingNotes) {
		this.shippingNotes = shippingNotes;
	}
	public String getPackageInstruction() {
		return packageInstruction;
	}
	public void setPackageInstruction(String packageInstruction) {
		this.packageInstruction = packageInstruction;
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
	public String getDeliveryTrackingNo() {
		return deliveryTrackingNo;
	}
	public void setDeliveryTrackingNo(String deliveryTrackingNo) {
		this.deliveryTrackingNo = deliveryTrackingNo;
	}
	public String getGblMsg() {
		return gblMsg;
	}
	public void setGblMsg(String gblMsg) {
		this.gblMsg = gblMsg;
	}
	public String getQueryItemNumber() {
		return queryItemNumber;
	}
	public void setQueryItemNumber(String queryItemNumber) {
		this.queryItemNumber = queryItemNumber;
	}
	public String getEmptyRecords() {
		return emptyRecords;
	}
	public void setEmptyRecords(String emptyRecords) {
		this.emptyRecords = emptyRecords;
	}

}
