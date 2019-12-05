import backend.dataConnection;
import backend.user;
import com.google.gson.Gson;

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
            if(e.getSource()== anmeldenButton && !(textField1.getText().equals("")) && !(String.valueOf(passwordField1.getPassword()).equals(""))){
                dataConnection dc = new dataConnection();
                Gson converter = new Gson();
                String jsonstring = "";
                user jsonuser = null;

                try {
                    jsonstring = dc.loginUser(textField1.getText(), String.valueOf(passwordField1.getPassword()));
                } catch (MalformedURLException ex) {
                    ex.printStackTrace();
                }

                if(jsonstring != ""){
                    jsonuser = converter.fromJson(jsonstring, user.class);

                    wm.setUser(jsonuser);
                }
                else JOptionPane.showMessageDialog(this, "Es ist ein Fehler beim Login aufgetreten. Bitte versuchen sie es erneut.");

                switch(jsonuser.getIsAdmin()){
                    case -1:
                        JOptionPane.showMessageDialog(this, "Sie sind kein registrierter Nutzer!");
                        break;

                    case 0:
                        wm.buildUsersight();
                        this.setVisible(false);
                        break;

                    case 1:
                        wm.buildAdminsight();
                        this.setVisible(false);
                        break;
                }
            }
            else
                JOptionPane.showMessageDialog(this, "Keine korrekte Eingabe der Logindaten getätigt!");

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
