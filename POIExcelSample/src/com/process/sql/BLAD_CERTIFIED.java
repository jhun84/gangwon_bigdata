package com.process.sql;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;
import com.process.dm.DM_CERTIFIED_COMPANY;
import com.process.util.LogWriter;

public class BLAD_CERTIFIED {
	
	final static String logfile = "/Users/hunchori/Documents/logs/PAY.log";
	
	private int CERTIFIED_COMPANY_INSERT(DM_CERTIFIED_COMPANY info, Connection conn) throws SQLException{		
		if (conn == null){
			throw new NullPointerException("SqlCon Connection is null.");
		}
		int result = 0;
		
        PreparedStatement pstmt = null;		       
        
		StringBuffer sql = new StringBuffer()
				.append("INSERT INTO CERTIFIED_COMPANY ")				
				.append("(COMPANY_NAME, ")      
				.append("COMPANY_ADDRESS, ")      
				.append("COMPANY_ZIP, ")     
				.append("CC_AREA, ")      
				.append("CA_AREA, ")      
				.append("CERT_NUM, ")      
				.append("SPT, ")  
				.append("JI_DATE, ")       
				.append("M_CERT, ")       
				.append("COMPANY_TYPE, ")       
				.append("JOJIK_TYPE, ")   
				.append("ES_DATE, ")    
				.append("BM_NUMBER, ")
				.append("COMPANY_BNUM, ")
				.append("COMPANY_JNUM, ")
				.append("UNIQ_NUM, ")
				.append("CR_NUM, ")
				.append("SUD_NM, ")
				.append("SUD_NUM, ")
				.append("BIZ_DETAIL, ")
				.append("ITEM_GUBUN, ")
				.append("ITEM_DRU, ")
				.append("ITEM_JRU, ")
				.append("INDUSTRY_BUNRYU, ")
				.append("CEO_NM, ")
				.append("CEO_BIRTH, ")
				.append("PIC, ")
				.append("C_POS, ")
				.append("HP_NUMBER, ")
				.append("AREAP_NUMBER, ")
				.append("FAX_NUMBER, ")
				.append("EMAIL, ")
				.append("REQ_DATE, ")
				.append("HOMEPAGE)")     
				.append("VALUES(?, ?, ?, ?, ?, ")
				.append("?, ?, ?, ?, ?, ")
				.append("?, ?, ?, ?, ?, ")
				.append("?, ?, ?, ?, ?, ")
				.append("?, ?, ?, ?, ?, ")
				.append("?, ?, ?, ?, ?, ")
				.append("?, ?, (select now()),?)");
		
		try{
			pstmt = conn.prepareStatement(sql.toString());			        
			pstmt.setString(1,info.company_name);
			pstmt.setString(2,info.company_address);
			pstmt.setString(3,info.company_zip);
			pstmt.setString(4,info.cc_area);
			pstmt.setString(5,info.ca_area);
			pstmt.setString(6,info.cert_num);
			pstmt.setString(7,info.spt);
			pstmt.setString(8,info.ji_date);
			pstmt.setString(9,info.m_cert);
			pstmt.setString(10,info.company_type);
			pstmt.setString(11,info.jojik_type);
			pstmt.setString(12,info.es_date);
			pstmt.setString(13,info.bm_number);
			pstmt.setString(14,info.company_bnum);
			pstmt.setString(15,info.company_jnum);
			pstmt.setString(16,info.uniq_num);
			pstmt.setString(17,info.cr_num);
			pstmt.setString(18,info.sud_nm);
			pstmt.setString(19,info.sud_num);
			pstmt.setString(20,info.biz_detail);
			pstmt.setString(21,info.item_gubun);
			pstmt.setString(22,info.item_dru);
			pstmt.setString(23,info.item_jru);
			pstmt.setString(24,info.industry_bunryu);
			pstmt.setString(25,info.ceo_nm);
			pstmt.setString(26,info.ceo_birth);
			pstmt.setString(27,info.pic);
			pstmt.setString(28,info.c_pos);
			pstmt.setString(29,info.hp_number);
			pstmt.setString(30,info.areap_number);
			pstmt.setString(31,info.fax_number);
			pstmt.setString(32,info.email);
			pstmt.setString(33,info.homepage);
						
        	    result = pstmt.executeUpdate();        	    
			        	
		} catch(SQLException SQL1) {
            throw SQL1;
        } finally {
            if (pstmt != null){
                try {
                    pstmt.close();
                }catch (SQLException SQL3){
                    throw SQL3;
                }
            }
        }
		return result;
	}
	
	public String CERTIFIED_COMPANY_INSERT(DM_CERTIFIED_COMPANY info) {
		Connection conn = null;
		int result = 0;
		String result_return = "";
							
		try {
          	conn = COMMON_CONN.getConnection();
            conn.setAutoCommit(false);
                        
			result = CERTIFIED_COMPANY_INSERT(info, conn);
            		
            if(result == 1 ){
				conn.commit();
				result_return = "SUCC";
			}else{
				conn.rollback();
				result_return = "ERROR";
            }            
            
		} catch(SQLException SQL1) {
            System.err.println("Exception Occurred at CERTIFIED_COMPANY_INSERT.try " + ( new Date() ).toString());
            StringBuffer msg1 = new StringBuffer("Exception Occurred at CERTIFIED_COMPANY_INSERT ");
            ( new LogWriter( logfile, msg1.toString(), SQL1 ) ).start();
            msg1 = null;
        }
		return result_return;
		
	}

}
