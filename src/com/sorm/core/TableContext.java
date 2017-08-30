package com.sorm.core;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.sorm.bean.ColumnInfo;
import com.sorm.bean.TableInfo;
import com.sorm.utils.JavaFileUtils;

/**
 * �����ȡ�������ݿ����б�ṹ����ṹ�Ĺ�ϵ�������Ը��ݱ�ṹ������ṹ��
 * 
 * @author lenovo
 *
 */
public class TableContext {
	/**
	 * ����Ϊkey������Ϣ����Ϊvalue
	 */
	public static Map<String, TableInfo> tables = new HashMap<>();
	/**
	 * ��po��class����ͱ���Ϣ��������������������ã�
	 */
	public static Map<Class, TableInfo> poClassTableMap = new HashMap<>();

	private TableContext() {
	}

	static {
		try {
			// ��ʼ����ñ����Ϣ
			Connection con = DBManager.getConn();
			DatabaseMetaData dbmd = con.getMetaData();

			ResultSet tableRet = dbmd.getTables(null, "%", "%", new String[] { "TABLE" });

			while (tableRet.next()) {
				String tableName = (String) tableRet.getObject("TABLE_NAME");

				TableInfo tableInfo = new TableInfo(tableName, new HashMap<String, ColumnInfo>(), new ArrayList<ColumnInfo>());
				tables.put(tableName, tableInfo);

				ResultSet columnSet = dbmd.getColumns(null, "%", tableName, "%"); // ��ѯ���е������ֶ�
				while (columnSet.next()) {
					ColumnInfo columnInfo = new ColumnInfo(columnSet.getString("COLUMN_NAME"), columnSet.getString("TYPE_NAME"), 0);
					tableInfo.getColumns().put(columnSet.getString("COLUMN_NAME"), columnInfo);
				}
				ResultSet primaryKeySet = dbmd.getPrimaryKeys(null, "%", tableName); // ��ѯt_user���е�����
				while (primaryKeySet.next()) {
					ColumnInfo columnInfo = (ColumnInfo) tableInfo.getColumns().get(primaryKeySet.getObject("COLUMN_NAME"));
					columnInfo.setKeyType(1); // ����Ϊ��������
					tableInfo.getPriKeys().add(columnInfo);
				}

				if (tableInfo.getPriKeys().size() > 0) { // ȡΨһ������������ʹ�á������������������Ϊ�գ�
					tableInfo.setOnlyPriKey(tableInfo.getPriKeys().get(0));
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		updateJavaPoFile();
	}
	
	public static void updateJavaPoFile() {
		for (TableInfo tableInfo : TableContext.tables.values()) {
			JavaFileUtils.createJavaPoFile(tableInfo, new MySqlTypeConvertor());
		}
	}
	
	
	public static void main(String[] args) {
		
	}
}
