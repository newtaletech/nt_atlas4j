package br.com.redcloud.tech.solutions.atlas4j.logger.config;

public interface AtlasLoggerConfigData 
{
	AtlasLoggerConfigData saveInFile     ( boolean value );
	AtlasLoggerConfigData disableConsole ( boolean value );
	AtlasLoggerConfigData enableDebug    ( boolean value );
}
