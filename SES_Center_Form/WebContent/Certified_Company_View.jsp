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
function Modify() {
	document.certified_form.action="Certified_Company_Modify.jsp"
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
   <td>seq_no: <%=dm_certified_company.seq_no%></td>
 </tr>
 <tr>
   <td>기관명: <%=dm_certified_company.company_name%></td>
 </tr>
 <tr>
   <td>주소: <%=dm_certified_company.company_address%></td>
 </tr>
 <tr>
   <td>우편번호: <%=dm_certified_company.company_zip%></td>
 </tr>
 <tr>
   <td>광역자치단체: <%=dm_certified_company.cc_area%></td>
 </tr>
 <tr>
   <td>관할관서: <%=dm_certified_company.ca_area%></td>
 </tr>
 <tr>
   <td>인증지정번호: <%=dm_certified_company.cert_num%></td>
 </tr>
 <tr>
   <td>사회적목적실현유형: <%=dm_certified_company.spt%></td>
 </tr>
 <tr>
   <td>지정일: <%=dm_certified_company.ji_date%></td>
 </tr>
 <tr>
   <td>인증유지현황: <%=dm_certified_company.m_cert%></td>
 </tr>
 <tr>
   <td>업체형태: <%=dm_certified_company.company_type%></td>
 </tr>
 <tr>
   <td>조직형태: <%=dm_certified_company.jojik_type%></td>
 </tr>
 <tr>
   <td>설립일: <%=dm_certified_company.es_date%></td>
 </tr>
 <tr>
   <td>사업장관리번호: <%=dm_certified_company.bm_number%></td>
 </tr>
 <tr>
   <td>사업자번호 본점: <%=dm_certified_company.company_bnum%></td>
 </tr>
 <tr>
   <td>사업자번호 지점(해당시 작성):<%=dm_certified_company.company_jnum%></td>
 </tr>
 <tr>
   <td>고유번호: <%=dm_certified_company.uniq_num%></td>
 </tr>
 <tr>
   <td>법인등록번호: <%=dm_certified_company.cr_num%></td>
 </tr>
 <tr>
   <td>사업단관련: <%=dm_certified_company.sud_nm%></td>
 </tr>
<tr>
   <td>모법인등록번호: <%=dm_certified_company.sud_num%></td>
 </tr>
<tr>
   <td>주요 사업내용: <%=dm_certified_company.biz_detail%></td>
 </tr>
<tr>
   <td>재화 및 서비스품목: <%=dm_certified_company.item_gubun%></td>
 </tr>
<tr>
   <td>대분류: <%=dm_certified_company.item_dru%></td>
 </tr>
<tr>
   <td>중분류: <%=dm_certified_company.item_jru%></td>
 </tr>
<tr>
   <td>업종분류: <%=dm_certified_company.industry_bunryu%></td>
 </tr>
<tr>
   <td>대표자: <%=dm_certified_company.ceo_nm%></td>
 </tr>
<tr>
   <td>대표자 생년월일: <%=dm_certified_company.ceo_birth%></td>
 </tr>
<tr>
   <td>담당자: <%=dm_certified_company.pic%></td>
 </tr>
<tr>
   <td>직위: <%=dm_certified_company.c_pos%></td>
 </tr>
<tr>
   <td>핸드폰: <%=dm_certified_company.hp_number%></td>
 </tr>
<tr>
   <td>전화번호: <%=dm_certified_company.areap_number%></td>
 </tr>
<tr>
   <td>팩스번호: <%=dm_certified_company.fax_number%></td>
 </tr>
<tr>
   <td>이메일: <%=dm_certified_company.email%></td>
 </tr>
<tr>
   <td>홈페이지: <%=dm_certified_company.homepage%></td>
 </tr>
<tr>
   <td>등록일자: <%=dm_certified_company.req_date%></td>
 </tr>
<tr>
<%
String data = dm_certified_company.total_sales;
System.out.println("StringTokenizer...");
StringTokenizer st = new StringTokenizer(data,"||");
while(st.hasMoreTokens()) System.out.println(st.nextToken());
%>
   <td>매출액(천원): <%=dm_certified_company.total_sales%></td>
 </tr>
<tr>
   <td>영업이익(천원): <%=dm_certified_company.oper_profit%></td>
 </tr>
<tr>
   <td>당기순이익(천원): <%=dm_certified_company.income_term%></td>
 </tr>
<tr>
   <td>총노무비(천원): <%=dm_certified_company.total_labor%></td>
 </tr>
<tr>
   <td>사업개발비 금액(백만원): <%=dm_certified_company.total_devel_sales%></td>
 </tr>
<tr>
   <td>기초컨설팅 금액: <%=dm_certified_company.basic_consalting%></td>
 </tr>
<tr>
   <td>전문컨설팅 금액: <%=dm_certified_company.pro_consalting%></td>
 </tr>
<tr>
   <td>사회적일자리배정인원(명): <%=dm_certified_company.social_people%></td>
 </tr>
<tr>
   <td>전문인력배정인원(명): <%=dm_certified_company.prof_people%></td>
 </tr>
<tr>
   <td>유급근로자수(명): <%=dm_certified_company.salary_people%></td>
 </tr>
<tr>
   <td>취약계층근로자수(명): <%=dm_certified_company.vul_people%></td>
 </tr>
</table>
<table align="left">
 <tr> 
   <td><a href="./Certified_Company_List.jsp">목록</a>&nbsp;&nbsp;</td>
   <td><a href="javascript:Modify()">수정</a></td>
 </tr>
</table>
</form>
<%
  }
}
%>
</body>
</html>