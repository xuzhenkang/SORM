package com.sorm.core;

public class MySqlTypeConvertor implements TypeConvertor {

	@Override
	public String databaseType2JavaType(String columnType) {
		if ("varchar".equalsIgnoreCase(columnType) || "char".equalsIgnoreCase(columnType)) {
			return "String";
		} else if ("int".equalsIgnoreCase(columnType) 
				|| "tinyint".equalsIgnoreCase(columnType)
				|| "smallint".equalsIgnoreCase(columnType) 
				|| "integer".equalsIgnoreCase(columnType)) {
			return "Integer";
		} else if ("bigint".equalsIgnoreCase(columnType)) {
			return "Long";
		} else if ("double".equalsIgnoreCase(columnType) || "float".equalsIgnoreCase(columnType)) {
			return "Double";
		} else if ("clob".equalsIgnoreCase(columnType)) {
			return "java.sql.Blob";
		} else if ("date".equalsIgnoreCase(columnType)) {
			return "java.sql.Date";
		} else if ("time".equalsIgnoreCase(columnType)) {
			return "java.sql.Timestamp";
		} else // 其他的先不管了
			return null;
	}

	@Override
	public String javaType2DatabaseType(String javaDataType) {
		// 待完成
		return null;
	}

}
