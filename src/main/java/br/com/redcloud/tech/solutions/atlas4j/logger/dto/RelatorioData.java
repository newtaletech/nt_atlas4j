/**
 * NewTale © 2024
 */

package br.com.redcloud.tech.solutions.atlas4j.logger.dto;

import br.com.redcloud.tech.solutions.atlas4j.logger.relatorio.IH_RelatorioVersao;

public class RelatorioData 
{
	private String             m_relNome;
	private LogData            m_relLogData;
	private byte[]             m_relFileBytes;
	private IH_RelatorioVersao m_relVer;
	
	public RelatorioData( )
	{
		super( );
	}
	
	public String getM_relNome( ) 
	{
		return m_relNome;
	}
	
	public void setM_relNome( String m_relNome )
	{
		this.m_relNome = m_relNome;
	}
	
	public LogData getM_relLogData( ) 
	{
		return m_relLogData;
	}
	
	public void setM_relLogData( LogData m_relLogData )
	{
		this.m_relLogData = m_relLogData;
	}
	
	public byte[] getM_relFileBytes( )
	{
		return m_relFileBytes;
	}
	
	public void setM_relFile( byte[] m_relFileBytes ) 
	{
		this.m_relFileBytes = m_relFileBytes;
	}
}
