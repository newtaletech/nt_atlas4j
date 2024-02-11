package br.com.redcloud.tech.solutions.atlas4j.logger;

import java.time.LocalDate;
import java.time.LocalTime;

import br.com.redcloud.tech.solutions.atlas4j.logger.dto.LogData;
import br.com.redcloud.tech.solutions.atlas4j.logger.exception.DebugNotEnabledException;
import br.com.redcloud.tech.solutions.atlas4j.logger.exception.ExceptionMessage;
import br.com.redcloud.tech.solutions.atlas4j.logger.formatter.AtlasLoggerFormatter;

public abstract class Atlas 
{
	protected boolean saveInFile = false;
	protected Class<?> targetClass;
	protected boolean disableConsole = true;
	protected boolean enableDebug = true;
	
	protected void infoAndApplyConfig( String message )
	{
		if( !disableConsole )
		{
			AtlasLoggerFormatter.logInfo( message, targetClass );
		}
	};
	
	protected void warnAndApplyConfig( String message )
	{
		if( !disableConsole )
		{
			AtlasLoggerFormatter.logWarn( message, targetClass );
		}
	}
	
	protected LogData errorAndApplyConfig( String message, Exception e )
	{
		LogData ld = new LogData( );
		if( !disableConsole )
		{
			AtlasLoggerFormatter.logError( message, targetClass, e, ld );		
			ld.setLogErrMsg( message              );
		}
		
		return ld;
	}
	
	protected void debugAndApplyConfig( String message ) 
	{
		if( !disableConsole && enableDebug )
		{
			AtlasLoggerFormatter.logDebug( message, targetClass );
		}
		// verifica��o n�o se comportando como o esperado, ver depois isso...
		else if ( !enableDebug )
			throw new DebugNotEnabledException( ExceptionMessage.EXC_DEBUG_NOT_ENABLED_MSG );
	}
}
