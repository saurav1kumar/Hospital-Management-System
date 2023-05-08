package com.ty.hospital_app.dto;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
@Entity
public class Hospital {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO.IDENTITY)
	private int hospital_id;
	private String hospital_name;
	private String hospital_website;
	@OneToMany(mappedBy = "hospital")
	private List<Branch> branches;

	public int gethospital_id() {
		return hospital_id;
	}

	public void sethospital_id(int hospital_id) {
		this.hospital_id = hospital_id;
	}

	public String gethospital_name() {
		return hospital_name;
	}

	public void sethospital_name(String hospital_name) {
		this.hospital_name = hospital_name;
	}

	public String gethospital_website() {
		return hospital_website;
	}

	public void sethospital_website(String hospital_website) {
		this.hospital_website = hospital_website;
	}

	public List<Branch> getBranches() {
		return branches;
	}

	public void setBranches(List<Branch> branches) {
		this.branches = branches;
	}

}
