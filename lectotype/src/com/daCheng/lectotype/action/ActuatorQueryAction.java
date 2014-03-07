package com.daCheng.lectotype.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import net.sf.json.JSONObject;

import com.daCheng.lectotype.domain.Actuator;
import com.daCheng.lectotype.service.ActuatorService;
import com.opensymphony.xwork2.ActionSupport;

public class ActuatorQueryAction  extends ActionSupport{
	private static final long serialVersionUID = 1L;
	private static Logger logger = Logger.getLogger(ActuatorQueryAction.class);
	
	private JSONObject results;
    
	public String queryAll(){
		ActuatorService service = new ActuatorService();
		List<Actuator> actuators = service.getActuators();
		
		Map<String,Object> jsonMap = new HashMap<String,Object>();		
		
		jsonMap.put("rows", actuators);	//rowsΪdatagrid������,��ʾҪ��ʾ�ļ�¼		
		jsonMap.put("total", actuators.size());	//totalΪdatagrid������,��ʾ���ж��ټ�¼	
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
