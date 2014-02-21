package com.daCheng.lectotype.data;

import java.util.List;
import java.util.Map;

import com.daCheng.lectotype.domain.Fluid;

public interface FluidMapper {
	public void insert(Fluid fluid);
	public Fluid find(String id);
	public List<Fluid> findFluids(Map<String,Object> conditions);
	public int count(String id);
	public int countByName(String name);
	public void update(Fluid fluid);
	public void delete(String id);
}
