package com.sorm.utils;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.sorm.bean.ColumnInfo;
import com.sorm.bean.JavaFieldGetSet;
import com.sorm.bean.TableInfo;
import com.sorm.core.DBManager;
import com.sorm.core.MySqlTypeConvertor;
import com.sorm.core.TableContext;
import com.sorm.core.TypeConvertor;

/**
 * 封装了生成Java源文件的常用操作。
 * 
 * @author lenovo
 * 
 */
public class JavaFileUtils {
	public static JavaFieldGetSet createFieldGetSetSRC(ColumnInfo column, TypeConvertor convertor) {

		JavaFieldGetSet jfgs = new JavaFieldGetSet();

		String javaFieldType = convertor.databaseType2JavaType(column.getDataType());

		jfgs.setFieldInfo("\tprivate " + javaFieldType + " " + column.getName() + ";\r\n");

		StringBuilder getSrc = new StringBuilder();

		getSrc.append("\tpublic " + javaFieldType + " get" + StringUtils.firstChar2UpperCase(column.getName())
				+ "() {\r\n\t\treturn this." + column.getName() + ";\r\n\t}\r\n");
		jfgs.setGetInfo(getSrc.toString());
		StringBuilder setSrc = new StringBuilder();
		setSrc.append("\tpublic void set" + StringUtils.firstChar2UpperCase(column.getName()) + "(" + javaFieldType
				+ " " + column.getName() + ") {\r\n\t\tthis." + column.getName() + " = " + column.getName()
				+ ";\r\n\t}\r\n");
		jfgs.setSetInfo(setSrc.toString());
		return jfgs;
	}
	
	
	public static String createJavaSrc(TableInfo tableInfo, TypeConvertor convertor) {
		
		Map<String, ColumnInfo> columns = tableInfo.getColumns();
		
		List<JavaFieldGetSet> javaFields = new ArrayList<>();
		
		for (ColumnInfo c : columns.values()) {
			javaFields.add(createFieldGetSetSRC(c, convertor));
		}
		StringBuilder src = new StringBuilder();
		
		// 生成package语句
		src.append("package " + DBManager.getConf().getPoPackage() + ";\r\n\r\n");
		
		// 生成import语句
		src.append("import java.sql.*;\r\n");
		src.append("import java.util.*;\r\n\r\n");
		
		//生成 类声明语句
		src.append("public class " + StringUtils.firstChar2UpperCase(tableInfo.gettName()) + " {\r\n\r\n");
		
		// 生成属性列表
		for (JavaFieldGetSet f : javaFields) {
			src.append(f.getFieldInfo());
		}
		src.append("\r\n\r\n");
		// 生成get方法列表
		for (JavaFieldGetSet f : javaFields) {
			src.append(f.getGetInfo());
		}
		src.append("\r\n\r\n");
		// 生成set方法列表
		for (JavaFieldGetSet f : javaFields) {
			src.append(f.getSetInfo());
		}
		src.append("\r\n\r\n");
		// 生成结束符
		src.append("}\r\n");
		return src.toString();
	}
	
	public static void createJavaPoFile(TableInfo tableInfo, TypeConvertor typeConvertor) {
		String src = createJavaSrc(tableInfo, typeConvertor);
		String srcPath = DBManager.getConf().getSrcPath() + "\\src\\";
		String packagePath = DBManager.getConf().getPoPackage().replaceAll("\\.", "\\\\");
		String fileName = StringUtils.firstChar2UpperCase(tableInfo.gettName()) + ".java";
		File file = new File(srcPath + packagePath + "\\" + fileName);
		System.out.println(file.getAbsolutePath());
		if (!file.exists()) {
			if (!file.getParentFile().exists()) {
				if (!file.getParentFile().mkdirs()) {
					System.out.println("目录创建失败");
					return;
				}
			}
			try {
				file.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		BufferedWriter bw = null;
		try {
			bw = new BufferedWriter(new FileWriter(file));
			bw.write(src);
			System.out.println("建立表" + tableInfo.gettName() + "对应的JavaBean类"+ StringUtils.firstChar2UpperCase(tableInfo.gettName()) +"成功！");
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (bw != null) {
					bw.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}
	
	
	public static void main(String[] args) {
//		ColumnInfo ci = new ColumnInfo("id", "int", 0);
//		JavaFieldGetSet jfgs =  createFieldGetSetSRC(ci, new MySqlTypeConvertor());
//		System.out.println(jfgs);
//		ColumnInfo ci1 = new ColumnInfo("id", "int", 1);
//		ColumnInfo ci2 = new ColumnInfo("username", "varchar", 0);
//		ColumnInfo ci3 = new ColumnInfo("password", "varchar", 0);
//		
//		columns.put(ci1.getName(), ci1);
//		columns.put(ci2.getName(), ci2);
//		columns.put(ci3.getName(), ci3);
//		List<ColumnInfo> priKeys = new ArrayList<>();
//		priKeys.add(ci1);
//		TableInfo tableInfo = new TableInfo("user", columns, priKeys);
//		System.out.println(createJavaSrc(tableInfo, new MySqlTypeConvertor()));
		
		
		Map<String, TableInfo> map = TableContext.tables;
		
		for (TableInfo tableInfo : map.values()) {
			createJavaPoFile(tableInfo, new MySqlTypeConvertor());
		}
		
	}
}
