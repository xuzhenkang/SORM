package com.sorm.core;

import java.util.List;

/**
 * Give the core class, it is the important interface use for query from the
 * database.
 * 该接口给定是sorm框架的核心接口，提供增删改查功能。
 * @author Kang
 */
public interface Query {
	/**
	 * Execute a DML sentence straightly.
	 * 直接执行一个DML语句。
	 * 
	 * @param sql
	 * @param params
	 * @return
	 */
	public int executeDML(String sql, Object[] params);
	
	/**
	 * Insert an object into the database.
	 * 将一个对象存储到数据库中。
	 * @param obj
	 */
	public void insert(Object obj);
	
	/**
	 * 删除clazz表示类对应的表中的记录（指定主键值的记录）
	 * @param clazz 与表对应的类的class对象
	 * @param id 主键的值
	 * @return
	 */
	public int delete(Class clazz, int id);

	/**
	 * 删除对象在数据库中对应的记录（对象所在的类对应到表，对象的主键的值对应到记录）
	 * @param obj
	 */
	public void delete(Object obj);
	
	/**
	 * 更新对象对应的记录，并且只更新指定的字段的值
	 * @param obj 所需要更新的对象
	 * @param fieldNames 更新的属性列表
	 * @return
	 */
	public int update(Object obj, String[] fieldNames);
	
	/**
	 * 查询返回多行记录，并将每行记录封装到clazz指定的类对象中
	 * @param sql 查询语句
	 * @param clazz 封装数据的javabean对应的class
	 * @param params
	 * @return
	 */
	public List queryRows(String sql, Class clazz, Object[] params);
	
	/**
	 * 查询返回一行记录，并将该记录封装到clazz指定的类的对象中
	 * @param sql 查询语句
	 * @param clazz 封装数据的javabean类的Class对象
	 * @param params sql的参数
	 * @return 查询到的结果
	 */
	public Object queryUniqueRow(String sql,Class clazz,Object[] params);
	
	/**
	 * 查询返回一个值(一行一列)，并将该值返回
	 * @param sql 查询语句
	 * @param params sql的参数
	 * @return 查询到的结果
	 */
	public Object queryValue(String sql,Object[] params);
	
	/**
	 * 查询返回一个数字(一行一列)，并将该值返回
	 * @param sql 查询语句
	 * @param params sql的参数
	 * @return 查询到的数字
	 */
	public Number queryNumber(String sql,Object[] params);
	
}
