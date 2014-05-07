class LeString{
	Fluxo f =new Fluxo();
	Comando c = new Comando();
	String linha;
	int i,valores,;
	
	public void busca(String s[]){
		for(i=0; i < s.length; i++){
			if(s[i] != null){
				linha = s[i];
				
				if(linha.contains(";")){ //identifica que é uma declaração de variavel
					
					Variaveis var = new Variaveis(linha);
					
				}
				
				if(linha.contains("<-"){ //atribuição
				
				}
				
				if(linha.contains("exibe("){ //printar na tela
				
				
				}
				
				if(linha.contains("ler("){ //le do teclado
				
				
				}
				
				if(linha.contains("se("){ //controle de fluxo
				
				
				
				}
				
				if(linha.contains("enquanto("){ //laço
				
				
				
				}
				
				
			
			
			
			
			
			
			
			
	
			}
				
		}
	}
	
}