/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examencodtwitter;

import javax.swing.JOptionPane;
import twitter4j.TwitterException;

/**
 *
 * @author dcuerdogarcia
 */
public class ExamenCodTwitter {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws TwitterException {

        Metodos obx = new Metodos();

        int opcion = Integer.parseInt(JOptionPane.showInputDialog("Seleccione Opcion:\n 1.-Ver TimeLine\n 2.- Buscar\n 3.-Tuitear"));

        if (opcion == 1) {
            obx.verTimeLine();
        }
        if (opcion == 2) {
            String msg = JOptionPane.showInputDialog("Introduzca la palabra o frase a buscar");
            obx.buscar(msg);
        }

        if (opcion == 3) {
            String tweet = JOptionPane.showInputDialog("Inserte el mensaje a twitear");

            obx.twitear(tweet);
        }

        if (opcion < 1 && opcion > 3) {
            System.exit(0);
        }
    }

}
