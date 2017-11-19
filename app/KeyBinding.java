/**
 * @author(Chai Ying Hua)
 * <p>
 * Keybinding class is Model Class that use to register key to allow user add the moves
 * -----------------------------------------------------------------------------------
 * 1.  This class perform getInputMap() on a specific key and assign action to the specific key with getActionMap()
 * 2.  This class is implemented in order to solve KeyListener not responding after ButtonListener is clicked
 * a. This is due to the focus on a specific event is lost and the key not responsive after clicked the button
 */

public class KeyBinding extends AbstractAction implements ActionListener {
    private String bindingMove;
    private UserTank user;

    public KeyBinding(String bindingMove, UserTank user) {
        super(bindingMove);
        this.bindingMove = bindingMove;
        this.user = user;

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (user.getKeyLeft() < 18) {
            user.getUserTankMove(bindingMove);
        }
    }


}