package com.daCheng.lectotype.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import net.sf.json.JSONObject;

import com.daCheng.lectotype.domain.Conveyer;
import com.daCheng.lectotype.domain.FilterReducingValve;
import com.daCheng.lectotype.service.ConveyerService;
import com.daCheng.lectotype.service.FilterReducingValveService;
import com.opensymphony.xwork2.ActionSupport;

public class FilterReducingValveQueryAction  extends ActionSupport{
	private static final long serialVersionUID = 1L;
	private static Logger logger = Logger.getLogger(FilterReducingValveQueryAction.class);
	
	private JSONObject results;
    
	public String queryAll(){
		FilterReducingValveService service = new FilterReducingValveService();
		List<FilterReducingValve> filterReducingValves = service.getFilterReducingValves();
		
		Map<String,Object> jsonMap = new HashMap<String,Object>();		
		
		jsonMap.put("rows", filterReducingValves);	//rowsΪdatagrid������,��ʾҪ��ʾ�ļ�¼		
		jsonMap.put("total", filterReducingValves.size());	//totalΪdatagrid������,��ʾ���ж��ټ�¼	
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
