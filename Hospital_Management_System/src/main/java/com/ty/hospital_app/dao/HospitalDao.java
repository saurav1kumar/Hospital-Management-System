package com.ty.hospital_app.dao;

import com.ty.hospital_app.dto.Hospital;

public interface HospitalDao {
	public Hospital saveHospital(Hospital hospital);

	public Hospital getHospitalbyId(int hospital_id);

	public boolean deletehospitalId(int hospital_id);

	public Hospital updateHospital(int hospital_id, Hospital hospital);
}
