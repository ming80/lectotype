package com.daCheng.lectotype.data;

import java.util.List;
import java.util.Map;

import com.daCheng.lectotype.domain.ValveSpecification;

public interface ValveSpecificationMapper {
	public void insert(ValveSpecification valveSpecification);
	public ValveSpecification find(String id);
	public List<ValveSpecification> findValveSpecifications(Map<String,Object> conditions);
	public int count(String id);
	public void update(ValveSpecification valveSpecification);
	public void delete(String id);
}
