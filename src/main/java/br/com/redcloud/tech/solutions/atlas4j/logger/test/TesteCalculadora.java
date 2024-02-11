package br.com.redcloud.tech.solutions.atlas4j.logger.test;

public class TesteCalculadora 
{
	public static void main(String[] args) throws Exception {
		Calculadora calc = new Calculadora( );
		calc.setDisableConsole( false );
		calc.setEnableDebug( true );
		
		double[ ] list = {  };
		
		double soma = calc.soma( 10, 5 );
		double divisao = calc.divide( 10, 2 );
		double media = calc.calculaMedia( list );
		
		
		System.out.println( "soma = " + soma );
		System.out.println( "divisao = " + divisao );
		System.out.println( "media = " + media );
	}
}
