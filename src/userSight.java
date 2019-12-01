import javax.swing.*;

public class userSight {


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

    JFrame userSight = new JFrame("userSight");


    public void buildWindow(){
        userSight.setContentPane(new userSight().tabbedPane1);
        userSight.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        userSight.pack();
        userSight.setVisible(true);
    }









}
