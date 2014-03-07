package com.daCheng.lectotype.data;

import java.util.List;
import java.util.Map;
import com.daCheng.lectotype.domain.Actuator;

public interface ActuatorMapper {
	public void insert(Actuator actuator);
	public Actuator find(String id);
	public Actuator findByModel(String model);
	public List<Actuator> findActuators(Map<String,Object> conditions);
	public int count(String id);
	public int countByModel(String model);
	public void update(Actuator actuator);
	public void delete(String id);
}
