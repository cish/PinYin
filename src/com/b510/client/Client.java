/**
 * 
 */
package com.b510.client;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.junit.Test;

import com.b510.common.Common;
import com.b510.excel.SaveData2DB;
import com.b510.excel.util.DbUtil;
import com.b510.excel.util.PinYinUtils;
import com.b510.excel.vo.City;
import com.b510.excel.vo.District;

/**
 * @author Hongten
 * @created 2014-5-18
 */
public class Client {

	public static void main(String[] args) throws Exception {
		SaveData2DB saveData2DB = new SaveData2DB();
		List<District> districtList=saveData2DB.save();
		//List<Province> provinceList=DbUtil.selectAllProvice();
		List<City> cityList=DbUtil.selectAllCity();
		Map<String,City> cityMap=new HashMap<String,City>();
		for(City c:cityList){
			cityMap.put(c.getName().trim(), c);
		}
		for(int i=0;i<districtList.size();i++){
			
			districtList.get(i).setId(UUID.randomUUID().toString());
			districtList.get(i).setCityinitials(PinYinUtils.FirstCharUP(districtList.get(i).getDistrict()));
			districtList.get(i).setFullpinyin(PinYinUtils.spellCharUP(districtList.get(i).getDistrict()));
			districtList.get(i).setFullnameinitials(PinYinUtils.ALLFirstCharUP(districtList.get(i).getDistrict()));
			if(cityMap.containsKey(districtList.get(i).getCityid().trim())){
				districtList.get(i).setCityid(cityMap.get(districtList.get(i).getCityid()).getId());
			}else{
				districtList.get(i).setCityid("");
			}
			if(i==0){
				districtList.get(i).setMarkid("001");
				districtList.get(i).setSortno(1);
			}else{
				if(districtList.get(i).getCityid().equals(districtList.get(i-1).getCityid())){
					String tmpMarkid=districtList.get(i-1).getMarkid();
					int intMarkid=Integer.valueOf(tmpMarkid).intValue()+1;
					districtList.get(i).setMarkid(intMarkid>99 ? intMarkid+"" : (intMarkid>9 ? "0"+intMarkid : "00"+intMarkid));
					districtList.get(i).setSortno(districtList.get(i-1).getSortno()+1);
				}else{
					districtList.get(i).setMarkid("001");
					districtList.get(i).setSortno(1);
				}
			}
			DbUtil.insert(Common.INSERT_STUDENT_SQL, districtList.get(i));
		}
		System.out.println("end");
	}
	
	@Test
	public void test1(){
		System.out.println(Integer.valueOf("001"));
		System.out.println(Integer.valueOf("010"));
		System.out.println(Integer.valueOf("100"));
	}
}
