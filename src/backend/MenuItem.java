package backend;

import java.math.BigDecimal;

public class MenuItem {

    private String menuItemID;
    private String description;
    private BigDecimal costs;

    public String getMenuItemID() {
        return menuItemID;
    }

    public void setMenuItemID(String menuItemID) {
        this.menuItemID = menuItemID;
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

    @Override
    public String toString() {
        return "MenuItem{" +
                "MenuItemID='" + menuItemID + '\'' +
                ", Description='" + description + '\'' +
                ", Costs=" + costs +
                '}';
    }
}
