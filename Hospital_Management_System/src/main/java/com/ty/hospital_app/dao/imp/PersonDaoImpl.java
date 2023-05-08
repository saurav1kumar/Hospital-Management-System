package com.ty.hospital_app.dao.imp;

import java.util.List;

import com.ty.hospital_app.dao.PersonDao;
import com.ty.hospital_app.dto.Person;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;

public class PersonDaoImpl implements PersonDao {

	public Person savePerson(int eid, Person person) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("hi");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();

		et.begin();
		em.persist(person);
		et.commit();
		return person;

	}

	public Person getPersonbyId(int pid) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("hi");
		EntityManager em = emf.createEntityManager();
		Person person = em.find(Person.class, pid);
		return person;
	}

	public boolean deletepersonId(int pid) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("hi");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		Person person = em.find(Person.class, pid);
		if (person != null) {
			et.begin();
			em.remove(person);
			et.commit();
			return true;
		} else {
			return false;
		}
	}

	public Person updatePerson(int pid, Person person) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("hi");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		Person person1 = em.find(Person.class, pid);
		if (person1 != null) {
			person1.setAddress(person1.getAddress());
			person1.setName(person1.getName());
			person1.setAge(person1.getAge());
			person1.setGender(person1.getGender());
			person1.setPhno(person1.getPhno());
			et.begin();
			em.merge(person1);
			et.commit();
			return person;
		} else {
			return null;
		}
	}

	public List<Person> getAllPerson() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("hi");
		EntityManager em = emf.createEntityManager();
		Query query = (Query) em.createQuery("Select s from Branch s");
		List<Person> person = query.getResultList();
		return person;
	}

	public List<Person> getPersonByGender(String gender) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("hi");
		EntityManager em = emf.createEntityManager();
		Person person = em.find(Person.class, gender);
		return getPersonByGender(gender);

	}

	public List<Person> getPersonByAge(int age) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("hi");
		EntityManager em = emf.createEntityManager();
		Person person = em.find(Person.class, age);
		return getPersonByAge(age);

	}

	public List<Person> getPersonByPhone(long phone) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("hi");
		EntityManager em = emf.createEntityManager();
		Person person = em.find(Person.class, phone);
		return getPersonByPhone(phone);
	}

}
