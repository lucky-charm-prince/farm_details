package com.entity;

public class AddPestisides {
	private int id;
   private String cropName;
   private String cropAge;
   private String pestisidesName;
   private int userId;
public AddPestisides(String cropName, String cropAge, String pestisidesName, int userId) {
	super();
	this.cropName = cropName;
	this.cropAge = cropAge;
	this.pestisidesName = pestisidesName;
	this.userId = userId;
}
public AddPestisides() {
	super();
	// TODO Auto-generated constructor stub
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getCropName() {
	return cropName;
}
public void setCropName(String cropName) {
	this.cropName = cropName;
}
public String getCropAge() {
	return cropAge;
}
public void setCropAge(String cropAge) {
	this.cropAge = cropAge;
}
public String getPestisidesName() {
	return pestisidesName;
}
public void setPestisidesName(String pestisidesName) {
	this.pestisidesName = pestisidesName;
}
public int getUserId() {
	return userId;
}
public void setUserId(int userId) {
	this.userId = userId;
}
@Override
public String toString() {
	return "AddPestisides [cropName=" + cropName + ", cropAge=" + cropAge + ", pestisidesName=" + pestisidesName
			+ ", userId=" + userId + "]";
}


   
   
	
}
