package com.ty.hospital_app.service;

import com.ty.hospital_app.dao.imp.HospitalDaoImp;
import com.ty.hospital_app.dto.Hospital;

public class HospitalService {
	public void saveHospital(Hospital hospital) {
		HospitalDaoImp daoImp = new HospitalDaoImp();
		Hospital hospital2 = daoImp.saveHospital(hospital);
		if (hospital2 != null) {
			System.out.println("data saved");
		} else {
			System.out.println("Unfortunately data not saved");
		}
	}

	public Hospital getHospitalById(int hospital_id) {
		HospitalDaoImp daoImp = new HospitalDaoImp();
		Hospital hospital2 = daoImp.getHospitalbyId(hospital_id);
		if (hospital2 != null) {
			return hospital2;
		} else {
			return null;
		}
	}

	public void deleteHospitalById(int hospital_id) {
		HospitalDaoImp daoImp = new HospitalDaoImp();
		boolean flag = daoImp.deletehospitalId(hospital_id);
		if (flag) {
			System.out.println("Data Deleted");
		} else {
			System.out.println("Data Not Found");
		}
	}

	public Hospital updateHospitalById(int hid) {
		HospitalDaoImp daoImp = new HospitalDaoImp();
		Hospital hospital1 = daoImp.updateHospital(hid, null);
		if (hospital1 != null) {
			return hospital1;
		} else {
			return null;
		}
	}

}
