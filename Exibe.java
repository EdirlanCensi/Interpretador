class Exibe extends LeString{
	String aux;
	public void imprimeString(String s){
		for(int i = 0; i < s.length()-1; i++){
				if(s.charAt(i) == '*'){
					aux = s.substring(s.indexOf("*")+1, s.indexOf("!")-1);
					//System.out.println(aux);
				}
				if(s.charAt(i) == '&'){
					aux = s.substring(s.indexOf("&")+1, s.indexOf("!")-1);
					//System.out.print(indiceVet);
					for(int j = 0; j < indiceVet; j++){
						if(aux == var[j].nome){
							//System.out.print(var[j].valor);
						}
					}
				}
		}
	}
}