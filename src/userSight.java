import backend.MenuItem;
import backend.menuItemSchedule;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.IsoFields;

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
import java.time.temporal.TemporalField;
import java.time.temporal.WeekFields;
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
    private windowManager wm;

    MenuItem[] menuList;
    LocalDate ld;



    //private JFrame userSight = new JFrame("Benutzeransicht");



    public userSight(String title, windowManager manager){
        wm = manager;
        buildWindow(title);
        LocalDate ld = LocalDate.now();

        weekofyearLabel.setText(String.valueOf(ld.get(IsoFields.WEEK_OF_WEEK_BASED_YEAR)));
        yearLabel.setText(String.valueOf(ld.getYear()));

        LocalDate firstDay = ld.with(DayOfWeek.MONDAY);
        String monday = firstDay.format(DateTimeFormatter.ofPattern("E dd. MMM"));
        montag.setBorder(new TitledBorder(monday));
        System.out.println(monday);

        LocalDate secondDay = ld.with(DayOfWeek.TUESDAY);
        String tuesday = secondDay.format(DateTimeFormatter.ofPattern("E dd. MMM"));
        dienstag.setBorder(new TitledBorder(tuesday));
        System.out.println(tuesday);

        LocalDate thirdDay = ld.with(DayOfWeek.WEDNESDAY);
        String wednesday = thirdDay.format(DateTimeFormatter.ofPattern("E dd. MMM"));
        mittwoch.setBorder(new TitledBorder(wednesday));
        System.out.println(wednesday);

        LocalDate fourthDay = ld.with(DayOfWeek.THURSDAY);
        String thursday = fourthDay.format(DateTimeFormatter.ofPattern("E dd. MMM"));
        donnerstag.setBorder(new TitledBorder(thursday));
        System.out.println(thursday);

        LocalDate fifthDay = ld.with(DayOfWeek.FRIDAY);
        String friday = fifthDay.format(DateTimeFormatter.ofPattern("E dd. MMM"));
        freitag.setBorder(new TitledBorder(friday));
        System.out.println(friday);


        //  menuList = wm.getDc().getMenuList();

        menü1RadioButton.setText("geilstes Menü 1");
        menü2RadioButton.setText("geilstes Menü 2");
        menü3RadioButton.setText("geilstes Menü 3");

        menü4RadioButton.setText("geilstes Menü 4");
        menü5RadioButton.setText("geilstes Menü 5");
        menü6RadioButton.setText("geilstes Menü 6");

        menü7RadioButton.setText("geilstes Menü 7");
        menü8RadioButton.setText("geilstes Menü 8");
        menü9RadioButton.setText("geilstes Menü 9");

        menü10RadioButton.setText("geilstes Menü 10");
        menü11RadioButton.setText("geilstes Menü 11");
        menü12RadioButton.setText("geilstes Menü 12");

        menü13RadioButton.setText("geilstes Menü 1");
        menü14RadioButton.setText("geilstes Menü 14");
        menü15RadioButton.setText("geilstes Menü 15");


        this.pack();


        wocheZurückButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if(actionEvent.getSource() == wocheZurückButton){
                    if(Integer.parseInt(weekofyearLabel.getText()) >= 2){
                        weekofyearLabel.setText(String.valueOf(Integer.parseInt(weekofyearLabel.getText()) - 1));
                    }
                    else{
                        weekofyearLabel.setText("53");
                        yearLabel.setText(String.valueOf(Integer.parseInt(yearLabel.getText()) - 1));
                    }

                    LocalDate weekback = ld.with(IsoFields.WEEK_OF_WEEK_BASED_YEAR, Long.parseLong(weekofyearLabel.getText()));

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

                    if(Integer.parseInt(weekofyearLabel.getText()) <= 52){
                        weekofyearLabel.setText(String.valueOf(Integer.parseInt(weekofyearLabel.getText()) + 1));
                    }
                    else{
                        weekofyearLabel.setText("1");
                        yearLabel.setText(String.valueOf(Integer.parseInt(yearLabel.getText()) + 1));
                    }

                    LocalDate weekahead = ld.with(IsoFields.WEEK_OF_WEEK_BASED_YEAR, Long.parseLong(weekofyearLabel.getText()));

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

    public void buildWindow(String title){
        this.setTitle(title);
        this.setContentPane(this.rootpane);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }



}
