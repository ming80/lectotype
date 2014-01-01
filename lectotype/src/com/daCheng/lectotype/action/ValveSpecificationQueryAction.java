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

import com.daCheng.lectotype.domain.ValveSpecification;
import com.daCheng.lectotype.service.ValveSpecificationService;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class ValveSpecificationQueryAction  extends ActionSupport{
	private static final long serialVersionUID = 1L;
	private static Logger logger = Logger.getLogger(ValveSpecificationQueryAction.class);
	
	private JSONObject results;
	private long rows;//每页显示的记录数,datagrid会提供此项属性    
    private long page;//当前第几页,datagrid会提供此项属性        
    
    private String sort;
    private String order;
    
    private String projectName;
    private String selectedModelName;
    private String model;
    
    private long queryTimestamp;	//时间戳
    
	public String queryValveSpecification() throws Exception{		
		Map<String, Object> session = ActionContext.getContext().getSession();
		
		List<ValveSpecification> results = doResults(session);
		
		//排序
		sortResults(results,this.sort);
		
		//server端分页
		List<ValveSpecification> currentPageRows = new ArrayList<ValveSpecification>();
		Iterator<ValveSpecification> iter = results.iterator();
		for(int index = 0;index < (this.page - 1) * this.rows;index++)
			iter.next();
		for(int i = 0;i < this.rows;i++)
			if(iter.hasNext())
				currentPageRows.add((ValveSpecification)iter.next());
			else
				break;
		
		Map<String,Object> jsonMap = new HashMap<String,Object>();
			
		jsonMap.put("rows", currentPageRows);	//rows为datagrid的属性,表示要显示的记录		
		jsonMap.put("total", results.size());	//total为datagrid的属性,表示共有多少记录	
		this.setResults(JSONObject.fromObject(jsonMap));
//		System.out.print(jsonMap);
		
		session.put("results", results);
		return SUCCESS;
	}
	
	private List<ValveSpecification> doResults(Map<String, Object> session) throws ParseException{		
				
		Long valveSpecificationQueryTimestamp = (Long)session.get("valveSpecificationQueryTimestamp");
		//如果请求中的时间戳与session中保存的时间戳不一致说明是一次新的查询请求,执行一次查询
		if(valveSpecificationQueryTimestamp == null || valveSpecificationQueryTimestamp != this.queryTimestamp){			
			session.put("valveSpecificationQueryTimestamp", this.queryTimestamp);
			
			//查询条件设置			
			String para1 = null;
			String para2 = null;
			String para3 = null;			
			if(!isEmpty(this.getProjectName()))
				para1 = "%" + this.getProjectName().trim() + "%";
			if(!isEmpty(this.getSelectedModelName()))
				para2 = "%" + this.getSelectedModelName().trim() + "%";
			if(!isEmpty(this.getModel()))
				para3 = "%" + this.getModel().trim() + "%";
			
			ValveSpecificationService service = new ValveSpecificationService();
			List<ValveSpecification> results = service.getValveSpecifications(para1, para2, para3);
			
			return results;
		}
		
		if(session.get("results") != null)
			return (List<ValveSpecification>)session.get("results");
		
		return new ArrayList<ValveSpecification>();
	}

	//排序
	private void sortResults(List<ValveSpecification> list,final String sort){
		if(this.sort == null || this.sort.trim().equals(""))
			return;
		if(this.order == null || this.order.trim().equals(""))
			return;
		
		//排序规则
		Comparator<ValveSpecification> comparator =	new 
			Comparator<ValveSpecification>(){
				@Override
				public int compare(ValveSpecification valveSpecification1, ValveSpecification valveSpecification2) {
					if("projectName".equals(sort))
						return doCompare(valveSpecification1.getProjectName(),valveSpecification2.getProjectName());
					
					if("tagNo".equals(sort))
						return doCompare(valveSpecification1.getTagNo(),valveSpecification2.getTagNo());
					if("quantity".equals(sort))
						return doCompare(valveSpecification1.getQuantity(),valveSpecification2.getQuantity());	
					if("selectedModel.name".equals(sort))
						return doCompare(valveSpecification1.getSelectedModel().getName(),valveSpecification2.getSelectedModel().getName()); 
					if("selectedModel.model".equals(sort))
						return doCompare(valveSpecification1.getSelectedModel().getModel(),valveSpecification2.getSelectedModel().getModel()); 
					if("selectedModel.bodyMaterial".equals(sort))
						return doCompare(valveSpecification1.getSelectedModel().getBodyMaterial(),valveSpecification2.getSelectedModel().getBodyMaterial()); 
					if("selectedModel.seatMaterial".equals(sort))
						return doCompare(valveSpecification1.getSelectedModel().getSeatMaterial(),valveSpecification2.getSelectedModel().getSeatMaterial()); 
					if("selectedModel.plugMaterial".equals(sort))
						return doCompare(valveSpecification1.getSelectedModel().getPlugMaterial(),valveSpecification2.getSelectedModel().getPlugMaterial()); 
							
					
					return valveSpecification1.getProjectName().compareTo(valveSpecification2.getProjectName());
				}
				
				private int doCompare(Comparable comp1,Comparable comp2){
					if(comp1 == null) return -1;
					if(comp2 == null) return 1;
					return comp1.compareTo(comp2);
				}
			};
		
		//根据给出的排序规则升序排列
		if("asc".equals(this.getOrder()))
			Collections.sort(list,comparator);
		//根据给出的排序规则降序排列
		if("desc".equals(this.getOrder()))
			Collections.sort(list,Collections.reverseOrder(comparator));
	}
	
	public JSONObject getResults() {
		return results;
	}

	public void setResults(JSONObject results) {
		this.results = results;
	}

	public long getRows() {
		return rows;
	}

	public void setRows(long rows) {
		this.rows = rows;
	}

	public long getPage() {
		return page;
	}

	public void setPage(long page) {
		this.page = page;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getSelectedModelName() {
		return selectedModelName;
	}

	public void setSelectedModelName(String selectedModelName) {
		this.selectedModelName = selectedModelName;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	private boolean isEmpty(String str){
		if(str == null) return true;
		if(str.trim().equals("")) return true;
		return false;
	}

	public long getQueryTimestamp() {
		return queryTimestamp;
	}

	public void setQueryTimestamp(long queryTimestamp) {
		this.queryTimestamp = queryTimestamp;
	}

	public String getSort() {
		return sort;
	}

	public void setSort(String sort) {
		this.sort = sort;
	}

	public String getOrder() {
		return order;
	}

	public void setOrder(String order) {
		this.order = order;
	}
}
