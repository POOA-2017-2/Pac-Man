package juego.elementos;

import java.awt.Color;
import java.awt.Graphics;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import juego.Cell;

public class Escenario {
	
	final static int CELL = 20;
	private String map = "src/levels/level1.txt/";
    private int	tileHeight;
    private int	tileWidth;
    private Cell[][] cells;
	
	public Escenario() {
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

}
