package com.process.util;
import java.io.*;
import java.util.*;

public class LogWriter extends Thread {
    private PrintWriter log;
    private String logfile;
    private String msg;
    private Throwable err;
    private StringBuffer sb;
    
	/**
	 * 에러메시지가 없는 로그쓰기 객체 생성.
	*/
    public LogWriter(String logfile, String msg, Throwable err) {
        this.logfile = logfile;
        this.msg = msg;
        this.err = err;
        this.sb = new StringBuffer((new Date()).toString());
//        sb.append("\n").append(this.msg).append(" ").append(err.toString()).append("\n");
        sb.append("\n").append(this.msg).append(err.toString()).append("\n");

    }

    /**
     * 에러메시지가 있는 로그쓰기 객체 생성.
    */

    public LogWriter(String logfile, String msg) {
        this.logfile = logfile;
        this.msg = msg;
        this.sb = new StringBuffer("[").append( new MyDate().getYMDHMS() ).append("] - ").append(this.msg);
    }

    public LogWriter(String logfile, String msg, String traceNo) {
        this.logfile = logfile;
        this.msg = msg;
        this.sb = new StringBuffer( new MyDate().getYMDHMS() ).append(" [TRACE_NO:" + traceNo + "]").append("\n").append(this.msg).append("\n");
    }

    public void run() {
        try {
            log = getPrintWriter(this.logfile);
            writeLog(sb.toString());
        } catch(IOException IO) {
            IO.printStackTrace();
            System.err.println("IOException occurred at LogWriter.getPrintWriter : "+(new Date()));
        }
    }

    private synchronized PrintWriter getPrintWriter(String logfile) throws IOException {
        return (new PrintWriter(new FileWriter(logfile,true),true));
    }

    private synchronized void writeLog(String msg) throws IOException {
        log.println(msg);
        log.close();
    }
}
