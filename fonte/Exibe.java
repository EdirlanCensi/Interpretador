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
 * Essa classe imprime na tela
 **/
 
 class Exibe {
	String aux;
	//método para imprimir na tela
	public void imprimeString(String s,Variaveis var[], int indiceVet){
		for(int i = 0; i < s.length(); i++){
				if(s.charAt(i) == '*'){
					aux = s.substring(s.indexOf("*")+1, s.indexOf("!")-1);
					System.out.print(aux+" ");
				}
				
				if(s.charAt(i) == '&'){ //se a variavel for double
					aux = s.substring(s.indexOf("&"), s.indexOf("!")-1);
					for(int j = 0; j < indiceVet; j++){
						if(var[j].nome.equals(aux) ){
							System.out.println( var[j].valor);
						}
					}
				}
				if(s.charAt(i) == '$'){ // se a variavel conter string
					aux = s.substring(s.indexOf("$"), s.indexOf("!")-1);
					for(int j = 0; j < indiceVet; j++){
						if(var[j].nome.equals(aux) ){
							System.out.println(var[j].frase);
						}
					}
				}
				
		}
	}
}