package com.daCheng.lectotype.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import net.sf.json.JSONObject;
import com.daCheng.lectotype.domain.Fluid;
import com.daCheng.lectotype.domain.User;
import com.daCheng.lectotype.service.FluidService;
import com.daCheng.lectotype.service.UserService;
import com.opensymphony.xwork2.ActionSupport;

public class UserQueryAction  extends ActionSupport{
	private static final long serialVersionUID = 1L;
	private static Logger logger = Logger.getLogger(UserQueryAction.class);
	
	private JSONObject results;
    
	public String queryAll(){
		UserService service = new UserService();
		List<User> users = service.getUsers();
		
		Map<String,Object> jsonMap = new HashMap<String,Object>();		
		
		jsonMap.put("rows", users);	//rows为datagrid的属性,表示要显示的记录		
		jsonMap.put("total", users.size());	//total为datagrid的属性,表示共有多少记录	
		this.setResults(JSONObject.fromObject(jsonMap));

		return SUCCESS;
	}
	
	public JSONObject getResults() {
		return results;
	}

	public void setResults(JSONObject results) {
		this.results = results;
	}


}
