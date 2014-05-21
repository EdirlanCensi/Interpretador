class LeString {
	String linha;
	Fluxo f = new Fluxo();
	int i,valores, indiceVet = 0, teste = 0,linhaAtual = 0;
	Variaveis var[] = new Variaveis[200];
	
	
	public void busca(String s[]){
		for(i=0; i < s.length-1; i++){
			teste = 0;
			linhaAtual = i;
			if(s[i] != null){
				linha = s[i];
			if(!linha.contains("exibe(") && !linha.contains("escreva(")){
				linha = linha.replace(" ","");
			}
				if(linha.contains(";")){ //identifica que é uma declaração de variavel ou atribuição
					Variaveis v = new Variaveis();
					v.declaraVar(linha,var, indiceVet);
					for(int i=0; i < indiceVet; i++){ //verifica se já existe a variavel declarada e altera o valor dela caso exita;
						if (var[i].nome.equals(v.nome)){
							if(v.nome.contains("&")){
								this.var[i].valor = v.valor;
							}
							if(v.nome.contains("$")){
								this.var[i].frase = v.frase;
							}
							teste=1;
						}
					}
					if (teste == 0 && linha.contains("@") ){ //se não existe a variavel, declara e armazena seu valor 
						var[indiceVet] = v;
						indiceVet++;
					}						
				}
				
				if(linha.contains("exibe(")){ //printar na tela
					Exibe e = new Exibe();
					e.imprimeString(linha,var,indiceVet);
				
				}		
				
				if(linha.contains("se(")){ //controle de fluxo
					int fl,auxl=0;
					String linhaAux = "NULL";
					
					fl = f.fluxo(linha,var,indiceVet,linhaAtual); //faz o fluxo
					if(fl == -1){ //se expressão for falsa ignora escopo do if
						auxl = linhaAtual;
						do{
							linhaAux = s[auxl];
							auxl++;  
						}while( !linhaAux.contains("end!")  ); 
						
						linhaAtual = auxl;
						
						i = linhaAtual;
					
					}else{
						linhaAtual = fl;
						i = linhaAtual;
					}
				}
				
				if(linha.contains("enquanto(")){ //laço
					Laco  l = new Laco();
					
				
				}
				
				if(linha.contains("escreva(")){ //scaner teclado
					Escreva es = new Escreva();
					es.escrever(linha ,var,indiceVet);
				}
			}
				
		}
		
	}
	
}