/**
 * Exemplo de interpretador.
 *
 * Esse código é um interpretador para a linguagem 'eT'.
 *
 * Por Edirlan Cenci e Taiane Baldin
 */

class Interpretador {
    private String linhas[];
    
    public void interpreta(String l[]) {
        this.linhas = l;
		LeString o = new LeString();
		o.busca(linhas);
        
        /*for(int i = 0; i < this.linhas.length; i++) {
            if(this.linhas[i] != null) {
                // TODO: interpretar a linha 
                //System.out.println("Linha " + (i + 1) + ": " + this.linhas[i]);
            }
        } */
    }
}