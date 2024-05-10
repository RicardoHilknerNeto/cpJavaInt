package Model;

import javax.swing.JOptionPane;
import java.util.ArrayList;

public class funcoes_DAO {
    
    static ArrayList<Integer> aviao = new ArrayList<Integer>();
    static ArrayList<Integer> assento = new ArrayList<Integer>();
    
    public static void passagens() {
        for(int i = 1 ; i <= 20 ; i++){
            aviao.add(i);
        }
    }

  public static void consultapN() {
    String connvoo = View.pNumero_GUI.c1_txt.getText();
    int intConnvoo = Integer.parseInt(connvoo);
    String mapaAviao = "";

    for (int c = 1; c <= 20; c++) {
        if (c == intConnvoo) {
            String[] passagem = Controller.bd.destinos();

            if (assento.contains(1)) {
                mapaAviao = "\n[X]  []\n[]  []\n[]  []\n[]  []";
            } else if (assento.contains(2)) {
                mapaAviao = "\n[]  [X]\n[]  []\n[]  []\n[]  []";
            } else if (assento.contains(3)) {
                mapaAviao = "\n[]  []\n[X]  []\n[]  []\n[]  []";
            } else if (assento.contains(4)) {
                mapaAviao = "\n[]  []\n[]  []\n[X]  []\n[]  []";
            } else if (assento.contains(5)) {
                mapaAviao = "\n[]  []\n[]  []\n[]  [X]\n[]  []";
            } else if (assento.contains(6)) {
                mapaAviao = "\n[]  []\n[]  []\n[]  []\n[X]  []";
            } else if (assento.contains(7)) {
                mapaAviao = "\n[]  []\n[]  []\n[]  []\n[]  [X]";
            }
            JOptionPane.showMessageDialog(null, passagem[c - 1] + " > " + passagem[c + 1] + "\n" + mapaAviao);
        }
    }
}

   public static void consultaDestino() {
    String[] destinos = Controller.bd.destinos();
    String destinoSelecionado = View.pdestino.c2_txt.getText();
    
    boolean destinoEncontrado = false;
    
    for (int i = 0; i < destinos.length; i++) {
        if (destinos[i].equalsIgnoreCase(destinoSelecionado)) {
            destinoEncontrado = true;
            if (i < destinos.length - 1) {
                String proximoDestino = destinos[i + 1];
                JOptionPane.showMessageDialog(null, proximoDestino + " > " + destinoSelecionado);
            } else {
                JOptionPane.showMessageDialog(null, destinoSelecionado + " é o primeiro destino da lista.");
            }
            break;
        }
    }
    
    if (!destinoEncontrado) {
        System.out.println("Destino não encontrado");
    }
}
   
    public static void consultaOrigem() {
    String[] destinos = Controller.bd.destinos();
    String destinoSelecionado = View.pdestino.c2_txt.getText();
    
    boolean destinoEncontrado = false;
    
    for (int i = 0; i < destinos.length; i++) {
        if (destinos[i].equalsIgnoreCase(destinoSelecionado)) {
            destinoEncontrado = true;
            // Verifica se não estamos no último elemento da lista
            if (i < destinos.length - 1) {
                String proximoDestino = destinos[i + 1];
                JOptionPane.showMessageDialog(null, destinoSelecionado + " > " + proximoDestino);
            } else {
                JOptionPane.showMessageDialog(null, destinoSelecionado + " é o ultimo destino da lista.");
            }
            break;
        }
    }
    
    if (!destinoEncontrado) {
        System.out.println("Destino não encontrado");
    }
}


  
  public static void reserva() {
        int IntAviao = Integer.parseInt(View.reserva_GUI.nvoo_txt.getText());
        int IntAssento = Integer.parseInt(View.pNumero_GUI.c1_txt.getText());
        
        // Verifica se o avião está na lista de aviões
        if (aviao.contains(IntAviao)) {
            // Se o avião não está na lista, adiciona
            aviao.add(IntAviao);
        }
        
        // Verifica se o assento já está reservado para o avião
        if (assento.contains(IntAssento)) {
            JOptionPane.showMessageDialog(null, "Assento já reservado, escolha outro");
        } else {
            // Se não estiver reservado, reserva o assento e informa ao usuário
            assento.add(IntAssento);
            JOptionPane.showMessageDialog(null, "Reserva concluída");
        }
    } 
}