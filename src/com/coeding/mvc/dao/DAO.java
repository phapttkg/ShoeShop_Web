package com.coeding.mvc.dao;

import java.util.List;

import javax.sql.DataSource;


public interface DAO<T> {
	List<T> selectAll();
	T selectOne(T arg);
	void insert(T arg);
	void delete(T arg);
	void update(T arg);
	void setDataSource(DataSource ds);
}
