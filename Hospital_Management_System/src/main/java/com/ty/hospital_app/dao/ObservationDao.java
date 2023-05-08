package com.ty.hospital_app.dao;

import java.util.List;

import com.ty.hospital_app.dto.Encounter;
import com.ty.hospital_app.dto.Observation;

public interface ObservationDao {
	public Observation saveObservation(int eid, Observation Observation);

	public Observation getObservationbyId(int oid);

	public boolean deleteObservationId(int oid);

	public Observation updateObservation(int oid, Observation Observation);

	public List<Observation> getAllObservations();

	public List<Observation> getObservationbyDoctorName(String name);
}
