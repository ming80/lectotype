package com.daCheng.lectotype.data;

import java.util.List;
import java.util.Map;

import com.daCheng.lectotype.domain.Conveyer;
import com.daCheng.lectotype.domain.FilterReducingValve;
import com.daCheng.lectotype.domain.LimitSwitch;
import com.daCheng.lectotype.domain.Positioner;

public interface FilterReducingValveMapper {
	public void insert(FilterReducingValve filterReducingValve);
	public FilterReducingValve find(String id);
	public FilterReducingValve findByModel(String model);
	public List<FilterReducingValve> findFilterReducingValves(Map<String,Object> conditions);
	public int count(String id);
	public int countByModel(String model);
	public void update(FilterReducingValve filterReducingValve);
	public void delete(String id);
}
