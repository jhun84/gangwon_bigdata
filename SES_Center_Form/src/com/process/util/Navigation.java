package com.process.util;

public class Navigation
{

    /**
     * 인자값을 받아서 페이지 네비게이션을 출력 해준다.
     *
     * @param   int total       (총카운트 - 총건수)
     * @param   int pageNo      (페이지 번호)
     * @param   int pageSize    (페이지 사이즈 - row)
     * @param   int listSize    (리스트 사이즈)
     * @return  String
     *

     */

    public static String getPageNavi(int total, int pageNo, int pageSize, int listSize, String img_url)
    {

        StringBuffer sb = new StringBuffer();

        int totalEnd = total / pageSize;

        if( ( total % pageSize ) != 0 )
        {
            ++totalEnd;
        }

        int startPage  = ( ( pageNo - 1) / listSize ) * listSize + 1;
        int endPageTmp = startPage + listSize - 1;
        int endPage    = ( totalEnd > endPageTmp ) ? endPageTmp : totalEnd;
        int previous   = ( startPage == 1 ) ? 0 : ( startPage - 1 );
        int next       = ( totalEnd > endPage ) ? ( endPage + 1 ) : 0;
				
				System.out.println("   d    "+startPage+"      d     "+endPageTmp+"    d    "+endPage+"   d    "+total+"   d    "+  totalEnd +"    "+pageSize);
        if (previous != 0)
        {
            sb.append("<a href=\"javascript:Navigation('" + previous + "');\"><IMG SRC=\"" + img_url+ "/images/Parrow02.gif\" border=0></font></a>&nbsp;");
        }


        for(int index = startPage ; index <= endPage ; index++)
        {
            if (index == pageNo)
            {
                sb.append("<B>" + index + "</B>" );
            }
            else
            {
                sb.append("<a href=\"javascript:Navigation('" + index + "');\">" + index + "</a>");
            }

			if (index != endPage)
			{
				sb.append("&nbsp;|&nbsp;");
			}
        }


        if( next != 0 )
        {
            sb.append("&nbsp;<a href=\"javascript:Navigation('" + next+ "');\"> <IMG SRC=\"" + img_url+ "/images/Parrow01.gif\" border=0></font></a></a>");
        }

        return sb.toString();

    } // End of getPageNavi

    public static String getPageNaviMain(int total, int pageNo, int pageSize, int listSize, String img_url)
    {

        StringBuffer sb = new StringBuffer();

        int totalEnd = total / pageSize;

        if( ( total % pageSize ) != 0 )
        {
            ++totalEnd;
        }

        int startPage  = ( ( pageNo - 1) / listSize ) * listSize + 1;
        int endPageTmp = startPage + listSize - 1;
        int endPage    = ( totalEnd > endPageTmp ) ? endPageTmp : totalEnd;
        int previous   = ( startPage == 1 ) ? 0 : ( startPage - 1 );
        int next       = ( totalEnd > endPage ) ? ( endPage + 1 ) : 0;

        if (previous != 0)
        {
                    sb.append("<td width=\"20\"><a href=\"javascript:Navigation('" + previous + "');\"><img src=\"/images/bullet_list01.gif\"></a></td>");
                    sb.append("<td align=\"center\">");
        }else{
                    sb.append("<td width=\"20\"><img src=\"/images/bullet_list01.gif\"></td>");
                    sb.append("<td align=\"center\">");		
		}


        for(int index = startPage ; index <= endPage ; index++)
        {
            if (index == pageNo)
            {
                sb.append("<B>" + index + "</B>" );
            }
            else
            {
                sb.append("<a href=\"javascript:Navigation('" + index + "');\">" + index + "</a>");
            }

			if (index != endPage)
			{
				sb.append("&nbsp;|&nbsp;");
			}
        }


        if( next != 0 )
        {
                    sb.append("<td width=\"20\"><a href=\"javascript:Navigation('" + next+ "');\"><img src=\"/images/bullet_list02.gif\"></a></td>");

        }else{
                    sb.append("<td width=\"20\"><img src=\"/images/bullet_list02.gif\"></td>");
		}

        return sb.toString();

    } // End of getPageNavi

    public static String getPageNavi2(int total, int pageNo, int pageSize, int listSize, String img_url)
    {

        StringBuffer sb = new StringBuffer();

        int totalEnd = total / pageSize;

        if( ( total % pageSize ) != 0 )
        {
            ++totalEnd;
        }

        int startPage  = ( ( pageNo - 1) / listSize ) * listSize + 1;
        int endPageTmp = startPage + listSize - 1;
        int endPage    = ( totalEnd > endPageTmp ) ? endPageTmp : totalEnd;
        int previous   = ( startPage == 1 ) ? 0 : ( startPage - 1 );
        int next       = ( totalEnd > endPage ) ? ( endPage + 1 ) : 0;

        if (previous != 0)
        {
            sb.append("<a href=\"javascript:Navigation2('" + previous + "');\"><IMG SRC=\"" + img_url+ "/images/Parrow02.gif\" border=0></font></a>&nbsp;");
        }


        for(int index = startPage ; index <= endPage ; index++)
        {
            if (index == pageNo)
            {
                sb.append("<B>" + index + "</B>" );
            }
            else
            {
                sb.append("<a href=\"javascript:Navigation2('" + index + "');\">" + index + "</a>");
            }

			if (index != endPage)
			{
				sb.append("&nbsp;|&nbsp;");
			}
        }


        if( next != 0 )
        {
            sb.append("&nbsp;<a href=\"javascript:Navigation2('" + next+ "');\"> <IMG SRC=\"" + img_url+ "/images/Parrow01.gif\" border=0></font></a></a>");
        }

        return sb.toString();

    } // End of getPageNavi

    /**
     * 인자값을 받아서 페이지 네비게이션을 출력 해준다.(프론트 페이지용)
     *
     * @param   int total       (총카운트 - 총건수)
     * @param   int pageNo      (페이지 번호)
     * @param   int pageSize    (페이지 사이즈 - row)
     * @param   int listSize    (리스트 사이즈)
     * @return  String
     *
     * @auth    : Kwon Joon Tek
     * @since   : 2004/10/13
    */
    public static String getPageNaviFront(int total, int pageNo, int pageSize, int listSize, String img_url)
    {

	return getPageNaviHelp(total, pageNo, pageSize,  listSize,  img_url);
		
	} // End of getPageNaviFront


    /**
     * 인자값을 받아서 페이지 네비게이션을 출력 해준다.(프론트 페이지용)
     *
     * @param   int total       (총카운트 - 총건수)
     * @param   int pageNo      (페이지 번호)
     * @param   int pageSize    (페이지 사이즈 - row)
     * @param   int listSize    (리스트 사이즈)
     * @param   String img_url    (이미지 경로)
     * @param   String tp    (이미지)
     * @return  String
     *
     * @auth    : 안장식
     * @since   : 2004/10/13
    */
    public static String getPageNaviFront(int total, int pageNo, int pageSize, int listSize, String img_url, String tp)
    {

		StringBuffer sb = new StringBuffer();
		
		if(total != 0)
		{
			int totalEnd = total / pageSize;
			
			if( ( total % pageSize ) != 0 )
			{
			    ++totalEnd;
			}
			
			int startPage  = ( ( pageNo - 1) / listSize ) * listSize + 1;
			int endPageTmp = startPage + listSize - 1;
			int endPage    = ( totalEnd > endPageTmp ) ? endPageTmp : totalEnd;
			int previous   = pageNo - 1; 
			int next       = pageNo + 1;
			
			if(pageNo <= 1)
			{
			    sb.append("<IMG SRC=\"" + img_url+ "/img/com/btn_pprev" + tp + ".gif\" width=\"16\" height=\"11\">&nbsp;");
			    sb.append("<IMG SRC=\"" + img_url+ "/img/com/btn_prev" + tp + ".gif\" width=\"33\" height=\"11\">&nbsp;&nbsp;");
			}
			else
			{
			    sb.append("<a href=\"javascript:Navigation('1');\"><IMG SRC=\"" + img_url+ "/img/com/btn_pprev" + tp + ".gif\" width=\"16\" height=\"11\" border=0></a>&nbsp;");
			    sb.append("<a href=\"javascript:Navigation('" + previous + "');\"><IMG SRC=\"" + img_url+ "/img/com/btn_prev" + tp + ".gif\" width=\"33\" height=\"11\" border=0></a>&nbsp;&nbsp;");
			}
			
			for(int index = startPage ; index <= endPage ; index++)
			{
				if (index == pageNo)
				{
					sb.append("<b>" +  index + "</b>&nbsp;&nbsp;");
				}
				else
				{
		        	sb.append("<a href=\"javascript:Navigation('" + index + "');\">" + index + "</a>&nbsp;&nbsp;");
				}
			}
			
			if(pageNo >= totalEnd)
			{
			    sb.append("<IMG SRC=\"" + img_url+ "/img/com/btn_next" + tp + ".gif\" width=\"32\" height=\"11\">");
			    sb.append("&nbsp;<IMG SRC=\"" + img_url+ "/img/com/btn_nnext" + tp + ".gif\" width=\"16\" height=\"11\">");
			}
			else
			{
			    sb.append("<a href=\"javascript:Navigation('" + next + "');\"><IMG SRC=\"" + img_url+ "/img/com/btn_next" + tp + ".gif\" width=\"32\" height=\"11\" border=0></a>");
			    sb.append("&nbsp;<a href=\"javascript:Navigation('" + totalEnd + "');\"><IMG SRC=\"" + img_url+ "/img/com/btn_nnext" + tp + ".gif\" width=\"16\" height=\"11\" border=0></a>");
			}
		}
		else
		{
			sb.append("");
		}
		
		return sb.toString();
		
	} // End of getPageNaviFront
    /**
     * 인자값을 받아서 페이지 네비게이션을 출력 해준다.(프론트 페이지용)
     *
     * @auth    : 위의 페이지네비게이션 2차판
     * @since   : 2004/03/08
    */
    public static String getPageNaviHelp(int total, int pageNo, int pageSize, int listSize, String img_url)
    {

		StringBuffer sb = new StringBuffer();
		
		if(total != 0)
		{
			int totalEnd = total / pageSize;
			
			if( ( total % pageSize ) != 0 )
			{
			    ++totalEnd;
			}
			
			int startPage  = ( ( pageNo - 1) / listSize ) * listSize + 1;
			int endPageTmp = startPage + listSize - 1;
			int endPage    = ( totalEnd > endPageTmp ) ? endPageTmp : totalEnd;
			int previous   = pageNo - 1; 
			int next       = pageNo + 1;
			
			if(pageNo <= 1)
			{
				//sb.append("<IMG SRC=\"" + img_url+ "/img/common/btn_pprev" + tp + ".gif\" width=\"16\" height=\"11\">&nbsp;");
				sb.append("<IMG SRC=\"" + img_url+ "/img/common/pre.gif\" width=\"33\" height=\"11\" valign=\"absmiddle\">&nbsp;&nbsp;");
			}
			else
			{
				//sb.append("<a href=\"javascript:Navigation('1');\"><IMG SRC=\"" + img_url+ "/img/common/btn_pprev" + tp + ".gif\" width=\"16\" height=\"11\" border=0></a>&nbsp;");
				sb.append("<a href=\"javascript:Navigation('" + previous + "');\" onfocus='blur();' class='num'><IMG SRC=\"" + img_url+ "/img/common/pre.gif\" width=\"33\" height=\"11\" border=0 valign=\"absmiddle\"></a>&nbsp;&nbsp;");
			}
			
			for(int index = startPage ; index <= endPage ; index++)
			{
				if (index == pageNo)
				{
					sb.append("<b>" +  index + "</b>&nbsp;&nbsp;");
				}
				else
				{
		        	sb.append("<a href=\"javascript:Navigation('" + index + "');\" onfocus='blur();' class='num'>" + index + "</a>&nbsp;&nbsp;");
				}
			}
			
			if(pageNo >= totalEnd)
			{
			    sb.append("<IMG SRC=\"" + img_url+ "/img/common/next.gif\" width=\"32\" height=\"11\" valign=\"absmiddle\">");
				//sb.append("&nbsp;<IMG SRC=\"" + img_url+ "/img/common/btn_nnext" + tp + ".gif\" width=\"16\" height=\"11\">");
			}
			else
			{
			    sb.append("<a href=\"javascript:Navigation('" + endPage + "');\" onfocus='blur();'><IMG SRC=\"" + img_url+ "/img/common/next.gif\" width=\"32\" height=\"11\" border=0 valign=\"absmiddle\"></a>");//next
				//sb.append("&nbsp;<a href=\"javascript:Navigation('" + totalEnd + "');\"><IMG SRC=\"" + img_url+ "/img/common/btn_nnext" + tp + ".gif\" width=\"16\" height=\"11\" border=0></a>");
			}
		}
		else
		{
			sb.append("");
		}
		
		return sb.toString();
		
	} // End of getPageNaviFront
}
