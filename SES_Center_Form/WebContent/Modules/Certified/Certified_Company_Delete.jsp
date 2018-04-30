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
String result = "";        

BLAD_CERTIFIED bl = new BLAD_CERTIFIED();
result = bl.CERTIFIED_COMPANY_DELETE(seq_no);
		
if(result.equals("SUCC")){
					
%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script>
function succ_proc(){
	alert("삭제가 완료 되었습니다.");
	location.href="Certified_Company_List.jsp";
}
</script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<script>
 succ_proc();
</script>
</body>
</html>
<%
}
%>