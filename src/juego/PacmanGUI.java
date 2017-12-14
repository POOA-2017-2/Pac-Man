package juego;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import juego.elementos.Maze;

class PacmanGUI extends JFrame {
	public PacmanGUI() {
	}
    private static JTextField gameDisp;
    private static Maze       gameMaze;

    public void startGUI() {

        // declaracion botones
        final JButton stopButton, startButton, pauseButton, resumeButton;
        JFrame        gameBoard = new JFrame("Pacman");

        gameBoard.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gameBoard.getContentPane().setLayout(new BorderLayout());

        //referencia al laberinto
        gameMaze = new Maze();

        // referencia a las celdas que hacen el mapa
        Cell[][] cells = gameMaze.getCells();

        // agrega laberinto al panel
        gameBoard.getContentPane().add(gameMaze, BorderLayout.CENTER);
        startButton = new JButton("Start");
        startButton.setEnabled(true);
        stopButton = new JButton("Stop");
        stopButton.setEnabled(false);
        pauseButton = new JButton("Pause");
        pauseButton.setEnabled(false);
        resumeButton = new JButton("Resume");
        resumeButton.setEnabled(false);
        startButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

      
                startButton.setEnabled(false);
                stopButton.setEnabled(true);
                pauseButton.setEnabled(true);
                resumeButton.setEnabled(true);
            }
        });
        stopButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                startButton.setEnabled(true);
                stopButton.setEnabled(false);
                pauseButton.setEnabled(false);
                resumeButton.setEnabled(false);

            }
        });
        pauseButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                startButton.setEnabled(false);
                stopButton.setEnabled(true);
                pauseButton.setEnabled(false);
                resumeButton.setEnabled(true);

            }
        });
        resumeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                startButton.setEnabled(false);
                stopButton.setEnabled(true);
                pauseButton.setEnabled(true);
                resumeButton.setEnabled(false);

            }
        });

//      SCORE PANEL
        JPanel dispPanel = new JPanel();

        dispPanel.setLayout(new FlowLayout());
        dispPanel.setBackground(Color.BLACK);
        gameBoard.getContentPane().add(dispPanel, BorderLayout.SOUTH);

///////////////////
        gameDisp = new JTextField(10);
        gameDisp.setEditable(false);
        gameDisp.setBackground(Color.BLACK);
        gameDisp.setForeground(Color.YELLOW);
        gameDisp.setBorder(null);
        gameDisp.removeFocusListener(null);
        dispPanel.add(gameDisp);
        newDisp();

//    pantalla juego en menu
        gameBoard.pack();
        gameBoard.setVisible(true);
    }

    public static void newDisp() {
        gameDisp.setText("Score " + gameMaze.getScore() + " Lives " + gameMaze.getLives());
        gameDisp.repaint();
    }
}
