/**
 * 
 */
package com.b510.excel;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import com.b510.common.Common;
import com.b510.excel.vo.District;
import com.b510.excel.vo.Student;

/**
 * @author Hongten
 * @created 2014-5-18
 */
public class ReadExcel {

	public List<District> readXls() throws IOException {
		InputStream is = new FileInputStream(Common.EXCEL_PATH);
		HSSFWorkbook hssfWorkbook = new HSSFWorkbook(is);
		District district = null;
		List<District> list = new ArrayList<District>();
		// ѭ��������Sheet
		for (int numSheet = 0; numSheet < hssfWorkbook.getNumberOfSheets(); numSheet++) {
			HSSFSheet hssfSheet = hssfWorkbook.getSheetAt(numSheet);
			if (hssfSheet == null) {
				continue;
			}
			// ѭ����Row
			for (int rowNum = 1; rowNum <= hssfSheet.getLastRowNum(); rowNum++) {
				HSSFRow hssfRow = hssfSheet.getRow(rowNum);
				if (hssfRow != null) {
					district = new District();
					//HSSFCell id = hssfRow.getCell(1);
					 
					HSSFCell districts = hssfRow.getCell(2);
					HSSFCell city = hssfRow.getCell(1);
					System.out.println("rowNum="+rowNum);
					//district.setId(UUID.randomUUID().toString());
					district.setDistrict(getValue(districts).trim());
					district.setCityid(getValue(city).trim());
					 
					list.add(district);
				}
			}
		}
		return list;
	}
	
	 @SuppressWarnings("static-access")
	private String getValue(HSSFCell hssfCell) {
	        if (hssfCell.getCellType() == hssfCell.CELL_TYPE_BOOLEAN) {
	            // ���ز������͵�ֵ
	            return String.valueOf(hssfCell.getBooleanCellValue());
	        } else if (hssfCell.getCellType() == hssfCell.CELL_TYPE_NUMERIC) {
	            // ������ֵ���͵�ֵ
	            return String.valueOf(hssfCell.getNumericCellValue());
	        } else {
	            // �����ַ������͵�ֵ
	            return String.valueOf(hssfCell.getStringCellValue());
	        }
	    }
}
