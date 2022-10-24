
package questao7;

import javax.swing.JOptionPane;

public class Questao7 {


    public static void main(String[] args) {
        //Declarar Variáveis
        String agenda[][];
        String teclado, nome, telefone;
        int i = 0, tam, posicao;
        
        //Perguntar o tamanho da agenda
        teclado = JOptionPane.showInputDialog("Quantas pessoas terá a agenda?");
        tam = Integer.parseInt(teclado);
        
        /*
         * Instanciar a matriz agenda com qtde de linhas definidas pelo
         * usuário e 2 colunas (Coluna 0 - Nome, Coluna 1 - Telefone) 
         */
        agenda = new String[tam][2];
             
        
        int opcao;
        loopMenu: do {
            teclado = JOptionPane.showInputDialog("Digite uma das opções da Agenda:"
                    + "\n1:Incluir Contato\n2:Pesquisar Contato\n3:Editar Contato\n4: Apagar Contato"
                    + "\n5:Listar\n6:Sair");
            opcao = Integer.parseInt(teclado);
            switch(opcao) {
                case 1:
                    if (i < tam) {
                        i = incluirContato(i, agenda);
                    } else {
                        System.out.println("Agenda Cheia!");
                    }
                    break;
                case 2:
                    if (i > 0) {
                        teclado = JOptionPane.showInputDialog("Informe o nome a pesquisar:");
                        nome = teclado;
                        posicao = pesquisarContato(nome, i, agenda);
                        if (posicao > -1) {
                            nome = agenda[posicao][0];
                            telefone = agenda[posicao][1];
                            System.out.println("Nome: " + nome + "\nTelefone: " + telefone);
                        } else {
                            System.out.println("Contato Inexistente!");
                        }
                    } else {
                        System.out.println("Agenda Vazia!");
                    }
                    break;
                case 3:
                    if (i > 0) {
                        teclado = JOptionPane.showInputDialog("Informe o nome a editar:");
                        nome = teclado;
                        posicao = editarContato(nome, i, agenda);
                        if (posicao > -1) {
                            System.out.println("Contato Editado!");
                        } else {
                            System.out.println("Contato Inexistente!");
                        }
                    } else {
                        System.out.println("Agenda Vazia!");
                    }
                    break;
                case 4:
                    if (i > 0) {
                        teclado = JOptionPane.showInputDialog("Informe o nome a apagar:");
                        nome = teclado;
                        posicao = apagarContato(nome, i, agenda);
                        if (posicao > -1) {
                            System.out.println("Contato Apagado!");
                            i = posicao;
                        } else {
                            System.out.println("Contato Inexistente!");
                        }
                    } else {
                        System.out.println("Agenda Vazia!");
                    }
                    break;
                case 5:
                    if (i > 0) {
                        listarContato(i, agenda);
                    } else {
                        System.out.println("Agenda Vazia!");
                    }
                    break;
                case 6:
                    System.out.println("Finalizando sistema...");
                    break loopMenu;
                default:
                    System.out.println("Opcão Inválida!");
            }
            
        } while (true);
    }
    
    public static int incluirContato(int i, String agenda[][]) {
        String teclado;
        
        teclado = JOptionPane.showInputDialog("Informe o nome:");
        agenda[i][0] = teclado;
        
        teclado = JOptionPane.showInputDialog("Informe o telefone:");
        agenda[i][1] = teclado;
        
        i++;
        return i; 
    }
    
    public static int pesquisarContato(String nomePesquisado, 
            int i, String agenda[][]) {
        int x = 0;
        String nome;
        
        int posicao = -1;
        do {
            nome = agenda[x][0];
            if (nome.equals(nomePesquisado)) {
               posicao = x;
               break; 
            }
            x++;
        } while (x < i);
        
        return posicao;
    }
    
    public static int editarContato(String nomeAEditar, 
            int i, String agenda[][]) {
        int posicao = -1;
        String teclado;
        
        posicao = pesquisarContato(nomeAEditar, i, agenda);
        
        if (posicao > -1) {
            teclado = JOptionPane.showInputDialog("Informe o nome:");
            agenda[posicao][0] = teclado;
            teclado = JOptionPane.showInputDialog("Informe o telefone:");
            agenda[posicao][1] = teclado;
            return posicao;
        } else {
            return -1;
        }
    }
    
    public static int apagarContato(String nomePesquisado,
            int i, String agenda[][]) {
        int x, posicao = -1;

        posicao = pesquisarContato(nomePesquisado, i, agenda);

        if (posicao > -1) { //Nome encontrado!
            //Apaga dados na posição
            agenda[posicao][0] = null; 
            agenda[posicao][1] = null;
            if (posicao < (i - 1)) { //Se não é a última posição incluída
                //Atribui a posicão seguinte à anterior
                x = posicao;
                do {
                    agenda[x] = agenda[x + 1];
                    x++;
                } while (x < i);
                //Apaga dados da última posição
                agenda[i][0] = null;
                agenda[i][1] = null;
            }
            return i-1; //retira uma posição do índice
        } else {
            return -1; // retorno indicando nome inexistente
        }
    }
    
    public static void listarContato(int i, String agenda[][]) {
        int x = 0;
        System.out.println("Imprimindo Agenda:");
        do {
            System.out.println("Nome " + agenda[x][0] + 
                    "\nTelefone: " + agenda[x][1]);
            x++;
        } while(x < i);
    }
}

