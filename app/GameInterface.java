/**
* 
*  @author(Chai Ying Hua) 
*
*   GameInterface class is a View class in MVC Pattern that interact and display to User
*   -----------------------------------------------------------------------------------
*   1.  This class is a JFRAME that contains all the elements (JPANEL, JLABEL, etc)
*   2.  This class is a Game Interface that allow user to perform all kind of functions.
*
*/

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;


public class GameInterface extends JFrame{ 

	private final int GRID_SIZE = 10;
	private final int CELLSIZE = 60;
	private final int BOARD_WIDTH = GRID_SIZE * CELLSIZE;
	private final int BOARD_HEIGHT = GRID_SIZE * CELLSIZE;
	private GameMenu gameMenu;
	private GameInfo gameInfo;
	private Gameboard gameBoard;
	private SequenceMoves sequenceMoves;     
	



	/*
	* 
	*  @author(Chai Ying Hua, Shubar, Abduelhakem G Abdusalam) 
	*
	*   During the GameInterface's constructor (BorderLayout) is called :- 
	*   	1. add the Gameboard in the Center
	*   	2. add the Move Sequence Panel in the East
	*   	3. add the GameMenu in the West
	*/
	public GameInterface() {
		super("Tank Game");
		
		setVisible(true);
		setResizable(true);
		setSize(BOARD_WIDTH+400,BOARD_HEIGHT+100);
		setBackground(Color.white);
		setLayout(new BorderLayout());
		
		gameBoard = new Gameboard();
		add(gameBoard, BorderLayout.CENTER);
		
		sequenceMoves = new SequenceMoves();
		add(sequenceMoves, BorderLayout.EAST);
		gameBoard.getUserTank().setMovesSequence(sequenceMoves);
		sequenceMoves.setInterface(this);
		
		gameMenu = new GameMenu();
        add(gameMenu, BorderLayout.WEST);

        
       
        gameMenu.setUserTank(gameBoard.getUserTank());
        gameMenu.setComTank(gameBoard.getComputerTank());        
        
        setFocusable(true);
        
        setLocationRelativeTo(null);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		gameMenu.setGameInterface(this);
        
		
		
		
	}
	
	/*
	* 
	*  @author(Shubar, Abduelhakem G Abdusalam) 
	*
	*   This function is use to add GameInformation and set Playername 
	*/
    public void setPlayerName(String name){
       gameInfo = new GameInfo(name, gameBoard);
       add(gameInfo, BorderLayout.NORTH);
       gameBoard.getUserTank().setGameInfo(gameInfo);
       //GameInfo.setTrialNo(0);
       
       gameMenu.setFileName(name);
    }
    
    
   
    
    
}










	


