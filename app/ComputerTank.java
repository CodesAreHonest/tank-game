/**
*@author (Chai Ying Hua)
*
*   ComputerTank class is a MODEL in MVC pattern. 
*   ----------------------------------------------
*   1. This class is function to notify the controller and update the view.
*   2. This class translated the object reads by Iterator (Move.java) in order to make the Computer Tank moves in the Gameboard.
*   3. This class is a client of Iterator design patterns. 
*/

import java.awt.*;
import javax.swing.*;
import java.awt.image.*;
import java.awt.event.*;
import java.util.Random;
import java.util.*;


public class ComputerTank extends Tank {

    
    private ComputerKeyContainer comKeyList;
    private int computerKey;
    private String move = "";
    private Move comMove;
    private BoardLocation computerTank;
    
    

    /*
    * @author(Chai Ying Hua)
    * When the Computer Tank's contructor is called, the computer sequence is generated and ready to be execute.
    */
	public ComputerTank(Gameboard gameBoard){
		super();
        this.gameBoard = gameBoard;
        comKeyList = new ComputerKeyContainer();
        computerTank = new BoardLocation(0,0);
        gameBoard.setTankAt(computerImages, 0,0, computerImages.ComputerTankDown());

        comKeyList.addComputerKey();
        
	}

    

    

    /*
    * @author(Chai Ying Hua)
    * This method is use to translate the sequence obtained from Iterator in order to make the computer tank move
    */
    public void makeComputerTankMove(Object object){
      
        if(object.equals("Up")){
            moveTankUp(computerImages, computerTank, computerImages.ComputerTankUp());  
        }
        else if(object.equals("Down")){
            moveTankDown(computerImages, computerTank, computerImages.ComputerTankDown());
        }
        else if(object.equals("Left")){
            moveTankLeft(computerImages, computerTank, computerImages.ComputerTankLeft());
        }
        else if(object.equals("Right")){
            moveTankRight(computerImages, computerTank, computerImages.ComputerTankRight());
        }
        else if(object.equals("T")){
            shootUp(fireImages, computerImages, computerTank, fireImages.ShotFireUp(), computerImages.ComputerTankUp()); 
        }
        else if(object.equals("F")){
            shootLeft(fireImages, computerImages, computerTank, fireImages.ShotFireLeft(), computerImages.ComputerTankLeft()); 
        }
        else if(object.equals("G")){
            shootDown(fireImages, computerImages, computerTank, fireImages.ShotFireDown(), computerImages.ComputerTankDown()); 
        }
        else if(object.equals("H")){
            shootRight(fireImages, computerImages, computerTank, fireImages.ShotFireRight(), computerImages.ComputerTankRight()); 
        }
        else {}     
    }
    
    /*
    * @author (Shubar, Abduelhakem G Abdusalam)
    *
    * This method is use to get the computer's sequence
    */
    public ArrayList<String> getComputerSequence(){
        return comKeyList.getComputerSequence();
    }
    

    /*
    * @author (Shubar, Abduelhakem G Abdusalam)
    *
    *   When the user clicks the [LOAD] button, the game will be start over and the save sequence
    *    will be loaded. 
    */
    public void loadSequence(ArrayList<String> sequence){
        reset();
        //comKeyList.addComputerKey();
        comKeyList.loadComputerKeys(sequence);
    }

    /*
    * @author (Shubar, Abduelhakem G Abdusalam)
    *
    *   This method is use to reset the game and re-assign the variable to the initial values
    */
    public void startUp(){
        restart(computerImages, computerTank, computerImages.ComputerTankDown(), 0, 0);
        hitTarget = false;
        strike = false;
    }

    /*
    * @author (Chai Ying Hua)
    *
    *   This method is use to restart the game and re-assign the variable to the initial values
    */
    public void reset(){
        startUp();
        comKeyList.clearList();
        comKeyList.resetRestriction();

    }
    
    /*
    * @author (Shubar, Abduelhakem G Abdusalam)
    *
    * This method is use to assign the computer's move variable. 
    */
    public void registerComMove(Move comMove){
        this.comMove = comMove;
    }
    
    /*
    * author (Shubar, Abduelhakem G Abdusalam)
    *
    * This method is use to get the computer's key list. 
    */
    public ComputerKeyContainer getComKeys(){
        return comKeyList;
    }
    
    
    
        

    
    

   
    
	
}

