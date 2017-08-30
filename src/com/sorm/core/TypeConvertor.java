package com.sorm.core;
/**
 * ����java�������ͺ����ݿ��������͵Ļ���ת��
 * @author Kang
 *
 */
public interface TypeConvertor {
	/**
	 * �����ݿ���������ת����java����������
	 * @param columnType
	 * @return
	 */
	public String databaseType2JavaType(String columnType);
	
	/**
	 * ��java��������ת�������ݿ���������
	 * @param javaDataType java��������
	 * @return ���ݿ�����
	 */
	public String javaType2DatabaseType(String javaDataType);
	
}
