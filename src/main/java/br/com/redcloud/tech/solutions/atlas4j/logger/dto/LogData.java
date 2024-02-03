/**
 * NewTale © 2024
 */

package br.com.redcloud.tech.solutions.atlas4j.logger.dto;

import java.time.LocalDate;
import java.time.LocalTime;

public class LogData 
{
	private String              m_logErrMsg;
	private String 				m_logErrTtl;
	private StackTraceElement[] m_logErrTrace;
	private LocalDate           m_logErrDt;
	private LocalTime           m_logErrTm;
	
	public LogData( )
	{
		super( );
	}
	
	public String getLogErrMsg( ) 
	{
		return m_logErrMsg;
	}
	
	public void setLogErrMsg( String m_logErrMsg )  
	{
		this.m_logErrMsg = m_logErrMsg;
	}
	
	public StackTraceElement[] getLogErrTrace( )
	{
		return m_logErrTrace;
	}
	
	public void setLogErrTrace( StackTraceElement[] m_logErrTrace ) 
	{
		this.m_logErrTrace = m_logErrTrace;
	}
	
	public LocalDate getLogErrDt( )
	{
		return m_logErrDt;
	}
	
	public void setLogErrDt( LocalDate m_logErrDt )
	{
		this.m_logErrDt = m_logErrDt;
	}
	
	public LocalTime getLogErrTm( ) 
	{
		return m_logErrTm;
	}
	
	public void setLogErrTm( LocalTime m_logErrTm )
	{ 
		this.m_logErrTm = m_logErrTm;
	}

	public String getM_logErrTtl() {
		return m_logErrTtl;
	}

	public void setM_logErrTtl(String m_logErrTtl) {
		this.m_logErrTtl = m_logErrTtl;
	}

	public String getLogErrTimestamp( )
	{
		String dt = this.getLogErrDtInString( );
		String tm = this.getLogErrTmInString( );
		return dt + " " + tm; 
	}
	
	public String getLogErrDtInString( )
	{
		
		LocalDate dt = this.m_logErrDt;
		String format = dt.getDayOfMonth( ) + "/" + dt.getMonthValue( ) + "/" + dt.getYear( );
		return format;
	}
	
	public String getLogErrTmInString( )
	{
		LocalTime tm = this.m_logErrTm;
		String format = tm.getHour( ) + ":" + tm.getMinute( );
		return format;
	}
}
