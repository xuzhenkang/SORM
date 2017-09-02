package com.sorm.core;

import java.util.List;

public class MySqlQuery implements Query {

	@Override
	public int executeDML(String sql, Object[] params) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void insert(Object obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int delete(Class clazz, int id) {
		
		return 0;
	}

	@Override
	public void delete(Object obj) {
		
	}

	@Override
	public int update(Object obj, String[] fieldNames) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List queryRows(String sql, Class clazz, Object[] params) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object queryUniqueRow(String sql, Class clazz, Object[] params) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object queryValue(String sql, Object[] params) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Number queryNumber(String sql, Object[] params) {
		// TODO Auto-generated method stub
		return null;
	}

}
