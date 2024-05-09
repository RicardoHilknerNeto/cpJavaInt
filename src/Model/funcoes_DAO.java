/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import javax.swing.JOptionPane;
import java.util.ArrayList;


/**
 *
 * @author logonrmlocal
 */

public class funcoes_DAO {
    
    static ArrayList<Integer> aviao = new ArrayList<Integer>();
    static ArrayList<Integer> assento = new ArrayList<Integer>();

    public static void reserva() {
    int IntAviao = Integer.parseInt(View.reserva_GUI.nvoo_txt.getText());
    aviao.add(IntAviao);

    int IntAssento = Integer.parseInt(View.reserva_GUI.nassento_txt.getText());
    
    if(assento.contains(IntAssento)) {
        JOptionPane.showMessageDialog(null, "Assento já reservado, escolha outro");
    } else {
        assento.add(IntAssento); // Movido para o bloco 'else'
        JOptionPane.showMessageDialog(null, "Reserva concluída");
    }
}
    
}