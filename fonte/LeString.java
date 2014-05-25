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
 * Essa classe busca cada linha para fazer a interpretação e chamar as respectivas classes/métodos.
 **/
 
 class LeString {
	String linha;
	int i,valores, indiceVet = 0, teste = 0,linhaAtual = 0, testeL=0,testeS=0, tif=0, c=0;
	Variaveis var[] = new Variaveis[200];
	public int v[] = new int[300];
	public int topo = -1;
	Fluxo f = new Fluxo();
				
	public void busca(String s[]){//método que busca cada linha para interpretar
		for(i=0; i < s.length-1; i++){
			if(s[i] != null){
				linhaAtual = i;
				linha = s[i];				
				if(!linha.contains("exibe(*")){
					linha = linha.replace(" ","");//tira espaços
				}
				
				//identifica que é uma declaração de variavel ou atribuição
				if(linha.contains(";")){
					teste = 0;
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
						//System.out.println( var[j].valor);
						indiceVet++;
					}				
				}
				
				//printar na tela
				if(linha.contains("exibe(")){ 
					Exibe e = new Exibe();
					e.imprimeString(linha,var,indiceVet);
				}
				
				//Faz o laço "enquanto isso faça isso"
				if(linha.contains("enquanto(")){ 
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
				//verifica se precisar repetir o laço
				if(linha.contains("fim")){
					if(testeL==1){ 
						linhaAtual = v[topo]-1;
						i = linhaAtual;
					}
				}

				//controle de fluxo "se isso faça aquilo"
				if(linha.contains("se(")){ 
					int fl;
					String linhaAux;
					fl = f.fluxo(linha,var,indiceVet,linhaAtual); //faz o fluxo
					if(fl == -1){ //se expressão for falsa ignora escopo do if						
						linhaAux = "end";	
						while(!s[linhaAtual].contains(linhaAux)){
							if (s[linhaAtual].contains("senao")){
								c = 0;
								break;
							}
							else{
								linhaAtual++;
							}
						}
					}else if(fl == 0){
						System.out.println("Operador nao existe");
						break;
					}else{
						linhaAtual = fl;
						c++;
					}
					i = linhaAtual;
				}
				
				if(c != 0){
					if (s[linhaAtual].contains("senao")){
						while(!s[linhaAtual].contains("end")){
							linhaAtual++;
						}
					}
					i = linhaAtual;
				}
				//Ler do teclado e escrever na variável
				if(linha.contains("leia(")){
					Leia e = new Leia();
					e.ler(linha ,var,indiceVet);
				}	
			}
		}
	}
}	