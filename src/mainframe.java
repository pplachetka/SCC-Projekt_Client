import backend.dataConnection;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;

public class mainframe {
    private JPanel panel1;
    private JTextField textField1;
    private JPasswordField passwordField1;
    private JButton anmeldenButton;
    JFrame frame = new JFrame("mainframe");

    public mainframe() {
        anmeldenButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource()== anmeldenButton){
                  /*  dataConnection dc = new dataConnection();
                    String token;

                    try {
                        token = dc.loginUser(textField1.getText(), String.valueOf(passwordField1.getPassword()));
                    } catch (MalformedURLException ex) {
                        ex.printStackTrace();
                    }*/

                    userSight us = new userSight();
                    us.buildWindow();

                    anmeldenButton.setEnabled(false);




                }
            }
        });
    }

    public static void main(String[] args) {
        mainframe mf = new mainframe();
        mf.buildWindow();
    }


    public void buildWindow(){

        frame.setContentPane(new mainframe().panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}
