package com.daCheng.lectotype.data;

import java.util.List;
import java.util.Map;

import com.daCheng.lectotype.domain.Conveyer;
import com.daCheng.lectotype.domain.LimitSwitch;
import com.daCheng.lectotype.domain.Positioner;

public interface ConveyerMapper {
	public void insert(Conveyer conveyer);
	public Conveyer find(String id);
	public Conveyer findByModel(String model);
	public List<Conveyer> findConveyers(Map<String,Object> conditions);
	public int count(String id);
	public int countByModel(String model);
	public void update(Conveyer conveyer);
	public void delete(String id);
}
