package br.com.redcloud.tech.solutions.atlas4j.logger.exception;

public enum ExceptionMessage
{
	EXC_DEBUG_NOT_ENABLED_MSG( "O debug não foi habilitado neste objeto de log atlas. Por favor habilite no objeto de configuração." );
	
	private String value;
	
	private ExceptionMessage( String value )
	{
		this.value = value;
	}
	
	public String getValue( )
	{
		return this.value;
	}
}
