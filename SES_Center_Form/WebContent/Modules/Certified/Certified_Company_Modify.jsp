<%@ page import="java.io.*"%>
<%@ page import="java.net.*"%>
<%@ page import="java.text.*"%>
<%@ page import="java.text.DecimalFormat"%>
<%@ page import="java.util.*"%>
<%@ page import="java.util.Date"%>
<%@ page import="com.process.dm.*"%>
<%@ page import="com.process.sql.*"%>
<%@ page import="com.process.bl.*"%>
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
<link rel="stylesheet" href="../../css/bootstrap.css">
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
<div style="font-size:18px;"><b>기관정보</b></div>
<table width="100%" border="0" cellpadding="0" cellspacing="0" class="table">
<input type="hidden" id="seq_no" name="seq_no" value="<%=dm_certified_company.seq_no%>">
 <tr>
   <td>기관명: <input type="text" id="company_name" name="company_name" value="<%=dm_certified_company.company_name%>"></td>
   <td>주소: <input type="text" id="company_address" name="company_address" value="<%=dm_certified_company.company_address%>"></td>
 </tr>
 <tr>
   <td>우편번호: <input type="text" id="company_zip" name="company_zip" value="<%=dm_certified_company.company_zip%>"></td>
   <td>광역자치단체: <input type="text" id="company_zip" name="company_zip" value="<%=dm_certified_company.cc_area%>"></td>
 </tr>
 <tr>
   <td>관할관서: <input type="text" id="ca_area" name="ca_area" value="<%=dm_certified_company.ca_area%>"></td>
   <td>인증지정번호: <input type="text" id="cert_num" name="cert_num" value="<%=dm_certified_company.cert_num%>"></td>
 </tr>
 <tr>
   <td>사회적목적실현유형: <input type="text" id="spt" name="spt" value="<%=dm_certified_company.spt%>"></td>
   <td>지정일: <input type="text" id="ji_date" name="ji_date" value="<%=dm_certified_company.ji_date%>"></td>
 </tr>
 <tr>
   <td>인증유지현황: <input type="text" id="m_cert" name="m_cert" value="<%=dm_certified_company.m_cert%>"></td>
   <td>업체형태: <input type="text" id="company_type" name="company_type" value="<%=dm_certified_company.company_type%>"></td>
 </tr>
 <tr>
   <td>조직형태: <input type="text" id="jojik_type" name="jojik_type" value="<%=dm_certified_company.jojik_type%>"></td>
   <td>설립일: <input type="text" id="es_date" name="es_date" value="<%=dm_certified_company.es_date%>"></td>
 </tr>
  <tr>
   <td>사업장관리번호: <input type="text" id="bm_number" name="bm_number" value="<%=dm_certified_company.bm_number%>"></td>
   <td>사업자번호 본점: <input type="text" id="company_bnum" name="company_bnum" value="<%=dm_certified_company.company_bnum%>"></td>
 </tr>
 <tr>
   <td>사업자번호 지점(해당시 작성): <input type="text" id="company_jnum" name="company_jnum" value="<%=dm_certified_company.company_jnum%>"></td>
   <td>고유번호: <input type="text" id="uniq_num" name="uniq_num" value="<%=dm_certified_company.uniq_num%>"></td>
 </tr>
 <tr>
   <td>법인등록번호: <input type="text" id="cr_num" name="cr_num" value="<%=dm_certified_company.cr_num%>"></td>
   <td>사업단관련: <input type="text" id="sud_nm" name="sud_nm" value="<%=dm_certified_company.sud_nm%>"></td>
 </tr>
 <tr>
   <td>모법인등록번호: <input type="text" id="sud_num" name="sud_num" value="<%=dm_certified_company.sud_num%>"></td>
   <td>주요 사업내용: <input type="text" id="biz_detail" name="biz_detail" value="<%=dm_certified_company.biz_detail%>"></td>
 </tr>
<tr>
   <td>재화 및 서비스품목: <input type="text" id="item_gubun" name="item_gubun" value="<%=dm_certified_company.item_gubun%>"></td>
   <td>대분류: <input type="text" id="item_dru" name="item_dru" value="<%=dm_certified_company.item_dru%>"></td>
 </tr>
<tr>
   <td>중분류: <input type="text" id="item_jru" name="item_jru" value="<%=dm_certified_company.item_jru%>"></td>
   <td>업종분류: <input type="text" id="industry_bunryu" name="industry_bunryu" value="<%=dm_certified_company.industry_bunryu%>"></td>
 </tr>
<tr>
   <td>대표자: <input type="text" id="ceo_nm" name="ceo_nm" value="<%=dm_certified_company.ceo_nm%>"></td>
   <td>대표자 생년월일: <input type="text" id="ceo_birth" name="ceo_birth" value="<%=dm_certified_company.ceo_birth%>"></td>
 </tr>
<tr>
   <td>담당자: <input type="text" id="pic" name="pic" value="<%=dm_certified_company.pic%>"></td>
   <td>직위: <input type="text" id="c_pos" name="c_pos" value="<%=dm_certified_company.c_pos%>"></td>
 </tr>
<tr>
   <td>핸드폰: <input type="text" id="hp_number" name="hp_number" value="<%=dm_certified_company.hp_number%>"></td>
   <td>전화번호: <input type="text" id="areap_number" name="areap_number" value="<%=dm_certified_company.areap_number%>"></td>
 </tr>
<tr>
   <td>팩스번호: <input type="text" id="fax_number" name="fax_number" value="<%=dm_certified_company.fax_number%>"></td>
   <td>이메일: <input type="text" id="email" name="email" value="<%=dm_certified_company.email%>"></td>
 </tr>
<tr>
   <td>홈페이지: <input type="text" id="homepage" name="homepage" value="<%=dm_certified_company.homepage%>"></td>
   <td>등록일자: <input type="text" id="req_date" name="req_date" value="<%=dm_certified_company.req_date%>" readonly></td>
 </tr>
</table>
<div style="font-size:18px;"><b>재무정보</b></div>
<table width="100%" border="0" cellpadding="0" cellspacing="0" class="table">
<tr>
<td>매출액: 
<%
String [] total_sales_arr = new String [100];
int x = 0;
String total_sales_last1 = "";
String total_sales_last2 = "";

String total_sales = dm_certified_company.total_sales;
StringTokenizer st1 = new StringTokenizer(total_sales, "||");
if(!total_sales.equals("false")){
while(st1.hasMoreElements()){
	total_sales_arr[x] = st1.nextElement().toString();		
	total_sales_last1 = total_sales_arr[x].substring(0,4);
    total_sales_last2 = total_sales_arr[x].substring(4,total_sales_arr[x].length());    
	
%>
<select name="total_sales">
  <option value="<%=total_sales_last1%>"><%=total_sales_last1%></option>
</select>년
<input type="text" id="total_sales" name="total_sales" value="<%=total_sales_last2%>" readonly>(천원)
<%
 }
}
%>
</td>
</tr>
<tr>
<td>영업이익:
<%
String [] oper_profit_arr = new String [100];
int y = 0;
String oper_profit_last1 = "";
String oper_profit_last2 = "";

String oper_profit = dm_certified_company.oper_profit;
StringTokenizer st2 = new StringTokenizer(oper_profit, "||");
if(!oper_profit.equals("false")){
while(st2.hasMoreElements()){
	oper_profit_arr[y] = st2.nextElement().toString();	
	oper_profit_last1 = oper_profit_arr[y].substring(0,4);
	oper_profit_last2 = oper_profit_arr[y].substring(4,oper_profit_arr[y].length());
%>
<select name="oper_profit">
  <option value="<%=oper_profit_last1%>"><%=oper_profit_last1%></option>
</select>년
<input type="text" id="oper_profit" name="oper_profit" value="<%=oper_profit_last2%>" readonly>(천원)
<%
 }
}
%>
</td> 
</tr>
<tr>
   <td>당기순이익:
<%
String [] income_term_arr = new String [100];
int z = 0;
String income_term_last1 = "";
String income_term_last2 = "";

String income_term = dm_certified_company.income_term;
StringTokenizer st3 = new StringTokenizer(income_term, "||");
if(!income_term.equals("false")){
while(st3.hasMoreElements()){
	income_term_arr[z] = st3.nextElement().toString();	
	income_term_last1 = income_term_arr[z].substring(0,4);
	income_term_last2 = income_term_arr[z].substring(4,income_term_arr[z].length());
%>
<select name="income_term">
  <option value="<%=income_term_last1%>"><%=income_term_last1%></option>
</select>년
<input type="text" id="income_term" name="income_term" value="<%=income_term_last2%>" readonly>(천원)
<%
 }
}
%> 
   </td>
   </tr>
   <tr>
   <td>총노무비:
<%
String [] total_labor_arr = new String [100];
int a = 0;
String total_labor_last1 = "";
String total_labor_last2 = "";

String total_labor = dm_certified_company.total_labor;
StringTokenizer st4 = new StringTokenizer(total_labor, "||");
if(!total_labor.equals("false")){
while(st4.hasMoreElements()){
	total_labor_arr[a] = st4.nextElement().toString();	
	total_labor_last1 = total_labor_arr[a].substring(0,4);
	total_labor_last2 = total_labor_arr[a].substring(4,total_labor_arr[a].length());
%>
<select name="total_labor">
  <option value="<%=total_labor_last1%>"><%=total_labor_last1%></option>
</select>년
<input type="text" id="total_labor" name="total_labor" value="<%=total_labor_last2%>" readonly>(천원)
<%
 }
}
%>    
   </td>
 </tr>
<tr>
   <td>사업개발비 금액(백만원):
<%
String [] total_devel_sales_arr = new String [100];
int b = 0;
String total_devel_sales_last1 = "";
String total_devel_sales_last2 = "";

String total_devel_sales = dm_certified_company.total_devel_sales;
StringTokenizer st5 = new StringTokenizer(total_devel_sales, "||");
if(!total_devel_sales.equals("false")){
while(st5.hasMoreElements()){
	total_devel_sales_arr[b] = st5.nextElement().toString();	
	total_devel_sales_last1 = total_devel_sales_arr[b].substring(0,4);
	total_devel_sales_last2 = total_devel_sales_arr[b].substring(4,total_devel_sales_arr[b].length());
%>
<select name="total_devel_sales">
  <option value="<%=total_devel_sales_last1%>"><%=total_devel_sales_last1%></option>
</select>년
<input type="text" id="total_devel_sales" name="total_devel_sales" value="<%=total_devel_sales_last2%>" readonly>(백만원)
<%
 }
}
%> 
   </td>
   </tr>
   <tr>
   <td>기초컨설팅 금액:
<%
String [] basic_consalting_arr = new String [100];
int c = 0;
String basic_consalting_last1 = "";
String basic_consalting_last2 = "";

String basic_consalting = dm_certified_company.basic_consalting;
StringTokenizer st6 = new StringTokenizer(basic_consalting, "||");
if(!basic_consalting.equals("false")){
while(st6.hasMoreElements()){
	basic_consalting_arr[c] = st6.nextElement().toString();	
	basic_consalting_last1 = basic_consalting_arr[c].substring(0,4);
	basic_consalting_last2 = basic_consalting_arr[c].substring(4,basic_consalting_arr[c].length());
%>
<select name="basic_consalting">
  <option value="<%=basic_consalting_last1%>"><%=basic_consalting_last1%></option>
</select>년
<input type="text" id="basic_consalting" name="basic_consalting" value="<%=basic_consalting_last2%>" readonly>
<%
 }
}
%> 
   </td>
 </tr>
<tr>
   <td>전문컨설팅 금액:
<%
String [] pro_consalting_arr = new String [100];
int d = 0;
String pro_consalting_last1 = "";
String pro_consalting_last2 = "";

String pro_consalting = dm_certified_company.pro_consalting;
StringTokenizer st7 = new StringTokenizer(pro_consalting, "||");
if(!pro_consalting.equals("false")){
while(st7.hasMoreElements()){
	pro_consalting_arr[d] = st7.nextElement().toString();	
	pro_consalting_last1 = pro_consalting_arr[d].substring(0,4);
	pro_consalting_last2 = pro_consalting_arr[d].substring(4,pro_consalting_arr[d].length());
%>
<select name="pro_consalting">
  <option value="<%=pro_consalting_last1%>"><%=pro_consalting_last1%></option>
</select>년
<input type="text" id="pro_consalting" name="pro_consalting" value="<%=pro_consalting_last2%>" readonly>
<%
 }
}
%>     
   </td>
   </tr>
 </table>
<div style="font-size:18px;"><b>인원정보</b></div>
<table width="100%" border="0" cellpadding="0" cellspacing="0" class="table">
   <tr>
   <td>사회적일자리배정인원:
<%
String [] social_people_arr = new String [100];
int e = 0;
String social_people_last1 = "";
String social_people_last2 = "";

String social_people = dm_certified_company.social_people;
StringTokenizer st8 = new StringTokenizer(social_people, "||");
if(!social_people.equals("false")){
while(st8.hasMoreElements()){
	social_people_arr[e] = st8.nextElement().toString();	
	social_people_last1 = social_people_arr[e].substring(0,4);
	social_people_last2 = social_people_arr[e].substring(4,social_people_arr[e].length());
%>
<select name="social_people">
  <option value="<%=social_people_last1%>"><%=social_people_last1%></option>
</select>년
<input type="text" id="social_people" name="social_people" value="<%=social_people_last2%>" readonly>명
<%
 }
}
%>  
   </td>
 </tr>
<tr>
   <td>전문인력배정인원(명):
<%
String [] prof_people_arr = new String [100];
int f = 0;
String prof_people_last1 = "";
String prof_people_last2 = "";

String prof_people = dm_certified_company.prof_people;
StringTokenizer st9 = new StringTokenizer(prof_people, "||");
if(!prof_people.equals("false")){
while(st9.hasMoreElements()){
	prof_people_arr[f] = st9.nextElement().toString();	
	prof_people_last1 = prof_people_arr[f].substring(0,4);
	prof_people_last2 = prof_people_arr[f].substring(4,prof_people_arr[f].length());
%>
<select name="prof_people">
  <option value="<%=prof_people_last1%>"><%=prof_people_last1%></option>
</select>년
<input type="text" id="prof_people" name="prof_people" value="<%=prof_people_last2%>" readonly>명
<%
 }
}
%>    
   </td>
   </tr>
   <tr>
   <td>유급근로자수(명):
<%
String [] salary_people_arr = new String [100];
int g = 0;
String salary_people_last1 = "";
String salary_people_last2 = "";

String salary_people = dm_certified_company.salary_people;
StringTokenizer st10 = new StringTokenizer(salary_people, "||");
if(!salary_people.equals("false")){
while(st10.hasMoreElements()){
	salary_people_arr[g] = st10.nextElement().toString();	
	salary_people_last1 = salary_people_arr[g].substring(0,4);
	salary_people_last2 = salary_people_arr[g].substring(4,salary_people_arr[g].length());
%>
<select name="salary_people">
  <option value="<%=salary_people_last1%>"><%=salary_people_last1%></option>
</select>년
<input type="text" id="salary_people" name="salary_people" value="<%=salary_people_last2%>" readonly>명
<%
 }
}
%> 
    </td>
 </tr>
<tr>
   <td>취약계층근로자수(명):
   <%
String [] vul_people_arr = new String [100];
int h = 0;
String vul_people_last1 = "";
String vul_people_last2 = "";

String vul_people = dm_certified_company.vul_people;
StringTokenizer st11 = new StringTokenizer(vul_people, "||");
if(!vul_people.equals("false")){
while(st11.hasMoreElements()){
	vul_people_arr[h] = st11.nextElement().toString();	
	vul_people_last1 = vul_people_arr[h].substring(0,4);
	vul_people_last2 = vul_people_arr[h].substring(4,vul_people_arr[h].length());
%>
<select name="vul_people">
  <option value="<%=vul_people_last1%>"><%=vul_people_last1%></option>
</select>년
<input type="text" id="vul_people" name="vul_people" value="<%=vul_people_last2%>" readonly>명
<%
 }
}
%>     
   </td>
 </tr>
</table>
</form>
<table align="center">
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