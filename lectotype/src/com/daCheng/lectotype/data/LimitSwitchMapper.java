package com.daCheng.lectotype.data;

import java.util.List;
import java.util.Map;

import com.daCheng.lectotype.domain.LimitSwitch;
import com.daCheng.lectotype.domain.Positioner;

public interface LimitSwitchMapper {
	public void insert(LimitSwitch limitSwitch);
	public LimitSwitch find(String id);
	public LimitSwitch findByModel(String model);
	public List<LimitSwitch> findLimitSwitchs(Map<String,Object> conditions);
	public int count(String id);
	public int countByModel(String model);
	public void update(LimitSwitch limitSwitch);
	public void delete(String id);
}
