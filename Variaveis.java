class Variaveis{
	public String nome,aux,aux2;
	public double aux3;
	public double valor;
	
	public Variaveis(){
		this.nome = new String();
		this.valor = 0;
		
	}
	public void declaraVar(String s, Variaveis var[], int indiceVet){
		if(s.contains("<-")){
			if(s.contains("@")){  //se for declaração com atribuição
				this.nome = s.substring(s.indexOf("@")+1, s.indexOf("<-"));
				aux = s.substring(s.indexOf("<-")+2, s.indexOf(";"));
				this.valor = Double.parseDouble(aux);
			}else{ // se for somente atribuição
				aux = s.substring(s.indexOf("&"), s.indexOf("<-"));		
				aux2 = s.substring(s.indexOf("<-")+2, s.indexOf(";"));
				aux3 = Double.parseDouble(aux2);
				
				for(int j = 0; j < indiceVet; j++){
					if(var[j].nome.equals(aux) ){
						var[j].valor = aux3;
					}
				}	
			}
		}else{ //se for declaração
			this.nome = s.substring(s.indexOf("@")+1, s.indexOf(";"));
			this.valor = 0;		
		}				
	}
}