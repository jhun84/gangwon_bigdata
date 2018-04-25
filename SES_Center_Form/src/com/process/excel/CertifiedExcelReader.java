package com.process.excel;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.process.vo.Certified_CompanyVO;
import com.process.vo.CustomerVo;

public class CertifiedExcelReader {
	
	/**
	 * XLS 파일을 분석하여 List<CustomerVo> 객체로 반환
	 * @param filePath
	 * @return
	 */
	@SuppressWarnings("resource")
	public List<Certified_CompanyVO> xlsToCertified_CompanyVoList(String filePath) {
		
		// 반환할 객체를 생성
		List<Certified_CompanyVO> list = new ArrayList<Certified_CompanyVO>();
		
		FileInputStream fis = null;
		HSSFWorkbook workbook = null;
		
		try {
			
			fis= new FileInputStream(filePath);
			// HSSFWorkbook은 엑셀파일 전체 내용을 담고 있는 객체
			workbook = new HSSFWorkbook(fis);
			
			// 탐색에 사용할 Sheet, Row, Cell 객체
			HSSFSheet curSheet;
			HSSFRow   curRow;
			HSSFCell  curCell;
			Certified_CompanyVO vo;
			
			// Sheet 탐색 for문
			for(int sheetIndex = 0 ; sheetIndex < workbook.getNumberOfSheets(); sheetIndex++) {
				// 현재 Sheet 반환
				curSheet = workbook.getSheetAt(sheetIndex);
				// row 탐색 for문
				for(int rowIndex=0; rowIndex < curSheet.getPhysicalNumberOfRows(); rowIndex++) {
					// row 0은 헤더정보이기 때문에 무시
					if(rowIndex != 0) {
						// 현재 row 반환
						curRow = curSheet.getRow(rowIndex);
						vo = new Certified_CompanyVO();
						String value;
						
						// row의 첫번째 cell값이 비어있지 않은 경우 만 cell탐색
						if(!"".equals(curRow.getCell(0).getStringCellValue())) {
							
							// cell 탐색 for 문
							for(int cellIndex=0;cellIndex<curRow.getPhysicalNumberOfCells(); cellIndex++) {
								curCell = curRow.getCell(cellIndex);
								
								if(true) {
									value = "";
									// cell 스타일이 다르더라도 String으로 반환 받음
									switch (curCell.getCellType()){
					                case HSSFCell.CELL_TYPE_FORMULA:
					                	value = curCell.getCellFormula();
					                    break;
					                case HSSFCell.CELL_TYPE_NUMERIC:
					                	value = curCell.getNumericCellValue()+"";
					                    break;
					                case HSSFCell.CELL_TYPE_STRING:
					                    value = curCell.getStringCellValue()+"";
					                    break;
					                case HSSFCell.CELL_TYPE_BLANK:
					                    value = curCell.getBooleanCellValue()+"";
					                    break;
					                case HSSFCell.CELL_TYPE_ERROR:
					                    value = curCell.getErrorCellValue()+"";
					                    break;
					                default:
					                	value = new String();
										break;
					                }
									
									// 현재 column index에 따라서 vo에 입력
									switch (cellIndex) {
									case 0: // 아이디
										vo.setCompany_name(value);;
										break;
									case 1:
										vo.setCompany_address(value);;
										break;
									case 2:
										vo.setCompany_address(value);
										break;
									case 3:
										vo.setCc_area(value);
										break;
									case 4:
										vo.setCa_area(value);
										break;									
									case 5:
										vo.setCert_num(value);
										break;
									case 6:
										vo.setSocial_purpose_type(value);
										break;
									case 7:
										vo.setJi_date(value);
										break;									
									case 8:
										vo.setM_cert(value);
										break;
									case 9:
										vo.setCompany_type(value);
										break;
									case 10:
										vo.setJojik_type(value);
										break;
									case 11:
										vo.setEs_date(value);
										break;
									case 12:
										vo.setBm_number(value);
										break;
									case 13:
										vo.setCompany_bnum(value);
										break;
									case 14:
										vo.setCompany_jnum(value);
										break;
									case 15:
										vo.setUniq_num(value);
										break;
									case 16:
										vo.setCr_num(value);
										break;
									case 17:
										vo.setSud_nm(value);
										break;
									case 18:
										vo.setSud_num(value);
										break;
									case 19:
										vo.setBiz_detail(value);
										break;
									case 20:
										vo.setItem_gubun(value);
										break;
									case 21:
										vo.setItem_dru(value);
										break;
									case 22:
										vo.setItem_jru(value);
										break;
									case 23:
										vo.setIndustry_bunryu(value);
										break;
									case 24:
										vo.setCeo_nm(value);
										break;
									case 25:
										vo.setCeo_birth(value);
										break;
									case 26:
										vo.setPic(value);
										break;
									case 27:
										vo.setC_pos(value);
										break;
									case 28:
										vo.setHp_number(value);
										break;
									case 29:
										vo.setAreap_number(value);
										break;
									case 30:
										vo.setFax_number(value);
										break;
									case 31:
										vo.setEmail(value);
										break;
									case 32:
										vo.setHomepage(value);
										break;
									case 33:
										vo.setTotal_sales(value);
										break;
									case 34:
										vo.setOper_profit(value);
										break;
									case 35:
										vo.setIncome_term(value);
										break;
									case 36:
										vo.setTotal_labor(value);
										break;
									case 37:
										vo.setTotal_devel_sales(value);
										break;
									case 38:
										vo.setBasic_consalting(value);
										break;
									case 39:
										vo.setPro_consalting(value);
										break;
									case 40:
										vo.setSocial_people(value);
										break;
									case 41:
										vo.setProf_people(value);
										break;
									case 42:
										vo.setSalary_people(value);
										break;
									case 43:
										vo.setVul_people(value);
										break;
									default:
										break;
									}
								}
							}
							// cell 탐색 이후 vo 추가
							list.add(vo);
						}
					}
				}
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		} finally {
			try {
				// 사용한 자원은 finally에서 해제
				if( workbook!= null) workbook.close();
				if( fis!= null) fis.close();
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return list;
	}
	
	/**
	 * XLSX 파일을 분석하여 List<Certified_CompanyVo> 객체로 반환
	 * @param filePath
	 * @return
	 */
	public List<Certified_CompanyVO> xlsxToCertified_CompanyVoList(String filePath) {
		// 반환할 객체를 생성
		List<Certified_CompanyVO> list = new ArrayList<Certified_CompanyVO>();
		
		FileInputStream fis = null;
		XSSFWorkbook workbook = null;
		
		try {
			
			fis= new FileInputStream(filePath);
			// HSSFWorkbook은 엑셀파일 전체 내용을 담고 있는 객체
			workbook = new XSSFWorkbook(fis);
			
			// 탐색에 사용할 Sheet, Row, Cell 객체
			XSSFSheet curSheet;
			XSSFRow   curRow;
			XSSFCell  curCell;
			Certified_CompanyVO vo;
			
			// Sheet 탐색 for문
			for(int sheetIndex = 0 ; sheetIndex < workbook.getNumberOfSheets(); sheetIndex++) {
				// 현재 Sheet 반환
				curSheet = workbook.getSheetAt(sheetIndex);
				// row 탐색 for문
				for(int rowIndex=0; rowIndex < curSheet.getPhysicalNumberOfRows(); rowIndex++) {
					// row 0은 헤더정보이기 때문에 무시
					if(rowIndex != 0) {
						// 현재 row 반환
						curRow = curSheet.getRow(rowIndex);
						vo = new Certified_CompanyVO();
						String value;
						
						// row의 첫번째 cell값이 비어있지 않은 경우 만 cell탐색
						if(!"".equals(curRow.getCell(0).getStringCellValue())) {
							
							// cell 탐색 for 문
							for(int cellIndex=0;cellIndex<curRow.getPhysicalNumberOfCells(); cellIndex++) {
								curCell = curRow.getCell(cellIndex);
								
								if(true) {
									value = "";
									// cell 스타일이 다르더라도 String으로 반환 받음
									switch (curCell.getCellType()){
					                case HSSFCell.CELL_TYPE_FORMULA:
					                	value = curCell.getCellFormula();
					                    break;
					                case HSSFCell.CELL_TYPE_NUMERIC:
					                	value = curCell.getNumericCellValue()+"";
					                    break;
					                case HSSFCell.CELL_TYPE_STRING:
					                    value = curCell.getStringCellValue()+"";
					                    break;
					                case HSSFCell.CELL_TYPE_BLANK:
					                    value = curCell.getBooleanCellValue()+"";
					                    break;
					                case HSSFCell.CELL_TYPE_ERROR:
					                    value = curCell.getErrorCellValue()+"";
					                    break;
					                    
					                default:
					                	value = new String();
										break;
					                }
									
									// 현재 column index에 따라서 vo에 입력
									switch (cellIndex) {
									case 0: // 아이디
										vo.setCompany_name(value);;
										break;
									case 1:
										vo.setCompany_address(value);;
										break;
									case 2:
										vo.setCompany_address(value);
										break;
									case 3:
										vo.setCc_area(value);
										break;
									case 4:
										vo.setCa_area(value);
										break;									
									case 5:
										vo.setCert_num(value);
										break;
									case 6:
										vo.setSocial_purpose_type(value);
										break;
									case 7:
										vo.setJi_date(value);
										break;									
									case 8:
										vo.setM_cert(value);
										break;
									case 9:
										vo.setCompany_type(value);
										break;
									case 10:
										vo.setJojik_type(value);
										break;
									case 11:
										vo.setEs_date(value);
										break;
									case 12:
										vo.setBm_number(value);
										break;
									case 13:
										vo.setCompany_bnum(value);
										break;
									case 14:
										vo.setCompany_jnum(value);
										break;
									case 15:
										vo.setUniq_num(value);
										break;
									case 16:
										vo.setCr_num(value);
										break;
									case 17:
										vo.setSud_nm(value);
										break;
									case 18:
										vo.setSud_num(value);
										break;
									case 19:
										vo.setBiz_detail(value);
										break;
									case 20:
										vo.setItem_gubun(value);
										break;
									case 21:
										vo.setItem_dru(value);
										break;
									case 22:
										vo.setItem_jru(value);
										break;
									case 23:
										vo.setIndustry_bunryu(value);
										break;
									case 24:
										vo.setCeo_nm(value);
										break;
									case 25:
										vo.setCeo_birth(value);
										break;
									case 26:
										vo.setPic(value);
										break;
									case 27:
										vo.setC_pos(value);
										break;
									case 28:
										vo.setHp_number(value);
										break;
									case 29:
										vo.setAreap_number(value);
										break;
									case 30:
										vo.setFax_number(value);
										break;
									case 31:
										vo.setEmail(value);
										break;
									case 32:
										vo.setHomepage(value);
										break;
									case 33:
										vo.setTotal_sales(value);
										break;
									case 34:
										vo.setOper_profit(value);
										break;
									case 35:
										vo.setIncome_term(value);
										break;
									case 36:
										vo.setTotal_labor(value);
										break;
									case 37:
										vo.setTotal_devel_sales(value);
										break;
									case 38:
										vo.setBasic_consalting(value);
										break;
									case 39:
										vo.setPro_consalting(value);
										break;
									case 40:
										vo.setSocial_people(value);
										break;
									case 41:
										vo.setProf_people(value);
										break;
									case 42:
										vo.setSalary_people(value);
										break;
									case 43:
										vo.setVul_people(value);
										break;
									default:
										break;
									}
								}
							}
							// cell 탐색 이후 vo 추가
							list.add(vo);
						}
					}
				}
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		} finally {
			try {
				// 사용한 자원은 finally에서 해제
				if( workbook!= null) workbook.close();
				if( fis!= null) fis.close();
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return list;
	}
	
}
