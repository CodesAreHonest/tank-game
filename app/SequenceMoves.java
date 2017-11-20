/**
* @author (Shubar, Abduelhakem G Abdusalam)
* 
*   SequenceMoves class is View Class updated by Controller 
*   --------------------------------------------------------
*   1.  This class is use to display the moves user had entered before execute  
*          
*/

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

public class SequenceMoves extends JPanel
{
    private JPanel[] MovesLabel = new JPanel[18];
    private JLabel movesLeft;
    private int index;
    private GameInterface GI;
    private Border thinBorder = BorderFactory.createLineBorder(Color.black);

    /**
    * @author (Shubar, Abduelhakem G Abdusalam)
    * 
    *   During the SequenceMove's constructor is called
    *   1.  A new JPanel is created and ready to show the list of moves enter by user          
    */
    public SequenceMoves()
    {
        index = 0;
        setBorder(thinBorder);
        movesLeft = new JLabel("   Moves Left : "+(18-index)+"    ");
        movesLeft.setBorder(thinBorder);
        this.add(movesLeft);
        //move.getMovesLeft(this);

 
        setSize(200,70);
        setLayout(new GridLayout(20,1));
     
        
    }

    
    public void setInterface(GameInterface GI){
        this.GI = GI;
    }
  
    /**
    * @author (Shubar, Abduelhakem G Abdusalam)
    * 
    *   This function is use to show the moves of the user      
    */
    public void showMoves(String moveReference, int x, int y){
        String moveTitle = null;
        moveTitle = "  Tank Moves " + moveReference + " to [" + x + "] [" + y + "]  ";
        MovesLabel[index] = new JPanel();
        MovesLabel[index].add(new JLabel(moveTitle));
        add(MovesLabel[index++]);
        movesLeft.setText("   Moves Left : "+(18-index)+"    ");
        revalidate();
        repaint();
            
    }
    
    /**
    * @author (Shubar, Abduelhakem G Abdusalam)
    * 
    *   This function is use to show the shoots direction of the user      
    */
    public void showShots(int x, int y, int shotX, int shotY){
        String moveTitle = null;
        moveTitle = " Tank at [" + x + "] [" + y + "] Shoots [" + shotX + "] [" + shotY + "] ";
        MovesLabel[index] = new JPanel();
        MovesLabel[index].add(new JLabel(moveTitle));
        
        add(MovesLabel[index++]);
        movesLeft.setText("   Moves Left : "+(18-index)+"    ");
        revalidate();
        repaint();
        
    
    }
    
    public void highlight(int index){
        MovesLabel[index].setBackground(Color.YELLOW);
        revalidate();
        repaint();
    }
    
    public void unHighlight(int index){
        MovesLabel[index].setBackground(null);
        revalidate();
        repaint();
    }
        
    
    public void clearAll(){
        while(index > 0){
            remove(index--);
        }
   
    }
    
    public void removeLastLabel(){
        remove(MovesLabel[--index]);
        movesLeft.setText("   Moves Left : "+(18-index)+"    ");
        revalidate();
        repaint();
    
    }

   
}




