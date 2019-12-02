import javax.swing.*;

public class windowManager {

    JFrame usersight;
    JFrame mainframe;
    JFrame adminsight;
    String usertoken;

    public static void main(String[] args) {
        windowManager windowManager = new windowManager();
        windowManager.buildMainframe();

    }

    public void buildMainframe(){
        mainframe = new mainframe("Kantine MNP - Login", this);
    }

    public void buildUsersight(){
        usersight = new userSight("Bestellung - Kantine MNP", this);
    }

    public void buildAdminsight(){
        adminsight = new adminSight("Admin - Kantine MNP", this);
    }

    public String getUsertoken() {
        return usertoken;
    }

    public void setUsertoken(String usertoken) {
        this.usertoken = usertoken;
    }

    public void showMainframe(){
        mainframe.setVisible(true);
    }


}
