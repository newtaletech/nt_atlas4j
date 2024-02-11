/**
 * NewTale © 2024
 */

package br.com.redcloud.tech.solutions.atlas4j.logger.relatorio;

import java.io.IOException;
import java.time.LocalDate;

import com.itextpdf.forms.fields.PdfFormField;
import com.lowagie.text.DocumentException;
import com.lowagie.text.pdf.PdfStamper;

import br.com.redcloud.tech.solutions.atlas4j.logger.dto.LogData;
import br.com.redcloud.tech.solutions.atlas4j.logger.sistema.IH_Sistema;

public class AcroFormPDF 
{
	public static void addParametersOnReportInV01p00( PdfStamper stamper, LogData ld ) 
			throws IOException, DocumentException
	{
		stamper.setFormFlattening( true );
		
		/**
		 * Tab - Resumo Atlas
		 * */
		stamper.getAcroFields( ).setField( "at_plataforma", "Java"                                    );
		stamper.getAcroFields( ).setField( "at_versao", IH_Sistema.getM_AtlasVer( )                   );
		stamper.getAcroFields( ).setField( "at_nome_biblioteca", "Atlas4J"                            );
		stamper.getAcroFields( ).setField( "at_report_versao", IH_RelatorioVersao.RelV1p0.toString( ) );
		
		/**
		 * Tab - Mensagem De Erro
		 * */
		// definindo propriedades de alinhamento e quebra de linha para o campo da mensagem do erro
		stamper.getAcroFields( ).setFieldProperty( "at_log_msg", "textalignment",  
				PdfFormField.ALIGN_LEFT, null                                                );
		stamper.getAcroFields( ).setFieldProperty( "at_log_msg" , "setfflags", 
				PdfFormField.FF_MULTILINE, null                                              );
		stamper.getAcroFields( ).setField( "at_log_msg" , ld.getLogErrMsg( ) );
		
		/**
		 * Tab - Informações Sobre O Log De Erro
		 * */
		stamper.getAcroFields( ).setField( "at_log_id" , ld.getM_logErrID( )                  );
		stamper.getAcroFields( ).setField( "at_log_dt_emissao", ld.getLogErrDt( ).toString( ) );
		stamper.getAcroFields( ).setField( "at_log_hr_emissao", ld.getLogErrTm( ).toString( ) );
		stamper.getAcroFields( ).setField( "at_method_called", ld.getM_logErrCallMethod( )    );
		
		/**
		 * Tab - Stack Trace
		 * */
		stamper.getAcroFields( ).setField( "at_log_full_target", ld.getM_logErrTarget( )     );

		// definindo propriedades de alinhamento e quebra de linha para o campo de stack trace
		stamper.getAcroFields( ).setFieldProperty( "at_log_trace", "textalignment",  
				PdfFormField.ALIGN_LEFT, null                                                );
		stamper.getAcroFields( ).setFieldProperty( "at_log_trace" , "setfflags", 
				PdfFormField.FF_MULTILINE, null                                              );
		stamper.getAcroFields( ).setField( "at_log_trace", ld.getLogErrStackTraceInString( ) );
		
		/**
		 * Rodapé
		 * */
		stamper.getAcroFields( ).setField( "report_dt_emissao" , LocalDate.now( ).toString( ) );
		
		stamper.close( );
	}
}
