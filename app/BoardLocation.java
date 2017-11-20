/**
*@author (Chai Ying Hua)
*
*   BoardLocation class is a MODEL in MVC pattern. 
*   This class is function to notify and update the controller.
*   The main function of this class is use to keep track the location of the all the tank. 
*/

public class BoardLocation{ // model
	private int x;
	private int y;
  
    public BoardLocation(){
    }

	public BoardLocation(int x, int y) {
		this.x = x;
		this.y = y;	
	}

	
	int getX() {
		return x;
	}

		
	int getY() { 
		return y;
	}


	public void setData(int x, int y) {
		this.x = x;
		this.y = y; 
	}
}