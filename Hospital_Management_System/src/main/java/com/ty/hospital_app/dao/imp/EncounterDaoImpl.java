package com.ty.hospital_app.dao.imp;

import java.util.List;

import com.ty.hospital_app.dao.EncounterDao;
import com.ty.hospital_app.dto.Branch;
import com.ty.hospital_app.dto.Encounter;
import com.ty.hospital_app.dto.Hospital;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;

public class EncounterDaoImpl implements EncounterDao {

	public Encounter saveEncounter(int bid, Encounter Encounter) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("hi");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		Encounter encounter = em.find(Encounter.class, bid);
		if (encounter != null) {
			et.begin();
			em.remove(encounter);
			et.commit();
			return Encounter;
		} else {
			return null;
		}
	}

	public Encounter getEncounterbyId(int aid) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("hi");
		EntityManager em = emf.createEntityManager();
		Encounter encounter = em.find(Encounter.class, aid);
		return encounter;
	}

	public boolean deleteEncounterId(int aid) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("hi");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		Encounter encounter = em.find(Encounter.class, aid);
		if (encounter != null) {
			et.begin();
			em.remove(encounter);
			et.commit();
			return true;
		} else {
			return false;
		}

	}

	public Encounter updateEncounter(int aid, Encounter Encounter) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("hi");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		Encounter encounter = em.find(Encounter.class, aid);
		if (encounter != null) {
			encounter.setBranch(encounter.getBranch());
			encounter.setPerson(encounter.getPerson());
			et.begin();
			em.merge(encounter);
			et.commit();
			return encounter;
		} else {
			return null;
		}
	}

	public List<Encounter> getAllEncounter() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("hi");
		EntityManager em = emf.createEntityManager();
		Query query = (Query) em.createQuery("Select s from Branch s");
		List<Encounter> encounter = query.getResultList();
		return encounter;
	}

}
