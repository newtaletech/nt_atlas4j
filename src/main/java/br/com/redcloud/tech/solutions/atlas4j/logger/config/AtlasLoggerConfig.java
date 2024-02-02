package br.com.redcloud.tech.solutions.atlas4j.logger.config;

public class AtlasLoggerConfig implements AtlasLoggerConfigData
{	
	private boolean saveInFile;
	private boolean disableConsole;
	private boolean enableDebug;
	
	
	@Override
	public AtlasLoggerConfig saveInFile( boolean saveInFile ) 
	{
		this.saveInFile = saveInFile;
		return this;
	};
	
	@Override
	public AtlasLoggerConfig disableConsole( boolean disable ) 
	{
		this.disableConsole = disable;
		return this; 
	}
	
	@Override
	public AtlasLoggerConfig enableDebug( boolean enableDebug )
	{
		this.enableDebug = enableDebug;
		return this;
	}
	
	public boolean getSaveInFile( )
	{
		return this.saveInFile;
	}
	
	public boolean getDisableConsole( )
	{
		return this.disableConsole;
	}
	
	public boolean getEnableDebug( )
	{
		return this.enableDebug;
	}
	
	public void setSaveInFile( boolean saveInFile )
	{
		this.saveInFile = saveInFile;
	}
	
	public void setDisableConsole( boolean disableConsole )
	{
		this.disableConsole = disableConsole;
	}
	
	private void setEnableDebug( boolean enableDebug )
	{
		this.enableDebug = enableDebug;
	}
}
