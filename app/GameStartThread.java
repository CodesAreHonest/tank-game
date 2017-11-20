/**
* 
*  @author(Chai Ying Hua) 
*
*   GameStartThread class is Worker threads, also known as background threads.
*   -----------------------------------------------------------------------------------
*   1.  This class execute  time-consuming background tasks .
*   2.  This class is implemented in order to deal with THREAD AND CONCURRENCY IN SWING.
*          a. Initial Threads
*          b. Event Threads
*          c. Worker Threads
*/

    import javax.swing.*;

    public class GameStartThread extends SwingWorker
    {
        Gameboard gameCopy;
            
        public GameStartThread(Gameboard gameBoard)
        {
             gameCopy = gameBoard;
        }

        @Override
        protected Object doInBackground() throws Exception {
           gameCopy.moveAllTheTank();
           return gameCopy;
        }

        
            
    }