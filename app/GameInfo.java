/**
 * @author(Shubar, Abduelhakem G Abdusalam)
 * <p>
 * GameInfo class is a View class in MVC Pattern that interact and display to User
 * -----------------------------------------------------------------------------------
 * 1.  This class consist severals button to let user to modify and execute the moves
 * 2.  This class show the player names after user enter the name in StartPanel.java
 */


public class GameInfo extends JPanel implements ActionListener {

    private JLabel nameLabel;
    private JLabel trial;
    private int trialNo = 1;
    private JButton DoMoves;
    private JButton UndoMoves;
    private String playerName;
    private JPanel Pbutton;
    private Border thinBorder = BorderFactory.createLineBorder(Color.black);
    private Gameboard gameBoard;
    private UserTank user;


    /*
    * 
    *  @author(Shubar, Abduelhakem G Abdusalam) 
    *
    *   During the GameInfo constructor is called :-
    *   1.  Set the player names
    *   2.  Add Two buttons that allow user to modify and execute the sequences entered.
    *
    */
    public GameInfo(String playerName, Gameboard gameBoard) {
        this.playerName = playerName;
        this.gameBoard = gameBoard;

        setBorder(thinBorder);
        setLayout(new GridLayout(1, 3, 10, 10));

        nameLabel = new JLabel("  Player Name : " + playerName);
        add(new JPanel().add(nameLabel));

        trial = new JLabel("  Trial : " + trialNo);
        add(new JPanel().add(trial));

        DoMoves = new JButton("Do");
        UndoMoves = new JButton("Undo");

        Pbutton = new JPanel();

        add(Pbutton);
        addUndoButton();
        addDoButton();

    }

    /*
    * 
    *  @author(Shubar, Abduelhakem G Abdusalam) 
    *
    *   During the Do Button is clicked :
    *   1.  Makes the tank moves.
    *   
    *   During the Undo Button is clicked :
    *   1.  Undo the last moves entered by the user.
    *
    */
    public void actionPerformed(ActionEvent vnt) {

        String btn = vnt.getActionCommand();

        if (btn.equals("Do")) {

            new GameStartThread(gameBoard).execute();
        } else if (btn.equals("Undo")) {
            gameBoard.getUserTank().undoMove();
        }
    }
    
    /*
    * 
    *  @author(Shubar, Abduelhakem G Abdusalam) 
    *
    *   This function returns player name entered earlier in start panel.
    */

    public String getPlayerName() {
        return playerName;
    }


    /*
    * 
    *  @author(Shubar, Abduelhakem G Abdusalam) 
    *
    *   This function is used to add Undo buttons.
    */
    public void addUndoButton() {
        Pbutton.add(UndoMoves);
        UndoMoves.addActionListener(this);
        UndoMoves.setVisible(false);
        Pbutton.revalidate();
        Pbutton.repaint();
    }

    /*
    * 
    *  @author(Shubar, Abduelhakem G Abdusalam) 
    *
    *   This function is used to add Do buttons.
    */
    public void addDoButton() {

        Pbutton.add(DoMoves);
        DoMoves.addActionListener(this);
        DoMoves.setVisible(false);
        Pbutton.revalidate();
        Pbutton.repaint();


    }

    /*
    * 
    *  @author(Chai Ying Hua) 
    *
    *   This function is used t make Undo button vanished
    */
    public void undoButtonVanish() {
        UndoMoves.setVisible(false);
        Pbutton.revalidate();
        Pbutton.repaint();
    }

    /*
    * 
    *  @author(Chai Ying Hua) 
    *
    *   This function is used to make Do button vanished
    */
    public void doButtonVanish() {
        DoMoves.setVisible(false);
        Pbutton.revalidate();
        Pbutton.repaint();
    }

    /*
    * 
    *  @author(Chai Ying Hua) 
    *
    *   This function is used to make Undo button appears
    */
    public void undoButtonAppears() {
        UndoMoves.setVisible(true);
        Pbutton.revalidate();
        Pbutton.repaint();
    }

    /*
    * 
    *  @author(Chai Ying Hua) 
    *
    *   This function is used to make Do button appears
    */
    public void doButtonAppears() {
        DoMoves.setVisible(true);
        Pbutton.revalidate();
        Pbutton.repaint();
    }

    /*
    * 
    *  @author(Shubar, Abduelhakem G Abdusalam) 
    *
    *   This function is used to incraese trail number after each new game.
    */
    public void increaseTrail() {
        trial.setText("  Trial : " + ++trialNo);
        trial.revalidate();
        trial.repaint();
    }

    /*
    * 
    *  @author(Shubar, Abduelhakem G Abdusalam) 
    *
    *  This function is use to get the number of trails. reset it to 0 after game finishs
    */
    public int getTrails() {
        int tempTrialNo = trialNo;
        trialNo = 0;
        return tempTrialNo;
    }

}





