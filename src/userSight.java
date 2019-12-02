import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class userSight extends JFrame{


    private JTabbedPane tabbedPane1;
    private JButton abmeldenButton;
    private JButton wocheZurückButton;
    private JRadioButton radioButton1;
    private JRadioButton radioButton2;
    private JRadioButton radioButton3;
    private JButton wocheVorButton;
    private JTable table1;
    private JTable table2;
    private JButton bestellungAbschickenButton;
    private JScrollPane rootpane;
    private windowManager wm;


    //private JFrame userSight = new JFrame("Benutzeransicht");


    public userSight(String title, windowManager manager) {
        wm = manager;
        buildWindow(title);
        this.setIconImage(new ImageIcon("C:\\Users\\Paul\\IdeaProjects\\untitled7\\src\\icons\\chef.png").getImage());

        abmeldenButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if(e.getSource() == abmeldenButton){
                    dispose();

                    wm.showMainframe();
                }


            }

        });
    }

    public void buildWindow(String title){
        this.setTitle(title);
        this.setContentPane(this.rootpane);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.setVisible(true);
    }









}
