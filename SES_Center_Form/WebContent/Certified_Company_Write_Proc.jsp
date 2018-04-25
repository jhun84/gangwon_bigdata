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
System.out.println("update_proc seq_no="+seq_no);
String company_name = request.getParameter("company_name");
String company_address = request.getParameter("company_address");
String company_zip = request.getParameter("company_zip");
String cc_area = request.getParameter("cc_area");
String ca_area = request.getParameter("ca_area");
String cert_num = request.getParameter("cert_num");
String spt = request.getParameter("spt");
String ji_date = request.getParameter("ji_date");
String m_cert = request.getParameter("m_cert");
String company_type = request.getParameter("company_type");
String jojik_type = request.getParameter("jojik_type");
String es_date = request.getParameter("es_date");
String bm_number = request.getParameter("bm_number");
String company_bnum = request.getParameter("company_bnum");
String company_jnum = request.getParameter("company_jnum");
String uniq_num = request.getParameter("uniq_num");
String cr_num = request.getParameter("cr_num");
String sud_nm = request.getParameter("sud_nm");
String sud_num = request.getParameter("sud_num");
String biz_detail = request.getParameter("biz_detail");
String item_gubun = request.getParameter("item_gubun");
String item_dru = request.getParameter("item_dru");
String item_jru = request.getParameter("item_jru");
String industry_bunryu = request.getParameter("industry_bunryu");
String ceo_nm = request.getParameter("ceo_nm");
String ceo_birth = request.getParameter("ceo_birth");
String pic = request.getParameter("pic");
String c_pos = request.getParameter("c_pos");
String hp_number = request.getParameter("hp_number");
String areap_number = request.getParameter("areap_number");
String fax_number = request.getParameter("fax_number");
String email = request.getParameter("email");
String req_date = request.getParameter("req_date");
String homepage = request.getParameter("homepage");
String total_sales = request.getParameter("total_sales");
String oper_profit = request.getParameter("oper_profit");
String income_term = request.getParameter("income_term");
String total_labor = request.getParameter("total_labor");
String total_devel_sales = request.getParameter("total_devel_sales");
String basic_consalting = request.getParameter("basic_consalting");
String pro_consalting = request.getParameter("pro_consalting");
String social_people = request.getParameter("social_people");
String prof_people = request.getParameter("prof_people");
String salary_people = request.getParameter("salary_people");
String vul_people = request.getParameter("vul_people");

DM_CERTIFIED_COMPANY mod_info = new DM_CERTIFIED_COMPANY();
BLAD_CERTIFIED bl = new BLAD_CERTIFIED();
String result = "";

mod_info.seq_no = seq_no;
mod_info.company_name       =  company_name;
mod_info.company_address    =  company_address;
mod_info.company_zip        =  company_zip;
mod_info.cc_area            =  cc_area;
mod_info.ca_area            =  ca_area;
mod_info.cert_num           =  cert_num;
mod_info.spt                =  spt;
mod_info.ji_date            =  ji_date;
mod_info.m_cert             =  m_cert;
mod_info.company_type       =  company_type;
mod_info.jojik_type         =  jojik_type;
mod_info.es_date            =  es_date;
mod_info.bm_number          =  bm_number;
mod_info.company_bnum       =  company_bnum;
mod_info.company_jnum       =  company_jnum;
mod_info.uniq_num           =  uniq_num;
mod_info.cr_num             =  cr_num;
mod_info.sud_nm             =  sud_nm;
mod_info.sud_num            =  sud_num;
mod_info.biz_detail         =  biz_detail;
mod_info.item_gubun         =  item_gubun;
mod_info.item_dru           =  item_dru;
mod_info.item_jru           =  item_jru;
mod_info.industry_bunryu    =  industry_bunryu;
mod_info.ceo_nm             =  ceo_nm;
mod_info.ceo_birth          =  ceo_birth;
mod_info.pic                =  pic;
mod_info.c_pos              =  c_pos;
mod_info.hp_number          =  hp_number;
mod_info.areap_number       =  areap_number;
mod_info.fax_number         =  fax_number;
mod_info.email              =  email;
mod_info.req_date           =  req_date;
mod_info.homepage           =  homepage;
mod_info.total_sales        =  total_sales;
mod_info.oper_profit        =  oper_profit;
mod_info.income_term        =  income_term;
mod_info.total_labor        =  total_labor;
mod_info.total_devel_sales  =  total_devel_sales;
mod_info.basic_consalting   =  basic_consalting;
mod_info.pro_consalting     =  pro_consalting;
mod_info.social_people      =  social_people;
mod_info.prof_people        =  prof_people;
mod_info.salary_people      =  salary_people;
mod_info.vul_people         =  vul_people;

result = bl.CERTIFIED_COMPANY_INSERT(mod_info);
System.out.println("write_result="+result);

%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html>