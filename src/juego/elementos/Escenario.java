package juego.elementos;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JPanel;
import juego.Cell;
import juego.estado.EstadoJuego;
import juego.estado.Juego;
import juego.manager.StateManager;
import juego.paneles.Ganador;

public class Escenario extends JPanel{
	
	final static int CELL = 20;
	private String map = "src/levels/level1.txt/";
    private int	tileHeight;
    private int	tileWidth;
    private Cell[][] cells;
    private Juego juego;
	private Ganador gano;
	
	public Cell[][] getCells() {
		return cells;
	}

	public void setCells(Cell[][] cells) {
		this.cells = cells;
	}

	public Escenario(Juego juego) {
		this.juego = juego;
		  createCellArray(map);
	}
	
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
	 
	 public void render(Graphics g) {
	       // super.paintComponent(g);
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
	 
	 public void update() {
		 int count = 0;
		 for (int row = 0; row < tileHeight; row++) {
			 // corrimiento atraves de cada columna del arreglo
	            for (int column = 0; column < tileWidth; column++) {
	               if (cells[column][row].getType() == 'd' || cells[column][row].getType() == 'p')
	            	   count ++;
	            }
	        }
		 if (count == 0) {
			 StateManager.getInstance().setCurrentEstado(EstadoJuego.MENU);
			gano = new Ganador();
			gano.setVisible(true);
			gano.setAlwaysOnTop(true);
			//int score = juego.getScore();
			/* Aqui tomar el score guardado, si es que hay uno
			 * y compararlo con el score obtenido
			 * Si es mayor entonces 
			 * 	//Scores about = new Scores();
				//about.setVisible(true);
				//about.setAlwaysOnTop(true);
				
			 */
		 }
			
			 
	 }

	

}
