import java.util.List;

import com.process.excel.CustomerExcelReader;
import com.process.vo.CustomerVo;


public class MainApplication {
	
	public static void main(String[] args) {
		
		CustomerExcelReader excelReader = new CustomerExcelReader();
		
		System.out.println("*****xls*****");
		List<CustomerVo> xlsList = excelReader.xlsToCustomerVoList("/Users/hunchori/Documents/test.xls");
		System.out.println(xlsList);
		printList(xlsList );
		
		System.out.println("*****xlsx*****");
		List<CustomerVo> xlsxList = excelReader.xlsxToCustomerVoList("/Users/hunchori/Documents/test.xlsx");
		printList(xlsxList );
	}
	
	public static void printList(List<CustomerVo> list) {
		CustomerVo vo;
		
		for (int i = 0; i < list.size(); i++) {
			vo = list.get(i);
			System.out.println(vo.toString());
		}
	}
}
