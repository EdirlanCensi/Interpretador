class Fluxo{
	public String ant,prox;
	public char token;
	public double aux1, aux2;
	public int fluxo(String s, Variaveis v[], int indiceVet, int linhaAtual){
		for(int i=0; i < s.length(); i++){
		//^ é diferente , ~ é igual 
			if( s.charAt(i) == '>'||s.charAt(i) == '<'||s.charAt(i) == '^'||s.charAt(i) == '~' ){
				token = s.charAt(i);
				ant =  s.substring(s.indexOf("(")+1, s.indexOf(token));
				
				prox = s.substring(s.indexOf(token)+1, s.indexOf(")"));
				
				aux1 = verificaExpressao(ant ,v,indiceVet);
				aux2 = verificaExpressao(prox ,v,indiceVet);
				
				if(token == '~'){
			
					if(aux1==aux2){
						return linhaAtual;//condição valida continua executando na proxima linha.
					}else{ 	
						return -1;
					}
				}	
				if(token =='<'){
					if(aux1<aux2){
						return linhaAtual;
					}else{
						return -1;
					}
				}
				
				if(token == '>'){
					if(aux1 > aux2){
						return linhaAtual;
					}else{
						return -1;
					}
				}
				
				if(token =='^'){
					if(aux1 != aux2){
						return linhaAtual;
					}else{
						return -1;
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