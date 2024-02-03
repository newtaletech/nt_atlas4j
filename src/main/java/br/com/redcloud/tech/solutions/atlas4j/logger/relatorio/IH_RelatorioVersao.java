/**
 * NewTale © 2024
 */

package br.com.redcloud.tech.solutions.atlas4j.logger.relatorio;

public enum IH_RelatorioVersao 
{
	RelV1p0( 1, 0 );
	
	private int    version;
	private int    patch;
	private String fullVer;
	
	IH_RelatorioVersao( int ver, int patch )
	{
		this.version = ver;
		this.patch = patch;
		this.fullVer = this.version + "p" + this.patch;
	}
	
	public String getFullVersion( )
	{
		return this.fullVer;
	}

	public int getVersion() {
		return this.version;
	}

	public int getPatch() {
		return this.patch;
	}

}
