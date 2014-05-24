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
 * Essa classe interpreta se for declaração de variável, ou somente atribuição de valor (double ou string) à uma variável.
 **/
 
 class Variaveis{
	public String nome,aux,aux2, frase;
	public double aux3;
	public double valor;
	public Comandos c = new Comandos();
	public Variaveis(){
		this.nome = "NULL";
		this.valor = 0;
		this.frase = "NULL";		
	}
	public void declaraVar(String s, Variaveis var[], int indiceVet){
		if(s.contains("<-")){
			if(s.contains("@")){  //se for declaração com atribuição
				this.nome = s.substring(s.indexOf("@")+1, s.indexOf("<-"));
				aux = s.substring(s.indexOf("<-")+2, s.indexOf(";"));
				if(s.contains("&")){
					this.valor = Double.parseDouble(aux);
				}
				if(nome.contains("$") ){
					this.frase = aux;
				}
			}else{ // se for somente atribuição
				if(s.contains("&")){ //se for double
					aux = s.substring(s.indexOf("&"), s.indexOf("<-"));		
					aux2 = s.substring(s.indexOf("<-")+2, s.indexOf(";"));
					if(aux2.contains("(")){
						aux3 = c.operacao(aux2, var, indiceVet);
					}else{	
						aux3 = Double.parseDouble(aux2);
					}
				}
				if(s.contains("$")){ //se for string
					aux = s.substring(s.indexOf("$"), s.indexOf("<-"));		
					aux2 = s.substring(s.indexOf("<-")+2, s.indexOf(";"));
				}
				for(int j = 0; j < indiceVet; j++){
					if(var[j].nome.equals(aux) ){
						if(aux.contains("&")){
							var[j].valor = aux3;
						}
						if(aux.contains("$")){
							var[j].frase = aux2;
						}
					}
				}	
			}
		}else{ //se for só declaração
			if(s.contains("@")){
				if(s.contains("&")){
					this.nome = s.substring(s.indexOf("&"), s.indexOf(";"));
					this.valor = 0;
				}
				if(s.contains("$")){
					this.nome = s.substring(s.indexOf("$"), s.indexOf(";"));
					this.frase = "NULL";		
				}
			}
		}				
	}
}