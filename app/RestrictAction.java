/**
 * @author (Chai Ying Hua)
 * <p>
 * RestrictAction class is MODEL in MVC Patterns
 * ---------------------------------------------
 * 1. This class is use to the tank does not go IndexOutOfBounds.
 * 2. The function of this class is to ensure the user and computer move does not shoot and hit the walls.
 */


public class RestrictAction {
    private final int minValue = -1;
    private final int maxValue = 10;
    private int x;
    private int y;
    private int shootX;
    private int shootY;
    private String tankMove;


    public RestrictAction(int x, int y) {
        this.x = x;
        this.y = y;
        this.shootX = x;
        this.shootY = y;
    }


    public Boolean restrictMove(String move) {
        Boolean restriction = true;
        if (move.equals("Up")) {

            y--;
            if (y > minValue) {
                restriction = true;
            } else {
                y++;
                restriction = false;
            }
        } else if (move.equals("Down")) {
            y++;
            if (y < maxValue) {
                restriction = true;
            } else {
                y--;
                restriction = false;
            }
        } else if (move.equals("Left")) {
            x--;
            if (x > minValue) {
                restriction = true;
            } else {
                x++;
                restriction = false;
            }
        } else if (move.equals("Right")) {
            x++;
            if (x < maxValue) {
                restriction = true;
            } else {
                x--;
                restriction = false;
            }
        } else if (move.equals("T")) {
            System.out.println(y);
            shootY = y - 1;
            shootX = x;
            if (shootY > minValue) {
                restriction = true;
            } else {
                shootY++;
                restriction = false;
            }
        } else if (move.equals("G")) {
            shootY = y + 1;
            shootX = x;
            if (shootY < maxValue) {
                restriction = true;
            } else {
                shootY--;
                restriction = false;
            }
        } else if (move.equals("F")) {
            shootX = x - 1;
            shootY = y;
            if (shootX > minValue) {
                restriction = true;
            } else {
                shootX++;
                restriction = false;
            }
        } else if (move.equals("H")) {
            shootX = x + 1;
            shootY = y;
            if (shootX < maxValue) {
                restriction = true;
            } else {
                shootX--;
                restriction = false;
            }
        } else {
            JOptionPane.showMessageDialog(null, "YOUR MOVE IS IMAPPROPRIATE!");
            restriction = false;
        }

        return restriction;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getShootY() {
        return shootY;
    }

    public int getShootX() {
        return shootX;
    }


}