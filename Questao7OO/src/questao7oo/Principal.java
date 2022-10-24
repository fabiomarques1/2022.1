
package questao7oo;

import java.util.ArrayList;
import javax.swing.JOptionPane;


public class Principal {

    static ArrayList<Contato> contatos = new ArrayList<Contato>();

    public static void main(String[] args) {
        String teclado;
        int opcao;
        Contato contato;
        
        
        loopPrincipal: do {
        teclado = JOptionPane.showInputDialog("Informe "
                + "\n1- Incluir Contato"
                + "\n2-Listar Contato"
                + "\n3-Pesquisar Contato"
                + "\n4-Editar Contato"
                + "\n5-Apagar Contato"
                + "\n6-Sair");
        opcao = Integer.parseInt(teclado);

        switch (opcao) {
            case 1:
                contato = new Contato();

                teclado = JOptionPane.showInputDialog("Informe o nome:");
                contato.setNome(teclado);

                teclado = JOptionPane.showInputDialog("Informe o telefone:");
                contato.setTelefone(teclado);
        
                contatos.add(contato);
                break;
            case 2:
                System.out.println("Lista de Contatos:");
                for (Contato c: contatos) {
                    System.out.println(c);
                }
                System.out.println("Fim da lista.");
                break;
            case 3:
                teclado = JOptionPane.showInputDialog("Informe nome a pesquisar:");
                contato = pesquisarContato(teclado);
                if (contato != null) {
                    System.out.println("Encontrado " + contato);
                } else {
                    System.out.println("Contato Inexistente!");
                }
                break;
            case 4: 
                teclado = JOptionPane.showInputDialog("Informe nome a editar:");
                contato = pesquisarContato(teclado);
                
                if (contato != null) {
                    int indice = contatos.indexOf(contato);
                    teclado = JOptionPane.showInputDialog("Informe o novo nome :");
                    contato.setNome(teclado);
                    teclado = JOptionPane.showInputDialog("Informe o novo telefone :");
                    contato.setTelefone(teclado);
                    contatos.set(indice, contato);
                }else {
                    System.out.println("Contato Inexistente!");
                }
                break;
            case 5:
                teclado = JOptionPane.showInputDialog("Informe nome a apagar:");
                contato = pesquisarContato(teclado);
                if (contato != null) {
                    contatos.remove(contato);
                } else {
                    System.out.println("Contato Inexistente!");
                }
                break;
            case 6:
                System.out.println("Finalizando programa...");
                break loopPrincipal;
            default:
                System.out.println("Opção Inválida!");
        }
        
        }while (true);
        
    }
    
    public static Contato pesquisarContato(String nome) {
        Contato contato = null;

        for (Contato c : contatos) {
            if (c.getNome().equals(nome)) {
                contato = c;
            }
        }
        
        return contato;

    }
}
