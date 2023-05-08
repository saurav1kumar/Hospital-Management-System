package com.ty.hospital_app.service;

import com.ty.hospital_app.dao.imp.BranchDaoImp;
import com.ty.hospital_app.dto.Branch;

public class BranchService {
	public void saveBranch(Branch branch, int hospital_id) {
		BranchDaoImp branchDaoImp = new BranchDaoImp();
		Branch branch2 = branchDaoImp.saveBranch(hospital_id, branch);
		if (branch2 != null) {
			System.out.println("branch Saved ");
		} else {
			System.out.println("Unfortunately Branch Not saved");
		}
	}
	
	
}
