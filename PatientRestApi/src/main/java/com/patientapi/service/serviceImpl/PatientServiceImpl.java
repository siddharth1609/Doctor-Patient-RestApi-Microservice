package com.patientapi.service.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.configuration.plist.XMLPropertyListConfiguration.PListNode;
import org.springframework.stereotype.Service;

import com.patientapi.model.Patient;
import com.patientapi.service.PatientService;

@Service
public class PatientServiceImpl implements PatientService {
	


	
	
	
	
	

	@Override
	public List<Patient> getPatientList() {
		
		
		List<Patient> pList = new ArrayList<>();
		Patient p = new Patient();
		
		p.setPatientNo(1);
		p.setPatientname("A");
		pList.add(p);
		
		
		return pList;
		
	}

	
	
	
	
}
