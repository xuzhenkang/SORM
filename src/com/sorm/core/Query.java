package com.sorm.core;

import java.util.List;

/**
 * Give the core class, it is the important interface use for query from the
 * database.
 * �ýӿڸ�����sorm��ܵĺ��Ľӿڣ��ṩ��ɾ�Ĳ鹦�ܡ�
 * @author Kang
 */
public interface Query {
	/**
	 * Execute a DML sentence straightly.
	 * ֱ��ִ��һ��DML��䡣
	 * 
	 * @param sql
	 * @param params
	 * @return
	 */
	public int executeDML(String sql, Object[] params);
	
	/**
	 * Insert an object into the database.
	 * ��һ������洢�����ݿ��С�
	 * @param obj
	 */
	public void insert(Object obj);
	
	/**
	 * ɾ��clazz��ʾ���Ӧ�ı��еļ�¼��ָ������ֵ�ļ�¼��
	 * @param clazz ����Ӧ�����class����
	 * @param id ������ֵ
	 * @return
	 */
	public int delete(Class clazz, int id);

	/**
	 * ɾ�����������ݿ��ж�Ӧ�ļ�¼���������ڵ����Ӧ���������������ֵ��Ӧ����¼��
	 * @param obj
	 */
	public void delete(Object obj);
	
	/**
	 * ���¶����Ӧ�ļ�¼������ֻ����ָ�����ֶε�ֵ
	 * @param obj ����Ҫ���µĶ���
	 * @param fieldNames ���µ������б�
	 * @return
	 */
	public int update(Object obj, String[] fieldNames);
	
	/**
	 * ��ѯ���ض��м�¼������ÿ�м�¼��װ��clazzָ�����������
	 * @param sql ��ѯ���
	 * @param clazz ��װ���ݵ�javabean��Ӧ��class
	 * @param params
	 * @return
	 */
	public List queryRows(String sql, Class clazz, Object[] params);
	
	/**
	 * ��ѯ����һ�м�¼�������ü�¼��װ��clazzָ������Ķ�����
	 * @param sql ��ѯ���
	 * @param clazz ��װ���ݵ�javabean���Class����
	 * @param params sql�Ĳ���
	 * @return ��ѯ���Ľ��
	 */
	public Object queryUniqueRow(String sql,Class clazz,Object[] params);
	
	/**
	 * ��ѯ����һ��ֵ(һ��һ��)��������ֵ����
	 * @param sql ��ѯ���
	 * @param params sql�Ĳ���
	 * @return ��ѯ���Ľ��
	 */
	public Object queryValue(String sql,Object[] params);
	
	/**
	 * ��ѯ����һ������(һ��һ��)��������ֵ����
	 * @param sql ��ѯ���
	 * @param params sql�Ĳ���
	 * @return ��ѯ��������
	 */
	public Number queryNumber(String sql,Object[] params);
	
}
