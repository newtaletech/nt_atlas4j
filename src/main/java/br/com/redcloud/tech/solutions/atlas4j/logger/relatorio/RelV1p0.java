/**
 * NewTale © 2024
 */

package br.com.redcloud.tech.solutions.atlas4j.logger.relatorio;


import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import com.lowagie.text.DocumentException;
import com.lowagie.text.pdf.PdfReader;
import com.lowagie.text.pdf.PdfStamper;

import br.com.redcloud.tech.solutions.atlas4j.logger.dto.LogData;
import br.com.redcloud.tech.solutions.atlas4j.logger.dto.RelatorioData;

public class RelV1p0 extends Relatorio
{
	private static final String S_LB_RELNAME = "Nome do relatório:",
			                    S_LB_RELDATA = "Data de emissão:"  ,
			                    S_LB_RELMSG  = "Mensagem de erro:" ;
	
	private static LogData m_logData;
	
	public RelV1p0( )
	{
		super( );
	}
	
	public RelV1p0( String titulo )
	{
		m_relNome = titulo;
	}
	
	@Override
	public RelatorioData geraPDF( LogData ld ) 
	{
		this.m_logData = ld;
		
		RelatorioData relData  = new RelatorioData( );
		relData.setM_relNome   ( m_relNome          );
		relData.setM_relLogData( ld                 );
		
		ByteArrayOutputStream byteArrayOS = new ByteArrayOutputStream( );
		
		try
		{
			PdfReader pdfReader = new PdfReader( 
					"report" + File.separator + 
					"template" + File.separator + 
					"atlas-error-report-v01p01-template.pdf" );
			
			PdfStamper stamper = new PdfStamper( pdfReader, byteArrayOS );
			
			addParameters( stamper, ld );
			
			pdfReader.close( );
		}
		catch( IOException | DocumentException e  )
		{
			if( e instanceof FileNotFoundException )
				System.err.println( "Erro ao achar o arquivo de template." );
		}

		
		byte[] pdfBytes = byteArrayOS.toByteArray( );
		relData.setM_relFile( pdfBytes );

		return relData;
	}

}
