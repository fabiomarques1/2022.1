
package ufc;

import java.util.Random;


public class Luta {
    
    Lutador desafiante;
    Lutador desafiado;
    boolean aprovada;
    
    public Luta(Lutador desafiante, Lutador desafiado) {
        this.desafiante = desafiante;
        this.desafiado = desafiado;
        
        this.aprovada = false;
        if (!desafiante.getNome().equals(desafiado.getNome())
            && desafiante.getCategoria().equals(desafiado.getCategoria())) {
            this.aprovada = true;   
        }
    }

    public boolean lutar() {
        
        if (this.aprovada) {

            Random random = new Random();
            int resultado = random.nextInt(3);

            switch (resultado) {
                case 0:
                    System.out.println("Empate!");
                    desafiante.empatarLuta();
                    desafiado.empatarLuta();
                    break;
                case 1:
                    System.out.println("Desafiante venceu!");
                    desafiante.ganharLuta();
                    desafiado.perderLuta();
                    break;
                case 2:
                    System.out.println("Desafiado venceu!");
                    desafiante.perderLuta();
                    desafiado.ganharLuta();
                    break;
            }
        }
        
        return this.aprovada;
    }
}
