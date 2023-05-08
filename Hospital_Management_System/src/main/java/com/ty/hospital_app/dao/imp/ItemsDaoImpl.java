package com.ty.hospital_app.dao.imp;

import java.util.List;

import com.ty.hospital_app.dao.ItemsDao;
import com.ty.hospital_app.dto.Branch;
import com.ty.hospital_app.dto.Hospital;
import com.ty.hospital_app.dto.Items;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;

public class ItemsDaoImpl implements ItemsDao {

	public Items saveItems(int mid, Items Items) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("hi");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();

		et.begin();
		em.persist(Items);
		et.commit();
		return Items;
	}

	public Items getItemsbyId(int id) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("hi");
		EntityManager em = emf.createEntityManager();
		Items items = em.find(Items.class, id);
		return items;

	}

	public boolean deleteItemsId(int id) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("hi");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		Items items = em.find(Items.class, id);
		if (items != null) {
			et.begin();
			em.remove(items);
			et.commit();
			return true;
		} else {
			return false;
		}
	}

	public Items updateItems(int id, Items Items) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("hi");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		Items items = em.find(Items.class, id);
		if (items != null) {
			items.setMedorder(Items.getMedorder());
			items.setQuantity(id);
			items.setName(Items.getName());
			et.begin();
			em.merge(Items);
			et.commit();
			return Items;
		} else {
			return null;
		}

	}

	public List<Items> getAllItem() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("hi");
		EntityManager em = emf.createEntityManager();
		Query query = (Query) em.createQuery("Select s from Branch s");
		List<Items> items2 = query.getResultList();
		return items2;
	}

}
