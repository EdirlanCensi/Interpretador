import java.util.*;
class Escreva{
	public String frase,nomeVar;
	public double valor;
	public void escrever(String s,Variaveis var[],int indiceVet){
		Scanner in = new Scanner(System.in);
		nomeVar = s.substring(s.indexOf("escreva(")+8, s.indexOf("!")-1);
		if(nomeVar.contains("&")){
			valor = in.nextDouble();
		}
		if(nomeVar.contains("$")){
			frase = in.nextLine();
		}

		for(int i=0; i < indiceVet ; i++){
			if(nomeVar.equals(var[i].nome) ){
				if(nomeVar.contains("&")){
					var[i].valor = valor;
				}
				if(nomeVar.contains("$")){
					var[i].frase = frase;
				}
			}
		}
	}
}