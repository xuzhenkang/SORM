package com.sorm.bean;

import java.util.List;
import java.util.Map;

/**
 * �洢��ṹ��Ϣ
 * @author lenovo
 *
 */
public class TableInfo {
	/**
	 * ����
	 */
	private String tName;
	/**
	 * �����ֶ���Ϣ ����Ϊkey������Ϣ����Ϊvalue
	 */
	private Map<String, ColumnInfo> columns;
	
	/**
	 * Ψһ������Ŀǰֻ֧�� ����ֻ��һ�������������
	 */
	private ColumnInfo onlyPriKey;
	
	/**
	 * ��������
	 */
	private List<ColumnInfo> priKeys;
	
	public String gettName() {
		return tName;
	}
	public void settName(String tName) {
		this.tName = tName;
	}
	public Map<String, ColumnInfo> getColumns() {
		return columns;
	}
	public void setColumns(Map<String, ColumnInfo> columns) {
		this.columns = columns;
	}
	public ColumnInfo getOnlyPriKey() {
		return onlyPriKey;
	}
	public void setOnlyPriKey(ColumnInfo onlyPriKey) {
		this.onlyPriKey = onlyPriKey;
	}
	public List<ColumnInfo> getPriKeys() {
		return priKeys;
	}
	public void setPriKeys(List<ColumnInfo> priKeys) {
		this.priKeys = priKeys;
	}
	
	public TableInfo(String tName, Map<String, ColumnInfo> columns, List<ColumnInfo> priKeys) {
		this.tName = tName;
		this.columns = columns;
		this.priKeys = priKeys;
	}
	public TableInfo() {
	}
}
