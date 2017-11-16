package br.com.sergio.streamvogal;

/**
 * Buscador de caractere Vogal, após uma consoante, onde a mesma é antecessora a uma vogal e que não se repita
 * 
 * @author Sérgio
 */
public class SearchVowel {
	
	public static char firstChar(Stream input) {
		
		SearchEligibleVowel eligibleVowel = new SearchEligibleVowel();
		
		char[] vogais = eligibleVowel.search(input);
		
		return vogais.length > 0 ? vogais[0] : '0';
	}
	
	/**
	 * Classe reposnsável por pesquisar as vogais elegiveis para a regra: (vogal, constatnte, vogal não repetida)
	 * 
	 * @author Sérgio
	 */
	private static class SearchEligibleVowel {
		
		/**
		 * Sequência para validação de vogal elegível
		 */
		private static final String SEQUENCE = "VCV";
		
		/**
		 * Vogais encontradas durante a busca
		 */
		private char foundVowels[] = new char[0];
		
		
		
		public SearchEligibleVowel() {
			super();
		}

		/**
		 * Busca as vogais elegiveis para retorno de acordo com a regra:
		 * <br/ >(vogal, consoante, vogal não repetida)
		 * 
		 * @param input {@link Stream}
		 * @return array of char
		 */
		public char[] search(Stream input) {
			
			char[] vowels = search(input, new char[0], "");
			
			vowels = filtersNonRepeatedVowels(vowels);
			
			return vowels;
		}

		/**
		 * Realiza a busca recusivamente no objeto input {@link Stream}
		 * 
		 * @param input
		 * @param eligibleVowels
		 * @param currentSequence
		 * @return array of char
		 */
		private char[] search(Stream input, char[] eligibleVowels, String currentSequence) {
			
			currentSequence = prepareCurrentSequence(currentSequence);
			
			if(input.hasNext()) {
				char nextChar = input.getNext();
				
				if(isVowel(nextChar)) {
					
					currentSequence = obtainSeqVowel(currentSequence);
					
					eligibleVowels = separateEligibleVowel(eligibleVowels, currentSequence, nextChar);
				}
				else {
					currentSequence = obtainSeqConsonant(currentSequence);
				}
				
				return search(input, eligibleVowels, currentSequence);
				
			} else {
				
				return eligibleVowels;
			}
			
		}

		/**
		 * Separa a vogal elegível par adicionar no array
		 * 
		 * @param eligibleVowels
		 * @param currentSequence
		 * @param nextChar
		 * @return
		 */
		private char[] separateEligibleVowel(char[] eligibleVowels, String currentSequence, char nextChar) {
			if(SEQUENCE.equals(currentSequence)) {
				if(!repeatedVowel(nextChar)) {
					eligibleVowels = addCharToArray(nextChar, eligibleVowels);
				}
			}
			
			foundVowels = addCharToArray(nextChar, foundVowels);
			
			return eligibleVowels;
		}
		
		/**
		 * Adiciona item no array de caracteres
		 * 
		 * @param c
		 * @param array 
		 */
		private char[] addCharToArray(char c, char[] array) {
			int length = array.length;
			char[] aux = new char[length+1];
			System.arraycopy(array, 0, aux, 0, array.length);
			aux[length] = c;
			return aux;
		}

		/**
		 * Prepara sequência
		 * 
		 * @param seq
		 * @return Sequência com formato correto
		 */
		private String prepareCurrentSequence(String seq) {
			
			if(seq == null) {
				return "";
			}
			
			if(seq.length() > 2) {
				return seq = seq.substring(1);
			}

			return seq;
		}

		/**
		 * Filtra as vogais que possam ser repetidas após o fim da checagem da entrada de dados 
		 * 
		 * @param vowels
		 * @return array of char
		 */
		private char[] filtersNonRepeatedVowels(char[] vowels) {
			char[] aux = vowels;
			for(int i = 0; i < aux.length; i++) {
				// separa caractere para validação
				char vowelBase = aux[i];
				int occurrences = 0;
				for(int j = 0; j < foundVowels.length; j++) {
					if(vowelBase == this.foundVowels[j]) {
						occurrences++;
					}
				}
				
				// Se houve mais de uma ocorrência da vogal ela deverá ser removida do array
				if(occurrences > 1) {
					char[] aux2 = new char[vowels.length - 1];
					for(int c = 0, iaux = 0; c < vowels.length; c++) {
						if(vowelBase != vowels[c]) {
							aux2[iaux++] = vowels[c];
						}
					}
					
					vowels = aux2;
				}
			}
			
			return vowels;
		}

		/**
		 * Verifica se a vogal enviada no parâmetro é repetida já foi adiciona no array de vogais encontradas
		 * 
		 * @param vowel
		 * @return
		 */
		private boolean repeatedVowel(char vowel) {
			int i = 0;
			for(; i < foundVowels.length; i++) {
				if(vowel == foundVowels[i]) {
					return true;
				}
			}
			
			return false;
		}
		
		/**
		 * @param seq Sequência atual
		 * @return Sequência para vogais
		 */
		private String obtainSeqVowel(String seq) {
			return seq.concat("V");
		}
		
		/**
		 * @param seq Sequência atual
		 * @return Sequência para consoantes
		 */
		private String obtainSeqConsonant(String seq) {
			return seq.concat("C");
		}
		
		/**
		 * @param c 
		 * @return <b>true</b> Para vogais
		 * <br><b>false</b> Para *não* vogais
		 */
		private boolean isVowel(char c) {
			return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u'
					|| c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U';
		}
	}

}

