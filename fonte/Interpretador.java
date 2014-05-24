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
 * Essa classe lê as linhas do prompt de comando e atribui à um vetor de Strings
 **/

class Interpretador {
    private String linhas[];
    
    public void interpreta(String l[]) {
        this.linhas = l;
		LeString o = new LeString();
		o.busca(linhas);//método que busca linha a linha
    }
}