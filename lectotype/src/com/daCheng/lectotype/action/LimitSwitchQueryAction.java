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
		
		jsonMap.put("rows", limitSwitchs);	//rowsΪdatagrid������,��ʾҪ��ʾ�ļ�¼		
		jsonMap.put("total", limitSwitchs.size());	//totalΪdatagrid������,��ʾ���ж��ټ�¼	
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
