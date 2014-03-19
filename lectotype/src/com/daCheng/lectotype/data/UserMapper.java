package com.daCheng.lectotype.data;

import java.util.List;
import java.util.Map;

import com.daCheng.lectotype.domain.Fluid;
import com.daCheng.lectotype.domain.User;

public interface UserMapper {
	public void insert(User user);
	public void update(User user);
	public void delete(String id);
	public User find(String id);
	public List<User> findUsers(Map<String,Object> conditions);
	public int count(Map<String,String> account);
}
