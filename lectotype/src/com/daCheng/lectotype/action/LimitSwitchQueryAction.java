package com.daCheng.lectotype.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import net.sf.json.JSONObject;

import com.daCheng.lectotype.domain.LimitSwitch;
import com.daCheng.lectotype.service.LimitSwitchService;
import com.opensymphony.xwork2.ActionSupport;

public class LimitSwitchQueryAction  extends ActionSupport{
	private static final long serialVersionUID = 1L;
	private static Logger logger = Logger.getLogger(LimitSwitchQueryAction.class);
	
	private JSONObject results;
    
	public String queryAll(){
		LimitSwitchService service = new LimitSwitchService();
		List<LimitSwitch> limitSwitchs = service.getLimitSwitchs();
		
		Map<String,Object> jsonMap = new HashMap<String,Object>();		
		
		jsonMap.put("rows", limitSwitchs);	//rows为datagrid的属性,表示要显示的记录		
		jsonMap.put("total", limitSwitchs.size());	//total为datagrid的属性,表示共有多少记录	
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
