/**
 * @author (Chai Ying Hua, Shubar, Abduelhakem G Abdusalam)
 * <p>
 * Tank class is Model Class in MVC Patterns that updates the View and notify by Controller
 * ------------------------------------------------------------------------------------------
 * 1.  This class contains all the method to make the Tanks move.
 * 2.  This class is a superclass that Inheritance and Aggregation occurs.
 */


public class Tank {

    private static BoardLocation enemy;
    protected String[] checkKey = {"Up", "Down", "Right", "Left", "F", "T", "G", "H"};
    protected Gameboard gameBoard;
    protected Images fireImages = new Images();
    protected Images userImages = new Images();
    protected Images computerImages = new Images();
    protected Boolean strike = false;
    protected Boolean hitTarget = false;


    /**
     * @author (Shubar, Abduelhakem G Abdusalam)
     * <p>
     * The enemy location is initialized when the Tank constructor is called.
     */
    public Tank() {
        enemy = new BoardLocation(0, 0);

    }


    /**
     * @author (Chai Ying Hua, Shubar, Abduelhakem G Abdusalam)
     * <p>
     * This function is use to move the tank up. The procedures are,
     * a. Remove the tank current location
     * b. Update the new location on the Model
     * c. Set the tank on the new location.
     * d. if both tank go the same place, the tank will destroy and user will lose
     */
    public void moveTankUp(Images images, BoardLocation allyLocation, ImageIcon pictures) {

        gameBoard.removeTankAt(allyLocation.getX(), allyLocation.getY());

        if (allyLocation.getX() == enemy.getX() && (allyLocation.getY() - 1) == enemy.getY()) {
            gameBoard.setTankAt(userImages, allyLocation.getX(), allyLocation.getY() - 1, userImages.TankDestroyed());
            strike = true;
            JOptionPane.showMessageDialog(null, "Your tank have crashed at [" + enemy.getX() + "][" + enemy.getY() + "]  , Computer Win");

        } else {

            allyLocation.setData(allyLocation.getX(), allyLocation.getY() - 1);
            enemy.setData(allyLocation.getX(), allyLocation.getY());
            gameBoard.setTankAt(images, allyLocation.getX(), allyLocation.getY(), pictures);
        }


    }

    /**
     * @author (Chai Ying Hua, Shubar, Abduelhakem G Abdusalam)
     * <p>
     * This function is use to move the tank down. The procedures are,
     * a. Remove the tank current location
     * b. Update the new location on the Model
     * c. Set the tank on the new location.
     * d. if both tank go the same place, the tank will destroy and user will lose
     */
    public void moveTankDown(Images images, BoardLocation allyLocation, ImageIcon pictures) {

        gameBoard.removeTankAt(allyLocation.getX(), allyLocation.getY());

        if (allyLocation.getX() == enemy.getX() && (allyLocation.getY() + 1) == enemy.getY()) {
            gameBoard.setTankAt(userImages, allyLocation.getX(), allyLocation.getY() + 1, userImages.TankDestroyed());
            strike = true;
            JOptionPane.showMessageDialog(null, "Your tank have crashed at [" + enemy.getX() + "][" + enemy.getY() + "]  , Computer Win");

        } else {
            allyLocation.setData(allyLocation.getX(), allyLocation.getY() + 1);
            enemy.setData(allyLocation.getX(), allyLocation.getY());
            gameBoard.setTankAt(images, allyLocation.getX(), allyLocation.getY(), pictures);
        }

    }

    /**
     * @author (Chai Ying Hua, Shubar, Abduelhakem G Abdusalam)
     * <p>
     * This function is use to move the tank left. The procedures are,
     * a. Remove the tank current location
     * b. Update the new location on the Model
     * c. Set the tank on the new location.
     * d. if both tank go the same place, the tank will destroy and user will lose
     */
    public void moveTankLeft(Images images, BoardLocation allyLocation, ImageIcon pictures) {

        gameBoard.removeTankAt(allyLocation.getX(), allyLocation.getY());

        if ((allyLocation.getX() - 1) == enemy.getX() && allyLocation.getY() == enemy.getY()) {
            gameBoard.removeTankAt(allyLocation.getX() - 1, allyLocation.getY());
            gameBoard.setTankAt(userImages, allyLocation.getX() - 1, allyLocation.getY(), userImages.TankDestroyed());
            strike = true;
            JOptionPane.showMessageDialog(null, "Your tank have crashed at [" + enemy.getX() + "][" + enemy.getY() + "]  , Computer Win");

        } else {
            allyLocation.setData(allyLocation.getX() - 1, allyLocation.getY());
            enemy.setData(allyLocation.getX(), allyLocation.getY());
            gameBoard.setTankAt(images, allyLocation.getX(), allyLocation.getY(), pictures);
        }

    }

    /**
     * @author (Chai Ying Hua, Shubar, Abduelhakem G Abdusalam)
     * <p>
     * This function is use to move the tank right. The procedures are,
     * a. Remove the tank current location
     * b. Update the new location on the Model
     * c. Set the tank on the new location.
     * d. if both tank go the same place, the tank will destroy and user will lose
     */
    public void moveTankRight(Images images, BoardLocation allyLocation, ImageIcon pictures) {

        gameBoard.removeTankAt(allyLocation.getX(), allyLocation.getY());

        if ((allyLocation.getX() + 1) == enemy.getX() && allyLocation.getY() == enemy.getY()) {
            gameBoard.removeTankAt(allyLocation.getX() + 1, allyLocation.getY());
            gameBoard.setTankAt(userImages, allyLocation.getX() + 1, allyLocation.getY(), userImages.TankDestroyed());
            strike = true;
            JOptionPane.showMessageDialog(null, "Your tank have crashed at [" + enemy.getX() + "][" + enemy.getY() + "]  , Computer Win");
        } else {
            allyLocation.setData(allyLocation.getX() + 1, allyLocation.getY());
            enemy.setData(allyLocation.getX(), allyLocation.getY());
            gameBoard.setTankAt(images, allyLocation.getX(), allyLocation.getY(), pictures);
        }

    }

    /**
     * @author (Chai Ying Hua, Shubar, Abduelhakem G Abdusalam)
     * <p>
     * This function is use to move the shoot up. The procedures are,
     * a. if the tank fire and hit the opponent tank, opponent tank destroyed and the tank who shoots win
     * b. if the tank fire and hit nothing, it display the animation.
     */
    public void shootUp(Images fireImages, Images shooterImages, BoardLocation shooter, ImageIcon firePic, ImageIcon tankPic) {

        if (shooter.getX() == enemy.getX() && (shooter.getY() - 1) == enemy.getY()) {
            gameBoard.removeTankAt(enemy.getX(), enemy.getY());
            gameBoard.setTankAt(shooterImages, shooter.getX(), shooter.getY(), tankPic);
            gameBoard.setTankAt(fireImages, shooter.getX(), shooter.getY() - 1, firePic);

            hitTarget = true;

        } else {
            enemy.setData(shooter.getX(), shooter.getY());
            gameBoard.setTankAt(shooterImages, shooter.getX(), shooter.getY(), tankPic);
            gameBoard.setTankAt(fireImages, shooter.getX(), shooter.getY() - 1, firePic);
            try {
                Thread.sleep(1000);
                gameBoard.removeTankAt(shooter.getX(), shooter.getY() - 1);
            } catch (InterruptedException e) {

            }


        }
    }

    /**
     * @author (Chai Ying Hua, Shubar, Abduelhakem G Abdusalam)
     * <p>
     * This function is use to move the shoot down. The procedures are,
     * a. if the tank fire and hit the opponent tank, opponent tank destroyed and the tank who shoots win
     * b. if the tank fire and hit nothing, it display the animation.
     */
    public void shootDown(Images fireImages, Images shooterImages, BoardLocation shooter, ImageIcon firePic, ImageIcon tankPic) {

        if (shooter.getX() == enemy.getX() && (shooter.getY() + 1) == enemy.getY()) {
            gameBoard.removeTankAt(enemy.getX(), enemy.getY());
            gameBoard.setTankAt(shooterImages, shooter.getX(), shooter.getY(), tankPic);
            gameBoard.setTankAt(fireImages, shooter.getX(), shooter.getY() + 1, firePic);

            hitTarget = true;

        } else {
            enemy.setData(shooter.getX(), shooter.getY());
            gameBoard.setTankAt(shooterImages, shooter.getX(), shooter.getY(), tankPic);
            gameBoard.setTankAt(fireImages, shooter.getX(), shooter.getY() + 1, firePic);
            try {
                Thread.sleep(1000);
                gameBoard.removeTankAt(shooter.getX(), shooter.getY() + 1);
            } catch (InterruptedException e) {

            }


        }
    }

    /**
     * @author (Chai Ying Hua, Shubar, Abduelhakem G Abdusalam)
     * <p>
     * This function is use to move the shoot left. The procedures are,
     * a. if the tank fire and hit the opponent tank, opponent tank destroyed and the tank who shoots win
     * b. if the tank fire and hit nothing, it display the animation.
     */
    public void shootLeft(Images fireImages, Images shooterImages, BoardLocation shooter, ImageIcon firePic, ImageIcon tankPic) {

        if ((shooter.getX() - 1) == enemy.getX() && shooter.getY() == enemy.getY()) {
            gameBoard.removeTankAt(enemy.getX(), enemy.getY());
            gameBoard.setTankAt(shooterImages, shooter.getX(), shooter.getY(), tankPic);
            gameBoard.setTankAt(fireImages, shooter.getX() - 1, shooter.getY(), firePic);

            hitTarget = true;

        } else {
            enemy.setData(shooter.getX(), shooter.getY());
            gameBoard.setTankAt(shooterImages, shooter.getX(), shooter.getY(), tankPic);
            gameBoard.setTankAt(fireImages, shooter.getX() - 1, shooter.getY(), firePic);
            try {
                Thread.sleep(1000);
                gameBoard.removeTankAt(shooter.getX() - 1, shooter.getY());
            } catch (InterruptedException e) {

            }


        }
    }

    /**
     * @author (Chai Ying Hua, Shubar, Abduelhakem G Abdusalam)
     * <p>
     * This function is use to move the shoot right. The procedures are,
     * a. if the tank fire and hit the opponent tank, opponent tank destroyed and the tank who shoots win
     * b. if the tank fire and hit nothing, it display the animation.
     */
    public void shootRight(Images fireImages, Images shooterImages, BoardLocation shooter, ImageIcon firePic, ImageIcon tankPic) {

        if ((shooter.getX() + 1) == enemy.getX() && shooter.getY() == enemy.getY()) {
            gameBoard.removeTankAt(enemy.getX(), enemy.getY());
            gameBoard.setTankAt(shooterImages, shooter.getX(), shooter.getY(), tankPic);
            gameBoard.setTankAt(fireImages, shooter.getX() + 1, shooter.getY(), firePic);

            hitTarget = true;

        } else {
            enemy.setData(shooter.getX(), shooter.getY());
            gameBoard.setTankAt(shooterImages, shooter.getX(), shooter.getY(), tankPic);
            gameBoard.setTankAt(fireImages, shooter.getX() + 1, shooter.getY(), firePic);
            try {
                Thread.sleep(1000);
                gameBoard.removeTankAt(shooter.getX() + 1, shooter.getY());
            } catch (InterruptedException e) {

            }
            //gameBoard.removeTankAt(fire.getX()+1, fire.getY());


        }
    }

    /**
     * @author (Shubar, Abduelhakem G Abdusalam)
     * <p>
     * This function is use to reset the tank back to their initial location.
     */
    public void restart(Images images, BoardLocation tankLocation, ImageIcon pictures, int x, int y) {
        gameBoard.removeTankAt(tankLocation.getX(), tankLocation.getY());
        tankLocation.setData(x, y); // 1
        gameBoard.setTankAt(images, tankLocation.getX(), tankLocation.getY(), pictures); // 2
    }

    /**
     * @author (Chai Ying Hua)
     * <p>
     * This function is use to get whether the tank hits the target
     */
    public Boolean hitTarget() {
        return hitTarget;
    }

    /**
     * @author (Chai Ying Hua)
     * <p>
     * This function is use to get whether the tank clash opponent tank.
     */
    public Boolean strike() {
        return strike;
    }


}