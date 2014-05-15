class Variaveis{
	public String nome,aux;
	public double valor;
	
	public Variaveis(String s){
		if(s.contains("<-")){
			this.nome = s.substring(s.indexOf("@")+1, s.indexOf("<-"));
			aux = s.substring(s.indexOf("<-")+1, s.indexOf(";"));
			this.valor = Double.parseDouble(aux);

		}else{
			this.nome = s.substring(s.indexOf("@")+1, s.indexOf(";"));
			this.valor = 0;		
		}
			
	}
	
}