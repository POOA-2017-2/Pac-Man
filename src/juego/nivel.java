package juego;

import java.awt.Color;
import java.awt.Graphics;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JPanel;

public final class nivel extends JPanel {

	final static int CELL=20;
	private String map="src/lvls/level1.txt";
	private int tileHeight;
	private int tileWidth;
	private Cell[][] cells;
	

private void createCellArray(String mapfile) {
	
	Scanner fileReader;
	ArrayList<String> lineList=new ArrayList<String>();
	
	try {
		
		fileReader=new Scanner(new File(mapfile));
		while(true) {
			String line=null;
			try {
				line=fileReader.nextLine();
			}catch(Exception eof) {
				
			}
			
			if(line==null) {
				break;
			}
			lineList.add(line);
			
			
		}
		tileHeight=lineList.size();
		tileWidth=lineList.get(0).length();
		cells=new Cell[tileHeight][tileWidth];
		for(int row=0;row<tileHeight;row++) {
			String line= lineList.get(row);
			for(int column=0;column<tileWidth;column++) {
				char type=line.charAt(column);
				cells[row][column]=new Cell(column,row,type);
			}
		}
				
	}catch (FileNotFoundException e) {
		System.out.println("Maze map file not found");
	}
}
	
	 public void paintComponent(Graphics g) {
	        super.paintComponent(g);
	        g.setColor(Color.BLACK);
	        g.fillRect(0, 0, tileWidth * CELL, tileHeight * CELL);

	        // Outer loop loops through each row in the array
	        for (int row = 0; row < tileHeight; row++) {

	            // Inner loop loops through each column in the array
	            for (int column = 0; column < tileWidth; column++) {
	                cells[row][column].drawBackground(g);
	            }
	        }

	        // Pacman.drawScore(g);
	       
	    }
	
	 public Cell[][] getCells() {
	        return cells;
	    }
	
	}

