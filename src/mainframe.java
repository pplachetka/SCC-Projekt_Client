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
    JFrame frame = new JFrame("MNP - Kantinensoftware");
    JFrame usersight;

    public mainframe() {
        this.frame.setIconImage(new ImageIcon("C:\\Users\\Paul\\IdeaProjects\\untitled7\\src\\icons\\chef.png").getImage());
        anmeldenButton.addActionListener(e -> {
            if(e.getSource()== anmeldenButton){
              /*  dataConnection dc = new dataConnection();
                String token;

                try {
                    token = dc.loginUser(textField1.getText(), String.valueOf(passwordField1.getPassword()));
                } catch (MalformedURLException ex) {
                    ex.printStackTrace();
                }*/

                usersight = new userSight("Benutzerfenster");

                anmeldenButton.setEnabled(false);





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
