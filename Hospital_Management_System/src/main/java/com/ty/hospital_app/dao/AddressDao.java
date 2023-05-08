package com.ty.hospital_app.dao;

import java.util.List;

import com.ty.hospital_app.dto.Address;

public interface AddressDao {
	public Address saveAddress(int bid,Address Address);

	public Address getAddressbyId(int aid);

	public boolean deleteAddressId(int aid);

	public Address updateAddress(int aid, Address Address);

	public List<Address> getAdressAll();
}
