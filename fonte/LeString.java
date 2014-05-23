class LeString {
	String linha;
	int i,valores, indiceVet = 0, teste = 0,linhaAtual = 0, testeL=0,testeS=0;
	Variaveis var[] = new Variaveis[200];
	
	public int v[] = new int[300];
	public int topo = -1;
	
	Fluxo f = new Fluxo();
				
	public void busca(String s[]){
		for(i=0; i < s.length-1; i++){
			if(s[i] != null){
				linhaAtual = i;
				linha = s[i];
				//System.out.println("Linha "+linhaAtual+"        "+linha);
				
				if(!linha.contains("exibe(*")){
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
	
				if(linha.contains("enquanto(")){ //laço
					int fl2;
					String linhaAux2;
					
					fl2 = f.fluxo(linha,var,indiceVet,linhaAtual);
					
					if(fl2==-1){			
						//se caso a condição do while não for verdadeira
						linhaAux2 = "fim";
						
						do{
							if( s[linhaAtual].contains(linhaAux2) ){
								break;
							}else{
								linhaAtual++;
							}	
						}while( s[linhaAtual+1]!= null);
			
						testeL=0;
						linhaAtual--;
					}else{
						if(	testeL  == 0 ){
							v[++topo] = linhaAtual;
						}
						testeL = 1;
						linhaAtual = fl2;
					}
					i = linhaAtual;
				}
				if(linha.contains("fim")){
					if(testeL==1){ // se precisar repetir o laço
						linhaAtual = v[topo]-1;
						i = linhaAtual;
					}
				}	
				if(linha.contains("se(")){ //controle de fluxo
					int fl;
					String linhaAux;
					
					fl = f.fluxo(linha,var,indiceVet,linhaAtual); //faz o fluxo
					if(fl == -1){ //se expressão for falsa ignora escopo do if
						linhaAux = "end";	
						while(!s[linhaAtual].contains(linhaAux)){
							linhaAtual++;
						}
					}else if(fl == 0){
						System.out.println("Operador nao existe");
						break;
					}else{
						linhaAtual = fl;
					}
					i = linhaAtual;
				}
				if(linha.contains("escreva(")){ //scaner teclado
					Escreva es = new Escreva();
					es.escrever(linha ,var,indiceVet);
				}	
			}
		}
	}
}	