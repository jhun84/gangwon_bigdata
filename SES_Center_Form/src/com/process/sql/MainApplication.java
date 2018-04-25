package com.process.sql;

import java.sql.SQLException;

import com.process.dm.DM_CERTIFIED_COMPANY;

public class MainApplication {
	public static void main(String[] args) throws SQLException {
		String test1 = "test";
		String test2 = "test";
		String test3 = "test";
		String test4 = "test";
		String test5 = "test";
		String test6 = "test";
		String test7 = "test";
		String test8 = "test";
		String test9 = "test";
		String test10 = "test";
		String test11 = "test";
		String test12 = "test";
		String test13 = "test";
		String test14 = "test";
		String test15 = "test";
		String test16 = "test";
		String test17 = "test";
		String test18 = "test";
		String test19 = "test";
		String test20 = "test";
		String test21 = "test";
		String test22 = "test";
		String test23 = "test";
		String test24 = "test";
		String test25 = "test";
		String test26 = "test";
		String test27 = "test";
		String test28 = "test";
		String test29 = "test";
		String test30 = "test";
		String test31 = "test";
		String test32 = "test";
		String test33 = "test";
		String test34 = "test";
		String test35 = "test";
		String test36 = "test";
				
		DM_CERTIFIED_COMPANY info = new DM_CERTIFIED_COMPANY();
		BLAD_CERTIFIED info_insert = new BLAD_CERTIFIED();
		String result = "";
		
		info.company_name = test1;
		info.company_address = test2;
		info.company_zip = test3;
		info.cc_area = test4;
		info.ca_area = test5;
		info.j_area = test6;
		info.b_area = test7;
		info.cert_num = test8;
		info.spt = test9;
		info.ji_date = test10;
		info.jiend_date = test11;
		info.m_cert = test12;
		info.company_type = test13;
		info.jojik_type = test14;
		info.es_date = test15;
		info.bm_number = test16;
		info.company_bnum = test17;
		info.company_jnum = test18;
		info.uniq_num = test19;
		info.cr_num = test20;
		info.sud_nm = test21;
		info.sud_num = test22;
		info.biz_detail = test23;
		info.item_gubun = test24;
		info.item_dru = test25;
		info.item_jru = test26;
		info.industry_bunryu = test27;
		info.ceo_nm = test28;
		info.ceo_birth = test29;
		info.pic = test30;
		info.c_pos = test31;
		info.hp_number = test32;
		info.areap_number = test33;
		info.fax_number = test34;
		info.email = test35;
		info.homepage = test36;
		
		result=info_insert.CERTIFIED_COMPANY_INSERT(info);
		
		System.out.println(result);
	}

}
