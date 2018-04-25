<%@ page import="java.io.*"%>
<%@ page import="java.net.*"%>
<%@ page import="java.text.*"%>
<%@ page import="java.text.DecimalFormat"%>
<%@ page import="java.util.*"%>
<%@ page import="java.util.Date"%>
<%@ page import="com.process.dm.*"%>
<%@ page import="com.process.sql.*"%>
<%
String seq_no = request.getParameter("seq_no");
System.out.println(seq_no);
        ArrayList           dataList            = new ArrayList();
		BLAD_CERTIFIED bl = new BLAD_CERTIFIED();
		dataList = bl.getCertified_Company_Info(seq_no);
		DM_CERTIFIED_COMPANY dm_certified_company = new DM_CERTIFIED_COMPANY();
		
		int iter = 0;
		iter = dataList.size();
		
		if (iter > 0) {
							
%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>사회적인증기업현황</title>
<link rel="stylesheet" href="css/bootstrap.css">
<script>
function update_proc(){
	document.certified_form.action = "Certified_Company_Modify_Proc.jsp"
	document.certified_form.submit();
}
</script>
</head>
<body>
<%
for(int i = 0; i < iter; i++) {
				dm_certified_company = new DM_CERTIFIED_COMPANY();
				dm_certified_company = (DM_CERTIFIED_COMPANY)dataList.get(i);
%>
<form id="certified_form" name="certified_form">
<table width="100%" border="0" cellpadding="0" cellspacing="0" class="table">
<input type="hidden" id="seq_no" name="seq_no" value="<%=dm_certified_company.seq_no%>">
 <tr>
   <td>기관명: <input type="text" id="company_name" name="company_name" value="<%=dm_certified_company.company_name%>"></td>
 </tr>
 <tr>
   <td>주소: <input type="text" id="company_address" name="company_address" value="<%=dm_certified_company.company_address%>"></td>
 </tr>
 <tr>
   <td>우편번호: <input type="text" id="company_zip" name="company_zip" value=" <%=dm_certified_company.company_zip%>"></td>
 </tr>
 <tr>
   <td>광역자치단체: <input type="text" id="cc_area" name="cc_area" value="<%=dm_certified_company.cc_area%>"></td>
 </tr>
 <tr>
   <td>관할관서: <input type="text" id="ca_area" name="ca_area" value="<%=dm_certified_company.ca_area%>"></td>
 </tr>
 <tr>
   <td>인증지정번호: <input type="text" id="cert_num" name="cert_num" value="<%=dm_certified_company.cert_num%>"></td>
 </tr>
 <tr>
   <td>사회적목적실현유형: <input type="text" id="spt" name="spt" value="<%=dm_certified_company.spt%>"></td>
 </tr>
 <tr>
   <td>지정일: <input type="text" id="ji_date" name="ji_date" value="<%=dm_certified_company.ji_date%>"></td>
 </tr>
 <tr>
   <td>인증유지현황: <input type="text" id="m_cert" name="m_cert" value="<%=dm_certified_company.m_cert%>"></td>
 </tr>
 <tr>
   <td>업체형태: <input type="text" id="company_type" name="company_type" value="<%=dm_certified_company.company_type%>"></td>
 </tr>
 <tr>
   <td>조직형태: <input type="text" id="jojik_type" name="jojik_type" value="<%=dm_certified_company.jojik_type%>"></td>
 </tr>
 <tr>
   <td>설립일: <input type="text" id="es_date" name="es_date" value="<%=dm_certified_company.es_date%>"></td>
 </tr>
 <tr>
   <td>사업장관리번호: <input type="text" id="bm_number" name="bm_number" value="<%=dm_certified_company.bm_number%>"></td>
 </tr>
 <tr>
   <td>사업자번호 본점: <input type="text" id="company_bnum" name="company_bnum" value="<%=dm_certified_company.company_bnum%>"></td>
 </tr>
 <tr>
   <td>사업자번호 지점(해당시 작성): <input type="text" id="company_jnum" name="company_jnum" value="<%=dm_certified_company.company_jnum%>"></td>
 </tr>
 <tr>
   <td>고유번호: <input type="text" id="uniq_num" name="uniq_num" value="<%=dm_certified_company.uniq_num%>"></td>
 </tr>
 <tr>
   <td>법인등록번호: <input type="text" id="cr_num" name="cr_num" value="<%=dm_certified_company.cr_num%>"></td>
 </tr>
 <tr>
   <td>사업단관련: <input type="text" id="sud_nm" name="sud_nm" value="<%=dm_certified_company.sud_nm%>"></td>
 </tr>
<tr>
   <td>모법인등록번호: <input type="text" id="sud_num" name="sud_num" value="<%=dm_certified_company.sud_num%>"></td>
 </tr>
<tr>
   <td>주요 사업내용: <input type="text" id="biz_detail" name="biz_detail" value="<%=dm_certified_company.biz_detail%>"></td>
 </tr>
<tr>
   <td>재화 및 서비스품목: <input type="text" id="item_gubun" name="item_gubun" value="<%=dm_certified_company.item_gubun%>"></td>
 </tr>
<tr>
   <td>대분류: <input type="text" id="item_dru" name="item_dru" value="<%=dm_certified_company.item_dru%>"></td>
 </tr>
<tr>
   <td>중분류: <input type="text" id="item_jru" name="item_jru" value="<%=dm_certified_company.item_jru%>"></td>
 </tr>
<tr>
   <td>업종분류: <input type="text" id="industry_bunryu" name="industry_bunryu" value="<%=dm_certified_company.industry_bunryu%>"></td>
 </tr>
<tr>
   <td>대표자: <input type="text" id="ceo_nm" name="ceo_nm" value="<%=dm_certified_company.ceo_nm%>"></td>
 </tr>
<tr>
   <td>대표자 생년월일: <input type="text" id="ceo_birth" name="ceo_birth" value="<%=dm_certified_company.ceo_birth%>"></td>
 </tr>
<tr>
   <td>담당자: <input type="text" id="pic" name="pic" value="<%=dm_certified_company.pic%>"></td>
 </tr>
<tr>
   <td>직위: <input type="text" id="c_pos" name="c_pos" value="<%=dm_certified_company.c_pos%>"></td>
 </tr>
<tr>
   <td>핸드폰: <input type="text" id="hp_number" name="hp_number" value="<%=dm_certified_company.hp_number%>"></td>
 </tr>
<tr>
   <td>전화번호: <input type="text" id="areap_number" name="areap_number" value="<%=dm_certified_company.areap_number%>"></td>
 </tr>
<tr>
   <td>팩스번호: <input type="text" id="fax_number" name="fax_number" value="<%=dm_certified_company.fax_number%>"></td>
 </tr>
<tr>
   <td>이메일: <input type="text" id="email" name="email" value="<%=dm_certified_company.email%>"></td>
 </tr>
<tr>
   <td>홈페이지: <input type="text" id="homepage" name="homepage" value="<%=dm_certified_company.homepage%>"></td>
 </tr>
<tr>
<%
String data = dm_certified_company.total_sales;
System.out.println("StringTokenizer...");
StringTokenizer st = new StringTokenizer(data,"||");
while(st.hasMoreTokens()) System.out.println(st.nextToken());
%>
   <td>매출액(천원): <input type="text" id="total_sales" name="total_sales" value="<%=dm_certified_company.total_sales%>"></td>
 </tr>
<tr>
   <td>영업이익(천원): <input type="text" id="oper_profit" name="oper_profit" value="<%=dm_certified_company.oper_profit%>"></td>
 </tr>
<tr>
   <td>당기순이익(천원): <input type="text" id="income_term" name="income_term" value="<%=dm_certified_company.income_term%>"></td>
 </tr>
<tr>
   <td>총노무비(천원): <input type="text" id="total_labor" name="total_labor" value="<%=dm_certified_company.total_labor%>"></td>
 </tr>
<tr>
   <td>사업개발비 금액(백만원): <input type="text" id="total_devel_sales" name="total_devel_sales" value="<%=dm_certified_company.total_devel_sales%>"></td>
 </tr>
<tr>
   <td>기초컨설팅 금액: <input type="text" id="basic_consalting" name="basic_consalting" value="<%=dm_certified_company.basic_consalting%>"></td>
 </tr>
<tr>
   <td>전문컨설팅 금액: <input type="text" id="pro_consalting" name="pro_consalting" value="<%=dm_certified_company.pro_consalting%>"></td>
 </tr>
<tr>
   <td>사회적일자리배정인원(명): <input type="text" id="social_people" name="social_people" value="<%=dm_certified_company.social_people%>"></td>
 </tr>
<tr>
   <td>전문인력배정인원(명): <input type="text" id="prof_people" name="prof_people" value="<%=dm_certified_company.prof_people%>"></td>
 </tr>
<tr>
   <td>유급근로자수(명): <input type="text" id="salary_people" name="salary_people" value="<%=dm_certified_company.salary_people%>"></td>
 </tr>
<tr>
   <td>취약계층근로자수(명): <input type="text" id="vul_people" name="vul_people" value="<%=dm_certified_company.vul_people%>"></td>
 </tr>
</table>
</form>
<table align="left">
 <tr> 
   <td><a href="./Certified_Company_List.jsp">목록</a>&nbsp;&nbsp;</td>
   <td><a href="javascript:update_proc()">저장</a></td>   
 </tr>
</table>

<%
  }
}
%>
</body>
</html>