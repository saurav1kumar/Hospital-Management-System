package com.ty.hospital_app.dao.imp;

import java.util.List;

import com.ty.hospital_app.dao.ObservationDao;
import com.ty.hospital_app.dto.Medorder;
import com.ty.hospital_app.dto.Observation;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;

public class ObservationDaoImpl implements ObservationDao {

	public Observation saveObservation(int eid, Observation Observation) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("hi");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();

		et.begin();
		em.persist(Observation);
		et.commit();
		return Observation;

	}

	public Observation getObservationbyId(int oid) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("hi");
		EntityManager em = emf.createEntityManager();
		Observation observation = em.find(Observation.class, oid);
		return observation;
	}

	public boolean deleteObservationId(int oid) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("hi");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		Observation observation = em.find(Observation.class, oid);
		if (observation != null) {
			et.begin();
			em.remove(observation);
			et.commit();
			return true;
		} else {
			return false;
		}
	}

	public Observation updateObservation(int oid, Observation Observation) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("hi");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		Observation observation = em.find(Observation.class, oid);
		if (observation != null) {
			observation.setDname(observation.getDname());
			observation.setRobservation(observation.getRobservation());
			et.begin();
			em.merge(observation);
			et.commit();
			return observation;
		} else {
			return null;
		}
	}

	public List<Observation> getAllObservations() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("hi");
		EntityManager em = emf.createEntityManager();
		Query query = (Query) em.createQuery("Select s from Branch s");
		List<Observation> observations = query.getResultList();
		return observations;
	}

	public List<Observation> getObservationbyDoctorName(String name) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("hi");
		EntityManager em = emf.createEntityManager();
		Medorder medorder1 = em.find(Medorder.class, name);
		return getObservationbyDoctorName(name);
	}

}
