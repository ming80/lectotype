package com.daCheng.lectotype.data;

import java.util.List;
import java.util.Map;

import com.daCheng.lectotype.domain.SelectedModel;

public interface SelectedModelMapper {
	public void insert(SelectedModel fluid);
	public SelectedModel find(String id);
	public SelectedModel findByName(String name);
	public List<SelectedModel> findSelectedModels(Map<String,Object> conditions);
	public int count(String id);
	public int countByName(String name);
	public void update(SelectedModel fluid);
	public void delete(String id);
}
