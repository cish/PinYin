/**
 * 
 */
package com.b510.excel.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.b510.common.Common;
import com.b510.excel.vo.City;
import com.b510.excel.vo.District;
import com.b510.excel.vo.Province;
import com.b510.excel.vo.Student;

/**
 * @author Hongten
 * @created 2014-5-18
 */
public class DbUtil {

	/**
	 * @param sql
	 */
	public static void insert(String sql, District district) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			Class.forName(Common.DRIVER);
			conn = DriverManager.getConnection(Common.URL, Common.USERNAME, Common.PASSWORD);
			ps = conn.prepareStatement(sql);
			ps.setString(1, district.getId());
			ps.setString(2, district.getDistrict());
			ps.setString(3, district.getCityinitials());
			ps.setString(4, district.getFullpinyin());
			ps.setString(5, district.getFullnameinitials());
			ps.setString(6, district.getCityid());
			ps.setString(7, district.getMarkid());
			ps.setInt(8, district.getSortno());
			boolean flag = ps.execute();
			if(!flag){
				System.out.println("Save data : No. = " + district.getDistrict() + " , Name = " + district.getId() + " succeed!");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (ps != null) {
				ps.close();
			}
			if (conn != null) {
				conn.close();
			}
		}
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static List selectOne(String sql, Student student) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List list = new ArrayList();
		try {
			Class.forName(Common.DRIVER);
			conn = DriverManager.getConnection(Common.URL, Common.USERNAME, Common.PASSWORD);
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()){
				if(rs.getString("no").equals(student.getNo()) || rs.getString("name").equals(student.getName())|| rs.getString("age").equals(student.getAge())){
					list.add(1);
				}else{
					list.add(0);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (rs != null) {
				rs.close();
			}
			if (ps != null) {
				ps.close();
			}
			if (conn != null) {
				conn.close();
			}
		}
		return list;
	}
	
	
	public static ResultSet selectAll(String sql) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			Class.forName(Common.DRIVER);
			conn = DriverManager.getConnection(Common.URL, Common.USERNAME, Common.PASSWORD);
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (rs != null) {
				rs.close();
			}
			if (ps != null) {
				ps.close();
			}
			if (conn != null) {
				conn.close();
			}
		}
		return rs;
	}

	public static List<Province> selectAllProvice() throws Exception {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Province> list=new ArrayList<Province>();
		String sql="select id,city as name,markid from pub_provinceaddr";
		Province province=null;
		try {
			Class.forName(Common.DRIVER);
			conn = DriverManager.getConnection(Common.URL, Common.USERNAME, Common.PASSWORD);
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()){
				province=new Province();
				province.setId(rs.getString(1));
				province.setName(rs.getString(2));
				province.setMarkid(rs.getString(3));
				list.add(province);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (rs != null) {
				rs.close();
			}
			if (ps != null) {
				ps.close();
			}
			if (conn != null) {
				conn.close();
			}
		}
		return list;
	}

	public static List<City> selectAllCity() throws Exception {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<City> list=new ArrayList<City>();
		String sql="select id,city as name,markid from pub_cityaddr";
		City province=null;
		try {
			Class.forName(Common.DRIVER);
			conn = DriverManager.getConnection(Common.URL, Common.USERNAME, Common.PASSWORD);
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()){
				province=new City();
				province.setId(rs.getString(1));
				province.setName(rs.getString(2));
				province.setMarkid(rs.getString(3));
				list.add(province);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (rs != null) {
				rs.close();
			}
			if (ps != null) {
				ps.close();
			}
			if (conn != null) {
				conn.close();
			}
		}
		return list;
	}
}
