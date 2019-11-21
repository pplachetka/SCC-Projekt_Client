package backend;

import java.util.ArrayList;

public class menulist {

    public menulist(ArrayList<menu> list) {
        this.list = list;
    }

    public ArrayList<menu> getList() {
        return list;
    }

    public void setList(ArrayList<menu> list) {
        this.list = list;
    }

    public ArrayList<menu> list;

}
