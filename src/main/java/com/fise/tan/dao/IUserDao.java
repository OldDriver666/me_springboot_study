package com.fise.tan.dao;

import java.util.List;

import com.fise.tan.entity.User;

public interface IUserDao {
	List<User> getList();
	User findByName(String name);
}
