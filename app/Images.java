/**
 * @author(Chai Ying Hua)
 * <p>
 * Images class stored all the images and pictures to be use
 * -----------------------------------------------------------
 */

public class Images extends JLabel {

    public Images() {

    }

    public ImageIcon UserTankUp() {
        ImageIcon userTankUp = new ImageIcon(new ImageIcon("UserTank/Tank pointing top.png").getImage().getScaledInstance(60, 60, Image.SCALE_DEFAULT));
        return userTankUp;
    }

    public ImageIcon UserTankDown() {
        ImageIcon userTankDown = new ImageIcon(new ImageIcon("UserTank/Tank pointing down.png").getImage().getScaledInstance(60, 60, Image.SCALE_DEFAULT));
        return userTankDown;
    }

    public ImageIcon UserTankRight() {
        ImageIcon userTankRight = new ImageIcon(new ImageIcon("UserTank/Tank pointing right.png").getImage().getScaledInstance(60, 60, Image.SCALE_DEFAULT));
        return userTankRight;
    }

    public ImageIcon UserTankLeft() {
        ImageIcon userTankLeft = new ImageIcon(new ImageIcon("UserTank/Tank pointing left.png").getImage().getScaledInstance(60, 60, Image.SCALE_DEFAULT));
        return userTankLeft;
    }

    public ImageIcon ComputerTankUp() {
        ImageIcon computerTankUp = new ImageIcon(new ImageIcon("ComputerTank/computerTank pointing top.png").getImage().getScaledInstance(60, 60, Image.SCALE_DEFAULT));
        return computerTankUp;
    }

    public ImageIcon ComputerTankDown() {
        ImageIcon computerTankDown = new ImageIcon(new ImageIcon("ComputerTank/computerTank pointing down.png").getImage().getScaledInstance(60, 60, Image.SCALE_DEFAULT));
        return computerTankDown;
    }

    public ImageIcon ComputerTankRight() {
        ImageIcon computerTankRight = new ImageIcon(new ImageIcon("ComputerTank/computerTank pointing right.png").getImage().getScaledInstance(60, 60, Image.SCALE_DEFAULT));
        return computerTankRight;
    }

    public ImageIcon ComputerTankLeft() {
        ImageIcon computerTankLeft = new ImageIcon(new ImageIcon("ComputerTank/computerTank pointing left.png").getImage().getScaledInstance(60, 60, Image.SCALE_DEFAULT));
        return computerTankLeft;
    }

    public ImageIcon ShotFireUp() {
        ImageIcon shotFireUp = new ImageIcon(new ImageIcon("Fire/Fireball Shooting Up.png").getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT));
        return shotFireUp;
    }

    public ImageIcon ShotFireDown() {
        ImageIcon shotFireDown = new ImageIcon(new ImageIcon("Fire/Fireball Shooting Down.png").getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT));
        return shotFireDown;
    }

    public ImageIcon ShotFireRight() {
        ImageIcon shotFireRight = new ImageIcon(new ImageIcon("Fire/Fireball Shooting Right.png").getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT));
        return shotFireRight;
    }

    public ImageIcon ShotFireLeft() {
        ImageIcon shotFireLeft = new ImageIcon(new ImageIcon("Fire/Fireball Shooting Left.png").getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT));
        return shotFireLeft;
    }

    public ImageIcon TankDestroyed() {
        ImageIcon tankDestroyed = new ImageIcon(new ImageIcon("UserTank/Tank Destroyed.png").getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT));
        return tankDestroyed;
    }

    public void setImages(ImageIcon pictures) {
        this.setIcon(pictures);
    }

    public void removeIcon() {
        this.setIcon(null);
    }

}