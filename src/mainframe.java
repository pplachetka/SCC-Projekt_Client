import backend.dataConnection;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;

public class mainframe extends JFrame{
    private JPanel panel1;
    private JTextField textField1;
    private JPasswordField passwordField1;
    private JButton anmeldenButton;
    private windowManager wm;

    public mainframe(String title, windowManager manager) {
        wm = manager;
        buildWindow(title);
        this.setIconImage(new ImageIcon("C:\\Users\\Paul\\IdeaProjects\\untitled7\\src\\icons\\chef.png").getImage());

        anmeldenButton.addActionListener(e -> {
            if(e.getSource()== anmeldenButton){
          /*      dataConnection dc = new dataConnection();
                String token;

                try {
                    token = dc.loginUser(textField1.getText(), String.valueOf(passwordField1.getPassword()));
                } catch (MalformedURLException ex) {
                    ex.printStackTrace();
                }

                wm.setUsertoken(token);*/

                wm.buildAdminsight();


                this.setVisible(false);




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

    public void unlockLoginButton(){
        anmeldenButton.setEnabled(true);
    }

}
