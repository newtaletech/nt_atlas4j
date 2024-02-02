package br.com.redcloud.tech.solutions.atlas4j.logger;

public class AtlasLoggerImpl extends Atlas implements AtlasLogger {
	public AtlasLoggerImpl() {
		
	}
	
	@Override
	public void info(String message) {
		infoAndApplyConfig(message);
	}
	
	@Override
	public void warn(String message) {
		warnAndApplyConfig(message);
	}
	
	@Override
	public void error(String message, Exception e) {
		errorAndApplyConfig(message, e);
	}
	
	@Override
	public void debug(String message) {
		debugAndApplyConfig(message);
	}
	
	
	public void setSaveInFile(boolean value) {
		super.saveInFile = value;
	}
	
	public void setTargetClass(Class<?> target) {
		super.targetClass = target;
	}
	
	public void setDisableConsole(boolean disableConsole) {
		super.disableConsole = disableConsole;
	}
	
	public void setEnableDebug( boolean enableDebug )
	{
		super.enableDebug = enableDebug;
	}
	
	public void setTargetClass(String target) {
		try {
			super.targetClass = Class.forName(target);	
		} catch(ClassNotFoundException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public boolean isDebugEnabled() {
		return super.enableDebug ? true : false;
	}
}
