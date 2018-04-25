package com.process.main;
import java.sql.SQLException;
import java.util.ArrayList;

import com.process.dm.DM_CERTIFIED_COMPANY;
import com.process.sql.BLAD_CERTIFIED;

public class Main_Test {
	public static void main(String[] args) throws NullPointerException, SQLException {
		BLAD_CERTIFIED bl = new BLAD_CERTIFIED();
		DM_CERTIFIED_COMPANY update_info = new DM_CERTIFIED_COMPANY();
		String result = "";
		
		update_info.seq_no = "1234";
		update_info.company_name = "후니훈네가족";
		update_info.company_zip = "0531";
		update_info.company_type = "정민재 팸";
		
		result = bl.updateCertified_Company(update_info);
		
		System.out.println(result);
    }
}
