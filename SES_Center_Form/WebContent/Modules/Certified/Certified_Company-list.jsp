<%@ page import="java.io.*"%>
<%@ page import="java.net.*"%>
<%@ page import="java.text.*"%>
<%@ page import="java.text.DecimalFormat"%>
<%@ page import="java.util.*"%>
<%@ page import="java.util.Date"%>
<%@ page import="com.process.dm.*"%>
<%@ page import="com.process.sql.*"%>
<%@ page import="com.process.bl.*"%>
<%@ page import="com.process.util.*"%>
<%
int total_cnt = 50; 
int page_no = 1;
int page_size = 100;
int LIST_SIZE    = 10;   
String IMAGE_URL = "";
String search_word = "";

        ArrayList dataList = new ArrayList();
		BLAD_CERTIFIED bl = new BLAD_CERTIFIED();
		dataList = bl.getCertified_Company_List(page_no, page_size);
		DM_CERTIFIED_COMPANY dm_certified_company = new DM_CERTIFIED_COMPANY();
		
		int iter = 0;
		iter = dataList.size();
		
		if (iter > 0) {
%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
  <head>
    <meta charset="utf-8">
    <title>사회적경제 빅데이터 플랫폼</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">
<script type="text/javascript">
function viewCompanyInfo(seq_no){
	location.href="Certified_Company-view.jsp?seq_no="+seq_no;
}
</script>
    <!-- 스타일 -->
    <link href="../../css/bootstrap.css" rel="stylesheet">
    <style type="text/css">
      body {
        padding-top: 60px;
        padding-bottom: 40px;
      }
      .sidebar-nav {
        padding: 9px 0;
      }

      @media (max-width: 980px) {
        /* Enable use of floated navbar text */
        .navbar-text.pull-right {
          float: none;
          padding-left: 5px;
          padding-right: 5px;
        }
      }
    </style>
    <link href="../../css/bootstrap-responsive.css" rel="stylesheet">    
  </head>

  <body>

    <div class="navbar navbar-inverse navbar-fixed-top">
      <div class="navbar-inner">
        <div class="container-fluid">         
          <a class="brand" href="#">강원도 사회적경제 빅데이터 플랫폼</a>
          <div class="nav-collapse collapse">
            <p class="navbar-text pull-right">
              <a href="#" class="navbar-link">사용자명</a>으로 로그인됨
            </p>
            <ul class="nav">
              <li class="active"><a href="#">대문</a></li>
              <li><a href="#about">소개</a></li>
              <li><a href="#contact">연락처</a></li>
            </ul>
          </div><!--/.nav-collapse -->
        </div>
      </div>
    </div>

    <div class="container-fluid">
      <div class="row-fluid">
        <div class="span3">
          <div class="well sidebar-nav">
            <ul class="nav nav-list">
              <li class="nav-header">기업정보</li>
              <li><a href="#">인증사회적기업</a></li>
              <li><a href="#">예비사회적기업</a></li>
              <li><a href="#">마을기업</a></li>
              <li><a href="#">예비마을기업</a></li>
              <li><a href="#">자활기업</a></li>
              <li><a href="#">사회적협동조합</a></li>
              <li><a href="#">협동조합</a></li>
              <li><a href="#">육성사업_창업팀</a></li>
              <li><a href="#">육성사업_동아리</a></li>              
            </ul>
          </div><!--/.well -->
        </div><!--/span-->
        <div class="span9">
          <div class="hero-unit">
           <!-- 게시판삽입위치 -->
<table width="100%" class="table">
<thead>
 <tr style="background-color:rgba(192,192,192,0.3);">
   <th>조직유형</th>
   <th>인증연도</th>
   <th>지역</th>
   <th>기관명</th>
   <th>대표자</th>
   <th>등록일</th>
 </tr>
</thead>
<%
for(int i = 0; i < iter; i++) {
	dm_certified_company = new DM_CERTIFIED_COMPANY();
	dm_certified_company = (DM_CERTIFIED_COMPANY)dataList.get(i);
%>
<tbody>
 <tr>
   <td><%=dm_certified_company.jojik_type %></td>
   <td><%=dm_certified_company.ji_date %></td>
   <td><%=dm_certified_company.ca_area %></td>
   <td><a href="javascript:viewCompanyInfo('<%=dm_certified_company.seq_no%>')"><%=dm_certified_company.company_name %></a></td>
   <td><%=dm_certified_company.ceo_nm %></td>
   <td><%=dm_certified_company.req_date.substring(0,10) %></td>
</tr>
</tbody>
<%
  }
}
%>
</table>

<a class="btn btn-default pull-right" href="Certified_Company_Write.jsp">글쓰기</a>
<script type="text/javascript" src="../../js/jquery-3.1.1.js"></script>
<script type="text/javascript" src="../../js/bootstrap.js"></script>
           <!-- 게시판 END -->        
          </div>          
        </div><!--/span-->
      </div><!--/row-->

      <hr>

      <footer>
        <p>&copy; 사회적경제지원센터 2018</p>
      </footer>

    </div><!--/.fluid-container-->

    <!-- 자바스크립트
    ================================================== -->
    <!-- 페이지를 빨리 읽어들이도록 문서 마지막에 배치 -->
    <script src="../../js/jquery.js"></script>
    <script src="../../js/bootstrap-transition.js"></script>
    <script src="../../js/bootstrap-alert.js"></script>
    <script src="../../js/bootstrap-modal.js"></script>
    <script src="../../js/bootstrap-dropdown.js"></script>
    <script src="../../js/bootstrap-scrollspy.js"></script>
    <script src="../../js/bootstrap-tab.js"></script>
    <script src="../../js/bootstrap-tooltip.js"></script>
    <script src="../../js/bootstrap-popover.js"></script>
    <script src="../../js/bootstrap-button.js"></script>
    <script src="../../js/bootstrap-collapse.js"></script>
    <script src="../../js/bootstrap-carousel.js"></script>
    <script src="../../js/bootstrap-typeahead.js"></script>

  </body>
</html>
