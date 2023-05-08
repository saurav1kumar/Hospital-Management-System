package com.ty.hospital_app.dao;

import java.util.List;

import com.ty.hospital_app.dto.Medorder;
import com.ty.hospital_app.dto.Person;

public interface MedOrderDao {
	public Medorder saveMedorder(int eid, Medorder Medorder);

	public Medorder getMedorderbyId(int mid);

	public boolean deleteMedorderId(int mid);

	public Medorder updateMedorder(int mid, Medorder Medorder);

	public List<Medorder> getAllMedorder();

	public List<Medorder> getMedOrderByDoctorName(String name);

	// public List<Medorder> getMedOrderByDate(String date);
}
