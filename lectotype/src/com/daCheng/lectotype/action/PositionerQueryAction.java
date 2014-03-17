package com.daCheng.lectotype.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import net.sf.json.JSONObject;

import com.daCheng.lectotype.domain.Actuator;
import com.daCheng.lectotype.domain.Positioner;
import com.daCheng.lectotype.service.ActuatorService;
import com.daCheng.lectotype.service.PositionerService;
import com.opensymphony.xwork2.ActionSupport;

public class PositionerQueryAction  extends ActionSupport{
	private static final long serialVersionUID = 1L;
	private static Logger logger = Logger.getLogger(PositionerQueryAction.class);
	
	private JSONObject results;
    
	public String queryAll(){
		PositionerService service = new PositionerService();
		List<Positioner> positioners = service.getPositioners();
		
		Map<String,Object> jsonMap = new HashMap<String,Object>();		
		
		jsonMap.put("rows", positioners);	//rows为datagrid的属性,表示要显示的记录		
		jsonMap.put("total", positioners.size());	//total为datagrid的属性,表示共有多少记录	
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
