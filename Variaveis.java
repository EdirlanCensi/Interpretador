class Variaveis{
	public String nome;
	public double valor;
	
	public Variaveis(String s[]){
		if(s.contains("<-"){
			this.nome = s.substring(s.indexOf("@")+1, s.indexOf("<-"));
			this.valor = s.substring(s.indexOf("<-")+1, s.indexOf(";"));
		}else{
			this.nome = s.substring(s.indexOf("@")+1, s.indexOf(";"));
			this.valor = 0;		
		}
			
	}
	
}