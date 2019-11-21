import backend.menu;
import backend.dataConnection

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class adminSight {
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


    public adminSight() {
        menüEinstellenButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if(e.getSource()==menüEinstellenButton){

                    try{
                        if(!(   comboBox1.getSelectedItem() == null ||
                                comboBox2.getSelectedItem() == null ||
                                comboBox3.getSelectedItem() == null ||
                                comboBox4.getSelectedItem() == null ||
                                comboBox5.getSelectedItem() == null ||
                                comboBox6.getSelectedItem() == null ||
                                comboBox7.getSelectedItem() == null ||
                                comboBox8.getSelectedItem() == null ||
                                comboBox9.getSelectedItem() == null ||
                                comboBox10.getSelectedItem() == null ||
                                comboBox11.getSelectedItem() == null ||
                                comboBox12.getSelectedItem() == null ||
                                comboBox13.getSelectedItem() == null ||
                                comboBox14.getSelectedItem() == null ||
                                comboBox15.getSelectedItem() == null ||

                                spinner2.getValue().equals(null) ||
                                Integer.parseInt((String) spinner2.getValue()) < 1 ||
                                Integer.parseInt((String) spinner2.getValue()) > 53 ||

                                Integer.parseInt(textField3.getText()) == 0
                        )) {


                        /////////////////////////////////////////////////////////////////////// HTTPs IMPLEMENTATION


                            }
                    } catch (NumberFormatException ex) {
                        ex.printStackTrace();
                    }
                }
                if(e.getSource()==menüErstellenButton) {
                    try {
                        if (textField1.getText() != null && €TextField.getText() != null && Double.parseDouble(€TextField.getText()) > 0) {

                            menu meal = new menu(textField1.getText(), Double.parseDouble(€TextField.getText()));

                            dataConnection dc = new dataConnection();
                            dc.sendNewMenu(meal);
                        }
                    } catch (NumberFormatException ex) {
                        ex.printStackTrace();
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                }



                )){

                    }



                }
            }
        menüErstellenButton.addActionListener(new ActionListener() {
        });
    });
    }
}

