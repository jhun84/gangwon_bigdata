import java.util.List;

import com.process.dm.DM_CERTIFIED_COMPANY;
import com.process.excel.CertifiedExcelReader;
import com.process.sql.BLAD_CERTIFIED;
import com.process.vo.Certified_CompanyVO;

public class Certified_MainApplication {
public static void main(String[] args) {
		
	CertifiedExcelReader excelReader = new CertifiedExcelReader();
		
		System.out.println("*****xlsx*****");
		List<Certified_CompanyVO> xlsxList = excelReader.xlsxToCertified_CompanyVoList("/Users/hunchori/Documents/Certified_test.xlsx");
		printList(xlsxList);	
		printList_insert(xlsxList);
	}
	
	public static void printList(List<Certified_CompanyVO> list) {
		Certified_CompanyVO vo;
		
		for (int i = 0; i < list.size(); i++) {
			vo = list.get(i);
			System.out.println(vo.getCompany_name());
		}
	}
	public static void printList_insert(List<Certified_CompanyVO> list) {
		Certified_CompanyVO vo;
		DM_CERTIFIED_COMPANY info = new DM_CERTIFIED_COMPANY();
		BLAD_CERTIFIED info_insert = new BLAD_CERTIFIED();
		String result = "";
		
		for (int i = 0; i < list.size(); i++) {
			vo = list.get(i);
			info.company_name = vo.getCompany_name();
			info.company_address = vo.getCompany_address();
			info.company_zip = vo.getCompany_zip();
			info.cc_area = vo.getCc_area();
			info.ca_area = vo.getCa_area();
			info.cert_num = vo.getCert_num();
			info.spt = vo.getSocial_purpose_type();
			info.ji_date = vo.getJi_date();
			info.m_cert = vo.getM_cert();
			info.company_type = vo.getCompany_type();
			info.jojik_type = vo.getJojik_type();
			info.es_date = vo.getEs_date();
			info.bm_number = vo.getBm_number();
			info.company_bnum = vo.getCompany_bnum();
			info.company_jnum = vo.getCompany_jnum();
			info.uniq_num = vo.getUniq_num();
			info.cr_num = vo.getCr_num();
			info.sud_nm = vo.getSud_nm();
			info.sud_num = vo.getSud_num();
			info.biz_detail = vo.getBiz_detail();
			info.item_gubun = vo.getItem_gubun();
			info.item_dru = vo.getItem_dru();
			info.item_jru = vo.getItem_jru();
			info.industry_bunryu = vo.getIndustry_bunryu();
			info.ceo_nm = vo.getCeo_nm();
			info.ceo_birth = vo.getCeo_birth();
			info.pic = vo.getPic();
			info.c_pos = vo.getC_pos();
			info.hp_number = vo.getHp_number();
			info.areap_number = vo.getAreap_number();
			info.fax_number = vo.getFax_number();
			info.email = vo.getEmail();
			info.homepage = vo.getHomepage();
			
			result = info_insert.CERTIFIED_COMPANY_INSERT(info);
			
			System.out.println(result);
		}
	}

}
