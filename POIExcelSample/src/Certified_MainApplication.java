import java.util.List;

import com.process.excel.CertifiedExcelReader;
import com.process.vo.Certified_CompanyVO;

public class Certified_MainApplication {
public static void main(String[] args) {
		
	CertifiedExcelReader excelReader = new CertifiedExcelReader();
		
		System.out.println("*****xlsx*****");
		List<Certified_CompanyVO> xlsxList = excelReader.xlsxToCertified_CompanyVoList("/Users/hunchori/Documents/Certified_test.xlsx");
		printList(xlsxList);
		System.out.println(xlsxList);
	}
	
	public static void printList(List<Certified_CompanyVO> list) {
		Certified_CompanyVO vo;
		
		for (int i = 0; i < list.size(); i++) {
			vo = list.get(i);
			System.out.println(vo.toString());
		}
	}

}
