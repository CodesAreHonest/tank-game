/**
 * @author(Chai Ying Hua)
 * <p>
 * This class is a concrete container class that implements ITERATOR design patterns.
 * -----------------------------------------------------------------------------------
 * <p>
 * It contains Arraylist that store computer generated sequence for the tanks.
 */

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

public class ComputerKeyContainer implements MoveIterator {

    // The ArrayList with String datatype is created to store computer sequences.
    private ArrayList<String> computerKeyList;
    private String move = "";
    // The instance of RestrictAction class to prevent sequence generated hit and shoot the walls.
    private RestrictAction computerRestriction;


    /*
    * @author (Chai Ying Hua)
    *  During the ComputerKeyContainer's constructor is called: - 
    *    1. Instantiate the computerRestriction object.
    *    2. Initialize a fixed size ArrayList for the class
    */
    public ComputerKeyContainer() {

        computerRestriction = new RestrictAction(0, 0);
        computerKeyList = new ArrayList<String>(18);
    }

    /*
    * @author (Chai Ying Hua)
    * This method overriding the interface class to provide implementation of creating iterator in the ArrayList
    * The Run-Time Polymorphism occurs here.
    */
    @Override
    public Iterator createIterator() {
        return computerKeyList.iterator();
    }

    /*
    * @author (Chai Ying Hua)
    * This function convert the generated random number into moves
    */
    public String convertMove() {
        int randomNumber = randomNum();

        if (randomNumber == 0) { // Move Up
            move = "Up";
        } else if (randomNumber == 1) { // Move Down
            move = "Down";
        } else if (randomNumber == 2) { // Move Right
            move = "Right";
        } else if (randomNumber == 3) { // Move Left
            move = "Left";
        } else if (randomNumber == 4) { // Shoot Left
            move = "F";
        } else if (randomNumber == 5) { // Shoot Up
            move = "T";
        } else if (randomNumber == 6) { // Shoot Down
            move = "G";
        } else if (randomNumber == 7) { // Shoot Right
            move = "H";
        } else {
        }

        // return the converted move 
        return move;
    }

    /*
    * @author (Shubar, Abduelhakem G Abdusalam)
    * The purpose of this method is to create a random move base on the random number generated 
    */
    public int randomNum() {
        Random random = new Random(System.nanoTime());
        int randomInt = random.nextInt(10);
        randomInt = randomInt % 8;
        return randomInt;
    }

    /*
    * @author (Chai Ying Hua)
    * This function of this method is use to add the random generated moves into the ArrayList
    */
    public void addComputerKey() {

        for (int computerKey = 0; computerKey < 18; computerKey++) {
            String randomMove = convertMove(); //The different kinds of move is generated here

            if (computerRestriction.restrictMove(randomMove)) {
        /* 
        *   if the random move generated is valid (does not hit or shoot the wall),
        *   the move is added into the ArrayList
        */

                computerKeyList.add(computerKey, randomMove);

        /*  
        *   if the random move is invalid (hit or shoot the wall), 
        *   it will generate a new move
        *   The new move then insert into the Arraylist
        */
            } else {
                if (randomMove == "Up") {
                    move = "Down";
                } else if (randomMove == "Left") {
                    move = "Right";
                } else if (randomMove == "T") {
                    move = "G";
                } else if (randomMove == "F") {
                    move = "H";
                } else {
                    move = "Right";
                }

                if (computerRestriction.restrictMove(move)) {
                    computerKeyList.add(move);
                }
            }
        }
    }

    /*
    * @author (Shubar, Abduelhakem G Abdusalam)
    *
    * This method is to load the computer's key sequence from the file.
    */
    public void loadComputerKeys(ArrayList<String> loadSequence) {
        for (int computerKey = 0; computerKey < 18; computerKey++) {

            // Read the next string from the sequence list 
            String moveCommand = loadSequence.get(computerKey); 

            
            /*
            * Allow the moves add into computer's container if the move is valid,
            */
            if (computerRestriction.restrictMove(moveCommand) == true) {

                // the move is added into container
                computerKeyList.add(computerKey, moveCommand);
            }
        }
    }

    /*
    * @author (Shubar, Abduelhakem G Abdusalam)
    *
    * This method is to get the computer's key sequence and ready save into the file
    */
    public ArrayList<String> getComputerSequence() {
        ArrayList<String> computerSequence = new ArrayList<String>(18);
        for (String str : computerKeyList) {
            computerSequence.add(str);
        }
        return computerSequence;
    }

    /*
    * @author (Shubar, Abduelhakem G Abdusalam)
    *
    * This method clears the move contains in the computer's container
    */
    public void clearList() {
        computerKeyList.clear();
    }

    /*
    * @author(Shubar, Abduelhakem G Abdusalam)
    *
    * This method is to reset the restriction variables to the initial values
    */
    public void resetRestriction() {
        computerRestriction.setX(0);
        computerRestriction.setY(0);
    }
}