package com.ty.hospital_app.dao;

import java.util.List;

import com.ty.hospital_app.dto.Person;
import com.ty.hospital_app.dto.User;

public interface UserDao {
	public User saveUser(User User);

	public User getUserbyId(int uid);

	public boolean deleteUserId(int uid);

	public User updateUser(int uid, User User);

	public List<User> getAllUser();

	public List<Person> getPersonByRole(String role);
}
