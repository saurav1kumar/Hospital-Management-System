package com.ty.hospital_app.service;

import com.ty.hospital_app.dao.imp.EncounterDaoImpl;
import com.ty.hospital_app.dao.imp.HospitalDaoImp;
import com.ty.hospital_app.dto.Encounter;
import com.ty.hospital_app.dto.Hospital;


public class EncounterService {
	public Encounter saveEncounter(Encounter encounter) {
		EncounterDaoImpl daoImp = new EncounterDaoImpl();
		Encounter encounter2 = daoImp.saveEncounter(0,encounter);
		if (encounter2 != null) {
			System.out.println("data saved");
		} else {
			System.out.println("Unfortunately data not saved");
		}
		return encounter2;
	}


	public Encounter getEncounterById(int eid) {
		EncounterDaoImpl daoImp = new EncounterDaoImpl();
		Encounter encounter = daoImp.getEncounterbyId(eid);
		if (encounter != null) {
			return encounter;
		} else {
			return null;
		}
	}

	public void deleteEncounterById(int eid) {
		EncounterDaoImpl daoImp = new EncounterDaoImpl();
		boolean flag = daoImp.deleteEncounterId(eid);
		if (flag) {
			System.out.println("Data Deleted");
		} else {
			System.out.println("Data Not Found");
		}
	}

	public Encounter updateEncounterById(int hid) {
		EncounterDaoImpl daoImp = new EncounterDaoImpl();
		Encounter encounter = daoImp.updateEncounter(hid, null);
		if (encounter != null) {
			return encounter;
		} else {
			return null;
		}
	}	
}
