package br.com.jsf.interfaces;

import java.util.List;

public interface DAO<T> {
    boolean save(T u);
    boolean saveOrUpdate(T u);
    T get(int id);
    List<T> list();
    boolean remove(int id);
}
