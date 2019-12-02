import backend.menu;
import backend.dataConnection;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class adminSight extends JFrame{
    private JButton abmeldenButton;
    private JTabbedPane tabbedPane1;
    private JButton menüEinstellenButton;
    private JComboBox comboBox1;
    private JComboBox comboBox2;
    private JComboBox comboBox3;
    private JSpinner spinner2;
    private JTextField textField3;
    private JTextField €TextField;
    private JTextField textField1;
    private JButton menüErstellenButton;
    private JComboBox comboBox4;
    private JComboBox comboBox5;
    private JComboBox comboBox6;
    private JComboBox comboBox7;
    private JComboBox comboBox8;
    private JComboBox comboBox9;
    private JComboBox comboBox10;
    private JComboBox comboBox11;
    private JComboBox comboBox12;
    private JComboBox comboBox13;
    private JComboBox comboBox14;
    private JComboBox comboBox15;
    private JPanel panel1;
    private JPanel panel2;
    windowManager wm;


    public adminSight(String title, windowManager manager) {
        wm = manager;
        buildWindow(title);
        this.setIconImage(new ImageIcon("C:\\Users\\Paul\\IdeaProjects\\untitled7\\src\\icons\\chef.png").getImage());

        menüEinstellenButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {









            }


        });
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
        this.setContentPane(this.panel1);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.setVisible(true);
    }
}

