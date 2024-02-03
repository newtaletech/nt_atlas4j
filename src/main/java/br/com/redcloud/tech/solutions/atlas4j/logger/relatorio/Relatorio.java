/**
 * NewTale © 2024
 */

package br.com.redcloud.tech.solutions.atlas4j.logger.relatorio;

import br.com.redcloud.tech.solutions.atlas4j.logger.dto.LogData;
import br.com.redcloud.tech.solutions.atlas4j.logger.dto.RelatorioData;

public abstract class Relatorio
{
	protected String m_relNome;
	
	public abstract RelatorioData geraPDF( LogData ld );
}
