package br.com.sergio.streamvogal;

public class MainClass {

	public static void main(String[] args) {
		
		if(args.length > 0) {
			char firstChar = SearchVowel.firstChar(new StreamImpl(args[0]));
			
			if(firstChar == '0') {
				System.out.println(":( Não foi possível encontrar caractere vogal");
			} else {
				System.out.println("Caractere encontrado: " + firstChar);
			}
		} else {
			System.err.println("Oi! Informe a stream!");
		}
		
	}

}
