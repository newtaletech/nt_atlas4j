package br.com.redcloud.tech.solutions.atlas4j.logger.exception;

public class DebugNotEnabledException extends RuntimeException 
{
	private String message;
	
	public DebugNotEnabledException( )
	{
		super( );
	}
	
	public DebugNotEnabledException( String message ) 
	{
		this.message = message;
	}
	
	public DebugNotEnabledException ( ExceptionMessage message )
	{
		this.message = message.getValue( );
	}
}
