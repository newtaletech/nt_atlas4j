/**
 * NewTale © 2024
 */

package br.com.redcloud.tech.solutions.atlas4j.logger.relatorio;

import br.com.redcloud.tech.solutions.atlas4j.logger.dto.LogData;
import br.com.redcloud.tech.solutions.atlas4j.logger.dto.RelatorioData;

public class IH_Relatorio 
{
	private static final IH_RelatorioVersao S_REL_DEFAUTL_VER = IH_RelatorioVersao.RelV1p0;
	
	public IH_RelatorioVersao getRelVer( )
	{
		return this.S_REL_DEFAUTL_VER;
	}
	
	public static RelatorioData geraRelatorio( TipoRelatorio tipo, LogData ld )
	{
		RelatorioData relData;
		
		switch ( tipo ) 
			{
			case PDF:
			{
				Relatorio rel = fabricaRelatorio( ld.getM_logErrTtl( ) );
				relData = rel.geraPDF( ld );
				break;
	
			}
			default:
			{
				Relatorio rel = fabricaRelatorio( ld.getM_logErrTtl( ) );
				relData = rel.geraPDF( ld );
				break;
			}
		}
		return relData;
	}
	
	private static Relatorio fabricaRelatorio( String titulo )
	{
		Relatorio rel;
		switch ( S_REL_DEFAUTL_VER ) 
		{
		case RelV1p0:
			rel = new RelV1p0( titulo );
			break;

		default:
			rel = new RelV1p0( titulo );
			break;
		}
		
		return rel;
	}
}
