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
 * 负责获取管理数据库所有表结构和类结构的关系，并可以根据表结构生成类结构。
 * 
 * @author lenovo
 *
 */
public class TableContext {
	/**
	 * 表名为key，表信息对象为value
	 */
	public static Map<String, TableInfo> tables = new HashMap<>();
	/**
	 * 将po的class对象和表信息对象关联起来，便于重用！
	 */
	public static Map<Class, TableInfo> poClassTableMap = new HashMap<>();

	private TableContext() {
	}

	static {
		try {
			// 初始化获得表的信息
			Connection con = DBManager.getConn();
			DatabaseMetaData dbmd = con.getMetaData();

			ResultSet tableRet = dbmd.getTables(null, "%", "%", new String[] { "TABLE" });

			while (tableRet.next()) {
				String tableName = (String) tableRet.getObject("TABLE_NAME");

				TableInfo tableInfo = new TableInfo(tableName, new HashMap<String, ColumnInfo>(), new ArrayList<ColumnInfo>());
				tables.put(tableName, tableInfo);

				ResultSet columnSet = dbmd.getColumns(null, "%", tableName, "%"); // 查询表中的所有字段
				while (columnSet.next()) {
					ColumnInfo columnInfo = new ColumnInfo(columnSet.getString("COLUMN_NAME"), columnSet.getString("TYPE_NAME"), 0);
					tableInfo.getColumns().put(columnSet.getString("COLUMN_NAME"), columnInfo);
				}
				ResultSet primaryKeySet = dbmd.getPrimaryKeys(null, "%", tableName); // 查询t_user表中的主键
				while (primaryKeySet.next()) {
					ColumnInfo columnInfo = (ColumnInfo) tableInfo.getColumns().get(primaryKeySet.getObject("COLUMN_NAME"));
					columnInfo.setKeyType(1); // 设置为主键类型
					tableInfo.getPriKeys().add(columnInfo);
				}

				if (tableInfo.getPriKeys().size() > 0) { // 取唯一主键。。方便使用。如果是联合主键。则为空！
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
