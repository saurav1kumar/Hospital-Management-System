package com.ty.hospital_app.dto;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Encounter {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO.IDENTITY)
	private int aid;
	private String reason;
	private String dateofjoin;
	private String dateofdischarge;
	@OneToMany(mappedBy = "encounter")
	private List<Observation> observations;
	@JoinColumn
	@ManyToOne
	private Person person;
	@JoinColumn
	@ManyToOne
	private Branch branch;
	@OneToMany(mappedBy = "encounter")
	private List<Medorder> order;

	public int getAid() {
		return aid;
	}

	public void setAid(int aid) {
		this.aid = aid;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public String getDateofjoin() {
		return dateofjoin;
	}

	public void setDateofjoin(String dateofjoin) {
		this.dateofjoin = dateofjoin;
	}

	public String getDateofdischarge() {
		return dateofdischarge;
	}

	public void setDateofdischarge(String dateofdischarge) {
		this.dateofdischarge = dateofdischarge;
	}

	public List<Observation> getObs() {
		return observations;
	}

	public void setObs(List<Observation> obs) {
		this.observations = obs;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public Branch getBranch() {
		return branch;
	}

	public void setBranch(Branch branch) {
		this.branch = branch;
	}

	public List<Medorder> getOrder() {
		return order;
	}

	public void setOrder(List<Medorder> order) {
		this.order = order;
	}

	

}
