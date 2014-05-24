/**
 * Universidade Federal da Fronteira Sul
 * Ci�ncia da Computa��o
 * 3� fase - Programa��o I
 * 
 * Desenvolvido por:
 * Edirlan Cenci - edirlan.censi@hotmail.com
 * Taiane Baldin - taiane.baldin@gmail.com
 *
 * Esse programa � um interpretador Java para a linguagem 'eT'.
 * Essa classe busca cada linha para fazer a interpreta��o e chamar as respectivas classes/m�todos.
 **/
 import java.util.*;
class Leia{
	public String frase,nomeVar;
	public double valor;
	public void ler(String s,Variaveis var[],int indiceVet){
		Scanner in = new Scanner(System.in);
		nomeVar = s.substring(s.indexOf("leia(")+5, s.indexOf("!")-1);
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