
/**
* 
*  @author(Shubar, Abduelhakem G Abdusalam) 
*
*   GameMenu class is a View/Controller class in MVC Pattern that interact with User
*   -----------------------------------------------------------------------------------
*   1.  This class is a JPanel Menu that contains many buttons that allow user to perform any functions.
*     
*
*/


import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import java.util.ArrayList;


public class GameMenu extends JPanel implements ActionListener
{
    
    private GameInterface gameInterface;
    private JButton[] bn= { new JButton( "New Game",  new ImageIcon(getClass().getResource("Menu/new game.png"))),
                            new JButton( "Restart",  new ImageIcon(getClass().getResource("Menu/Home.png"))),
                            new JButton( "Save", new ImageIcon(getClass().getResource("Menu/Save.png")) ), 
                            new JButton( "Load", new ImageIcon(getClass().getResource("Menu/load.png")) ), 
                            new JButton( "Help", new ImageIcon(getClass().getResource("Menu/Help.png"))), 
                            new JButton( "Quit", new ImageIcon(getClass().getResource("Menu/Quit.png")) )}; 
            
    private Border thinBorder = BorderFactory.createLineBorder(Color.black);
    private QuitFrame quitFrame;
    private Save save;
    private Load load;
    private UserTank userTank;
    private ComputerTank comTank;
   
    /**
     *  @author(Shubar, Abduelhakem G Abdusalam)
     *  During the GameMenu's Constructor is called:- 
     *    1. All the button are added with Action Listener
     */
    public GameMenu()
    {
        
        save = new Save();
        load = new Load();
       
        for(int i=0; i<6; i++){
            add(bn[i]);
            bn[i].addActionListener(this);
        }
       
        setLayout(new GridLayout(7,1));
    
        
    }
    
    /**
     *  @author(Shubar, Abduelhakem G Abdusalam, Chai Ying Hua)
     *   
     *    1. When the [New Game] buttons is clicked: 
     *        a. All the tanks return to the default position
     *        b. The user sequence is cleared but computer sequences remains. 
     *
     *    2. When the [Restart] buttons is clicked: 
     *        a. All the data in the game is lost and start up a new Game.
     *
     *    3. When the [Help] buttons is clicked: 
     *        a. A new frame pops out and guide the user how to interact with the system.
     *
     *    4. When the [Save] buttons is clicked: 
     *        a. User and computer's sequences is saved.
     *
     *    5. When the [Load] buttons is clicked: 
     *        a. All the sequences in the game is loaded and fill the ArrayList.
     *
     *    6. When the [Quit] buttons is clicked: 
     *        a. The user can leave the game.
     */
    public void actionPerformed(ActionEvent vnt){
        
        String btn=vnt.getActionCommand();

        if (btn.equals("New Game")){
          userTank.startUp();
          comTank.startUp();
         
        }
        else if(btn.equals("Restart")) {
           gameInterface.dispose();
           new StartPanel();
        }
        else if (btn.equals("Help")) {
          new Help();
        }
        else if (btn.equals("Save")){
             save.setSaveUserSequence(userTank.getUserSequence());
             save.setSaveComSequence(comTank.getComputerSequence());
             save.saving();
             JOptionPane.showMessageDialog(null,"GAME HAS BEEN SAVED SUCCESSFULLY");
            
        }
        else if (btn.equals("Load")){
             
             load.loading();            
             comTank.loadSequence(load.getComSequence());
             userTank.loadSequence(load.getUserSequence());
             JOptionPane.showMessageDialog(null,"GAME HAS BEEN LOADED SUCCESSFULLY");
        }

        else if (btn=="Quit"){
          quitFrame = new QuitFrame();
          setQuitButtonListener();
        }
        
        else if (btn=="Yes"){
            System.exit(0);
        }
        
        else if (btn=="No"){
            quitFrame.closeFrame();
        }
        
        else if (btn=="Cancel"){
            quitFrame.closeFrame();
        }
        
       
    }
    
    /**
     *  @author(Shubar, Abduelhakem G Abdusalam)
     *  
     * This function set button listener on three buttons in QuitFrame
     */
    public void setQuitButtonListener(){
        JButton[] arrayButtons = quitFrame.getQuitButtons();
        for(int i = 0; i < 3; i++){
            arrayButtons[i].addActionListener(this);
        }
    }
    
    /**
     *  @author(Shubar, Abduelhakem G Abdusalam)
     *  
     * This function set the save's file name base on the player name 
     */
    public void setFileName(String saveFile){
        save.setFileName(saveFile);
        load.setFileName(saveFile);
    }
    
    public void setUserTank(UserTank userTank){
        this.userTank = userTank;
    }
    
    public void setComTank(ComputerTank comTank){
        this.comTank = comTank;
    }

    public void setGameInterface(GameInterface gameInterface) { 
       this.gameInterface = gameInterface;
    }
    
    
        

    

    

}





