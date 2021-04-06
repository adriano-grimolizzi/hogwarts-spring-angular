package com.grimolizzi.hogwarts.generics;

import com.google.gson.Gson;
import java.util.Collections;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
public class GenericController<T> {

	@Autowired
	private GenericService<T> service;

	protected Class<T> type;

	@GetMapping()
	public List<T> get(@RequestParam(required = false) String id) {

		if (id != null) {
			return Collections.singletonList(this.service.get(id));
		} else {
			return this.service.getAll();
		}
	}

	@PostMapping()
	public void create(@RequestBody String json) {

		T t = new Gson().fromJson(json, this.type);
		this.service.create(t);
	}
}
