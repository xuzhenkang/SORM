package com.sorm.bean;

public class JavaFieldGetSet {
	/**
	 * ����Դ����Ϣ
	 */
	private String fieldInfo;
	/**
	 * get������Դ����Ϣ
	 */
	private String getInfo;
	/**
	 * set������Դ����Ϣ
	 */
	private String setInfo;
	
	public String getFieldInfo() {
		return fieldInfo;
	}
	public void setFieldInfo(String fieldInfo) {
		this.fieldInfo = fieldInfo;
	}
	public String getGetInfo() {
		return getInfo;
	}
	public void setGetInfo(String getInfo) {
		this.getInfo = getInfo;
	}
	public String getSetInfo() {
		return setInfo;
	}
	public void setSetInfo(String setInfo) {
		this.setInfo = setInfo;
	}
	public JavaFieldGetSet(String fieldInfo, String getInfo, String setInfo) {
		this.fieldInfo = fieldInfo;
		this.getInfo = getInfo;
		this.setInfo = setInfo;
	}
	public JavaFieldGetSet() {
	}
	@Override
	public String toString() {
		
		return this.fieldInfo + this.getInfo + this.setInfo;
	}
	
}
