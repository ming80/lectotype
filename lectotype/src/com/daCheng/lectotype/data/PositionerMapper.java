package com.daCheng.lectotype.data;

import java.util.List;
import java.util.Map;
import com.daCheng.lectotype.domain.Positioner;

public interface PositionerMapper {
	public void insert(Positioner positioner);
	public Positioner find(String id);
	public Positioner findByModel(String model);
	public List<Positioner> findPositioners(Map<String,Object> conditions);
	public int count(String id);
	public int countByModel(String model);
	public void update(Positioner positioner);
	public void delete(String id);
}
