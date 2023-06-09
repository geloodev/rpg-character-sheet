package com.geloodev.daos;

import java.util.List;
import java.util.UUID;

public abstract class DAO<T> {

    public abstract List<T> selectAll();
    public abstract T selectById(UUID id);
    public abstract T selectByName(String name);
    public abstract void insert(T t);
    public abstract void update(T t);
    public abstract void delete(T t);
}
