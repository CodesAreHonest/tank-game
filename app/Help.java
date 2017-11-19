/**
 * @author(Ramadan Ali Houssein)
 * <p>
 * This class is use to provide guidance for user to use the system.
 */


import java.io.IOException;

public class Help extends JFrame {

    private JPanel Phelp;
    private JLabel Lhelp;
    private File reader;
    private JTextArea textArea;
    private Border thinBorder = BorderFactory.createLineBorder(Color.black);
    private ImageIcon icon;


    public Help() {


        Phelp = new JPanel();
        textArea = new JTextArea(10, 20);
        Phelp.setBackground(Color.WHITE);
        setVisible(true);
        setSize(725, 450);
        setLocationRelativeTo(null);
        LoadHelp();

        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }

    public void LoadHelp() {
        // The name of the file to open.
        String fileName = "Help.txt";
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // This will reference one line at a time
        String line = null;

        try {
            // FileReader reads text files in the default encoding.
            FileReader fileReader =
                    new FileReader(fileName);

            // Always wrap FileReader in BufferedReader.
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            while ((line = bufferedReader.readLine()) != null) {
                Phelp.add(new Label(line + "\n"));

            }
            //Phelp.add(icon);
            Phelp.setBorder(thinBorder);
            add(Phelp);

            // Always close files.
            bufferedReader.close();
        } catch (FileNotFoundException ex) {
            System.out.println(
                    "Unable to open file '" +
                            fileName + "'");
        } catch (IOException ex) {
            System.out.println(
                    "Error reading file '"
                            + fileName + "'");
        }
    }
}



