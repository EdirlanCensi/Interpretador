class LeString {
	Fluxo f =new Fluxo();
	Comando c = new Comando();
	String linha;
	int i,valores, indiceVet = 0;
	Variaveis var[] = new Variaveis[200];
	
	public void busca(String s[]){
		for(i=0; i < s.length-1; i++){
			if(s[i] != null){
				linha = s[i];
				linha = linha.replace(" ","");
				
				if(linha.contains(";")){ //identifica que � uma declara��o de variavel
					
					Variaveis v = new Variaveis();
					v.declaraVar(linha);
					var[indiceVet] = v;
					indiceVet++;
				}
				
				if(linha.contains("exibe(")){ //printar na tela
					Exibe e = new Exibe();
					e.imprimeString(linha);
				
				}
				
				if(linha.contains("ler(")){ //le do teclado
				
				
				}
				
				if(linha.contains("se(")){ //controle de fluxo
				
				
				
				}
				
				if(linha.contains("enquanto(")){ //la�o
				
				
				
				}
			}
				
		}
		for(i = 0; i < indiceVet; i++){
			System.out.println("Nome = "+var[i].nome+"\nValor = "+var[i].valor);
		}
	}
	
}