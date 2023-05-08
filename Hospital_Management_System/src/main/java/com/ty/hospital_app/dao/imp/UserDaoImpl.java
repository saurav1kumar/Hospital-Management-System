package com.ty.hospital_app.dao.imp;

import java.util.List;

import com.ty.hospital_app.dao.UserDao;
import com.ty.hospital_app.dto.Person;
import com.ty.hospital_app.dto.User;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;

public class UserDaoImpl implements UserDao {

	public User saveUser(User User) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("hi");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();

		et.begin();
		em.persist(User);
		et.commit();
		return User;

	}

	public User getUserbyId(int uid) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("hi");
		EntityManager em = emf.createEntityManager();
		User user = em.find(User.class, uid);
		return user;
	}

	public boolean deleteUserId(int uid) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("hi");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		User user = em.find(User.class, uid);
		if (user != null) {
			et.begin();
			em.remove(user);
			et.commit();
			return true;
		} else {
			return false;
		}
	}

	public User updateUser(int uid, User User) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("hi");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		User user = em.find(User.class, uid);
		if (user != null) {
			user.setName(user.getEmail());
			user.setEmail(user.getEmail());
			user.setPassword(user.getPassword());
			user.setPhno(user.getPhno());
			user.setRole(user.getRole());
			et.begin();
			em.merge(user);
			et.commit();
			return user;
		} else {
			return null;
		}
	}

	public List<User> getAllUser() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("hi");
		EntityManager em = emf.createEntityManager();
		Query query = (Query) em.createQuery("Select s from Branch s");
		List<User> User = query.getResultList();
		return User;
	}

	public List<Person> getPersonByRole(String role) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("hi");
		EntityManager em = emf.createEntityManager();
		User user = em.find(User.class, role);
		return getPersonByRole(role);
	}

}
