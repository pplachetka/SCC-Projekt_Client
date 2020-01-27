import backend.MenuItem;
import backend.menuItemSchedule;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Array;
import java.net.MalformedURLException;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.time.temporal.IsoFields;
import java.time.temporal.WeekFields;
import java.util.ArrayList;
import java.util.Locale;

public class adminSight extends JFrame{
    private JButton abmeldenButton;
    private JTabbedPane tabbedPane1;
    private JButton menüEinstellenButton;
    private JComboBox comboBox1;
    private JComboBox comboBox2;
    private JComboBox comboBox3;
    private JTextField €TextField;
    private JTextField textField1;
    private JButton menüErstellenButton;
    private JComboBox comboBox4;
    private JComboBox comboBox5;
    private JComboBox comboBox6;
    private JComboBox comboBox7;
    private JComboBox comboBox8;
    private JComboBox comboBox9;
    private JComboBox comboBox10;
    private JComboBox comboBox11;
    private JComboBox comboBox12;
    private JComboBox comboBox13;
    private JComboBox comboBox14;
    private JComboBox comboBox15;
    private JPanel panel1;
    private JPanel panel2;
    private JButton wocheZurückButton;
    private JButton wocheVorButton;
    private JLabel yearLabel;
    private JLabel weekofyearLabel;
    private JPanel montag;
    private JPanel dienstag;
    private JPanel mittwoch;
    private JPanel donnerstag;
    private JPanel freitag;
    private JButton menüLöschenButton;
    windowManager wm;
    MenuItem[] menuList;
    LocalDate ld;
    menuItemSchedule[] serverSchedule;


    public adminSight(String title, windowManager manager) throws MalformedURLException {
        wm = manager;
        buildWindow(title);
        this.setIconImage(new ImageIcon(this.getClass().getResource("icons/chef.png")).getImage());
        menuList = wm.getDc().getMenuList();
        ld = LocalDate.now();
        yearLabel.setText(String.valueOf(ld.getYear()));
        weekofyearLabel.setText(String.valueOf(ld.get(IsoFields.WEEK_OF_WEEK_BASED_YEAR)));

        LocalDate dayOfWeek;
        dayOfWeek = ld.with(IsoFields.WEEK_OF_WEEK_BASED_YEAR, Long.parseLong(weekofyearLabel.getText()));
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("YYYYMMdd");
        String start = dtf.format(dayOfWeek.with(DayOfWeek.MONDAY));
        String end = dtf.format(dayOfWeek.with(DayOfWeek.FRIDAY));
        serverSchedule = wm.getDc().getMenuItemSchedule(start,end);


        LocalDate firstDay = ld.with(DayOfWeek.MONDAY);
        String monday = firstDay.format(DateTimeFormatter.ofPattern("EEEE dd. MMM"));
        montag.setBorder(new TitledBorder(monday));
        System.out.println(monday);

        LocalDate secondDay = ld.with(DayOfWeek.TUESDAY);
        String tuesday = secondDay.format(DateTimeFormatter.ofPattern("EEEEE dd. MMM"));
        dienstag.setBorder(new TitledBorder(tuesday));
        System.out.println(tuesday);

        LocalDate thirdDay = ld.with(DayOfWeek.WEDNESDAY);
        String wednesday = thirdDay.format(DateTimeFormatter.ofPattern("EEEE dd. MMM"));
        mittwoch.setBorder(new TitledBorder(wednesday));
        System.out.println(wednesday);

        LocalDate fourthDay = ld.with(DayOfWeek.THURSDAY);
        String thursday = fourthDay.format(DateTimeFormatter.ofPattern("EEEE dd. MMM"));
        donnerstag.setBorder(new TitledBorder(thursday));
        System.out.println(thursday);

        LocalDate fifthDay = ld.with(DayOfWeek.FRIDAY);
        String friday = fifthDay.format(DateTimeFormatter.ofPattern("EEEE dd. MMM"));
        freitag.setBorder(new TitledBorder(friday));
        System.out.println(friday);




        comboBox1.insertItemAt("",0);
        comboBox2.insertItemAt("",0);
        comboBox3.insertItemAt("",0);
        comboBox4.insertItemAt("",0);
        comboBox5.insertItemAt("",0);
        comboBox6.insertItemAt("",0);
        comboBox7.insertItemAt("",0);
        comboBox8.insertItemAt("",0);
        comboBox9.insertItemAt("",0);
        comboBox10.insertItemAt("",0);
        comboBox11.insertItemAt("",0);
        comboBox12.insertItemAt("",0);
        comboBox13.insertItemAt("",0);
        comboBox14.insertItemAt("",0);
        comboBox15.insertItemAt("",0);

        fillBoxes();

        fillWeek();
        pack();

        menüEinstellenButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if(e.getSource() == menüEinstellenButton){

                    LocalDate date = LocalDate.of(Integer.parseInt(yearLabel.getText()), LocalDate.now().getMonth(), 1);
                    LocalDate dayInWeek = date.with(IsoFields.WEEK_OF_WEEK_BASED_YEAR, Long.parseLong(weekofyearLabel.getText()));

                    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("YYYYMMdd");


                    String menu1ID = "";
                    String menu2ID = "";
                    String menu3ID = "";



                    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////MONDAY

                    if (!(comboBox1.getSelectedIndex() == -1)
                            || !(comboBox2.getSelectedIndex() == -1)
                            || !(comboBox3.getSelectedIndex() == -1)) {


                        for (MenuItem menu : menuList) {
                            if (menu.getDescription() == String.valueOf(comboBox1.getSelectedItem()))
                                menu1ID = menu.getMenuItemID();
                        }
                        for (MenuItem menu : menuList) {
                            if (menu.getDescription() == String.valueOf(comboBox2.getSelectedItem()))
                                menu2ID = menu.getMenuItemID();
                        }
                        for (MenuItem menu : menuList) {
                            if (menu.getDescription() == String.valueOf(comboBox3.getSelectedItem()))
                                menu3ID = menu.getMenuItemID();
                        }

                        try {

                            wm.getDc().sendMenusOfDay(menu1ID, menu2ID, menu3ID, dtf.format(dayInWeek.with(DayOfWeek.MONDAY)));

                        } catch (MalformedURLException ex) {
                            ex.printStackTrace();
                        }
                    }

                        /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////TUESDAY

                    menu1ID = "";
                    menu2ID = "";
                    menu3ID = "";

                        if (!(comboBox4.getSelectedIndex() == -1)
                            || !(comboBox5.getSelectedIndex() == -1)
                            || !(comboBox6.getSelectedIndex() == -1)) {


                            for (MenuItem menu : menuList) {
                                if (menu.getDescription() == String.valueOf(comboBox4.getSelectedItem()))
                                    menu1ID = menu.getMenuItemID();
                            }
                            for (MenuItem menu : menuList) {
                                if (menu.getDescription() == String.valueOf(comboBox5.getSelectedItem()))
                                    menu2ID = menu.getMenuItemID();
                            }
                            for (MenuItem menu : menuList) {
                                if (menu.getDescription() == String.valueOf(comboBox6.getSelectedItem()))
                                    menu3ID = menu.getMenuItemID();
                            }

                            try {

                                wm.getDc().sendMenusOfDay(menu1ID, menu2ID, menu3ID, dtf.format(dayInWeek.with(DayOfWeek.TUESDAY)));

                            } catch (MalformedURLException ex) {
                                ex.printStackTrace();
                            }
                        }

                            ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////WEDNESDAY

                    menu1ID = "";
                    menu2ID = "";
                    menu3ID = "";

                            if (!(comboBox7.getSelectedIndex() == -1)
                                || !(comboBox8.getSelectedIndex() == -1)
                                || !(comboBox9.getSelectedIndex() == -1)) {


                                for (MenuItem menu : menuList) {
                                    if (menu.getDescription() == String.valueOf(comboBox7.getSelectedItem()))
                                        menu1ID = menu.getMenuItemID();
                                }
                                for (MenuItem menu : menuList) {
                                    if (menu.getDescription() == String.valueOf(comboBox8.getSelectedItem()))
                                        menu2ID = menu.getMenuItemID();
                                }
                                for (MenuItem menu : menuList) {
                                    if (menu.getDescription() == String.valueOf(comboBox9.getSelectedItem()))
                                        menu3ID = menu.getMenuItemID();
                                }

                                try {

                                    wm.getDc().sendMenusOfDay(menu1ID, menu2ID, menu3ID, dtf.format(dayInWeek.with(DayOfWeek.WEDNESDAY)));

                                } catch (MalformedURLException ex) {
                                    ex.printStackTrace();
                                }
                            }

                                //////////////////////////////////////////////////////////////////////////////////////////////////////////////THURSDAY

                    menu1ID = "";
                    menu2ID = "";
                    menu3ID = "";

                                if (!(comboBox10.getSelectedIndex() == -1)
                                     || !(comboBox11.getSelectedIndex() == -1)
                                     || !(comboBox12.getSelectedIndex() == -1)) {


                                    for (MenuItem menu : menuList) {
                                        if (menu.getDescription() == String.valueOf(comboBox10.getSelectedItem()))
                                            menu1ID = menu.getMenuItemID();
                                    }
                                    for (MenuItem menu : menuList) {
                                        if (menu.getDescription() == String.valueOf(comboBox11.getSelectedItem()))
                                            menu2ID = menu.getMenuItemID();
                                    }
                                    for (MenuItem menu : menuList) {
                                        if (menu.getDescription() == String.valueOf(comboBox12.getSelectedItem()))
                                            menu3ID = menu.getMenuItemID();
                                    }

                                    try {

                                        wm.getDc().sendMenusOfDay(menu1ID, menu2ID, menu3ID, dtf.format(dayInWeek.with(DayOfWeek.THURSDAY)));

                                    } catch (MalformedURLException ex) {
                                        ex.printStackTrace();
                                    }
                                }

                                    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////FRIDAY

                    menu1ID = "";
                    menu2ID = "";
                    menu3ID = "";

                                    if (!(comboBox13.getSelectedIndex() == -1)
                                            || !(comboBox14.getSelectedIndex() == -1)
                                            || !(comboBox15.getSelectedIndex() == -1)) {


                                        for (MenuItem menu : menuList) {
                                            if (menu.getDescription() == String.valueOf(comboBox13.getSelectedItem()))
                                                menu1ID = menu.getMenuItemID();
                                        }
                                        for (MenuItem menu : menuList) {
                                            if (menu.getDescription() == String.valueOf(comboBox14.getSelectedItem()))
                                                menu2ID = menu.getMenuItemID();
                                        }
                                        for (MenuItem menu : menuList) {
                                            if (menu.getDescription() == String.valueOf(comboBox15.getSelectedItem()))
                                                menu3ID = menu.getMenuItemID();
                                        }

                                        try {

                                            int code = wm.getDc().sendMenusOfDay(menu1ID, menu2ID, menu3ID, dtf.format(dayInWeek.with(DayOfWeek.FRIDAY)));

                                            if(code == 200){
                                                successMessage();
                                            }
                                            else generalErrorMessage();

                                        } catch (MalformedURLException ex) {
                                            ex.printStackTrace();
                                        }
                                    }
                    }




                }


            });

        abmeldenButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource() == abmeldenButton){
                    dispose();

                    wm.deleteUser();
                    wm.showMainframe();
                }
            }
        });

        menüErstellenButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource() == menüErstellenButton){

                    try {
                        Double.parseDouble(€TextField.getText());
                        int status= wm.getDc().sendNewMenu(textField1.getText(), €TextField.getText());

                        if(status == 200){
                            clearBoxes();
                            menuList = wm.getDc().getMenuList();
                            fillBoxes();
                            successMessage();
                        }
                        else generalErrorMessage();


                    } catch (Exception ex) {
                        wrongPriceMessage();
                        ex.printStackTrace();
                    }
                }
            }
        });

        wocheZurückButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if(actionEvent.getSource() == wocheZurückButton){
                    weekofyearLabel.setText(String.valueOf(Integer.parseInt(weekofyearLabel.getText())-1));

                    LocalDate weekback = ld.with(IsoFields.WEEK_OF_WEEK_BASED_YEAR, Long.parseLong(weekofyearLabel.getText()));
                    String start = dtf.format(weekback.with(DayOfWeek.MONDAY));
                    String end = dtf.format(weekback.with(DayOfWeek.FRIDAY));
                    try {

                        serverSchedule = wm.getDc().getMenuItemSchedule(start,end);

                    } catch (MalformedURLException e) {
                        e.printStackTrace();
                    }

                    clear();

                    fillWeek();

                    LocalDate firstDay = weekback.with(DayOfWeek.MONDAY);
                    String monday = firstDay.format(DateTimeFormatter.ofPattern("EEEE dd. MMM"));
                    montag.setBorder(new TitledBorder(monday));
                    System.out.println(monday);

                    LocalDate secondDay = weekback.with(DayOfWeek.TUESDAY);
                    String tuesday = secondDay.format(DateTimeFormatter.ofPattern("EEEE dd. MMM"));
                    dienstag.setBorder(new TitledBorder(tuesday));
                    System.out.println(tuesday);

                    LocalDate thirdDay = weekback.with(DayOfWeek.WEDNESDAY);
                    String wednesday = thirdDay.format(DateTimeFormatter.ofPattern("EEEE dd. MMM"));
                    mittwoch.setBorder(new TitledBorder(wednesday));
                    System.out.println(wednesday);

                    LocalDate fourthDay = weekback.with(DayOfWeek.THURSDAY);
                    String thursday = fourthDay.format(DateTimeFormatter.ofPattern("EEEE dd. MMM"));
                    donnerstag.setBorder(new TitledBorder(thursday));
                    System.out.println(thursday);

                    LocalDate fifthDay = weekback.with(DayOfWeek.FRIDAY);
                    String friday = fifthDay.format(DateTimeFormatter.ofPattern("EEEE dd. MMM"));
                    freitag.setBorder(new TitledBorder(friday));
                    System.out.println(friday);

                }

            }
        });


        wocheVorButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if(actionEvent.getSource() == wocheVorButton){
                    weekofyearLabel.setText(String.valueOf(Integer.parseInt(weekofyearLabel.getText())+1));

                    LocalDate weekahead = ld.with(IsoFields.WEEK_OF_WEEK_BASED_YEAR, Long.parseLong(weekofyearLabel.getText()));
                    String start = dtf.format(weekahead.with(DayOfWeek.MONDAY));
                    String end = dtf.format(weekahead.with(DayOfWeek.FRIDAY));
                    try {

                        serverSchedule = wm.getDc().getMenuItemSchedule(start,end);

                    } catch (MalformedURLException e) {
                        e.printStackTrace();
                    }

                    clear();

                    fillWeek();

                    LocalDate firstDay = weekahead.with(DayOfWeek.MONDAY);
                    String monday = firstDay.format(DateTimeFormatter.ofPattern("EEEE dd. MMM"));
                    montag.setBorder(new TitledBorder(monday));
                    System.out.println(monday);

                    LocalDate secondDay = weekahead.with(DayOfWeek.TUESDAY);
                    String tuesday = secondDay.format(DateTimeFormatter.ofPattern("EEEE dd. MMM"));
                    dienstag.setBorder(new TitledBorder(tuesday));
                    System.out.println(tuesday);

                    LocalDate thirdDay = weekahead.with(DayOfWeek.WEDNESDAY);
                    String wednesday = thirdDay.format(DateTimeFormatter.ofPattern("EEEE dd. MMM"));
                    mittwoch.setBorder(new TitledBorder(wednesday));
                    System.out.println(wednesday);

                    LocalDate fourthDay = weekahead.with(DayOfWeek.THURSDAY);
                    String thursday = fourthDay.format(DateTimeFormatter.ofPattern("EEEE dd. MMM"));
                    donnerstag.setBorder(new TitledBorder(thursday));
                    System.out.println(thursday);

                    LocalDate fifthDay = weekahead.with(DayOfWeek.FRIDAY);
                    String friday = fifthDay.format(DateTimeFormatter.ofPattern("EEEE dd. MMM"));
                    freitag.setBorder(new TitledBorder(friday));
                    System.out.println(friday);
                }
            }
        });
    }

    private void fillWeek(){
        menuItemSchedule daysMenus[] = new menuItemSchedule[3];
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("YYYYMMdd");
        LocalDate date = ld.with(IsoFields.WEEK_OF_WEEK_BASED_YEAR, Integer.parseInt(weekofyearLabel.getText()));
        LocalDate weekday = date.with(DayOfWeek.MONDAY);

        try {

            for (menuItemSchedule item : serverSchedule) {
                if (item.getDate().equals(dtf.format(weekday)) && item.getPosition().equals("1"))
                    daysMenus[0] = item;
                else if (item.getDate().equals(dtf.format(weekday)) && item.getPosition().equals("2"))
                    daysMenus[1] = item;
                else if (item.getDate().equals(dtf.format(weekday)) && item.getPosition().equals("3"))
                    daysMenus[2] = item;
            }


            if(daysMenus[0] != null){
                comboBox1.getModel().setSelectedItem(daysMenus[0].getDescription());
            }
            if(daysMenus[1] != null) {
                comboBox2.getModel().setSelectedItem(daysMenus[1].getDescription());
            }
            if(daysMenus[2] != null){
                comboBox3.getModel().setSelectedItem(daysMenus[2].getDescription());
            }

            daysMenus = new menuItemSchedule[3];
            weekday = date.with(DayOfWeek.TUESDAY);


            for (menuItemSchedule item : serverSchedule) {
                if (item.getDate().equals(dtf.format(weekday)) && item.getPosition().equals("1"))
                    daysMenus[0] = item;
                else if (item.getDate().equals(dtf.format(weekday)) && item.getPosition().equals("2"))
                    daysMenus[1] = item;
                else if (item.getDate().equals(dtf.format(weekday)) && item.getPosition().equals("3"))
                    daysMenus[2] = item;
            }


            if(daysMenus[0] != null){
                comboBox4.getModel().setSelectedItem(daysMenus[0].getDescription());
            }
            if(daysMenus[1] != null) {
                comboBox5.getModel().setSelectedItem(daysMenus[1].getDescription());
            }
            if(daysMenus[2] != null){
                comboBox6.getModel().setSelectedItem(daysMenus[2].getDescription());
            }

            daysMenus = new menuItemSchedule[3];
            weekday = date.with(DayOfWeek.WEDNESDAY);


            for (menuItemSchedule item : serverSchedule) {
                if (item.getDate().equals(dtf.format(weekday)) && item.getPosition().equals("1"))
                    daysMenus[0] = item;
                else if (item.getDate().equals(dtf.format(weekday)) && item.getPosition().equals("2"))
                    daysMenus[1] = item;
                else if (item.getDate().equals(dtf.format(weekday)) && item.getPosition().equals("3"))
                    daysMenus[2] = item;
            }


            if(daysMenus[0] != null){
                comboBox7.getModel().setSelectedItem(daysMenus[0].getDescription());
            }
            if(daysMenus[1] != null) {
                comboBox8.getModel().setSelectedItem(daysMenus[1].getDescription());
            }
            if(daysMenus[2] != null){
                comboBox9.getModel().setSelectedItem(daysMenus[2].getDescription());
            }

            daysMenus = new menuItemSchedule[3];
            weekday = date.with(DayOfWeek.THURSDAY);


            for (menuItemSchedule item : serverSchedule) {
                if (item.getDate().equals(dtf.format(weekday)) && item.getPosition().equals("1"))
                    daysMenus[0] = item;
                else if (item.getDate().equals(dtf.format(weekday)) && item.getPosition().equals("2"))
                    daysMenus[1] = item;
                else if (item.getDate().equals(dtf.format(weekday)) && item.getPosition().equals("3"))
                    daysMenus[2] = item;
            }

            if(daysMenus[0] != null){
                comboBox10.getModel().setSelectedItem(daysMenus[0].getDescription());
            }
            if(daysMenus[1] != null) {
                comboBox11.getModel().setSelectedItem(daysMenus[1].getDescription());
            }
            if(daysMenus[2] != null){
                comboBox12.getModel().setSelectedItem(daysMenus[2].getDescription());
            }

            daysMenus = new menuItemSchedule[3];
            weekday = date.with(DayOfWeek.FRIDAY);


            for (menuItemSchedule item : serverSchedule) {
                if (item.getDate().equals(dtf.format(weekday)) && item.getPosition().equals("1"))
                    daysMenus[0] = item;
                else if (item.getDate().equals(dtf.format(weekday)) && item.getPosition().equals("2"))
                    daysMenus[1] = item;
                else if (item.getDate().equals(dtf.format(weekday)) && item.getPosition().equals("3"))
                    daysMenus[2] = item;
            }

            if(daysMenus[0] != null){
                comboBox13.getModel().setSelectedItem(daysMenus[0].getDescription());
            }
            if(daysMenus[1] != null) {
                comboBox14.getModel().setSelectedItem(daysMenus[1].getDescription());
            }
            if(daysMenus[2] != null){
                comboBox15.getModel().setSelectedItem(daysMenus[2].getDescription());
            }

        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    private void clear(){
        comboBox1.setSelectedIndex(-1);
        comboBox2.setSelectedIndex(-1);
        comboBox3.setSelectedIndex(-1);
        comboBox4.setSelectedIndex(-1);
        comboBox5.setSelectedIndex(-1);
        comboBox6.setSelectedIndex(-1);
        comboBox7.setSelectedIndex(-1);
        comboBox8.setSelectedIndex(-1);
        comboBox9.setSelectedIndex(-1);
        comboBox10.setSelectedIndex(-1);
        comboBox11.setSelectedIndex(-1);
        comboBox12.setSelectedIndex(-1);
        comboBox13.setSelectedIndex(-1);
        comboBox14.setSelectedIndex(-1);
        comboBox15.setSelectedIndex(-1);
    }


    public void wrongPriceMessage(){
        JOptionPane.showMessageDialog(this, "Kein gültiger Preis eingegeben!");
    }
    public void successMessage(){
        JOptionPane.showMessageDialog(this, "Aktion erfolgreich!");
    }
    public void generalErrorMessage(){ JOptionPane.showMessageDialog(this, "Aktion fehlgeschlagen. Bitte erneut versuchen!"); }

    public void fillBoxes(){
        for(MenuItem menu : menuList){
            comboBox1.addItem(menu.getDescription());
            comboBox2.addItem(menu.getDescription());
            comboBox3.addItem(menu.getDescription());
            comboBox4.addItem(menu.getDescription());
            comboBox5.addItem(menu.getDescription());
            comboBox6.addItem(menu.getDescription());
            comboBox7.addItem(menu.getDescription());
            comboBox8.addItem(menu.getDescription());
            comboBox9.addItem(menu.getDescription());
            comboBox10.addItem(menu.getDescription());
            comboBox11.addItem(menu.getDescription());
            comboBox12.addItem(menu.getDescription());
            comboBox13.addItem(menu.getDescription());
            comboBox14.addItem(menu.getDescription());
            comboBox15.addItem(menu.getDescription());
        }
    }

    public void clearBoxes(){
            comboBox1.removeAllItems();
            comboBox2.removeAllItems();
            comboBox3.removeAllItems();
            comboBox4.removeAllItems();
            comboBox5.removeAllItems();
            comboBox6.removeAllItems();
            comboBox7.removeAllItems();
            comboBox8.removeAllItems();
            comboBox9.removeAllItems();
            comboBox10.removeAllItems();
            comboBox11.removeAllItems();
            comboBox12.removeAllItems();
            comboBox13.removeAllItems();
            comboBox14.removeAllItems();
            comboBox15.removeAllItems();
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

