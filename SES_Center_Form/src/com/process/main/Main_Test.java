package com.process.main;
import java.sql.SQLException;
import java.util.ArrayList;

import com.process.dm.DM_CERTIFIED_COMPANY;
import com.process.sql.BLAD_CERTIFIED;

public class Main_Test {
	public static void main(String[] args) throws NullPointerException, SQLException {
		ArrayList           dataList            = new ArrayList();
		BLAD_CERTIFIED bl = new BLAD_CERTIFIED();
		dataList = bl.getCertified_Company_List();
		DM_CERTIFIED_COMPANY dm_certified_company = new DM_CERTIFIED_COMPANY();
		
		int iter = 0;
		iter = dataList.size();
		
		if (iter > 0) {
			for(int i = 0; i < iter; i++) {
				dm_certified_company = new DM_CERTIFIED_COMPANY();
				dm_certified_company = (DM_CERTIFIED_COMPANY)dataList.get(i);
				
				String company_name = dm_certified_company.company_name;
				System.out.println(company_name);
		
		}
    }
  }
}