class LeString {
	Fluxo f =new Fluxo();
	String linha;
	int i,valores, indiceVet = 0, teste = 0;
	Variaveis var[] = new Variaveis[200];
	
	
	public void busca(String s[]){
		for(i=0; i < s.length-1; i++){
			teste = 0;
			if(s[i] != null){
				linha = s[i];
			if(!linha.contains("exibe(") ){
				linha = linha.replace(" ","");
			}
				if(linha.contains(";")){ //identifica que � uma declara��o de variavel ou atribui��o
					Variaveis v = new Variaveis();
					v.declaraVar(linha,var, indiceVet);
					for(int i=0; i < indiceVet; i++){
						if (var[i].nome.equals(v.nome)){
							this.var[i].valor = v.valor;	
							teste=1;
						}
					}
					if (teste == 0 && linha.contains("@") ){ // se for declara��o 
						var[indiceVet] = v;
						indiceVet++;
					}						
				}
				
				if(linha.contains("exibe(")){ //printar na tela
					Exibe e = new Exibe();
					e.imprimeString(linha,var,indiceVet);
				
				}		
				
				if(linha.contains("se(")){ //controle de fluxo
					Fluxo f = new Fluxo();
					
				
				
				}
				
				if(linha.contains("enquanto(")){ //la�o
					Laco  l = new Laco();
				
				
				}
				
				if(linha.contains("escreva(")){	
					Escreva es = new Escreva();
					es.escrever(linha ,var,indiceVet);
				}
			}
				
		}
		/*for(i = 0; i < indiceVet; i++){
			System.out.println("Nome = "+var[i].nome+"\nValor = "+var[i].valor);
		}*/
	}
	
}