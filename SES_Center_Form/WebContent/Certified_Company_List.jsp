<%@ page import="java.io.*"%>
<%@ page import="java.net.*"%>
<%@ page import="java.text.*"%>
<%@ page import="java.text.DecimalFormat"%>
<%@ page import="java.util.*"%>
<%@ page import="java.util.Date"%>
<%@ page import="com.process.dm.*"%>
<%@ page import="com.process.sql.*"%>
<%
        ArrayList           dataList            = new ArrayList();
		BLAD_CERTIFIED bl = new BLAD_CERTIFIED();
		dataList = bl.getCertified_Company_List();
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
<title>Insert title here</title>
</head>
<body>
<table width="100%" style="border-collapse:collapse;">
 <tr>
   <td style="border:1px solid #eee">조직유형</td>
   <td style="border:1px solid #eee">인증연도</td>
   <td style="border:1px solid #eee">지역</td>
   <td style="border:1px solid #eee">기관명</td>
   <td style="border:1px solid #eee">대표자</td>
   <td style="border:1px solid #eee">등록일</td>
 
<%
for(int i = 0; i < iter; i++) {
	dm_certified_company = new DM_CERTIFIED_COMPANY();
	dm_certified_company = (DM_CERTIFIED_COMPANY)dataList.get(i);
%>
 </tr>
 <tr>
   <td style="border:1px solid #eee"><%=dm_certified_company.jojik_type %></td>
   <td style="border:1px solid #eee"><%=dm_certified_company.ji_date %></td>
   <td style="border:1px solid #eee"><%=dm_certified_company.ca_area %></td>
   <td style="border:1px solid #eee"><%=dm_certified_company.company_name %></td>
   <td style="border:1px solid #eee"><%=dm_certified_company.ceo_nm %></td>
   <td style="border:1px solid #eee"><%=dm_certified_company.req_date.substring(0,10) %></td>
<%
}
}
%>
</tr>
</table>
</body>
</html>
