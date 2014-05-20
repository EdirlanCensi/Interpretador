class LeString {
	Fluxo f =new Fluxo();
	Comando c = new Comando();
	String linha;
	int i,valores, indiceVet = 0, teste = 0;
	Variaveis var[] = new Variaveis[200];
	
	
	public void busca(String s[]){
		for(i=0; i < s.length-1; i++){
			teste = 0;
			if(s[i] != null){
				linha = s[i];
				linha = linha.replace(" ","");
				
				if(linha.contains(";")){ //identifica que é uma declaração de variavel ou atribuição
					Variaveis v = new Variaveis();
					v.declaraVar(linha,var, indiceVet);
					for(int i=0; i < indiceVet; i++){
						if (var[i].nome.equals(v.nome)){
							this.var[i].valor = v.valor;	
							teste=1;
						}
					}
					if (teste == 0 && linha.contains("@") ){ // se for declaração 
						var[indiceVet] = v;
						indiceVet++;
					}						
				}
				
				if(linha.contains("exibe(")){ //printar na tela
					Exibe e = new Exibe();
					e.imprimeString(linha,var,indiceVet);
				
				}
				
				if(linha.contains("ler(")){ //le do teclado
				
				
				}
				
				if(linha.contains("se(")){ //controle de fluxo
				
				
				
				}
				
				if(linha.contains("enquanto(")){ //laço
				
				
				
				}
			}
				
		}
		/*for(i = 0; i < indiceVet; i++){
			System.out.println("Nome = "+var[i].nome+"\nValor = "+var[i].valor);
		}*/
	}
	
}