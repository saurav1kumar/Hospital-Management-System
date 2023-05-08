package com.ty.hospital_app.dao.imp;

import java.util.List;

import com.ty.hospital_app.dao.BranchDao;
import com.ty.hospital_app.dto.Branch;
import com.ty.hospital_app.dto.Hospital;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;

public class BranchDaoImp implements BranchDao {

	public Branch saveBranch(int hospital_id, Branch Branch) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("hi");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		Hospital hospital = em.find(Hospital.class, hospital_id);
		if (hospital != null) {
			et.begin();
			em.remove(hospital);
			et.commit();
			return Branch;
		} else {
			return null;
		}

	}

	public Branch getBranchbyId(int bid) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("hi");
		EntityManager em = emf.createEntityManager();
		Branch branch = em.find(Branch.class, bid);
		return branch;

	}

	public boolean deleteBranchId(int bid) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("hi");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		Branch branch = em.find(Branch.class, bid);
		if (branch != null) {
			et.begin();
			em.remove(branch);
			et.commit();
			return true;
		} else {
			return false;
		}
	}

	public Branch updateBranch(int bid, Branch Branch) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("hi");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		Hospital branch = em.find(Hospital.class, bid);
		if (branch != null) {
			branch.sethospital_name(branch.gethospital_name());
			branch.sethospital_website(branch.gethospital_website());
			et.begin();
			em.merge(branch);
			et.commit();
			return Branch;
		} else {
			return null;
		}
	}

	public List<Branch> getAllBranch() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("hi");
		EntityManager em = emf.createEntityManager();
		Query query = (Query) em.createQuery("Select s from Branch s");
		List<Branch> branch = query.getResultList();
		return branch;
	}

}
