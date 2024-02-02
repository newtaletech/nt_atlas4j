package br.com.redcloud.tech.solutions.atlas4j.logger.enumlog;

public enum LogColor {
	ANSI_RESET		   		(	"\u001B[0m"					)	,	
	ANSI_BLACK		   		(	"\u001B[30m"				)	,
	ANSI_RED		   		(	"\u001B[38;2;255;0;0m"		)	,
	ANSI_GREEN  	   		(	"\u001B[32m"				)	,
	ANSI_YELLOW 	   		(	"\u001B[38;2;255;178;0m"	)	,
	ANSI_CERULEAN_BLUE 		(	"\u001B[38;2;0;133;185m" 	)	,	
	ANSI_DEEP_PURPLE   		(	"\u001B[38;2;95;6;231m"		)   ,
	ANSI_WHITE  	   		(	"\u001B[37m"				)	,
	ANSI_BACKGROUND_YELLOW	(	"\u001B[43m"				)	;
	
	private String colorCode;
	
	LogColor(String colorCode) {
		this.colorCode = colorCode;
	}
	
	public String getColorCode() {
		return this.colorCode;
	}
}
