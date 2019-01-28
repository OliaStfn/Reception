package com.stfn.dao;

import java.util.Collection;

public interface GenericDao<T> {
    T create(T obj)throws Exception;
    T read(int id)throws Exception;
    Collection<T>readAll()throws Exception;
    void update(T obj)throws Exception;
    void delete(int id)throws Exception;
}
