class Exibe {
	String aux;
	public void imprimeString(String s,Variaveis var[], int indiceVet){
		for(int i = 0; i < s.length(); i++){
				if(s.charAt(i) == '*'){
					aux = s.substring(s.indexOf("*")+1, s.indexOf("!")-1);
					System.out.println(aux);
				}
				if(s.charAt(i) == '&'){ //se a variavel for double
					aux = s.substring(s.indexOf("&"), s.indexOf("!")-1);
					for(int j = 0; j < indiceVet; j++){
						if(var[j].nome.equals(aux) ){
							System.out.println(var[j].valor);
						}
					}
				}
				if(s.charAt(i) == '$'){ // se a variavel conter string
					aux = s.substring(s.indexOf("$"), s.indexOf("!")-1);
					for(int j = 0; j < indiceVet; j++){
						if(var[j].nome.equals(aux) ){
							System.out.println(var[j].frase);
						}
					}
				}
		}
	}
}