package com.daCheng.lectotype.data;

import com.daCheng.lectotype.domain.ValveSpecification;

public interface ValveSpecificationMapper {
	public void insert(ValveSpecification valveSpecification);
	public ValveSpecification find(String id);
	public int count(String id);
	public void update(ValveSpecification valveSpecification);
	public void delete(String id);
}
