package br.com.redcloud.tech.solutions.atlas4j.logger.test;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import br.com.redcloud.tech.solutions.atlas4j.logger.AtlasLogger;
import br.com.redcloud.tech.solutions.atlas4j.logger.config.AtlasLoggerConfig;
import br.com.redcloud.tech.solutions.atlas4j.logger.factory.AtlasLoggerFactory;
import br.com.redcloud.tech.solutions.atlas4j.logger.relatorio.GeradorRelatorio;

public class Teste 
{
	public static void main(String[] args) 
	{
		AtlasLoggerConfig config = new AtlasLoggerConfig( );
		AtlasLogger log = AtlasLoggerFactory.getLogger( config, Teste.class );
		
		String ttl = "Teste de geração de relatório de erro no formato PDF";
		byte[] pdf = GeradorRelatorio.geraPDF( log.error( "Esse é um teste de erro." , 
				new Exception( "Erro mto doido" ) ), ttl );
		
		// Comandos do cliente 
		String path = "relatorio.pdf";
		try( FileOutputStream fos = new FileOutputStream( new File( path ) ) )
		{
			fos.write( pdf );
		}
		catch( IOException e )
		{
			e.printStackTrace( );
		}
		
		System.out.println( "Arquivo de relatório pdf gerado com sucesso!" );
	}
}
