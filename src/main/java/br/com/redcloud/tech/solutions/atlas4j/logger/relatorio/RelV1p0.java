/**
 * NewTale © 2024
 */

package br.com.redcloud.tech.solutions.atlas4j.logger.relatorio;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfWriter;

import br.com.redcloud.tech.solutions.atlas4j.logger.dto.LogData;
import br.com.redcloud.tech.solutions.atlas4j.logger.dto.RelatorioData;

public class RelV1p0 extends Relatorio
{
	private static final String S_LB_RELNAME = "Nome do relatório:",
			                    S_LB_RELDATA = "Data de emissão:";
	
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
		RelatorioData relData  = new RelatorioData( );
		relData.setM_relNome   ( m_relNome          );
		relData.setM_relLogData( ld                 );
		
		Document  docPDF = new Document( );
		Paragraph p;

		ByteArrayOutputStream byteArrayOS = new ByteArrayOutputStream( );
		
		try 
		{
			PdfWriter pdfWriter = PdfWriter.getInstance( docPDF, byteArrayOS );

			docPDF.open( );

			docPDF.add( p = new Paragraph( S_LB_RELNAME + " " + ld.getLogErrMsg( ) )       );
			docPDF.add( p = new Paragraph( S_LB_RELDATA + " " + ld.getLogErrTimestamp( ) ) );
			

		} catch ( DocumentException e ) 
		{
			e.printStackTrace( );
		}
		docPDF.close( );
		
		byte[] pdfBytes = byteArrayOS.toByteArray( );
		relData.setM_relFile( pdfBytes );
		
		return relData;
	}
	

}
