package com.daCheng.lectotype.service;

import java.io.IOException;
import java.io.Reader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.daCheng.lectotype.data.FluidMapper;
import com.daCheng.lectotype.data.UserMapper;
import com.daCheng.lectotype.domain.Fluid;
import com.daCheng.lectotype.domain.User;
import com.daCheng.lectotype.exception.UserServiceException;



public class UserService {
	private final static String RESOURCES = "com/daCheng/lectotype/data/Configuration.xml";	

	private SqlSession openSession() throws UserServiceException{
		Reader reader;
		try {
			reader = Resources.getResourceAsReader(RESOURCES);
		} catch (IOException e) {
			throw new UserServiceException("open session failed!",e);
		}
		SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();	
		return builder.build(reader).openSession();
	}
	
	public void add(User user){
		if(user == null)
			throw new IllegalArgumentException("user is null!");	
		SqlSession session = openSession();
		try{
			UserMapper mapper = session.getMapper(UserMapper.class);
			mapper.insert(user);
			session.commit();
		}
		finally{
			if(session != null) session.close();
		}
	}
	
	public void update(User user){
		if(user == null)
			throw new IllegalArgumentException("user is null!");	
		SqlSession session = openSession();
		try{
			UserMapper mapper = session.getMapper(UserMapper.class);
			mapper.update(user);
			session.commit();
		}
		finally{
			if(session != null) session.close();
		}
	}
	
	public void delete(String id){
		if(id == null || id.trim().equals(""))
			throw new IllegalArgumentException("id is null!");	
		SqlSession session = openSession();
		try{
			UserMapper mapper = session.getMapper(UserMapper.class);
			mapper.delete(id);
			session.commit();
		}
		finally{
			if(session != null) session.close();
		}
	}
	
	public User getUser(String id) throws UserServiceException{
		if(id == null || id.trim().equals(""))
			throw new IllegalArgumentException("id is null!");	
		SqlSession session = openSession();
		try{
			UserMapper mapper = session.getMapper(UserMapper.class);
			return mapper.find(id);			
		}
		finally{
			if(session != null) session.close();
		}		
	}
	
	public List<User> getUsers(){
		SqlSession session = openSession();
		try{
			UserMapper mapper = session.getMapper(UserMapper.class);
			
			Map<String,Object> conditions = new HashMap<String, Object>();
//			conditions.put("name", name);
			
			return mapper.findUsers(conditions);
		}
		finally{
			if(session != null) session.close();
		}
	}
	
	public boolean hasSuchUser(String id,String pw){
		if(id == null || id.trim().equals(""))
			throw new IllegalArgumentException("id is null!");
		if(pw == null || pw.trim().equals(""))
			throw new IllegalArgumentException("password is null!");
		
		SqlSession session = openSession();
		
		try{
			UserMapper mapper = session.getMapper(UserMapper.class);
			Map<String, String> account = new HashMap();
			account.put("id", id);
			account.put("password", pw);
			return (mapper.count(account) == 1);
		}
		finally{
			if(session != null) session.close();
		}		
	}

	public static void main(String[] args){
//		UserService service = new UserService();
//		User user = new User ("DX0004","Ô±¹¤4","yuangong4",User.ROLE_SALESMAN);
//		
//		
//		service.delete("DX0004");
//		
//		for(User user2:service.getUsers())
//			System.out.println(user2.getId() + "," + 
//								user2.getName() + "," + 
//								user2.getPassword() + "," +
//								user2.getRole());
		
		System.out.print("a".trim().matches("^\\w{6,20}$"));
	}
}
