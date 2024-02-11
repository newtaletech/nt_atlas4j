package br.com.redcloud.tech.solutions.atlas4j.logger.test;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import br.com.redcloud.tech.solutions.atlas4j.logger.AtlasLogger;
import br.com.redcloud.tech.solutions.atlas4j.logger.config.AtlasLoggerConfig;
import br.com.redcloud.tech.solutions.atlas4j.logger.factory.AtlasLoggerFactory;
import br.com.redcloud.tech.solutions.atlas4j.logger.relatorio.GeradorRelatorio;

public class TesteRelatorioErro 
{
	public static void main(String[] args) 
	{
		AtlasLoggerConfig config = new AtlasLoggerConfig( );
		AtlasLogger log = AtlasLoggerFactory.getLogger( config, TesteRelatorioErro.class );
		
		String msg = "Infelizmente ocorreu um erro ao tentar acessar o servidor. Erro 504! Infelizmente ocorreu um erro ao tentar acessar o servidor. Erro 504! Infelizmente ocorreu um erro ao tentar acessar o servidor. Erro 504!";
		
		byte[] pdf = GeradorRelatorio.geraPDF( log.error( msg , new Exception( "Erro 504 - Falha no GET." ) ) );
		
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
