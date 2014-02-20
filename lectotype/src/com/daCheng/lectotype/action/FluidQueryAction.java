package com.daCheng.lectotype.action;


import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import net.sf.json.JSONObject;

import com.daCheng.lectotype.domain.Fluid;
import com.daCheng.lectotype.domain.ValveSpecification;
import com.daCheng.lectotype.service.FluidService;
import com.daCheng.lectotype.service.ValveSpecificationService;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class FluidQueryAction  extends ActionSupport{
	private static final long serialVersionUID = 1L;
	private static Logger logger = Logger.getLogger(FluidQueryAction.class);
	
	private JSONObject results;
    
	public String queryAll(){
		FluidService service = new FluidService();
		List<Fluid> fluids = service.getFluids();
		
		Map<String,Object> jsonMap = new HashMap<String,Object>();		
		
		jsonMap.put("rows", fluids);	//rowsΪdatagrid������,��ʾҪ��ʾ�ļ�¼		
		jsonMap.put("total", fluids.size());	//totalΪdatagrid������,��ʾ���ж��ټ�¼	
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
