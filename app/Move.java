/**
 * @author(Chai Ying Hua, Shubar, Abduelhakem G Abdusalam)
 * <p>
 * Move class is Model Class that updates Views and notify by Controller
 * --------------------------------------------------------------------
 * 1.  This class is a CLIENT OF ITERATOR DESIGN PATTERNS.
 * 2.  The iterator is create in the ArrayList to access the elements contain in the container without exposing its internal structure.
 */


public class Move {

    private UserTank userTank;
    private ComputerTank comTank;

    private Iterator userIteratorMoves;
    private Iterator comIteratorMoves;


    /**
     * @author(Chai Ying Hua, Shubar, Abduelhakem G Abdusalam)
     * <p>
     * During the Move constructor is called:-
     * 1.  Get the instance of computer tank and user tank.
     */
    public Move(ComputerTank comTank, UserTank userTank) {
        this.comTank = comTank;
        this.userTank = userTank;

    }


    /**
     * @author(Chai Ying Hua, Shubar, Abduelhakem G Abdusalam)
     * <p>
     * This function display the moves by using the Iterator to read the objects store in the user and computer Arraylist.
     */
    public void displayTheMove() {
        userIteratorMoves = userTank.getUserKeys().createIterator();
        comIteratorMoves = comTank.getComKeys().createIterator();

        int indexSequence = 0;

        while (userIteratorMoves.hasNext()) {
            Object userObject = userIteratorMoves.next();
            Object comObject = comIteratorMoves.next();
            try {


                comTank.makeComputerTankMove(comObject);
                userTank.getSequenceMoves().highlight(indexSequence);
                Thread.sleep(250);
                userTank.makeUserMove(userObject);
                userTank.getSequenceMoves().unHighlight(indexSequence++);


                if (userTank.hitTarget() == true) { // player win
                    new Result(indexSequence, "Win", userTank.getTrails());
                    break;
                } else if (userTank.strike() == true || comTank.strike() == true) { // player lose
                    new Result(indexSequence, "Lose", userTank.getTrails());
                    break;

                } else if (comTank.hitTarget() == true) {
                    new Result(indexSequence, "Lose", userTank.getTrails());
                    break;
                } else {

                }
            } catch (InterruptedException e) {

            }

        }

        if (userTank.hitTarget() == false && userTank.strike() == false && comTank.strike() == false && comTank.hitTarget() == false) {
            JOptionPane.showMessageDialog(null, "The game is DRAW, press [NEW GAME] to Challenge again.");
        }
    }

}


        
    
        
    
    

