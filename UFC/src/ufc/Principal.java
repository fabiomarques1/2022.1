
package ufc;

import java.util.Random;
import javax.swing.JOptionPane;


public class Principal {

    public static void main(String[] args) {
        Lutador lutador1 = new Lutador();
        lutador1 = solicitarDados();
        
        Lutador lutador2 = new Lutador();
        lutador2 = solicitarDados();
        
        Luta luta = new Luta(lutador1, lutador2);
        boolean aprovacao = luta.lutar();
        
        if (aprovacao) {
            System.out.println("Desafiante: " + lutador1.status());
            System.out.println("Desafiado: " + lutador2.status());
        } else {
            System.out.println("Luta não foi aprovada!");
        }
        
        
    }
    
    public static Lutador solicitarDados() {
        String teclado;
        
        Lutador lutador = new Lutador();
        
        teclado = JOptionPane.showInputDialog("Informe o nome");
        lutador.setNome(teclado);
        
        teclado = JOptionPane.showInputDialog("Informe a nacionalidade");
        lutador.setNacionalidade(teclado);
        
        do {
            teclado = JOptionPane.showInputDialog("Informe a idade");
            lutador.setIdade(Integer.parseInt(teclado));
        } while (lutador.getIdade() == 0);
        
        do {
            teclado = JOptionPane.showInputDialog("Informe a altura");
            lutador.setAltura(Float.parseFloat(teclado));
        } while (lutador.getAltura() == 0);
        
        do {
            teclado = JOptionPane.showInputDialog("Informe o peso");
            lutador.setPeso(Float.parseFloat(teclado));
        } while (lutador.getPeso() == 0);
        
        lutador.setCategoria();
        lutador.setVitoria(0);
        lutador.setDerrota(0);
        lutador.setEmpate(0);
        
        return lutador;
        
    }
}
