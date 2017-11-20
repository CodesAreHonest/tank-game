/**
* 
*@author(Chai Ying Hua) 
*
*   Gameboard class is a View class in MVC Pattern that interact and display to User
*   -----------------------------------------------------------------------------------
*   1.  This class consist of 10x10 JPanel and contains 2 Tanks (JLabel)
*   2.  The main function is use to display the action of Tanks / show how the Tanks animates in the games. 
*
*/

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

public class Gameboard extends JPanel { 

    private final int GRID_SIZE = 10;
    private JPanel gameBoard [][] = new JPanel[GRID_SIZE][GRID_SIZE];
    private Border thinBorder = BorderFactory.createLineBorder(Color.black);
    private Images tank = null;
    private Images user = new Images();
    private Images computer  = new Images();
    private UserTank userTank;
    private ComputerTank computerTank;
    private Move move;
    
   /*
    * @author (Chai Ying Hua)
    * 
    *  During the Gameboard's contructor is called :- 
    *    1. Create a new 10x10 JPanel
    *    2. Create ComputerTank and UserTank
    *    3. Call the Move Constructor to register the ComputerTank and UserTank
    */
    public Gameboard() { 
        setLayout(new GridLayout(GRID_SIZE,GRID_SIZE,1,1));
        for(int x = 0 ; x < GRID_SIZE; x++) { 
            for(int y = 0 ; y < GRID_SIZE; y++ ) {
                   gameBoard[y][x] = new JPanel();       
                   gameBoard[y][x].setBorder(thinBorder);
                   add(gameBoard[y][x]);
            }
        }
        
        
        computerTank = new ComputerTank(this);
        userTank = new UserTank(this);
        move = new Move(computerTank, userTank);
        
        userTank.registerUserMove(move);
        computerTank.registerComMove(move);
       
    }
    
    
	/*
    * @author (Chai Ying Hua)
    * 
    *  The gameboard orders the tank to show the moves. 
    */
    public void moveAllTheTank() {
        userTank.showTheMove();
    }
    
    /*
    * @author (Chai Ying Hua)
    * 
    *  This function allow the tank to place on specific location in Gameboard
    */
	public void setTankAt(Images images, int x, int y, ImageIcon pictures) {
        tank = images;
        tank.setImages(pictures);
        revalidate();
        repaint();

	gameBoard[x][y].add(tank);
        revalidate();   
        repaint();  
        
    }

    /*
    * @author (Chai Ying Hua)
    * 
    *  This function allow to remove the tank from specific location in Gameboard
    */
    public void removeTankAt(int x, int y) {
        gameBoard[x][y].removeAll();
        tank = null;
        revalidate();
        repaint();
    }

    /*
    * @author (Shubar, Abduelhakem G Abdusalam)
    * 
    *  This function allow to get the data of UserTank
    */
    public UserTank getUserTank(){
        return userTank;
    }
    
    /*
    * @author (Shubar, Abduelhakem G Abdusalam)
    * 
    *  This function allow to get the data of ComputerTank
    */
    public ComputerTank getComputerTank(){
        return computerTank;
    }

}
