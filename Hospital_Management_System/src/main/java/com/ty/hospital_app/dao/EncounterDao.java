																														package com.ty.hospital_app.dao;

import java.util.List;

import com.ty.hospital_app.dto.Encounter;

public interface EncounterDao {
	public Encounter saveEncounter(int bid,Encounter Encounter);

	public Encounter getEncounterbyId(int aid);

	public boolean deleteEncounterId(int aid);

	public Encounter updateEncounter(int aid, Encounter Encounter);
	
	public List<Encounter> getAllEncounter();
}
