package juego.elementos;

import java.awt.Color;
import java.awt.Graphics;

import java.io.File;
import java.io.FileNotFoundException;

import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JPanel;

import juego.Cell;
//import juego.PacmanGUI;


public final class Maze extends JPanel {
    final static int CELL                = 20;
    private int      ghostInitialColumn  = 13;
    private int      ghostInitialRow     = 21;
    private int      lives               = 3;
    private String   map                 = "src/pacman/levels/level1.txt/";
    private int      pacmanInitialColumn = 7;
    private int      pacmanInitialRow    = 21;
    private int      score               = 0;
    private Enemigo    blinky;
    private Cell[][] cells;
    private Enemigo    clyde;
    private Enemigo    inky;
    public Jugador    pacman;
    private Enemigo    pinky;
    private int      tileHeight;
    private int      tileWidth;

    public Maze() {
        createCellArray(map);
     /*   setPreferredSize(new Dimension(CELL * tileWidth, CELL * tileHeight));
        pacman = new Jugador(null, pacmanInitialRow, pacmanInitialColumn, this, 3);
        inky   = new Enemigo(ghostInitialRow, ghostInitialColumn, this, "inky.png");
        blinky = new Enemigo(ghostInitialRow + 3, ghostInitialColumn, this, "blinky.png");
        pinky  = new Enemigo(ghostInitialRow, ghostInitialColumn + 3, this, "pinky.png");
        clyde  = new Enemigo(ghostInitialRow + 3, ghostInitialColumn + 3, this, "clyde.png");

        
        checkCollision();
        repaint();*/
    }

    /**
     * lectura arreglo bidimensional
     */
    private void createCellArray(String mapFile) {

        // lectura mapa
        Scanner           fileReader;
        ArrayList<String> lineList = new ArrayList<String>();

        // carga laberinto
        try {
            fileReader = new Scanner(new File(mapFile));

            while (true) {
                String line = null;

                try {
                    line = fileReader.nextLine();
                } catch (Exception eof) {

                   
                }

                if (line == null) {
                    break;
                }

                lineList.add(line);
            }

            tileHeight = lineList.size();
            tileWidth  = lineList.get(0).length();

            // Create the cells
            cells = new Cell[tileHeight][tileWidth];

            for (int row = 0; row < tileHeight; row++) {
                String line = lineList.get(row);

                for (int column = 0; column < tileWidth; column++) {
                    char type = line.charAt(column);

                    cells[row][column] = new Cell(column, row, type);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Maze map file not found");
        }
    }

    /**
     *iteraciones atraves de cada celda y cuadro
     *
     *
     */
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, tileWidth * CELL, tileHeight * CELL);
        	//corrimiento atraves de cada hilera del arreglo
        
        for (int row = 0; row < tileHeight; row++) {

            // corrimiento atraves de cada columna del arreglo
            for (int column = 0; column < tileWidth; column++) {
                cells[row][column].drawBackground(g);
            }
        }

  
      
    }

    public Cell[][] getCells() {
        return cells;
    }

    public int getScore() {
        return pacman.getScore();
    }

    public int getLives() {
        return pacman.getLives();
    }

    public void setEdible() {
        inky.setDeadly(false);
        blinky.setDeadly(false);
        pinky.setDeadly(false);
        clyde.setDeadly(false);
        inky.setEdibleLifeRemaining(inky.getEdibleLifeRemaining());
        blinky.setEdibleLifeRemaining(blinky.getEdibleLifeRemaining());
        pinky.setEdibleLifeRemaining(pinky.getEdibleLifeRemaining());
        clyde.setEdibleLifeRemaining(clyde.getEdibleLifeRemaining());
       // System.out.println("OMNOMNOM!");
    }

    public void checkCollision() {
        if (pinky.isDeadly() && (pinky.getCol() == pacman.getY()) && (pinky.getRow() == pacman.getX())) {
            System.out.println("Pacman eaten by Pinky!");
            loseLife();
        } else if (inky.isDeadly() && (inky.getCol() == pacman.getY()) && (inky.getRow() == pacman.getX())) {
            System.out.println("Pacman eaten by Inky!");
            loseLife();
        } else if (blinky.isDeadly() && (blinky.getCol() == pacman.getY()) && (blinky.getRow() == pacman.getX())) {
            System.out.println("Pacman eaten by Blinky!");
            loseLife();
        } else if (clyde.isDeadly() && (clyde.getCol() == pacman.getY()) && (clyde.getRow() == pacman.getX())) {
            System.out.println("Pacman eaten by Clyde!");
            loseLife();
        }
    }

    public void loseLife() {
        lives--;
       // PacmanGUI.newDisp();    // actualizar vidas

        //integrar animacion muerte
        if (lives <= 0) {
        /*	inky.endgame();
            blinky.endgame();
            pinky.endgame();
            clyde.endgame();
            pacman.endgame();*/
            System.out.println("Game Over!");
        }
    }
}
