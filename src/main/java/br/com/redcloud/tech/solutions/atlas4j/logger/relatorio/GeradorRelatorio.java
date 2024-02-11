/**
 * NewTale © 2024
 */

package br.com.redcloud.tech.solutions.atlas4j.logger.relatorio;

import br.com.redcloud.tech.solutions.atlas4j.logger.dto.LogData;
import br.com.redcloud.tech.solutions.atlas4j.logger.dto.RelatorioData;

/**
 * <P>Classe <CODE>GeradorRelatorio</CODE>.</P>
 * <P>
 * Essa classe é responsável pela geração de relatórios do sistema.
 * Atualmente essa classe da suporte para as seguintes extensões de arquivos:
 * <UL><LI>PDF</LI></UL>
 * </P>
 * */
public class GeradorRelatorio 
{
	/**
	 * <P>Método resposável pela geração de relatório no formato PDF.</P>
	 * <P>Versão do relatório: 1.0</P>
	 * */
	public static byte[] geraPDF( LogData ld )
	{
		RelatorioData relData = IH_Relatorio.geraRelatorio( TipoRelatorio.PDF, ld );
		
		return relData.getM_relFileBytes( );
	}
}
