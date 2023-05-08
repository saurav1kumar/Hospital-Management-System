package com.ty.hospital_app.dao.imp;

import java.util.List;

import com.ty.hospital_app.dao.AddressDao;
import com.ty.hospital_app.dto.Address;
import com.ty.hospital_app.dto.Branch;
import com.ty.hospital_app.dto.Hospital;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;

public class AddressDaoImpl implements AddressDao {

	public Address saveAddress(int bid, Address Address) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("hi");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		//Branch branch = em.find(Branch.class, bid);
		et.begin();
		em.persist(Address);
		et.commit();
		return Address;
	}

	public Address getAddressbyId(int aid) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("hi");
		EntityManager em = emf.createEntityManager();
		Address address = em.find(Address.class, aid);
		return address;
	}

	public boolean deleteAddressId(int aid) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("hi");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		Address address = em.find(Address.class, aid);
		if (address != null) {
			et.begin();
			em.remove(address);
			et.commit();
			return true;
		} else {
			return false;
		}
	}

	public Address updateAddress(int aid, Address Address) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("hi");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		Address address = em.find(Address.class, aid);
		if (address != null) {
			address.setBranch(address.getBranch());
			address.setCountry(address.getCountry());
			et.begin();
			em.merge(address);
			et.commit();
			return Address;
		} else {
			return null;
		}
	}

	public List<Address> getAdressAll() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("hi");
		EntityManager em = emf.createEntityManager();
		Query query = (Query) em.createQuery("Select s from Branch s");
		List<Address> address = query.getResultList();
		return address;
	}

}
