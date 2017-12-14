package juego;

import javax.swing.SwingUtilities;


public class Main {

  
    public static void main(String[] args) {
        Runnable r;

        r = new Runnable() {
            public void run() {
                new PacmanGUI().startGUI();
            }
        };
        SwingUtilities.invokeLater(r);
    }
}
