/*
* 
*author(Chai Ying Hua)
*
*   This class is a concrete container class that implements ITERATOR design patterns. 
*   -----------------------------------------------------------------------------------
*
*  It contains Arraylist that store user generated sequence for the tanks. 
*  The iterator is create to access the elements contain in the container without exposing its internal structure.
*
*/




import java.util.ArrayList;
import java.util.Random;
import java.util.*;

public class UserKeyContainer implements MoveIterator {
	private ArrayList<String> userKeyList;

	/*
	* author (Chai Ying Hua)
	* The ArrayList is initialized with a fixed size that only can contains 18 objects
	*/
	public UserKeyContainer() {
		userKeyList = new ArrayList<String>(18);
	}

	/*
	* author (Chai Ying Hua)
	* This method allow the user to add the key into the ArrayList
	*/
	public void addUserKey(int position, String move) {
		userKeyList.add(position, move);
	}

	/*
	* author (Chai Ying Hua)
	* This method allow the user to remove the key into the ArrayList
	*/
	public void removeUserKey() {
		userKeyList.remove(userKeyList.size());
	}

	/*
    * author (Chai Ying Hua)
    * This method overriding the interface class to provide implementation of creating iterator in the ArrayList
    * The Run-Time Polymorphism occurs here.
    */
	@Override
	public Iterator createIterator() { 
		return userKeyList.iterator();
	}

	/*
	* author (Shubar, Abduelhakem G Abdusalam)
	* This method is use to get the size of the User Key Container
	*/
	public int getUserKeyContainerSize() {
		return userKeyList.size();
	}
	
	/*
	* author (Shubar, Abduelhakem G Abdusalam)
	* This method is use to get the userSequence and ready to save into the file
	*/
	public ArrayList<String> getUserSequence(){
        ArrayList<String> userSequence = new ArrayList<String>(18);
         for(String str : userKeyList){
           userSequence.add(str);
        }
        return userSequence;
    }
    
    /*
	* author (Shubar, Abduelhakem G Abdusalam)
	* This method is use to get the object in arraylist at a specific position
	*/
    public String getMove(int index){
        return userKeyList.get(index);
    }
    
    /*
	* author (Shubar, Abduelhakem G Abdusalam)
	* This method is use to clear all the object contains in the list.
	*/
    public void clearList(){
        userKeyList.clear();

    }
    
    /*
	* author (Shubar, Abduelhakem G Abdusalam)
	* This method is use to remove the last key of the array list. This method is use with the Undo buttons.
	*/
     public void removeLastKey(int lastKey){
        userKeyList.remove(lastKey);
    }
    
}
