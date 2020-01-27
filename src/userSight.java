import backend.MenuItem;
import backend.menuItemSchedule;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.*;

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
import java.time.format.DateTimeFormatter;
import java.time.temporal.IsoFields;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;


public class userSight extends JFrame{



    private JButton abmeldenButton;
    private JButton wocheZurückButton;
    private JRadioButton menü1RadioButton;
    private JRadioButton menü2RadioButton;
    private JRadioButton menü3RadioButton;
    private JRadioButton Menü4RadioButton;


    private JButton wocheVorButton;
    private JButton bestellungAbschickenButton;
    private JScrollPane rootpane;
    private JRadioButton menü4RadioButton;
    private JRadioButton menü5RadioButton;
    private JRadioButton menü6RadioButton;
    private JRadioButton menü7RadioButton;
    private JRadioButton menü8RadioButton;
    private JRadioButton menü9RadioButton;
    private JRadioButton menü10RadioButton;
    private JRadioButton menü11RadioButton;
    private JRadioButton menü12RadioButton;
    private JRadioButton menü13RadioButton;
    private JRadioButton menü14RadioButton;
    private JRadioButton menü15RadioButton;
    private JLabel weekofyearLabel;
    private JPanel montag;
    private JPanel dienstag;
    private JPanel mittwoch;
    private JPanel donnerstag;
    private JPanel freitag;
    private JLabel yearLabel;

    windowManager wm;
    MenuItem[] menuList;
    LocalDate ld;
    menuItemSchedule[] serverSchedule;



    //private JFrame userSight = new JFrame("Benutzeransicht");



    public userSight(String title, windowManager manager) throws MalformedURLException {
        wm = manager;
        buildWindow(title);
        LocalDate ld = LocalDate.now();
        menuList = wm.getDc().getMenuListUser();

        weekofyearLabel.setText(String.valueOf(ld.get(IsoFields.WEEK_OF_WEEK_BASED_YEAR)));
        yearLabel.setText(String.valueOf(ld.getYear()));

        LocalDate firstDay = ld.with(DayOfWeek.MONDAY);
        String monday = firstDay.format(DateTimeFormatter.ofPattern("EEEE dd. MMMM"));
        montag.setBorder(new TitledBorder(monday));

        LocalDate secondDay = ld.with(DayOfWeek.TUESDAY);
        String tuesday = secondDay.format(DateTimeFormatter.ofPattern("EEEE dd. MMMM"));
        dienstag.setBorder(new TitledBorder(tuesday));

        LocalDate thirdDay = ld.with(DayOfWeek.WEDNESDAY);
        String wednesday = thirdDay.format(DateTimeFormatter.ofPattern("EEEE dd. MMMM"));
        mittwoch.setBorder(new TitledBorder(wednesday));

        LocalDate fourthDay = ld.with(DayOfWeek.THURSDAY);
        String thursday = fourthDay.format(DateTimeFormatter.ofPattern("EEEE dd. MMMM"));
        donnerstag.setBorder(new TitledBorder(thursday));

        LocalDate fifthDay = ld.with(DayOfWeek.FRIDAY);
        String friday = fifthDay.format(DateTimeFormatter.ofPattern("EEEE dd. MMMM"));
        freitag.setBorder(new TitledBorder(friday));


                LocalDate dayOfWeek;
                dayOfWeek = ld.with(IsoFields.WEEK_OF_WEEK_BASED_YEAR, Long.parseLong(weekofyearLabel.getText()));
                DateTimeFormatter dtf = DateTimeFormatter.ofPattern("YYYYMMdd");
                String start = dtf.format(dayOfWeek.with(DayOfWeek.MONDAY));
                String end = dtf.format(dayOfWeek.with(DayOfWeek.FRIDAY));
                serverSchedule = wm.getDc().getMenuItemSchedule(start, end);




        //  menuList = wm.getDc().getMenuList();




        setTexts();
        fillWeek();

        this.pack();

        wocheZurückButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if(actionEvent.getSource() == wocheZurückButton) {
                    if (Integer.parseInt(weekofyearLabel.getText()) >= 2) {
                        weekofyearLabel.setText(String.valueOf(Integer.parseInt(weekofyearLabel.getText()) - 1));
                    } else {
                        weekofyearLabel.setText("53");
                        yearLabel.setText(String.valueOf(Integer.parseInt(yearLabel.getText()) - 1));
                    }

                    LocalDate weekback = ld.with(IsoFields.WEEK_OF_WEEK_BASED_YEAR, Long.parseLong(weekofyearLabel.getText()));

                    LocalDate firstDay = weekback.with(DayOfWeek.MONDAY);
                    String monday = firstDay.format(DateTimeFormatter.ofPattern("EEEE dd. MMMM"));
                    montag.setBorder(new TitledBorder(monday));

                    LocalDate secondDay = weekback.with(DayOfWeek.TUESDAY);
                    String tuesday = secondDay.format(DateTimeFormatter.ofPattern("EEEE dd. MMMM"));
                    dienstag.setBorder(new TitledBorder(tuesday));

                    LocalDate thirdDay = weekback.with(DayOfWeek.WEDNESDAY);
                    String wednesday = thirdDay.format(DateTimeFormatter.ofPattern("EEEE dd. MMMM"));
                    mittwoch.setBorder(new TitledBorder(wednesday));

                    LocalDate fourthDay = weekback.with(DayOfWeek.THURSDAY);
                    String thursday = fourthDay.format(DateTimeFormatter.ofPattern("EEEE dd. MMM"));
                    donnerstag.setBorder(new TitledBorder(thursday));

                    LocalDate fifthDay = weekback.with(DayOfWeek.FRIDAY);
                    String friday = fifthDay.format(DateTimeFormatter.ofPattern("EEEE dd. MMM"));
                    freitag.setBorder(new TitledBorder(friday));

                    String start = dtf.format(weekback.with(DayOfWeek.MONDAY));
                    String end = dtf.format(weekback.with(DayOfWeek.FRIDAY));
                    try {

                        serverSchedule = wm.getDc().getMenuItemSchedule(start, end);

                    } catch (MalformedURLException e) {
                        e.printStackTrace();
                    }

                }

                    setTexts();
                    fillWeek();

                }

            });


        wocheVorButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if(actionEvent.getSource() == wocheVorButton){

                    if(Integer.parseInt(weekofyearLabel.getText()) <= 52){
                        weekofyearLabel.setText(String.valueOf(Integer.parseInt(weekofyearLabel.getText()) + 1));
                    }
                    else{
                        weekofyearLabel.setText("1");
                        yearLabel.setText(String.valueOf(Integer.parseInt(yearLabel.getText()) + 1));
                    }

                    LocalDate weekahead = ld.with(IsoFields.WEEK_OF_WEEK_BASED_YEAR, Long.parseLong(weekofyearLabel.getText()));

                    LocalDate firstDay = weekahead.with(DayOfWeek.MONDAY);
                    String monday = firstDay.format(DateTimeFormatter.ofPattern("EEEE dd. MMMM"));
                    montag.setBorder(new TitledBorder(monday));

                    LocalDate secondDay = weekahead.with(DayOfWeek.TUESDAY);
                    String tuesday = secondDay.format(DateTimeFormatter.ofPattern("EEEE dd. MMMM"));
                    dienstag.setBorder(new TitledBorder(tuesday));

                    LocalDate thirdDay = weekahead.with(DayOfWeek.WEDNESDAY);
                    String wednesday = thirdDay.format(DateTimeFormatter.ofPattern("EEEE dd. MMMM"));
                    mittwoch.setBorder(new TitledBorder(wednesday));

                    LocalDate fourthDay = weekahead.with(DayOfWeek.THURSDAY);
                    String thursday = fourthDay.format(DateTimeFormatter.ofPattern("EEEE dd. MMMM"));
                    donnerstag.setBorder(new TitledBorder(thursday));

                    LocalDate fifthDay = weekahead.with(DayOfWeek.FRIDAY);
                    String friday = fifthDay.format(DateTimeFormatter.ofPattern("EEEE dd. MMMM"));
                    freitag.setBorder(new TitledBorder(friday));

                    String start = dtf.format(weekahead.with(DayOfWeek.MONDAY));
                    String end = dtf.format(weekahead.with(DayOfWeek.FRIDAY));
                    try {

                        serverSchedule = wm.getDc().getMenuItemSchedule(start,end);

                    } catch (MalformedURLException e) {
                        e.printStackTrace();
                    }

                    setTexts();
                    fillWeek();
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


    }


    private void fillWeek(){
        menuItemSchedule daysMenus[] = new menuItemSchedule[3];
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("YYYYMMdd");
        LocalDate ld = LocalDate.now();
        LocalDate date = ld.with((TemporalField) IsoFields.WEEK_OF_WEEK_BASED_YEAR, Integer.parseInt(weekofyearLabel.getText()));
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
                menü1RadioButton.setText(daysMenus[0].getDescription());
                menü1RadioButton.setForeground(Color.black);
                menü1RadioButton.setEnabled(true);
            }
            if(daysMenus[1] != null) {
                menü2RadioButton.setText(daysMenus[1].getDescription());
                menü2RadioButton.setForeground(Color.black);
                menü2RadioButton.setEnabled(true);
            }
            if(daysMenus[2] != null){
                menü3RadioButton.setText(daysMenus[2].getDescription());
                menü3RadioButton.setForeground(Color.black);
                menü3RadioButton.setEnabled(true);
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
                menü4RadioButton.setText(daysMenus[0].getDescription());
                menü4RadioButton.setForeground(Color.black);
                menü4RadioButton.setEnabled(true);
            }
            if(daysMenus[1] != null) {
                menü5RadioButton.setText(daysMenus[1].getDescription());
                menü5RadioButton.setForeground(Color.black);
                menü5RadioButton.setEnabled(true);

            }
            if(daysMenus[2] != null){
                menü6RadioButton.setText(daysMenus[2].getDescription());
                menü6RadioButton.setForeground(Color.black);
                menü6RadioButton.setEnabled(true);
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
                menü7RadioButton.setText(daysMenus[0].getDescription());
                menü7RadioButton.setForeground(Color.black);
                menü7RadioButton.setEnabled(true);
            }
            if(daysMenus[1] != null) {
                menü8RadioButton.setText(daysMenus[1].getDescription());
                menü8RadioButton.setForeground(Color.black);
                menü8RadioButton.setEnabled(true);
            }
            if(daysMenus[2] != null){
                menü9RadioButton.setText(daysMenus[2].getDescription());
                menü9RadioButton.setForeground(Color.black);
                menü9RadioButton.setEnabled(true);
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
                menü10RadioButton.setText(daysMenus[0].getDescription());
                menü10RadioButton.setForeground(Color.black);
                menü10RadioButton.setEnabled(true);
            }
            if(daysMenus[1] != null) {
                menü11RadioButton.setText(daysMenus[1].getDescription());
                menü11RadioButton.setForeground(Color.black);
                menü11RadioButton.setEnabled(true);
            }
            if(daysMenus[2] != null){
                menü12RadioButton.setText(daysMenus[2].getDescription());
                menü12RadioButton.setForeground(Color.black);
                menü12RadioButton.setEnabled(true);
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
                menü13RadioButton.setText(daysMenus[0].getDescription());
                menü13RadioButton.setForeground(Color.black);
                menü13RadioButton.setEnabled(true);
            }
            if(daysMenus[1] != null) {
                menü14RadioButton.setText(daysMenus[1].getDescription());
                menü14RadioButton.setForeground(Color.black);
                menü14RadioButton.setEnabled(true);
            }
            if(daysMenus[2] != null){
                menü15RadioButton.setText(daysMenus[2].getDescription());
                menü15RadioButton.setForeground(Color.black);
                menü15RadioButton.setEnabled(true);
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    private void setTexts(){
        menü1RadioButton.setText("kein Menü verfügbar");
        menü2RadioButton.setText("kein Menü verfügbar");
        menü3RadioButton.setText("kein Menü verfügbar");

        menü4RadioButton.setText("kein Menü verfügbar");
        menü5RadioButton.setText("kein Menü verfügbar");
        menü6RadioButton.setText("kein Menü verfügbar");

        menü7RadioButton.setText("kein Menü verfügbar");
        menü8RadioButton.setText("kein Menü verfügbar");
        menü9RadioButton.setText("kein Menü verfügbar");

        menü10RadioButton.setText("kein Menü verfügbar");
        menü11RadioButton.setText("kein Menü verfügbar");
        menü12RadioButton.setText("kein Menü verfügbar");

        menü13RadioButton.setText("kein Menü verfügbar");
        menü14RadioButton.setText("kein Menü verfügbar");
        menü15RadioButton.setText("kein Menü verfügbar");


        menü1RadioButton.setForeground(Color.gray);
        menü2RadioButton.setForeground(Color.gray);
        menü3RadioButton.setForeground(Color.gray);

        menü4RadioButton.setForeground(Color.gray);
        menü5RadioButton.setForeground(Color.gray);
        menü6RadioButton.setForeground(Color.gray);

        menü7RadioButton.setForeground(Color.gray);
        menü8RadioButton.setForeground(Color.gray);
        menü9RadioButton.setForeground(Color.gray);

        menü10RadioButton.setForeground(Color.gray);
        menü11RadioButton.setForeground(Color.gray);
        menü12RadioButton.setForeground(Color.gray);

        menü13RadioButton.setForeground(Color.gray);
        menü14RadioButton.setForeground(Color.gray);
        menü15RadioButton.setForeground(Color.gray);


        menü1RadioButton.setEnabled(false);
        menü2RadioButton.setEnabled(false);
        menü3RadioButton.setEnabled(false);

        menü4RadioButton.setEnabled(false);
        menü5RadioButton.setEnabled(false);
        menü6RadioButton.setEnabled(false);

        menü7RadioButton.setEnabled(false);
        menü8RadioButton.setEnabled(false);
        menü9RadioButton.setEnabled(false);

        menü10RadioButton.setEnabled(false);
        menü11RadioButton.setEnabled(false);
        menü12RadioButton.setEnabled(false);

        menü13RadioButton.setEnabled(false);
        menü14RadioButton.setEnabled(false);
        menü15RadioButton.setEnabled(false);
    }


    public void buildWindow(String title){
        this.setTitle(title);
        this.setContentPane(this.rootpane);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    

}
