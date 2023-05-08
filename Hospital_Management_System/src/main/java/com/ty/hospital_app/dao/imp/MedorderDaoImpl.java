package com.ty.hospital_app.dao.imp;

import java.util.List;

import com.ty.hospital_app.dao.MedOrderDao;
import com.ty.hospital_app.dto.Medorder;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;

public class MedorderDaoImpl implements MedOrderDao {

	public Medorder saveMedorder(int eid, Medorder Medorder) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("hi");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();

		et.begin();
		em.persist(Medorder);
		et.commit();
		return Medorder;
	}

	public Medorder getMedorderbyId(int mid) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("hi");
		EntityManager em = emf.createEntityManager();
		Medorder medorder = em.find(Medorder.class, mid);
		return medorder;
	}

	public boolean deleteMedorderId(int mid) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("hi");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		Medorder medorder = em.find(Medorder.class, mid);
		if (medorder != null) {
			et.begin();
			em.remove(medorder);
			et.commit();
			return true;
		} else {
			return false;
		}

	}

	public Medorder updateMedorder(int mid, Medorder Medorder) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("hi");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		Medorder medorder = em.find(Medorder.class, mid);
		if (medorder != null) {
			medorder.setDname(medorder.getDname());
			medorder.setOrderdate(medorder.getOrderdate());
			et.begin();
			em.merge(medorder);
			et.commit();
			return medorder;
		} else {
			return null;
		}
	}

	public List<Medorder> getAllMedorder() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("hi");
		EntityManager em = emf.createEntityManager();
		Query query = (Query) em.createQuery("Select s from Branch s");
		List<Medorder> medorder = query.getResultList();
		return medorder;
	}

	public List<Medorder> getMedOrderByDoctorName(String name) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("hi");
		EntityManager em = emf.createEntityManager();
		Medorder medorder1 = em.find(Medorder.class, name);
		return getMedOrderByDoctorName(name);
	}

}
