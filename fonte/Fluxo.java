/**
 * Universidade Federal da Fronteira Sul
 * Ciência da Computação
 * 3ª fase - Programação I
 * 
 * Desenvolvido por:
 * Edirlan Cenci - edirlan.censi@hotmail.com
 * Taiane Baldin - taiane.baldin@gmail.com
 *
 * Esse programa é um interpretador Java para a linguagem 'eT'.
 * Essa classe verifica os tokens e expressão para executar o fluxo
 **/
 
 class Fluxo{
	public String ant,prox;
	public char token;
	public double aux1, aux2;
	public int fluxo(String s, Variaveis v[], int indiceVet, int linhaAtual){
		for(int i=0; i < s.length(); i++){
		//símbolo ^ equivale à diferente , símbolo ? é o mesmo que igual 
			if( s.charAt(i) == '>'||s.charAt(i) == '<'||s.charAt(i) == '^'||s.charAt(i) == '?' ){
				token = s.charAt(i);
				ant =  s.substring(s.indexOf("(")+1, s.indexOf(token));
				prox = s.substring(s.indexOf(token)+1, s.indexOf(")"));
				aux1 = verificaExpressao(ant ,v,indiceVet);		
				aux2 = verificaExpressao(prox ,v,indiceVet);
				
				//compara se há equivalencia entre as partes da expressão
				if(token == '?'){		
					if(aux1==aux2){
						return linhaAtual;//condição valida continua executando na proxima linha, dentro do escopo do se.
					}else{
						return -1;//para sair do escopo do se
						
					}
				}

				//compara se há uma parte da expressão é menor que a outra
				if(token =='<'){
					if(aux1<aux2){
						return linhaAtual;//condição valida continua executando na proxima linha, dentro do escopo do se.
					}else{
						return -1;//para sair do escopo do se
					}
				}				
				
				//compara se há uma parte da expressão é maior que a outra
				if(token == '>'){
					if(aux1 > aux2){
						return linhaAtual;//condição valida continua executando na proxima linha, dentro do escopo do se.
					}else{
						return -1;//para sair do escopo do se
					}
				}	

				//compara se as partes da expressão são diferentes
				if(token =='^'){
					if(aux1 != aux2){
						return linhaAtual;//condição valida continua executando na proxima linha, dentro do escopo do se.
					}else{
						return -1;//para sair do escopo do if
					}
				}
			}	
		}
		return 0;
	}
	public double verificaExpressao(String s, Variaveis v[],int indiceVet){
		double valor = 0.0;
		if(s.matches("^[0.0-9.9]*$")){
			valor = Double.parseDouble(s);	
		}else{
			for(int i=0; i<indiceVet; i++){
				if(v[i].nome.equals(s)){
					valor = v[i].valor;
				}	
			}	
		}
		return valor;
	}
}