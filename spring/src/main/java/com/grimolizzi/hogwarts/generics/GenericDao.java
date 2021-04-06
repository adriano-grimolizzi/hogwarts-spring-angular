package com.grimolizzi.hogwarts.generics;

import java.util.List;

public interface GenericDao<T> {

  List<T> getAll();

  T get(String id);

  void create(T t);
}
