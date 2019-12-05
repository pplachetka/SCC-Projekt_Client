import backend.user;

import javax.swing.*;

public class windowManager {

    JFrame usersight;
    JFrame mainframe;
    JFrame adminsight;
    private backend.user user;

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

    public void showMainframe(){
        mainframe.setVisible(true);
    }

    public void setUser(user newuser){
        this.user = newuser;
    }

    public String getUserName(){
        return this.user.getName();
    }

    public String getFamilyname(){
        return this.user.getFamilyname();
    }

    public String getUserID(){
        return user.getUserid();
    }

    public String getServicetoken(){
        return user.getServicetoken();
    }

    public int usergroup(){
        return user.getIsAdmin();
    }

    public void deleteUser(){
        this.user = null;
    }
}
