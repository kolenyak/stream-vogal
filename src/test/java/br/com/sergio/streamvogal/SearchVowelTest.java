package br.com.sergio.streamvogal;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

import org.junit.Test;

/**
 * Classe de testes de {@link SearchVowel}
 * 
 * @author Sérgio
 */
public class SearchVowelTest {
	
	/**
	 * Deve retornar caracter 'zero', pois não satisfez a regra {vogal, consoante, vogal não repetida} para sequência
	 * com apenas uma vogal: "a"
	 */
	@Test
	public void deveRetornarCaracterZeroParaSequenciaComUmaVogal() {
		
		String entrada = "a";
		
		StreamImpl input = new StreamImpl(entrada);
		
		char saida = SearchVowel.firstChar(input);
		
		assertThat(saida, equalTo('0'));
	}
	
	/**
	 * Deve retornar caracter 'zero', pois não satisfez a regra {vogal, consoante, vogal não repetida} para sequência
	 * com apenas uma vogal: "c"
	 */
	@Test
	public void deveRetornarCaracterZeroParaSequenciaComUmaConsoante() {
		
		String entrada = "c";
		
		StreamImpl input = new StreamImpl(entrada);
		
		char saida = SearchVowel.firstChar(input);
		
		assertThat(saida, equalTo('0'));
	}
	
	/**
	 * Deve retornar caracter 'zero', pois não satisfez a regra {vogal, consoante, vogal não repetida} para sequência
	 * com uma vogal e cuma consoante: "ac"
	 */
	@Test
	public void deveRetornarCaracterZeroParaSequenciaComUmaVogalEUmaConsoante() {
		
		String entrada = "ac";
		
		StreamImpl input = new StreamImpl(entrada);
		
		char saida = SearchVowel.firstChar(input);
		
		assertThat(saida, equalTo('0'));
	}
	
	/**
	 * Deve retornar caracter 'zero', pois não satisfez a regra {vogal, consoante, vogal não repetida} para sequência
	 * com vários caracteres: "afeaAbBABacafIeKI"
	 */
	@Test
	public void deveRetornarCaracterZeroQuandoRegraNaoForAtendidaTestandoSequênciaComVáriosCaracteres() {
		
		String entrada = "afeaAbBABacafIeKI";
		
		StreamImpl input = new StreamImpl(entrada);
		
		char saida = SearchVowel.firstChar(input);
		
		assertThat(saida, equalTo('0'));
	}
	
	/**
	 * Deve retornar caracter 'zero', pois não satisfez a regra {vogal, consoante, vogal não repetida} para sequência
	 * com apenas uma vogal não repetida que não sucede uma consoante: "afeAbBABcfIeKI"
	 */
	@Test
	public void deveRetornarCaracterZeroQuandoHouverApenasUmaVogalNaoRepetidaQueNaoSucedeConsoante() {
		
		String entrada = "afeAbBABcfIeKI";
		
		StreamImpl input = new StreamImpl(entrada);
		
		char saida = SearchVowel.firstChar(input);
		
		assertThat(saida, equalTo('0'));
	}
	
	/**
	 * Deve retornar caracter 'zero', pois não satisfez a regra {vogal, consoante, vogal não repetida} para sequência
	 * com apenas uma vogal não repetida que precede uma consoante sem vogal antecessora: "xafeAbBABcfIeKI"
	 */
	@Test
	public void deveRetornarCaracterZeroQuandoHouverApenasUmaVogalNaoRepetidaQueSucedeConsoanteSemVogalAntecessora() {
		
		String entrada = "xafeAbBABcfIeKI";
		
		StreamImpl input = new StreamImpl(entrada);
		
		char saida = SearchVowel.firstChar(input);
		
		assertThat(saida, equalTo('0'));
	}
	
	/**
	 * Deve retornar caracter 'e', pois satisfez a regra {vogal, consoante, vogal não repetida} para sequência
	 * com uma vogal, uma consoante e uma vogal não repetida: "ace"
	 */
	@Test
	public void deveRetornarVogalEMinusculoParaSequenciaComUmaVogalUmaConsoanteEUmaVogalNaoRepetida() {
		
		String entrada = "ace";
		
		StreamImpl input = new StreamImpl(entrada);
		
		char saida = SearchVowel.firstChar(input);
		
		assertThat(saida, equalTo('e'));
	}
	
	/**
	 * Deve retornar caracter 'e', pois satisfez a regra {vogal, consoante, vogal não repetida} para sequência
	 * com uma vogal, uma consoante, uma vogal não repetida e uma outra consoante: "acef"
	 */
	@Test
	public void deveRetornarVogalEMinusculoParaSequenciaCorretaComConsoanteNoFinal() {
		
		String entrada = "acef";
		
		StreamImpl input = new StreamImpl(entrada);
		
		char saida = SearchVowel.firstChar(input);
		
		assertThat(saida, equalTo('e'));
	}
	
	/**
	 * Deve retornar caracter 'e', pois é a primeira vogal não repetida que satisfez a regra {vogal, consoante, vogal não repetida} 
	 * para sequência: "acefi"
	 */
	@Test
	public void deveRetornarVogalEMinusculoParaPrimeiraVogalNaoRepetidaQueSatisfezASequenciaCorreta() {
		
		String entrada = "acefi";
		
		StreamImpl input = new StreamImpl(entrada);
		
		char saida = SearchVowel.firstChar(input);
		
		assertThat(saida, equalTo('e'));
	}

	/**
	 * Deve retornar caracter 'I', pois é a primeira vogal não repetida que satisfez a regra {vogal, consoante, vogal não repetida} 
	 * para sequência: "acefIe"
	 */
	@Test
	public void deveRetornarVogalIMaiusculoParaPrimeiraVogalNaoRepetidaQueSatisfezASequenciaCorreta() {
		
		String entrada = "acefIe";
		
		StreamImpl input = new StreamImpl(entrada);
		
		char saida = SearchVowel.firstChar(input);
		
		assertThat(saida, equalTo('I'));
	}
	
	/**
	 * Deve retornar caracter 'I', pois é a primeira vogal não repetida que satisfez a regra {vogal, consoante, vogal não repetida}
	 * mesmo possuindo na sequencia a voga 'i', esse é o teste para difernciar maiúsculas de minúsculas
	 * para sequência: "acifIe"
	 */
	@Test
	public void deveRetornarVogalIMaiusculoMesmoQuandoNaSentencaHouverIMinusculo() {
		
		String entrada = "acbifIe";
		
		StreamImpl input = new StreamImpl(entrada);
		
		char saida = SearchVowel.firstChar(input);
		
		assertThat(saida, equalTo('I'));
	}
	
	/**
	 * Deve retornar vogal 'e', pois é a primeira vogal não repetida que satisfez a regra {vogal, consoante, vogal não repetida},
	 * mesmo estando no final da sequência.
	 * 
	 * Sequência: "aAbBABacafe"
	 */
	@Test
	public void deveRetornarVogalEMinusculaQuandoSequenciaEstiverApenasNoFinal() {
		
		String entrada = "aAbBABacafe";
		
		StreamImpl input = new StreamImpl(entrada);
		
		char saida = SearchVowel.firstChar(input);
		
		assertThat(saida, equalTo('e'));
	}
	
	/**
	 * Deve retornar vogal 'e', pois é a primeira vogal não repetida que satisfez a regra {vogal, consoante, vogal não repetida},
	 * quando a sequência não estiver no começo ou fim.
	 * 
	 * Sequência: "aAbBABacafesa"
	 */
	@Test
	public void deveRetornarVogalEMinusculaQuandoSequenciaNaoEstaNoInicioOuFim() {
		
		String entrada = "aAbBABacafesa";
		
		StreamImpl input = new StreamImpl(entrada);
		
		char saida = SearchVowel.firstChar(input);
		
		assertThat(saida, equalTo('e'));
	}
	
	/**
	 * Deve retornar vogal 'e', pois é a primeira vogal não repetida que satisfez a regra {vogal, consoante, vogal não repetida},
	 * mesmo quando a duas sequências que satisfação a regra.
	 * 
	 * Sequência: "aAbBABacafesi"
	 * Sequências ok: "aAbBABac<b>afe</b>si" e "aAbBABacaf<b>esi</b>"
	 */
	@Test
	public void deveRetornarVogalEMinusculaQuandoForEncontradaAntesDeOutraVogalIMinusculaQueTambemAtendeARegra() {
		
		String entrada = "aAbBABacafesi";
		
		StreamImpl input = new StreamImpl(entrada);
		
		char saida = SearchVowel.firstChar(input);
		
		assertThat(saida, equalTo('e'));
	}
	
	/**
	 * Deve retornar vogal 'I', pois é a primeira vogal não repetida que satisfez a regra {vogal, consoante, vogal não repetida},
	 * 
	 * Testando apenas outra vogal
	 * 
	 * Sequência: "afeaAbBABacafIe"
	 */
	@Test
	public void deveRetornarVogalIMaiusculaParaSentenca() {
		
		String entrada = "afeaAbBABacafIe";
		
		StreamImpl input = new StreamImpl(entrada);
		
		char saida = SearchVowel.firstChar(input);
		
		assertThat(saida, equalTo('I'));
	}
	

}
