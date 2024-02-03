package br.com.redcloud.tech.solutions.atlas4j.logger;

import br.com.redcloud.tech.solutions.atlas4j.logger.dto.LogData;
import br.com.redcloud.tech.solutions.atlas4j.logger.exception.DebugNotEnabledException;

public interface AtlasLogger 
{
	void    info  ( String message              );
	void    warn  ( String message              );
	LogData error ( String message, Exception e );
	void    debug ( String message              );
	
	boolean isDebugEnabled ( ) 
			throws DebugNotEnabledException				 ;
}
