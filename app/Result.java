
/**
* @author (Chai Ying Hua)
* 
*  	Result class is View in MVC Patterns
*   ---------------------------------------------
*    1. This class is use to display the Result after all the move is executed.
*	 2. The function of this class is let the player know the outcomes of the games.
*
*/


import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;


public class Result extends JFrame implements ActionListener{

	
	private String results;
	private int moves;
	private int trail;
	private JButton OkButton;
	private JPanel resultPanel;
	
 
	public Result(int moves, String results, int trail) {
		super("Result");
		this.moves = moves;
		this.results = results;
		this.trail = trail;
		setPanel();
	    
		setVisible(true);
		setResizable(true);
		setSize(300,170);
		setBackground(Color.white);
	    setLayout(new BorderLayout());
	    
	    add(resultPanel,BorderLayout.CENTER);
	    add(new JPanel(),BorderLayout.EAST);
	    add(new JPanel(),BorderLayout.WEST);
	    add(new JPanel(),BorderLayout.SOUTH);
	    
	    setLocationRelativeTo(null);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);

		
		
	}
	
	public void setPanel(){

	    resultPanel = new JPanel();		
		resultPanel.setLayout(new GridLayout(4,1));
		
		if(results == "Win") {
			resultPanel.add(new JLabel(" CONGRATULATION You Win The Game!"));
			resultPanel.add(new JLabel(" Number of trails used: " + trail));
			resultPanel.add(new JLabel(" Number of moves used: " + moves));
		}
		else if(results == "Lose") {
			resultPanel.add(new JLabel(" You Lose The Game. "));
			resultPanel.add(new JLabel(" Number of trails used: " + trail));
			resultPanel.add(new JLabel(" Number of moves used: " + moves));
		}

	
		resultPanel.add(setOKButton());
    }
    
    public JPanel setOKButton(){
        OkButton = new JButton(" Ok ");
        
        JPanel ButtonPanel = new JPanel();
        ButtonPanel.setLayout(new BoxLayout(ButtonPanel, BoxLayout.LINE_AXIS));
        ButtonPanel.add(Box.createVerticalGlue());
        ButtonPanel.add(OkButton);
        ButtonPanel.add(Box.createVerticalGlue());
        
		OkButton.addActionListener(this);
		
		return  ButtonPanel;
        
    }
 
	    
	
	public void actionPerformed(ActionEvent evnt){
      
        if (evnt.getActionCommand().equals(" Ok ")){
           closeFrame();
        }
    }
    
    public void closeFrame(){  
        WindowEvent closingEvent = new WindowEvent(this, WindowEvent.WINDOW_CLOSING);
        Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(closingEvent);
    }
        


	
	
}



	


