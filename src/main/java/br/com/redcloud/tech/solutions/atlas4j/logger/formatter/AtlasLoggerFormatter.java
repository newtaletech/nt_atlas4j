package br.com.redcloud.tech.solutions.atlas4j.logger.formatter;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import br.com.redcloud.tech.solutions.atlas4j.logger.dto.LogData;
import br.com.redcloud.tech.solutions.atlas4j.logger.enumlog.LogColor;
import br.com.redcloud.tech.solutions.atlas4j.logger.enumlog.LogLevel;

public abstract class AtlasLoggerFormatter {

	private static final DateTimeFormatter TIMESTAMP_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
	private static final int CALLING_METHOD_NAME_INDEX = 8;
	
	
	
	public static void logInfo(String message, Class<?> classTarget) {
		formatterLog(LogLevel.LEVEL_INFO, message, classTarget);
	}	
	
	/**
	 * Criar m�todo na interface AtlasLogger e implementar na classe AtlasLoggerImpl
	 * @see br.com.redcloud.tech.solutions.atlas4j.logger.AtlasLogger
	 * @see br.com.redcloud.tech.solutions.atlas4j.logger.AtlasLoggerImpl
	 * */
	public static void logWarn(String message, Class<?> classTarget) {
		formatterLog(LogLevel.LEVEL_WARN, message, classTarget);
	}
	
	/**
	 * Criar m�todo na interface AtlasLogger e implementar na classe AtlasLoggerImpl
	 * @see br.com.redcloud.tech.solutions.atlas4j.logger.AtlasLogger
	 * @see br.com.redcloud.tech.solutions.atlas4j.logger.AtlasLoggerImpl
	 * */
	public static void logDebug(String message, Class<?> classTarget) {
		formatterLog(LogLevel.LEVEL_DEBUG, message, classTarget);
	}
	
	/**
	 * Criar m�todo na interface AtlasLogger e implementar na classe AtlasLoggerImpl
	 * @see br.com.redcloud.tech.solutions.atlas4j.logger.AtlasLogger
	 * @see br.com.redcloud.tech.solutions.atlas4j.logger.AtlasLoggerImpl
	 * */
	public static void logError(String message, Class<?> classTarget, Exception e, LogData ld ) {
		formatError(message, LogLevel.LEVEL_ERROR, e, classTarget, ld);
	}
	
	
	private static void formatterLog(LogLevel level, String message, Class<?> classTarget) {
		log(level, message, classTarget);
	}
	
	private static void log(LogLevel level, String message, Class<?> classTarget) {
		switch (level) {
		case LEVEL_INFO:
			formatInfo(message, level, classTarget);
			break;
		case LEVEL_WARN:
			formatWarn(message, level, classTarget);
			break;
		case LEVEL_DEBUG:
			formatDebug(message, level, classTarget);
			break;
		default:
			formatInfo(message, level, classTarget);
			break;
		}
	}
	
	private static void log(LogLevel level, String message, Class<?> classTarget, Exception e, LogData ld) {
		switch (level) {
		case LEVEL_ERROR:
			formatError(message, level, e, classTarget, ld);
			break;
		default:
			// joker
			break;
		}
	}
	
	/**
	 * Separar o c�digo padr�o de exibi��o de mensagem da configura��o de cor.
	 * */
	private static void formatInfo(String message, LogLevel levelParam, Class<?> classTarget) {
		String timestamp = LocalDateTime.now().format(TIMESTAMP_FORMATTER);
		String color = getIdealColor(levelParam);
		String resetColor = LogColor.ANSI_RESET.getColorCode();
		String level = "INFO";
		String classPackage = classTarget.getPackage().toString().replace("package ", "");
		String className = classTarget.getSimpleName();
		String fullClassPath =  classPackage + "." + className; 
		String randomLogId = generateRandomLogId();
		
		String classColor = LogColor.ANSI_DEEP_PURPLE.getColorCode();
		
		String logEntry = String.format("[%s%s%s] %s [%s] @%s%s%s: %s", 
				classColor,
				timestamp, 
				resetColor,
				fullClassPath, 
				randomLogId,
				color, 
				level, 
				resetColor, 
				message);
		
		
		System.out.println(logEntry);
	}
	
	
	private static void formatWarn(String message, LogLevel levelParam, Class<?> classTarget) {
		String timestamp = LocalDateTime.now().format(TIMESTAMP_FORMATTER);
		String color = getIdealColor(levelParam);
		String resetColor = LogColor.ANSI_RESET.getColorCode();
		String level = "WARN";
		String classPackage = classTarget.getPackage().toString().replace("package ", "");
		String className = classTarget.getSimpleName();
		String fullClassPath =  classPackage + "." + className; 
		String randomLogId = generateRandomLogId();
		
		String classColor = LogColor.ANSI_DEEP_PURPLE.getColorCode();
		
		
		
		String logEntry = String.format("[%s%s%s] %s [%s] @%s%s%s: %s", 
				classColor,
				timestamp, 
				resetColor,
				fullClassPath, 
				randomLogId,
				color, 
				level, 
				resetColor, 
				message);
		
		System.out.println(logEntry);
	}
	
	
	private static void formatError(String message, LogLevel levelParam, Exception e, Class<?> classTarget, LogData ld) {
		LocalDateTime dateTime = LocalDateTime.now();
		String timestamp = dateTime.format(TIMESTAMP_FORMATTER);
		String color = getIdealColor(levelParam);
		String resetColor = LogColor.ANSI_RESET.getColorCode();
		String level = "ERROR";
		String classPackage = classTarget.getPackage().toString().replace("package ", "");
		String className = classTarget.getSimpleName();
		String fullClassPath =  classPackage + "." + className; 
		String randomLogId = generateRandomLogId();
		String callingMethodName = getCallingMethodNameToErrorLog() + "()";
		
		
		String classColor = LogColor.ANSI_DEEP_PURPLE.getColorCode();
		
		String logEntry = String.format("[%s%s%s] %s [%s] @%s%s%s: %s", 
				classColor,
				timestamp, 
				resetColor,
				fullClassPath, 
				randomLogId,
				color, 
				level, 
				resetColor, 
				message);
		
		System.out.println(logEntry);
		e.printStackTrace();
		
		ld.setM_logErrID        ( randomLogId             );
		ld.setLogErrDt          ( dateTime.toLocalDate( ) );
		ld.setLogErrTm          ( dateTime.toLocalTime( ) );
		ld.setLogErrTrace       ( e.getStackTrace( )      );
		ld.setM_logErrTarget    ( fullClassPath           );
		ld.setM_logErrCallMethod( callingMethodName       );
		ld.setM_logErrThrowable ( e                       );
	}
	
	
	
	private static void formatDebug(String message, LogLevel levelParam, Class<?> classTarget) {
		String timestamp = LocalDateTime.now().format(TIMESTAMP_FORMATTER);
		String color = getIdealColor(levelParam);
		String resetColor = LogColor.ANSI_RESET.getColorCode();
		String level = "DEBUG";
		String classPackage = classTarget.getPackage().toString().replace("package ", "");
		String className = classTarget.getSimpleName();
		
		String randomLogId = generateRandomLogId();
		String callingMethodName = LogColor.ANSI_BLACK.getColorCode() +  
					LogColor.ANSI_BACKGROUND_YELLOW.getColorCode() 	  +
					getCallingMethodName() + "()"					  	+
					LogColor.ANSI_RESET.getColorCode()				  ;				
		
		String fullClassPath =  classPackage + "." + className + "#" + callingMethodName; 
		
		String classColor = LogColor.ANSI_DEEP_PURPLE.getColorCode();
		
		String logEntry = String.format("[%s%s%s] %s [%s] @%s%s%s: %s", 
				classColor,
				timestamp, 
				resetColor,
				fullClassPath, 
				randomLogId,
				color, 
				level, 
				resetColor, 
				message);
		
		System.out.println("\t"+logEntry);
	}
	
	
	
	private static String getIdealColor(LogLevel level) {
		switch (level) {
		case LEVEL_INFO:
			return LogColor.ANSI_GREEN.getColorCode();
		case LEVEL_WARN:
			return LogColor.ANSI_YELLOW.getColorCode();
		case LEVEL_ERROR:
			return LogColor.ANSI_RED.getColorCode();
		case LEVEL_DEBUG:
			return LogColor.ANSI_CERULEAN_BLUE.getColorCode();
		default:
			return LogColor.ANSI_GREEN.getColorCode();
		}
	}
	
	
	private static String generateRandomLogId() {
		Random random = new Random();
		
		Integer randomNumber = ThreadLocalRandom.current().nextInt(10, 20);
		char randomMinChar = (char) (random.nextInt(26) + 'a');
		
		Integer randomNumber2 = ThreadLocalRandom.current().nextInt(10, 20);
		char randomMinChar2 = (char) (random.nextInt(26) + 'a');
	
		Integer randomNumber3 = ThreadLocalRandom.current().nextInt(10, 20);
		char randomMinChar3 = (char) (random.nextInt(26) + 'a');
			
		Integer randomNumber4 = ThreadLocalRandom.current().nextInt(10, 20);
		char randomMinChar4 = (char) (random.nextInt(26) + 'a');
		
		
		
		String id = "atId-" + 
				randomNumber  + randomMinChar  + 
				randomNumber2 + randomMinChar2 + 
				randomNumber3 + randomMinChar3 +
				randomNumber4 + randomMinChar4 
				;
		
		return id;
	}
	
	
	private static String getCallingMethodName() {
		StackTraceElement[] stacks = Thread.currentThread().getStackTrace();
		return stacks[stacks.length - 2].getMethodName();
	}
	
	private static String getCallingMethodNameToErrorLog() {
		StackTraceElement[] stacks = Thread.currentThread().getStackTrace();
		return stacks[stacks.length - 1].getMethodName();
	}
}
