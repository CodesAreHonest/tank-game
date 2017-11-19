/**
 * @author (Shubar, Abduelhakem G Abdusalam)
 * <p>
 * StartPanel class is View Class in MVC Patterns
 * -----------------------------------------------
 * 1.  This class is the first interface that allow user to enter their name and start the game
 */


public class StartPanel extends JFrame implements ActionListener {

    private JButton BStart;
    private JTextField nameField;
    private JPanel PStart;


    public StartPanel() {
        super("Welcome To Tank Game");
        setPanel();

        setVisible(true);
        setResizable(true);
        setSize(450, 170);
        setBackground(Color.white);
        setLayout(new BorderLayout());

        add(PStart, BorderLayout.CENTER);
        add(new JPanel(), BorderLayout.EAST);
        add(new JPanel(), BorderLayout.WEST);
        add(new JPanel(), BorderLayout.SOUTH);

        setLocationRelativeTo(null);

        setDefaultCloseOperation(DISPOSE_ON_CLOSE);


    }

    public static void main(String[] args) {
        StartPanel startPanel = new StartPanel();

    }

    public void setPanel() {
        PStart = new JPanel();

        nameField = new JTextField();

        PStart.setLayout(new GridLayout(3, 1));

        PStart.add(new JLabel(" Player Name : "));
        PStart.add(nameField);

        PStart.add(setStartButton());
    }

    public JPanel setStartButton() {
        BStart = new JButton(" Start ");

        JPanel ButtonPanel = new JPanel();
        ButtonPanel.setLayout(new BoxLayout(ButtonPanel, BoxLayout.LINE_AXIS));
        ButtonPanel.add(Box.createVerticalGlue());
        ButtonPanel.add(BStart);
        ButtonPanel.add(Box.createVerticalGlue());

        BStart.addActionListener(this);

        return ButtonPanel;

    }

    public void actionPerformed(ActionEvent evnt) {

        if (evnt.getActionCommand().equals(" Start ")) {
            closeFrame();

            GameInterface game = new GameInterface();
            game.setPlayerName(nameField.getText());
        }
    }

    public void closeFrame() {

        WindowEvent closingEvent = new WindowEvent(this, WindowEvent.WINDOW_CLOSING);
        Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(closingEvent);
    }


}










	


