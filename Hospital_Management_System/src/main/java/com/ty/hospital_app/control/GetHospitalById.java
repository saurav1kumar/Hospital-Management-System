package com.ty.hospital_app.control;

import com.ty.hospital_app.dto.Hospital;
import com.ty.hospital_app.service.HospitalService;

public class GetHospitalById {
	public static void main(String[] args) {
		HospitalService service = new HospitalService();
		Hospital hospital = service.getHospitalById(1);
		System.out.println(hospital.gethospital_id());
		System.out.println(hospital.gethospital_name());
		System.out.println(hospital.gethospital_website());

	}
}
