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
int page_no = 1;
int page_size = 100;
        ArrayList           dataList            = new ArrayList();
		BLAD_CERTIFIED bl = new BLAD_CERTIFIED();
		dataList = bl.getCertified_Company_List(page_no,page_size);
		DM_CERTIFIED_COMPANY dm_certified_company = new DM_CERTIFIED_COMPANY();
		
		int iter = 0;
		iter = dataList.size();
		
		if (iter > 0) {
%>		
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript">
function viewCompanyInfo(seq_no){
	location.href="Certified_Company_View.jsp?seq_no="+seq_no;
}
</script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>사회적인증기업현황</title>
<link rel="stylesheet" href="../../css/bootstrap.css">
</head>
<body>
<table width="100%" class="table">
<thead>
 <tr>
   <th>조직유형</th>
   <th>인증연도</th>
   <th>지역</th>
   <th>기관명</th>
   <th>대표자</th>
   <th>등록일</th>
<%
for(int i = 0; i < iter; i++) {
	dm_certified_company = new DM_CERTIFIED_COMPANY();
	dm_certified_company = (DM_CERTIFIED_COMPANY)dataList.get(i);
%>
 </tr>
</thead>
<tbody>
 <tr>
   <td><%=dm_certified_company.jojik_type %></td>
   <td><%=dm_certified_company.ji_date %></td>
   <td><%=dm_certified_company.ca_area %></td>
   <td><a href="javascript:viewCompanyInfo('<%=dm_certified_company.seq_no%>')"><%=dm_certified_company.company_name %></a></td>
   <td><%=dm_certified_company.ceo_nm %></td>
   <td><%=dm_certified_company.req_date.substring(0,10) %></td>
<%
  }
}
%>
</tr>
</tbody>
</table>
<a class="btn btn-default pull-right" href="Certified_Company_Write.jsp">글쓰기</a>
<script type="text/javascript" src="../../js/jquery-3.1.1.js"></script>
<script type="text/javascript" src="../../js/bootstrap.js"></script>
</body>
</html>
