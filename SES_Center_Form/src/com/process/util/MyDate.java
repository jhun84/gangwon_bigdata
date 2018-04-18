package com.process.util;
import java.util.Calendar;

public class MyDate{

    public Calendar c;
    public int YEAR ;
    public int MONTH ;
    public int DATE ;
    public int HOUR_OF_DAY ;
    public int MINUTE ;
    public int SECOND ;


    public MyDate()
    {
        this.c = Calendar.getInstance();
    }


    public String getYYMMDD()
    {
        String strYear, strMonth, strDay;

        YEAR  = c.get(c.YEAR);
        MONTH = c.get(c.MONTH) + 1;
        DATE  = c.get(c.DATE);

        strYear = Integer.toString( YEAR );

        if( MONTH < 10 ) {
            strMonth = "0" + Integer.toString( MONTH );
        } else {
            strMonth = Integer.toString( MONTH );
        }

        if( DATE < 10 ) {
            strDay = "0" + Integer.toString( DATE );
        } else {
            strDay = Integer.toString( DATE );
        }

        return ( strYear + "-" + strMonth + "-" +strDay );
    }


    public String getYYMMDD_non()
    {
        String strYear, strMonth, strDay;

        YEAR  = c.get(c.YEAR);
        MONTH = c.get(c.MONTH) + 1;
        DATE  = c.get(c.DATE);

        strYear = Integer.toString( YEAR );

        if( MONTH < 10 ) {
            strMonth = "0" + Integer.toString( MONTH );
        } else {
            strMonth = Integer.toString( MONTH );
        }

        if( DATE < 10 ) {
            strDay = "0" + Integer.toString( DATE );
        } else {
            strDay = Integer.toString( DATE );
        }

        return ( strYear + strMonth + strDay );
    }


    public String getYMDBFR()
    {
        String strYear, strMonth, strDay;

        YEAR  = c.get(c.YEAR);
        MONTH = c.get(c.MONTH) + 1;
        DATE  = c.get(c.DATE);

        MONTH = MONTH - 1 ;
        if (MONTH == 0) {
            MONTH = 12;
            YEAR  = YEAR -1;
        }

        strYear = Integer.toString( YEAR );

        if( MONTH < 10 ) {
            strMonth = "0" + Integer.toString( MONTH );
        } else {
            strMonth = Integer.toString( MONTH );
        }

        if( DATE < 10 ) {
            strDay = "0" + Integer.toString( DATE );
        } else {
            strDay = Integer.toString( DATE );
        }

        return ( strYear + "-" + strMonth + "-" + strDay );
    }


    public String getYMDBFR_non()
    {
        String strYear, strMonth, strDay;

        YEAR  = c.get(c.YEAR);
        MONTH = c.get(c.MONTH) + 1;
        DATE  = c.get(c.DATE);

        MONTH = MONTH - 1 ;
        if (MONTH ==0){
            MONTH = 12;
            YEAR  = YEAR -1;
        }

        strYear = Integer.toString( YEAR );

        if( MONTH < 10 ) {
            strMonth = "0" + Integer.toString( MONTH );
        } else {
            strMonth = Integer.toString( MONTH );
        }

        if( DATE < 10 ) {
            strDay = "0" + Integer.toString( DATE );
        } else {
            strDay = Integer.toString( DATE );
        }

        return ( strYear + strMonth + strDay );
    }


    public Calendar setYYMMDD(String yymmdd)
    {
        c.set(c.YEAR,  Integer.parseInt( yymmdd.substring(0,4) ) );
        c.set(c.MONTH, Integer.parseInt( yymmdd.substring(4,6) ) );
        c.set(c.DATE,  Integer.parseInt( yymmdd.substring(6,8) ) );

        return c;
    }


    public String getYMDHMS()
    {
        String strYear, strMonth, strDay,strHour,strMinute,strSecond;

        YEAR  = c.get(c.YEAR);
        MONTH = c.get(c.MONTH) + 1;
        DATE  = c.get(c.DATE);
        HOUR_OF_DAY = c.get(c.HOUR_OF_DAY);
        MINUTE = c.get(c.MINUTE);
        SECOND = c.get(c.SECOND);

        strYear = Integer.toString( YEAR );
        if( MONTH < 10 ) {
            strMonth = "0" + Integer.toString( MONTH );
        } else {
            strMonth = Integer.toString( MONTH );
        }

        if( DATE < 10 ) {
            strDay = "0" + Integer.toString( DATE );
        } else {
            strDay = Integer.toString( DATE );
        }

        if( HOUR_OF_DAY < 10 ) {
            strHour = "0" + Integer.toString( HOUR_OF_DAY );
        } else {
            strHour = Integer.toString( HOUR_OF_DAY );
        }

        if( MINUTE < 10 ) {
            strMinute = "0" + Integer.toString( MINUTE );
        } else {
            strMinute = Integer.toString( MINUTE );
        }

        if( SECOND < 10 ) {
            strSecond = "0" + Integer.toString( SECOND );
        } else {
            strSecond = Integer.toString( SECOND );
        }

        return ( strYear + "-" + strMonth + "-" + strDay + " " + strHour + ":" + strMinute + ":" + strSecond );
    }


    public String getYMDHMS_non()
    {
        String strYear, strMonth, strDay,strHour,strMinute,strSecond;

        YEAR  = c.get(c.YEAR);
        MONTH = c.get(c.MONTH) + 1;
        DATE  = c.get(c.DATE);
        HOUR_OF_DAY = c.get(c.HOUR_OF_DAY);
        MINUTE = c.get(c.MINUTE);
        SECOND = c.get(c.SECOND);

        strYear = Integer.toString( YEAR );
        if( MONTH < 10 ) {
            strMonth = "0" + Integer.toString( MONTH );
        } else {
            strMonth = Integer.toString( MONTH );
        }

        if( DATE < 10 ) {
            strDay = "0" + Integer.toString( DATE );
        } else {
            strDay = Integer.toString( DATE );
        }

        if( HOUR_OF_DAY < 10 ) {
            strHour = "0" + Integer.toString( HOUR_OF_DAY );
        } else {
            strHour = Integer.toString( HOUR_OF_DAY );
        }

        if ( MINUTE < 10 ) {
            strMinute = "0" + Integer.toString( MINUTE );
        } else {
            strMinute = Integer.toString( MINUTE );
        }

        if ( SECOND < 10 ) {
            strSecond = "0" + Integer.toString( SECOND );
        } else {
            strSecond = Integer.toString( SECOND );
        }

        return ( strYear + strMonth + strDay + strHour + strMinute + strSecond );
    }


    public String getYMDHMS_Timestamp()
    {
        String strYear, strMonth, strDay,strHour,strMinute,strSecond;

        YEAR  = c.get(c.YEAR);
        MONTH = c.get(c.MONTH) + 1;
        DATE  = c.get(c.DATE);
        HOUR_OF_DAY = c.get(c.HOUR_OF_DAY);
        MINUTE = c.get(c.MINUTE);
        SECOND = c.get(c.SECOND);

        strYear = Integer.toString( YEAR );
        if( MONTH < 10 ) {
            strMonth = "0" + Integer.toString( MONTH );
        } else {
            strMonth = Integer.toString( MONTH );
        }

        if( DATE < 10 ) {
            strDay = "0" + Integer.toString( DATE );
        } else {
            strDay = Integer.toString( DATE );
        }

        if( HOUR_OF_DAY < 10 ) {
            strHour = "0" + Integer.toString( HOUR_OF_DAY );
        } else {
            strHour = Integer.toString( HOUR_OF_DAY );
        }

        if( MINUTE < 10 ) {
            strMinute = "0" + Integer.toString( MINUTE );
        } else {
            strMinute = Integer.toString( MINUTE );
        }

        if( SECOND < 10 ) {
            strSecond = "0" + Integer.toString( SECOND );
        } else {
            strSecond = Integer.toString( SECOND );
        }

        return ( strYear + "-" + strMonth + "-" + strDay + " " + strHour + ":" + strMinute + ":" +strSecond );
    }


    public String getHMS()
    {
        String strHour,strMinute,strSecond;

        HOUR_OF_DAY = c.get(c.HOUR_OF_DAY);
        MINUTE = c.get(c.MINUTE);
        SECOND = c.get(c.SECOND);

        if( HOUR_OF_DAY < 10 ) {
            strHour = "0" + Integer.toString( HOUR_OF_DAY );
        } else {
            strHour = Integer.toString( HOUR_OF_DAY );
        }

        if( MINUTE < 10 ) {
            strMinute = "0" + Integer.toString( MINUTE );
        } else {
            strMinute = Integer.toString( MINUTE );
        }

        if( SECOND < 10 ) {
            strSecond = "0" + Integer.toString( SECOND );
        } else {
            strSecond = Integer.toString( SECOND );
        }

        return ( strHour + strMinute +strSecond );
    }

}


