package br.com.redcloud.tech.solutions.atlas4j.logger.test;

import br.com.redcloud.tech.solutions.atlas4j.logger.AtlasLogger;
import br.com.redcloud.tech.solutions.atlas4j.logger.config.AtlasLoggerConfig;
import br.com.redcloud.tech.solutions.atlas4j.logger.factory.AtlasLoggerFactory;

public class Calculadora 
{
	private AtlasLogger log;
	private Boolean disableConsole = true;
	private Boolean enableDebug = false;
	
	
	public Calculadora( )
	{
		super( );
		montaLog( );
	}
	
	public double soma( double... numbers )
	{
		if( log.isDebugEnabled( ) )
			log.debug( "numbers = " + numbers );
			
		double resultado = 0;
		for( double num : numbers )
		{
			resultado += num;
		}
		
		log.info( "Um usuário acabou de realizar uma soma no sistema." );
		
		if( log.isDebugEnabled( ) )
			log.debug( "@return = " + resultado );
		
		return resultado;
	}
	
	public double divide( double num1, double num2 )
	{
		if( log.isDebugEnabled( ) )
			log.debug( "num1 = " + num1 + " num2 = " + num2 );
			
		if( num1 <= 0 || num2 <= 0 )
			log.warn( "Algum número entrou no método de divisão com valor igual ou abaixo de zero. "
					+ "Isso poderá ocasionar um erro futuramente." );
		double resultado = num1 / num2;
		
		if( log.isDebugEnabled( ) )
			log.debug( "@return = " + resultado );
		
		return resultado;
	}
	
	public double calculaMedia( double[] list ) throws Exception
	{
		if( log.isDebugEnabled( ) )
			log.debug( "list = " + list );
		
		if( list == null || list.length <= 0 )
		{
			String msg = "A lista não pode estar vazia!";
			Exception e = new IllegalArgumentException( msg );
			log.error(msg , e);
			throw e;
		}

		
		int total = list.length;
		double somador = 0;
		for( double num : list )
		{
			somador += num;
		}
		double resultado = somador / total;
		
		if( log.isDebugEnabled( ) )
			log.debug( "@return = " + resultado );
		
		return resultado;
	}
	
	private void montaLog( )
	{
		AtlasLoggerConfig config = new AtlasLoggerConfig( )
				.disableConsole( disableConsole )
				.enableDebug   ( enableDebug    );
		
		log = AtlasLoggerFactory.getLogger( config, Calculadora.class );
	}
	

	public Boolean getDisableConsole( )
	{
		return disableConsole;
	}

	public void setDisableConsole( Boolean disableConsole )
	{
		this.disableConsole = disableConsole;
		montaLog( );
	}

	public Boolean getEnableDebug( )
	{
		return enableDebug;
	}

	public void setEnableDebug( Boolean enableDebug ) 
	{
		this.enableDebug = enableDebug;
		montaLog( );
	}

}
