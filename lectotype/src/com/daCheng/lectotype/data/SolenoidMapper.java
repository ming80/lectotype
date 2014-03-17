package com.daCheng.lectotype.data;

import java.util.List;
import java.util.Map;
import com.daCheng.lectotype.domain.Solenoid;

public interface SolenoidMapper {
	public void insert(Solenoid solenoid);
	public Solenoid find(String id);
	public Solenoid findByModel(String model);
	public List<Solenoid> findSolenoids(Map<String,Object> conditions);
	public int count(String id);
	public int countByModel(String model);
	public void update(Solenoid solenoid);
	public void delete(String id);
}
