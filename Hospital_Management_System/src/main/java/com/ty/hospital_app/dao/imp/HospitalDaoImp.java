package com.ty.hospital_app.dao.imp;

import com.ty.hospital_app.dao.HospitalDao;
import com.ty.hospital_app.dto.Hospital;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class HospitalDaoImp implements HospitalDao {

	public Hospital saveHospital(Hospital hospital) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("hi");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();

		et.begin();
		em.persist(hospital);
		et.commit();
		return hospital;
	}

	public Hospital getHospitalbyId(int hospital_id) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("hi");
		EntityManager em = emf.createEntityManager();
		Hospital hospital = em.find(Hospital.class, hospital_id);
		return hospital;
	}

	public boolean deletehospitalId(int hospital_id) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("hi");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		Hospital hospital = em.find(Hospital.class, hospital_id);
		if (hospital != null) {
			et.begin();
			em.remove(hospital);
			et.commit();
			return true;
		} else {
			return false;
		}
	}

	public Hospital updateHospital(int hospital_id, Hospital hospital) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("hi");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		Hospital hospital1 = em.find(Hospital.class, hospital_id);
		if (hospital1 != null) {
			hospital1.sethospital_name(hospital1.gethospital_name());
			hospital1.sethospital_website(hospital1.gethospital_website());
			et.begin();
			em.merge(hospital1);
			et.commit();
			return hospital;
		} else {
			return null;
		}
	}

}
