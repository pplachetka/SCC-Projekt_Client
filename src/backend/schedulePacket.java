package backend;

import java.util.ArrayList;

public class schedulePacket {



    private String token;
    private ArrayList<menuItemSchedule> menuItemSchedule;

    public schedulePacket(String token) {
        this.token = token;
        menuItemSchedule = new ArrayList<>();
    }


    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public ArrayList<menuItemSchedule> getMis() {
        return menuItemSchedule;
    }

    public void setMis(ArrayList<menuItemSchedule> mis) {
        this.menuItemSchedule = mis;
    }

    public void addToList(menuItemSchedule mis){
        this.menuItemSchedule.add(mis);
    }


}
