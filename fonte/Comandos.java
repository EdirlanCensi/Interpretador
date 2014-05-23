class Comandos{
	public String ant,prox;
	public char token;
	public double aux1, aux2, aux3;
	public double operacao(String s, Variaveis v[], int indiceVet){
		for(int i=0; i < s.length(); i++){
			try{
				aux3 = Double.parseDouble(s); 
				return aux3;
			}catch(Exception ex){
				if( s.charAt(i) == '+'||s.charAt(i) == '-'||s.charAt(i) == '*'||s.charAt(i) == '/'|| s.charAt(i) == '%' ){
					token = s.charAt(i);
					ant =  s.substring(s.indexOf("(")+1, s.indexOf(token));
					
					prox = s.substring(s.indexOf(token)+1, s.indexOf(")"));
					
					aux1 = verificaExpressao(ant ,v,indiceVet);
					aux2 = verificaExpressao(prox ,v,indiceVet);
					
					if(token == '+'){
						return aux1 + aux2;
					}	
					if(token =='-'){
						return aux1 - aux2;
					}
					if(token == '*'){
						return aux1 *aux2;
					}		
					if(token =='/'){
						if(aux2 != 0){
							return aux1 / aux2;
						}else{
							System.out.println("DIVISÃO POR ZERO");
							break;
						}
					}
					if(token =='%'){
							return aux1 % aux2;
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