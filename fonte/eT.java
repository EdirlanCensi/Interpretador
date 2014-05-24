/**
 * Universidade Federal da Fronteira Sul
 * Ciência da Computação
 * 3ª fase - Programação I
 *
 * Esse é o ponto de partida para o interpretador da linguagem 'eT'.
 * O único objetivo desse programa é instanciar um objeto eT, que é
 * o interpretador da linguagem, passando para ele o caminho do arquivo
 * a ser interpretador. Para mais informações, veja o arquivo eT.java
 *
 * Para executar, rode o seguinte comando no terminal:
 * java eT ./teste.eT
 * 
 * Por:
 * Edirlan Cenci - edirlan.censi@hotmail.com
 * Taiane Baldin - taiane.baldin@gmail.com
 */
import java.util.Scanner;
import java.io.File;

class eT {
    public static void main(String args[])throws Exception {
        File f;
        Scanner s;
        Interpretador b;
        String linhas[] = new String[2000]; // arquivo pode ter, no máximo, 2000 linhas.
            // Referencia o arquivo. args[0] conterá os dados passados pela linha de comando.
            f = new File(args[0]);
            // Mandamos o Scanner ler a partir do arquivo.
            s = new Scanner(f);
            // Instanciamos o interpretador.
            b = new Interpretador();            
            // Lemos todas as linhas do arquivo para dentro do
            // vetor "linhas".
            int i = 0;
            while(s.hasNext()) {
                linhas[i] = s.nextLine();
                i++;
            }            
            // Inicializamos o interpretador com o vetor de linhas. A partir
            // desse ponto, o objeto "b" irá interpretar o código lido do arquivo.
            b.interpreta(linhas);             
    }
}