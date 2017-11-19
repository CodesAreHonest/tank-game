/**
 * @author(Chai Ying Hua)
 * <p>
 * UserTank class is CONTROLLER in MVC Patterns that modify the VIEW and CONTROLLER
 * UserTank class is CLIENT of ITERATOR DESIGN PATTERNS
 * --------------------------------------------------------------------------------
 * 1. This class is use to receive the user input and generate a sequence of move to destroy the opponent tank.
 * 2. The function of this class is to bind the key and able to accept the key input by user and translate to move.
 */

public class UserTank extends Tank {

    private UserKeyContainer userKeyList = new UserKeyContainer();
    private RestrictAction userRestriction;
    private BoardLocation userTank = new BoardLocation(9, 9);
    private GameInfo gameInfo;
    private SequenceMoves sequenceMoves;
    private Move userMove;

    private int RestrictActionX;
    private int RestrictActionY;


    private int userKey = 0;

    /**
     * @author(Chai Ying Hua)
     * <p>
     * During the UserTank contructor is called.
     * 1. The tank is set at [9][9] in the gameBoard, the restriction of moves is set.
     * 2. The arrow keys and shooting keys are bind in order to accept the input.
     */
    public UserTank(Gameboard gameBoard) {
        super();
        this.gameBoard = gameBoard;
        gameBoard.setTankAt(userImages, 9, 9, userImages.UserTankUp());
        userRestriction = new RestrictAction(9, 9);
        setBindingKeys();
    }


    /**
     * @author(Chai Ying Hua)
     * <p>
     * This function is use to accept the valid user key
     */
    public void getUserTankMove(String keyPressed) {
        for (int i = 0; i < 8; i++) {
            if (keyPressed.equals(checkKey[i])) {


                if (userRestriction.restrictMove(checkKey[i]) == true) {
                    //getUserKey[userKey++] = checkKey[i]; //insert into array
                    userKeyList.addUserKey(userKey, checkKey[i]);


                    if (checkKey[i] == "T" || checkKey[i] == "F" || checkKey[i] == "G" || checkKey[i] == "H") {
                        sequenceMoves.showShots(userRestriction.getX(), userRestriction.getY(),
                                userRestriction.getShootX(), userRestriction.getShootY());
                    } else {
                        sequenceMoves.showMoves(checkKey[i], userRestriction.getX(), userRestriction.getY());
                    }

                    userKey++;

                    if (userKey == 1) {
                        gameInfo.undoButtonAppears();
                    }


                    if (userKey == 18) {
                        gameInfo.doButtonAppears();
                    }


                } else {
                    JOptionPane.showMessageDialog(null, "You can't perform this action!");
                }
            }
        }
    }

    /**
     * @author(Chai Ying Hua)
     * <p>
     * This function is use to display and animates the tank to move
     */
    public void showTheMove() {
        userMove.displayTheMove();
    }


    /**
     * @author(Chai Ying Hua)
     * <p>
     * This function is use to translate the object read by Iterator to moves.
     */
    public void makeUserMove(Object object) {
        if (object.equals("Up")) {

            moveTankUp(userImages, userTank, userImages.UserTankUp());
        } else if (object.equals("Down")) {
            moveTankDown(userImages, userTank, userImages.UserTankDown());
        } else if (object.equals("Left")) {
            moveTankLeft(userImages, userTank, userImages.UserTankLeft());
        } else if (object.equals("Right")) {
            moveTankRight(userImages, userTank, userImages.UserTankRight());
        } else if (object.equals("T")) {
            shootUp(fireImages, userImages, userTank, fireImages.ShotFireUp(), userImages.UserTankUp());
        } else if (object.equals("G")) {
            shootDown(fireImages, userImages, userTank, fireImages.ShotFireDown(), userImages.UserTankDown());
        } else if (object.equals("F")) {
            shootLeft(fireImages, userImages, userTank, fireImages.ShotFireLeft(), userImages.UserTankLeft());
        } else if (object.equals("H")) {
            shootRight(fireImages, userImages, userTank, fireImages.ShotFireRight(), userImages.UserTankRight());
        } else {
        }

    }

    /**
     * @author(Shubar, Abduelhakem G Abdusalam)
     * <p>
     * This function is use to get the UserKey left for user to enter
     */
    public int getKeyLeft() {
        return userKey;
    }


    public void registerGameBoard(Gameboard gameBoard) {
        this.gameBoard = gameBoard;

    }

    public void setMovesSequence(SequenceMoves sequenceMoves) {
        this.sequenceMoves = sequenceMoves;
    }

    /**
     * @author(Shubar, Abduelhakem G Abdusalam)
     * <p>
     * This function is use to get the user moves store in the arraylist.
     */
    public ArrayList<String> getUserSequence() {
        return userKeyList.getUserSequence();
    }


    /**
     * @author(Shubar, Abduelhakem G Abdusalam)
     * <p>
     * This function is use to load the sequence from the file and add into the Container
     */
    public void loadSequence(ArrayList<String> loadSequence) {
        startUp();
        for (int i = 0; i < 18; i++) {

            String moveCommand = loadSequence.get(i);

            if (userRestriction.restrictMove(moveCommand) == true) {

                userKeyList.addUserKey(userKey, moveCommand);
                if (moveCommand.equals("T") || moveCommand.equals("F") || moveCommand.equals("G") || moveCommand.equals("H")) {

                    sequenceMoves.showShots(userRestriction.getX(), userRestriction.getY(),
                            userRestriction.getShootX(), userRestriction.getShootY());

                } else {
                    sequenceMoves.showMoves(moveCommand, userRestriction.getX(), userRestriction.getY());
                }

                userKey++;

                if (userKey == 18) {
                    gameInfo.doButtonAppears();
                }

            } else {
                JOptionPane.showMessageDialog(null, "You can't perform this action!");
            }
        }
    }

    /**
     * @author(Chai Ying Hua, Shubar, Abduelhakem G Abdusalam)
     * <p>
     * This function is reset all the data of user tank to the initialized value
     */
    public void startUp() {
        restart(userImages, userTank, userImages.UserTankUp(), 9, 9);
        userKey = 0;
        userKeyList.clearList();
        userRestriction.setX(9);
        userRestriction.setY(9);
        sequenceMoves.clearAll();
        hitTarget = false;
        strike = false;
        gameInfo.increaseTrail();
    }


    public void registerUserMove(Move userMove) {
        this.userMove = userMove;
    }


    public UserKeyContainer getUserKeys() {
        gameInfo.doButtonVanish();
        gameInfo.undoButtonVanish();
        return userKeyList;
    }

    public SequenceMoves getSequenceMoves() {
        return sequenceMoves;
    }

    /**
     * @author(Chai Ying Hua)
     * <p>
     * This function is use to register the key binding.
     */
    public void setBindingKeys() {
        //move up 
        KeyStroke upKey = KeyStroke.getKeyStroke(KeyEvent.VK_UP, 0);
        gameBoard.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(upKey, "Up");
        gameBoard.getActionMap().put("Up", new KeyBinding("Up", this));

        //move down
        KeyStroke downKey = KeyStroke.getKeyStroke(KeyEvent.VK_DOWN, 0);
        gameBoard.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(downKey, "Down");
        gameBoard.getActionMap().put("Down", new KeyBinding("Down", this));

        //move left
        KeyStroke leftKey = KeyStroke.getKeyStroke(KeyEvent.VK_LEFT, 0);
        gameBoard.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(leftKey, "Left");
        gameBoard.getActionMap().put("Left", new KeyBinding("Left", this));

        //move right
        KeyStroke rightKey = KeyStroke.getKeyStroke(KeyEvent.VK_RIGHT, 0);
        gameBoard.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(rightKey, "Right");
        gameBoard.getActionMap().put("Right", new KeyBinding("Right", this));

        //shoot up 
        KeyStroke keyT = KeyStroke.getKeyStroke(KeyEvent.VK_T, 0);
        gameBoard.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(keyT, "T");
        gameBoard.getActionMap().put("T", new KeyBinding("T", this));

        //shoot right 
        KeyStroke keyF = KeyStroke.getKeyStroke(KeyEvent.VK_F, 0);
        gameBoard.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(keyF, "F");
        gameBoard.getActionMap().put("F", new KeyBinding("F", this));

        //shoot down 
        KeyStroke keyG = KeyStroke.getKeyStroke(KeyEvent.VK_G, 0);
        gameBoard.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(keyG, "G");
        gameBoard.getActionMap().put("G", new KeyBinding("G", this));

        //shoot down
        KeyStroke keyH = KeyStroke.getKeyStroke(KeyEvent.VK_H, 0);
        gameBoard.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(keyH, "H");
        gameBoard.getActionMap().put("H", new KeyBinding("H", this));
    }

    public void undoMove() {

        if (userKey == 18) {
            gameInfo.doButtonVanish();
        }
        if (userKey == 1) {
            gameInfo.undoButtonVanish();
        }

        resetRestriction(userKeyList.getMove(--userKey));
        userKeyList.removeLastKey(userKey);
        sequenceMoves.removeLastLabel();
    }

    public void setGameInfo(GameInfo gameInfo) {
        this.gameInfo = gameInfo;
    }

    public void resetRestriction(String move) {
        if (move.equals("Up")) {
            userRestriction.setY(userRestriction.getY() + 1);
        } else if (move.equals("Down")) {
            userRestriction.setY(userRestriction.getY() - 1);
        } else if (move.equals("Right")) {
            userRestriction.setX(userRestriction.getX() - 1);
        } else if (move.equals("Left")) {
            userRestriction.setX(userRestriction.getX() + 1);
        }
    }

    /*
    * 
    *  @author(Shubar, Abduelhakem G Abdusalam) 
    *  
    *  this function returns the number of trails
    */
    public int getTrails() {
        return gameInfo.getTrails();
    }

}
     


    
