package com.grimolizzi.hogwarts.generics;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GenericService<T> {

	@Autowired
	private GenericDao<T> dao;

	public List<T> getAll() {
		return this.dao.getAll();
	}

	public T get(String id) {
		return this.dao.get(id);
	}

	public void create(T t) {
		this.dao.create(t);
	}
}
