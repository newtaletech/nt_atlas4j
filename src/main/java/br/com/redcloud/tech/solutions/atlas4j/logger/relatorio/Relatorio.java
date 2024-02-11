/**
 * NewTale © 2024
 */

package br.com.redcloud.tech.solutions.atlas4j.logger.relatorio;

import java.io.IOException;

import com.lowagie.text.DocumentException;
import com.lowagie.text.pdf.PdfStamper;

import br.com.redcloud.tech.solutions.atlas4j.logger.AtlasLogger;
import br.com.redcloud.tech.solutions.atlas4j.logger.config.AtlasLoggerConfig;
import br.com.redcloud.tech.solutions.atlas4j.logger.dto.LogData;
import br.com.redcloud.tech.solutions.atlas4j.logger.dto.RelatorioData;
import br.com.redcloud.tech.solutions.atlas4j.logger.factory.AtlasLoggerFactory;

public abstract class Relatorio
{
	protected String m_relNome;
	private AtlasLogger m_log;
	
	public abstract RelatorioData geraPDF( LogData ld );
	
	protected void addParameters( PdfStamper stamper, LogData ld )
	{
		montaLog( );
		try 
		{
			IH_Relatorio.addParametersOnReport( stamper, ld );
		} 
		catch ( IOException | DocumentException e ) 
		{
			String msg = "Não foi possível adicionar parâmetros para o template do relatório na versão: "
					+ IH_Relatorio.S_REL_DEFAUTL_VER.toString( ) + "." +
					"Talvez o nome dos parâmetros não condizem com a versão atual ou apenas estão errados.";
			m_log.error( msg , e );
		}
	}
	
	private void montaLog( )
	{
		m_log = AtlasLoggerFactory.getLogger( new AtlasLoggerConfig( ), Relatorio.class );
	}
}
