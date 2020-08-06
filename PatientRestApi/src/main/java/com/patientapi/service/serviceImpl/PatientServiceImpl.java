package com.patientapi.service.serviceImpl;

import com.patientapi.model.Patient;
import com.patientapi.service.PatientService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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
