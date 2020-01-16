import backend.MenuItem;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.util.ArrayList;

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
    MenuItem[] menuList;


    public adminSight(String title, windowManager manager) throws MalformedURLException {
        wm = manager;
        buildWindow(title);
        this.setIconImage(new ImageIcon("C:\\Users\\Paul\\IdeaProjects\\untitled7\\src\\icons\\chef.png").getImage());
        menuList = wm.getDc().getMenuList();

        comboBox1.insertItemAt("",0);
        comboBox2.insertItemAt("",0);
        comboBox3.insertItemAt("",0);
        comboBox4.insertItemAt("",0);
        comboBox5.insertItemAt("",0);
        comboBox6.insertItemAt("",0);
        comboBox7.insertItemAt("",0);
        comboBox8.insertItemAt("",0);
        comboBox9.insertItemAt("",0);
        comboBox10.insertItemAt("",0);
        comboBox11.insertItemAt("",0);
        comboBox12.insertItemAt("",0);
        comboBox13.insertItemAt("",0);
        comboBox14.insertItemAt("",0);
        comboBox15.insertItemAt("",0);



        for(MenuItem menu : menuList){
            comboBox1.addItem(menu.getDescription());
            comboBox2.addItem(menu.getDescription());
            comboBox3.addItem(menu.getDescription());
            comboBox4.addItem(menu.getDescription());
            comboBox5.addItem(menu.getDescription());
            comboBox6.addItem(menu.getDescription());
            comboBox7.addItem(menu.getDescription());
            comboBox8.addItem(menu.getDescription());
            comboBox9.addItem(menu.getDescription());
            comboBox10.addItem(menu.getDescription());
            comboBox11.addItem(menu.getDescription());
            comboBox12.addItem(menu.getDescription());
            comboBox13.addItem(menu.getDescription());
            comboBox14.addItem(menu.getDescription());
            comboBox15.addItem(menu.getDescription());


        }

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

                    wm.deleteUser();
                    wm.showMainframe();
                }
            }
        });
        menüErstellenButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource() == menüErstellenButton){

                    try {

                        wm.getDc().sendNewMenu(textField1.getText(), €TextField.getText());

                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                }
            }
        });
    }

    public void buildWindow(String title){
        this.setTitle(title);
        this.setContentPane(this.panel1);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
}

