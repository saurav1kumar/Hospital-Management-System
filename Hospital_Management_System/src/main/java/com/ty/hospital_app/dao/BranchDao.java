package com.ty.hospital_app.dao;

import java.util.List;

import com.ty.hospital_app.dto.Branch;

public interface BranchDao {
	public Branch saveBranch(int hohospital_id, Branch Branch);

	public Branch getBranchbyId(int bid);

	public boolean deleteBranchId(int bid);

	public Branch updateBranch(int bid, Branch Branch);
	
	public List<Branch> getAllBranch();
}
