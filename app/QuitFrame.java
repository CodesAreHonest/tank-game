/**
 * @author (Shubar, Abduelhakem G Abdusalam)
 * <p>
 * QuitFrame class is a View in MVC Patterns
 * ------------------------------------------
 * 1. This class is an JFrame that contains three buttons.
 * 2. The function of this class is to ensure whether user willing to quit the games.
 */


public class QuitFrame extends JFrame {

    private JButton[] buttons = new JButton[3];
    private JPanel quit;

    public QuitFrame() {
        super("Quit");

        setPanel();

        setVisible(true);
        setResizable(true);
        setSize(300, 150);
        setBackground(Color.white);


        add(quit, BorderLayout.CENTER);
        add(new JPanel(), BorderLayout.EAST);
        add(new JPanel(), BorderLayout.WEST);
        add(new JPanel(), BorderLayout.SOUTH);

        setLocationRelativeTo(null);

        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }

    public void setPanel() {
        quit = new JPanel();
        quit.setLayout(new GridLayout(2, 1, 20, 20));
        quit.add(new JLabel(" Do you want to LEAVE the game? "));
        quit.add(setButton());
    }

    public JPanel setButton() {
        buttons[0] = new JButton("Yes");
        buttons[1] = new JButton("No");
        buttons[2] = new JButton("Cancel");

        JPanel ButtonPanel = new JPanel();
        ButtonPanel.setLayout(new GridLayout(1, 3, 5, 5));
        for (int i = 0; i < 3; i++)
            ButtonPanel.add(buttons[i]);

        return ButtonPanel;

    }

    public JButton[] getQuitButtons() {
        return buttons;
    }

    public void closeFrame() {

        WindowEvent closingEvent = new WindowEvent(this, WindowEvent.WINDOW_CLOSING);
        Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(closingEvent);
    }


}










	


