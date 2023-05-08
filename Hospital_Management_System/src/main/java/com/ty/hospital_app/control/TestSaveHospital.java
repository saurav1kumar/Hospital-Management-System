package com.ty.hospital_app.control;

import com.ty.hospital_app.dto.Hospital;
import com.ty.hospital_app.service.HospitalService;

public class TestSaveHospital {
public static void main(String[] args) {
	Hospital hospital=new Hospital();
	HospitalService service=new HospitalService();
	hospital.sethospital_name("Appolo");
	hospital.sethospital_website("www.saurav.com");
	service.saveHospital(hospital);
	}
}
