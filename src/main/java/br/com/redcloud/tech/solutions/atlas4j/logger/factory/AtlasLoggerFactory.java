package br.com.redcloud.tech.solutions.atlas4j.logger.factory;

import br.com.redcloud.tech.solutions.atlas4j.logger.AtlasLogger;
import br.com.redcloud.tech.solutions.atlas4j.logger.AtlasLoggerImpl;
import br.com.redcloud.tech.solutions.atlas4j.logger.config.AtlasLoggerConfig;

/**
 * <h3>Classe de fábrica do Atlas Logger</h3>
 * 
 * */
public class AtlasLoggerFactory 
{
	private static AtlasLoggerFactory factoryInstance;
	private static AtlasLoggerImpl loggerImpl;
	
	private AtlasLoggerFactory( )
	{
		super( );
	}
	
	
	/* Sets methods */
	
	private static void setSaveInFile( boolean saveInFile )
	{
		AtlasLoggerFactory.loggerImpl.setSaveInFile( saveInFile );
	}
	
	private static void setDisableConsole( boolean disableConsole )
	{
		AtlasLoggerFactory.loggerImpl.setDisableConsole( disableConsole );
	}
	
	private static void setEnableDebug( boolean enableDebug )
	{
		AtlasLoggerFactory.loggerImpl.setEnableDebug( enableDebug );
	}
	
	
	/**
	 * GetLogger Instances
	 * */
	public static <T> AtlasLogger getLogger( AtlasLoggerConfig config, Class<T> target )
	{
		loggerImpl = new AtlasLoggerImpl();
		AtlasLoggerFactory.loggerImpl.setTargetClass(target);
		applyConfig(config);
		return AtlasLoggerFactory.loggerImpl;
	}
	
	public static <T> AtlasLogger getLogger( AtlasLoggerConfig config, String target )
	{
		loggerImpl = new AtlasLoggerImpl();
		AtlasLoggerFactory.loggerImpl.setTargetClass(target);
		applyConfig(config);
		return AtlasLoggerFactory.loggerImpl;
	} 
		
	private static void applyConfig( AtlasLoggerConfig config )
	{
		setSaveInFile     ( config.getSaveInFile( )     );
		setDisableConsole ( config.getDisableConsole( ) );
		setEnableDebug    ( config.getEnableDebug( )    );
	}
}
