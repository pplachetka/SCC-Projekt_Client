package backend;

import java.util.ArrayList;

public class week {

    private ArrayList<day> weekdays;

    public week(){
        weekdays = new ArrayList<>();
    }

    public void addDay(day d){
        weekdays.add(d);
    }

}


