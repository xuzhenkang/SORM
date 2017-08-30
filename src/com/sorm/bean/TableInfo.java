package com.sorm.bean;

import java.util.List;
import java.util.Map;

/**
 * 存储表结构信息
 * @author lenovo
 *
 */
public class TableInfo {
	/**
	 * 表名
	 */
	private String tName;
	/**
	 * 所有字段信息 表名为key，表信息对象为value
	 */
	private Map<String, ColumnInfo> columns;
	
	/**
	 * 唯一主键（目前只支持 有且只有一个主键的情况）
	 */
	private ColumnInfo onlyPriKey;
	
	/**
	 * 联合主键
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
