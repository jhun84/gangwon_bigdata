package com.process.bl;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import com.process.dm.DM_CERTIFIED_COMPANY;
import com.process.util.LogWriter;
import com.process.util.Utility;
import com.process.sql.*;

public class BLAD_CERTIFIED {
	
	final static String logfile = "/Users/hunchori/Documents/logs/PAY.log";
	
	private int CERTIFIED_COMPANY_INSERT(DM_CERTIFIED_COMPANY info, Connection conn) throws SQLException{		
		if (conn == null){
			throw new NullPointerException("SqlCon Connection is null.");
		}
		int result = 0;
		
        PreparedStatement pstmt = null;		       
        
		StringBuffer sql = new StringBuffer()
				.append("INSERT INTO CERTIFIED_COMPANY_TOTAL ")				
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
				.append("HOMEPAGE, ")
				.append("TOTAL_SALES, ")

				.append("OPER_PROFIT, ")
				.append("INCOME_TERM, ")
				.append("TOTAL_LABOR, ")
				.append("TOTAL_DEVEL_SALES, ")
				.append("BASIC_CONSALTING, ")

				.append("PRO_CONSALTING, ")
				.append("SOCIAL_PEOPLE, ")
				.append("PROF_PEOPLE, ")
				.append("SALARY_PEOPLE, ")
				.append("VUL_PEOPLE)")     
				.append("VALUES(?, ?, ?, ?, ?, ")
				.append("?, ?, ?, ?, ?, ")
				.append("?, ?, ?, ?, ?, ")
				.append("?, ?, ?, ?, ?, ")
				.append("?, ?, ?, ?, ?, ")
				.append("?, ?, ?, ?, ?, ")
				.append("?, ?, (select now()), ?, ?, ")
				.append("?, ?, ?, ?, ?, ")
				.append("?, ?, ?, ?, ?)");
		
		try{
			pstmt = conn.prepareStatement(sql.toString());			        
			pstmt.setString(1,info.company_name);
	        System.out.println("company_name="+info.company_name);	
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
			pstmt.setString(34,info.total_sales);
			pstmt.setString(35,info.oper_profit);
			pstmt.setString(36,info.income_term);
			pstmt.setString(37,info.total_labor);
			pstmt.setString(38,info.total_devel_sales);
			pstmt.setString(39,info.basic_consalting);
			pstmt.setString(40,info.pro_consalting);
			pstmt.setString(41,info.social_people);
			pstmt.setString(42,info.prof_people);
			pstmt.setString(43,info.salary_people);
			pstmt.setString(44,info.vul_people);

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
	
	private ArrayList getCertified_Company_List(int page_no, int page_size, Connection conn) throws SQLException {
		
		if (conn == null) {
			throw new NullPointerException("SqlCon is null.");
		}
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		DM_CERTIFIED_COMPANY result = null;
		/*
		* vector대신 ArrayList 사용(권고사항)
		*/	 
		ArrayList v = new ArrayList();
		StringBuffer sql = new StringBuffer()
        .append("SELECT ")
        .append("seq_no,")
        .append("company_name,")
        .append("company_address,")
        .append("company_zip,")
        .append("cc_area,")
        .append("ca_area,")
        .append("cert_num,")
        .append("spt,")
        .append("ji_date,")
        .append("m_cert,")
        .append("company_type,")
        .append("jojik_type,")
        .append("es_date,")
        .append("bm_number,")
        .append("company_bnum,")
        .append("company_jnum,")
        .append("uniq_num,")
        .append("cr_num,")
        .append("sud_nm,")
        .append("sud_num,")
        .append("biz_detail,")
        .append("item_gubun,")
        .append("item_dru,")
        .append("item_jru,")
        .append("industry_bunryu,")
        .append("ceo_nm,")
        .append("ceo_birth,")
        .append("pic,")
        .append("c_pos,")
        .append("hp_number,")
        .append("areap_number,")
        .append("fax_number,")
        .append("email,")
        .append("homepage,")
        .append("req_date ")
        .append("FROM ")
        .append("CERTIFIED_COMPANY_TOTAL ")
        .append("WHERE  NUM BETWEEN " + ((page_no - 1) * page_size + 1)+" AND "+(page_no * page_size)+"  ");
		
		System.out.println(sql.toString());
				        
		try{

			pstmt = conn.prepareStatement(sql.toString());						
			rs = pstmt.executeQuery();

			while(rs.next()){ 
			    result = new DM_CERTIFIED_COMPANY();
			 // sql 커리시의 컬럼명과 갯수  똑같이
			    result.seq_no = rs.getString("seq_no");	
			    result.company_name = rs.getString("company_name");			    
			    result.company_address = rs.getString("company_address");
			    result.company_zip = rs.getString("company_zip");
			    result.cc_area = rs.getString("cc_area");
			    result.ca_area = rs.getString("ca_area");
			    result.cert_num = rs.getString("cert_num");
			    result.spt = rs.getString("spt");
			    result.ji_date = rs.getString("ji_date");
			    result.m_cert = rs.getString("m_cert");
			    result.company_type = rs.getString("company_type");
			    result.jojik_type = rs.getString("jojik_type");
			    result.es_date = rs.getString("es_date");
			    result.bm_number = rs.getString("bm_number");
			    result.company_bnum = rs.getString("company_bnum");
			    result.company_jnum = rs.getString("company_jnum");
			    result.uniq_num = rs.getString("uniq_num");
			    result.cr_num = rs.getString("cr_num");
			    result.sud_nm = rs.getString("sud_nm");
			    result.sud_num = rs.getString("sud_num");
			    result.biz_detail = rs.getString("biz_detail");
			    result.item_gubun = rs.getString("item_gubun");
			    result.item_dru = rs.getString("item_dru");
			    result.item_jru = rs.getString("item_jru");
			    result.industry_bunryu = rs.getString("industry_bunryu");
			    result.ceo_nm = rs.getString("ceo_nm");
			    result.ceo_birth = rs.getString("ceo_birth");
			    result.pic = rs.getString("pic");
			    result.c_pos = rs.getString("c_pos");
			    result.hp_number = rs.getString("hp_number");
			    result.areap_number = rs.getString("areap_number");
			    result.fax_number = rs.getString("fax_number");
			    result.email = rs.getString("email");
			    result.homepage = rs.getString("homepage");
			    result.req_date = rs.getString("req_date");

				//Utility.fixNull(result);
				v.add(result);				
			} 
			v.trimToSize();
            
		} catch(SQLException SQL1) {
			throw SQL1;
		}finally{
			if (rs != null){
				try	{
					rs.close();
				}catch (SQLException SQL2){
					throw SQL2;
				}
			}
			if (pstmt != null){
				try	{
					pstmt.close();
				}catch (SQLException SQL3){
					throw SQL3;
				}
			}			
		}
		return v;		/// return 값
	}
	
	private int updateCertified_Company(DM_CERTIFIED_COMPANY update_info, Connection conn ) throws SQLException, NullPointerException {
		if (conn == null) {
			throw new NullPointerException("SqlCon is null.");
		}
		
		int result = 0;
		PreparedStatement pstmt = null;

		StringBuffer sql = new StringBuffer() 
			.append("UPDATE ")
			.append("CERTIFIED_COMPANY_TOTAL  ")
			.append("SET ")
			.append("company_name = ?, ")
			.append("company_address = ?, ")
			.append("company_zip = ?, ")
			.append("cc_area = ?, ")
			.append("ca_area = ?, ")
			.append("cert_num = ?, ")
			.append("spt = ?, ")
			.append("ji_date = ?, ")
			.append("m_cert = ?, ") 
			.append("company_type = ?, ")
			.append("jojik_type = ?, ")
			.append("es_date = ?, ")
			.append("bm_number = ?, ")
			.append("company_bnum = ?, ")
			.append("company_jnum = ?, ")
			.append("uniq_num = ?, ")
			.append("cr_num = ?, ")
			.append("sud_nm = ?, ")
			.append("sud_num = ?, ")
			.append("biz_detail = ?, ")
			.append("item_gubun = ?, ")
			.append("item_dru = ?, ")
			.append("item_jru = ?, ")
			.append("industry_bunryu = ?, ")
			.append("ceo_nm = ?, ")
			.append("ceo_birth = ?, ")
			.append("pic = ?, ")
			.append("c_pos = ?, ")
			.append("hp_number = ?, ")
			.append("areap_number = ?, ")
			.append("fax_number = ?, ")
			.append("email = ?, ")
			.append("req_date = (select now()), ")
			.append("homepage = ?, ")
			.append("total_sales = ?, ")
			.append("oper_profit = ?, ")
			.append("income_term = ?, ")
			.append("total_labor = ?, ")
			.append("total_devel_sales = ?, ")
			.append("basic_consalting = ?, ")
			.append("pro_consalting = ?, ")
			.append("social_people = ?, ")
			.append("prof_people = ?, ")
			.append("salary_people = ?, ")
			.append("vul_people = ? ")						
			.append("WHERE  ")
			.append("seq_no = ? ");
		System.out.println(sql.toString());
			
		try {
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1,update_info.company_name);
			pstmt.setString(2,update_info.company_address);
			pstmt.setString(3,update_info.company_zip);
			pstmt.setString(4,update_info.cc_area);
			pstmt.setString(5,update_info.ca_area);
			pstmt.setString(6,update_info.cert_num);
			pstmt.setString(7,update_info.spt);
			pstmt.setString(8,update_info.ji_date);
			pstmt.setString(9,update_info.m_cert);
			pstmt.setString(10,update_info.company_type);
			pstmt.setString(11,update_info.jojik_type);
			pstmt.setString(12,update_info.es_date);
			pstmt.setString(13,update_info.bm_number);
			pstmt.setString(14,update_info.company_bnum);
			pstmt.setString(15,update_info.company_jnum);
			pstmt.setString(16,update_info.uniq_num);
			pstmt.setString(17,update_info.cr_num);
			pstmt.setString(18,update_info.sud_nm);
			pstmt.setString(19,update_info.sud_num);
			pstmt.setString(20,update_info.biz_detail);
			pstmt.setString(21,update_info.item_gubun);
			pstmt.setString(22,update_info.item_dru);
			pstmt.setString(23,update_info.item_jru);
			pstmt.setString(24,update_info.industry_bunryu);
			pstmt.setString(25,update_info.ceo_nm);
			pstmt.setString(26,update_info.ceo_birth);
			pstmt.setString(27,update_info.pic);
			pstmt.setString(28,update_info.c_pos);
			pstmt.setString(29,update_info.hp_number);
			pstmt.setString(30,update_info.areap_number);
			pstmt.setString(31,update_info.fax_number);
			pstmt.setString(32,update_info.email);			
			pstmt.setString(33,update_info.homepage);
			pstmt.setString(34,update_info.total_sales);
			pstmt.setString(35,update_info.oper_profit);
			pstmt.setString(36,update_info.income_term);
			pstmt.setString(37,update_info.total_labor);
			pstmt.setString(38,update_info.total_devel_sales);
			pstmt.setString(39,update_info.basic_consalting);
			pstmt.setString(40,update_info.pro_consalting);
			pstmt.setString(41,update_info.social_people);
			pstmt.setString(42,update_info.prof_people);
			pstmt.setString(43,update_info.salary_people);
			pstmt.setString(44,update_info.vul_people);
			pstmt.setString(45,update_info.seq_no );

			result = pstmt.executeUpdate();
			
		} catch (SQLException SQL1) {
			throw SQL1;
		} finally {
			if (pstmt != null) {
				try	{
					pstmt.close();
				} catch (SQLException SQL3) {
					throw SQL3;
				}
			}			
		}
		return result;
	}
	
	private int HISTORY_CERTIFIED_COMPANY(DM_CERTIFIED_COMPANY info, Connection conn) throws SQLException{		
		if (conn == null){
			throw new NullPointerException("SqlCon Connection is null.");
		}
		int result = 0;
		
        PreparedStatement pstmt = null;		       
        
		StringBuffer sql = new StringBuffer()
		.append("INSERT INTO CERTIFIED_COMPANY_HISTORY ")				
		.append("SELECT * FROM CERTIFIED_COMPANY_TOTAL ")
		.append("WHERE seq_no = ?");
		
		try{
			pstmt = conn.prepareStatement(sql.toString());			        
			pstmt.setString(1,info.seq_no);
			System.out.println("history insert query start="+info.seq_no);
								
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
	
private ArrayList getCertified_Company_Info(String seq_no, Connection conn) throws SQLException {
		
		if (conn == null) {
			throw new NullPointerException("SqlCon is null.");
		}
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		DM_CERTIFIED_COMPANY result = null;
		/*
		* vector대신 ArrayList 사용(권고사항)
		*/	 
		ArrayList v = new ArrayList();
		StringBuffer sql = new StringBuffer()
        .append("SELECT ")
        .append("seq_no, ")
        .append("company_name,")
        .append("company_address,")
        .append("company_zip,")
        .append("cc_area,")
        .append("ca_area,")
        .append("cert_num,")
        .append("spt,")
        .append("ji_date,")
        .append("m_cert,")
        .append("company_type,")
        .append("jojik_type,")
        .append("es_date,")
        .append("bm_number,")
        .append("company_bnum,")
        .append("company_jnum,")
        .append("uniq_num,")
        .append("cr_num,")
        .append("sud_nm,")
        .append("sud_num,")
        .append("biz_detail,")
        .append("item_gubun,")
        .append("item_dru,")
        .append("item_jru,")
        .append("industry_bunryu,")
        .append("ceo_nm,")
        .append("ceo_birth,")
        .append("pic,")
        .append("c_pos,")
        .append("hp_number,")
        .append("areap_number,")
        .append("fax_number,")
        .append("email,")
        .append("homepage,")
        .append("req_date, ")
        .append("total_sales, ")
		.append("oper_profit, ")
		.append("income_term, ")
		.append("total_labor, ")
		.append("total_devel_sales, ")
		.append("basic_consalting, ")
		.append("pro_consalting, ")
		.append("social_people, ")
		.append("prof_people, ")
		.append("salary_people, ")
		.append("vul_people ")
        .append("FROM ")
        .append("CERTIFIED_COMPANY_TOTAL ")
        .append("WHERE ")
        .append("seq_no = ?");
				        
		try{

			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, seq_no);
			rs = pstmt.executeQuery();

			while(rs.next()){ 
			    result = new DM_CERTIFIED_COMPANY();
			 // sql 커리시의 컬럼명과 갯수  똑같이
			    result.seq_no = rs.getString("seq_no");
			    result.company_name = rs.getString("company_name");			    
			    result.company_address = rs.getString("company_address");
			    result.company_zip = rs.getString("company_zip");
			    result.cc_area = rs.getString("cc_area");
			    result.ca_area = rs.getString("ca_area");
			    result.cert_num = rs.getString("cert_num");
			    result.spt = rs.getString("spt");
			    result.ji_date = rs.getString("ji_date");
			    result.m_cert = rs.getString("m_cert");
			    result.company_type = rs.getString("company_type");
			    result.jojik_type = rs.getString("jojik_type");
			    result.es_date = rs.getString("es_date");
			    result.bm_number = rs.getString("bm_number");
			    result.company_bnum = rs.getString("company_bnum");
			    result.company_jnum = rs.getString("company_jnum");
			    result.uniq_num = rs.getString("uniq_num");
			    result.cr_num = rs.getString("cr_num");
			    result.sud_nm = rs.getString("sud_nm");
			    result.sud_num = rs.getString("sud_num");
			    result.biz_detail = rs.getString("biz_detail");
			    result.item_gubun = rs.getString("item_gubun");
			    result.item_dru = rs.getString("item_dru");
			    result.item_jru = rs.getString("item_jru");
			    result.industry_bunryu = rs.getString("industry_bunryu");
			    result.ceo_nm = rs.getString("ceo_nm");
			    result.ceo_birth = rs.getString("ceo_birth");
			    result.pic = rs.getString("pic");
			    result.c_pos = rs.getString("c_pos");
			    result.hp_number = rs.getString("hp_number");
			    result.areap_number = rs.getString("areap_number");
			    result.fax_number = rs.getString("fax_number");
			    result.email = rs.getString("email");
			    result.homepage = rs.getString("homepage");
			    result.req_date = rs.getString("req_date");
			    result.total_sales = rs.getString("total_sales");
				result.oper_profit = rs.getString("oper_profit");
				result.income_term = rs.getString("income_term");
				result.total_labor = rs.getString("total_labor");
				result.total_devel_sales = rs.getString("total_devel_sales");
				result.basic_consalting = rs.getString("basic_consalting");
				result.pro_consalting = rs.getString("pro_consalting");
				result.social_people = rs.getString("social_people");
				result.prof_people = rs.getString("prof_people");
				result.salary_people = rs.getString("salary_people");
				result.vul_people = rs.getString("vul_people");

				//Utility.fixNull(result);
				v.add(result);				
			} 
			v.trimToSize();
            
		} catch(SQLException SQL1) {
			throw SQL1;
		}finally{
			if (rs != null){
				try	{
					rs.close();
				}catch (SQLException SQL2){
					throw SQL2;
				}
			}
			if (pstmt != null){
				try	{
					pstmt.close();
				}catch (SQLException SQL3){
					throw SQL3;
				}
			}			
		}
		return v;		/// return 값
	}

private int CERTIFIED_COMPANY_DELETE(String seq_no, Connection conn) throws SQLException{		
	if (conn == null){
		throw new NullPointerException("SqlCon Connection is null.");
	}
	int result = 0;
	
    PreparedStatement pstmt = null;		       
    
	StringBuffer sql = new StringBuffer()
	.append("DELETE FROM CERTIFIED_COMPANY_TOTAL ")				
	.append("WHERE seq_no = ?");
	
	try{
		pstmt = conn.prepareStatement(sql.toString());			        
		pstmt.setString(1,seq_no);
		System.out.println("delete query start="+seq_no);
							
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
	
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	public String CERTIFIED_COMPANY_INSERT(DM_CERTIFIED_COMPANY info) throws SQLException {
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
		finally {
            if (conn != null) {
                conn.close();
            }
        }
		return result_return;
		
	}
	
	public ArrayList getCertified_Company_List(int page_no, int page_size) throws SQLException, NullPointerException {
		Connection conn = null;
		ArrayList result = null;
        		
		/// Connection Error 검출을 위해
		try {
			conn = COMMON_CONN.getConnection();
			result = getCertified_Company_List (page_no, page_size, conn);

		} catch (java.sql.SQLException SQL1) {
			
			/// CRT출력용
			////System.out.println("Exception occurred at BLAD_CARD_Trade.getEDI_Trade_List.try "+SQL1);
			/// Log 출력용
			StringBuffer msg1 = (new StringBuffer("Exception occurred at BLAD_CERTIFIED.getCertified_Company_List.try "));
			/// log writer
			(new LogWriter(logfile,msg1.toString(),SQL1)).start();
			/// msg1 을 초기화시킴
			msg1 = null;
		}
		finally {
            if (conn != null) {
                conn.close();
            }
        }
		return result;
	}
	
	public String updateCertified_Company(DM_CERTIFIED_COMPANY update_info) throws SQLException, NullPointerException {
		Connection conn = null;
		int result = 0;
		String result_return = "";
		int result_history = 0;

		try {
			conn = COMMON_CONN.getConnection();
			conn.setAutoCommit(false);
			
			result_history = HISTORY_CERTIFIED_COMPANY(update_info, conn);
			System.out.println("insert history="+result_history);
			
			result = updateCertified_Company(update_info, conn);
		
			if(result == 1 ){
				conn.commit();
				result_return = "SUCC";
			}
            else{
				conn.rollback();
				result_return = "ERROR";
            }


		} catch (java.sql.SQLException SQL1) {
			
			StringBuffer msg1 = (new StringBuffer("Exception occurred at BLAD_CERTIFIED.updateCertified_Company.try "));
			(new LogWriter(logfile,msg1.toString(),SQL1)).start();
			msg1 = null;		
		}
		finally {
            if (conn != null) {
                conn.close();
            }
        }
		return result_return;
	}
	
	public ArrayList getCertified_Company_Info(String seq_no) throws SQLException, NullPointerException {
		Connection conn = null;
		ArrayList result = null;
        		
		/// Connection Error 검출을 위해
		try {
			conn = COMMON_CONN.getConnection();
			result = getCertified_Company_Info (seq_no, conn);

		} catch (java.sql.SQLException SQL1) {
			
			/// Log 출력용
			StringBuffer msg1 = (new StringBuffer("Exception occurred at BLAD_CERTIFIED.getCertified_Company_Info.try "));
			/// log writer
			(new LogWriter(logfile,msg1.toString(),SQL1)).start();
			/// msg1 을 초기화시킴
			msg1 = null;
		}
		finally {
            if (conn != null) {
                conn.close();
            }
        }
		return result;
	}
	
	public String CERTIFIED_COMPANY_DELETE(String info) throws SQLException {
		Connection conn = null;
		int result = 0;
		String result_return = "";
							
		try {
          	conn = COMMON_CONN.getConnection();
            conn.setAutoCommit(false);
                        
			result = CERTIFIED_COMPANY_DELETE(info, conn);
            		
            if(result == 1 ){
				conn.commit();
				result_return = "SUCC";
			}else{
				conn.rollback();
				result_return = "ERROR";
            }            
            
		} catch(SQLException SQL1) {
            System.err.println("Exception Occurred at CERTIFIED_COMPANY_DELETE.try " + ( new Date() ).toString());
            StringBuffer msg1 = new StringBuffer("Exception Occurred at CERTIFIED_COMPANY_DELETE ");
            ( new LogWriter( logfile, msg1.toString(), SQL1 ) ).start();
            msg1 = null;
        }
		finally {
            if (conn != null) {
                conn.close();
            }
        }
		return result_return;
		
	}

}
