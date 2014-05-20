import java.util.*;
class Escreva{
	public String frase,nomeVar;
	public double valor;
	public void escrever(String s,Variaveis var[],int indiceVet){
		Scanner in = new Scanner(System.in);
		
		valor = in.nextDouble();
		nomeVar = s.substring(s.indexOf("escreva(")+8, s.indexOf("!")-1);
		System.out.println(nomeVar);
		for(int i=0; i < indiceVet ; i++){
			if(nomeVar.equals(var[i].nome) ){
				var[i].valor = valor;
			}
		}
	}
}