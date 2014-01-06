package com.daCheng.lectotype.action;
import java.io.BufferedInputStream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.daCheng.lectotype.domain.ValveSpecification;
import com.daCheng.lectotype.domain.excel.ExcelBuilder;

public class ValveSpecificationSavingAction extends ActionSupport{
	private static final long serialVersionUID = 1L;
	private static Logger logger = Logger.getLogger(ValveSpecificationSavingAction.class);
	
	private InputStream queryResultsExcelIn;	
	private int resultsBuildingProgress;

	
	public String saveQueryResults(){
		Map<String,Object> session = ActionContext.getContext().getSession();		
		List<ValveSpecification> results = (List<ValveSpecification>)session.get("results");
		
		if(results.size() > 200)
			return "tooBigResults";
		
		try {
			ExcelBuilder builder = new ExcelBuilder(results);
			
			this.queryResultsExcelIn = 
					new BufferedInputStream(
							new FileInputStream(builder.execute()));
			
			logger.info("save query results!");
						
			return SUCCESS;
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 

		return NONE;
	}	

	


	public InputStream getQueryResultsExcelIn() {
		return queryResultsExcelIn;
	}
	
	public int getResultsBuildingProgress(){
		return resultsBuildingProgress;
	}
	

}
