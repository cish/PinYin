/**
 * 
 */
package com.b510.common;

/**
 * @author Hongten
 * @created 2014-5-18
 */
public class Common {

	// connect the database
	public static final String DRIVER = "com.mysql.jdbc.Driver";
	public static final String DB_NAME = "pd_carservicedev_v5.0.0";
	public static final String USERNAME = "developer";
	public static final String PASSWORD = "yc@123456";
	public static final String IP = "10.10.10.101";
	public static final String PORT = "3306";
	public static final String URL = "jdbc:mysql://" + IP + ":" + PORT + "/" + DB_NAME+"?useUnicode=true&characterEncoding=utf8";
	
	// common
	public static final String EXCEL_PATH = "lib/district.xls";
	
	// sql
	public static final String INSERT_STUDENT_SQL = "insert into pub_district(id, district, cityinitials, fullpinyin,fullnameinitials,cityid,markid,sortno) values(?, ?, ?, ?,?,?,?,?)";
	public static final String UPDATE_STUDENT_SQL = "update student_info set no = ?, name = ?, age= ?, score = ? where id = ? ";
	public static final String SELECT_STUDENT_ALL_SQL = "select id,no,name,age,score from student_info";
	public static final String SELECT_STUDENT_SQL = "select * from student_info where name like ";
}
