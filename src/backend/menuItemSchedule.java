package backend;

import java.math.BigDecimal;

public class menuItemSchedule {

    String menuItemID;
    String position;
    String date;
    String menuItemScheduleID;
    String description;
    BigDecimal costs;

    public menuItemSchedule() {
    }


    public String getMenuItemID() {
        return menuItemID;
    }

    public void setMenuItemID(String menuItemID) {
        this.menuItemID = menuItemID;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getMenuItemScheduleID() {
        return menuItemScheduleID;
    }

    public void setMenuItemScheduleID(String menuItemScheduleID) {
        this.menuItemScheduleID = menuItemScheduleID;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getCosts() {
        return costs;
    }

    public void setCosts(BigDecimal costs) {
        this.costs = costs;
    }

}
