/**
 * Exemplo de interpretador.
 *
 * Esse código é um interpretador para a linguagem 'eT'.
 *
 * Por Edirlan Censi e Taiane Baldin
 */

class Interpretador {
    private String linhas[];
    
    public void interpreta(String l[]) {
        this.linhas = l;
		LeString o = new LeString();
		o.busca(linhas);
    }
}