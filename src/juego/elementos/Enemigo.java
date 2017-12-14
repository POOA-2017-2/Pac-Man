package juego.elementos;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.util.Random;
import juego.Cell;
import juego.estado.Juego;

public class Enemigo {

	
	    private static final String IMAGE_SOURCE        = "/src/Imagenes";
	    int                         edibleLifetime      = 10;
	    boolean                     isRunning           = true;
	    Random                      randGen             = new Random();
	    private int                 edibleLifeRemaining = edibleLifetime;
	    private boolean             deadly              = true;
		Cell[][]                    cells;
	    private Image               ghostPicIcon;
	    private int                 ghostRow, ghostCol;
	    Maze                        maze;
	    private Juego juego; 
	

	 public Enemigo(int initialRow, int initialColumn, Juego juego, String ghostGraphic) {
	        ghostRow = initialRow;
	        ghostCol = initialColumn;
	        this.juego     = juego;
	        cells        = juego.getCells();
	        ghostPicIcon = Toolkit.getDefaultToolkit().getImage(IMAGE_SOURCE + ghostGraphic);
	    }


	public void update() {
		  if (this.deadly == false) {
              this.edibleLifeRemaining--;

              if (this.edibleLifeRemaining <= 0) {
                  this.deadly = true;
              }
          }

          // Movimiento
          switch (randGen.nextInt(4) + 1) {
          case (1) :
              moveCol(0);
          	moveRow(0);

              break;

          case (2) :
              moveCol(-1);
          	moveRow(-1);

              break;

          case (3) :
              moveRow(1);
          	moveCol(1);

              break;

          case (4) :
            moveRow(2);
          	moveCol(2);
              break;
          }

          maze.repaint();
	}

	    public void render(Graphics g) {
	        g.drawImage(ghostPicIcon, ghostRow *20, ghostCol *20, maze);
	    }

	    /*
	     * Get renglon actual
	     *
	     */
	    public int getRow() {
	        return ghostRow;
	    }

	    /*
	     * columna actual
	     *
	     */
	    public int getCol() {
	        return ghostCol;
	    }

	    /*
	     * Movimiento horizontal
	     *
	     */
	    protected void moveRow(int x) {
	        if (isCellNavigable(ghostCol, ghostRow + x)) {
	            ghostRow = ghostRow + x;
	        }
	    }

	    /*
	     * Movimiento vertical
	     *
	     */
	    protected void moveCol(int y) {
	        if (isCellNavigable(ghostCol + y, ghostRow)) {
	            ghostCol = ghostCol + y;
	        }
	    }

	    /*
	     * Run method
	     */
	    
	    public boolean isCellNavigable(int column, int row) {
	        return ((cells[column][row].getType() == 'o') || (cells[column][row].getType() == 'd')
	                || (cells[column][row].getType() == 'p'));
	    }
	    
	    public int getEdibleLifetime() {
			return edibleLifetime;
		}

		public void setEdibleLifetime(int edibleLifetime) {
			this.edibleLifetime = edibleLifetime;
		}

		public int getEdibleLifeRemaining() {
			return edibleLifeRemaining;
		}

		public void setEdibleLifeRemaining(int edibleLifeRemaining) {
			this.edibleLifeRemaining = edibleLifeRemaining;
		}


		public boolean isDeadly() {
			return deadly;
		}


		public void setDeadly(boolean deadly) {
			this.deadly = deadly;
		}


}
