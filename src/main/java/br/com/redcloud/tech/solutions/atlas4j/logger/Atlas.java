package br.com.redcloud.tech.solutions.atlas4j.logger;

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
	
	protected void errorAndApplyConfig( String message, Exception e )
	{
		if( !disableConsole )
		{
			AtlasLoggerFormatter.logError( message, targetClass, e );
		}
	}
	
	protected void debugAndApplyConfig( String message ) 
	{
		if( !disableConsole && enableDebug )
		{
			AtlasLoggerFormatter.logDebug( message, targetClass );
		}
		// verificação não se comportando como o esperado, ver depois isso...
		else if ( !enableDebug )
			throw new DebugNotEnabledException( ExceptionMessage.EXC_DEBUG_NOT_ENABLED_MSG );
	}
}
