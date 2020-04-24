package com.patientapi.model;

public class Patient {
   
	public	int patientNo;
    public	String patientname;
    
    
    
    
	public Patient(int patientNo, String patientname) {
		super();
		this.patientNo = patientNo;
		this.patientname = patientname;
	}




	public Patient() {
		super();
		// TODO Auto-generated constructor stub
	}




	public int getPatientNo() {
		return patientNo;
	}




	public String getPatientname() {
		return patientname;
	}




	public void setPatientNo(int patientNo) {
		this.patientNo = patientNo;
	}




	public void setPatientname(String patientname) {
		this.patientname = patientname;
	}
	
	
	
}