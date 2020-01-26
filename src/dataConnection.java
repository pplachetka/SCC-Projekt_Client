import backend.MenuItem;
import backend.menuItemSchedule;
import backend.schedulePacket;
import com.google.gson.Gson;
import javax.net.ssl.HttpsURLConnection;
import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class dataConnection {

    String URI = "https://speiseplan.ddns.net/speiseplan/endpoint/";
    private windowManager wima;



    public dataConnection(windowManager wm){
        this.wima = wm;
    }

    public String loginUser(String userid, String password) throws MalformedURLException {
        StringBuilder jsonresponse = new StringBuilder();

        URL idCheckURL = new URL(URI + "authentication/login");

        try {
            HttpsURLConnection con = (HttpsURLConnection) idCheckURL.openConnection();

            con.setRequestMethod("POST");
            con.setRequestProperty("ContentType", "application/x-www-form-urlencoded");
            con.setDoOutput(true);
            con.setDoInput(true);

            DataOutputStream dataOutputStream = new DataOutputStream(con.getOutputStream());
            dataOutputStream.writeBytes("userID="+userid+"&password="+password);
            dataOutputStream.flush();
            dataOutputStream.close();

            BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream()));

            String line;
            while((line = br.readLine()) != null){
               jsonresponse.append(line);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return jsonresponse.toString();
    }

    public MenuItem[] getMenuList() throws MalformedURLException {

        URL getListURL = new URL(URI + "admin/getMenuItemList?token=" + wima.getServicetoken());

        try {

            HttpsURLConnection con = (HttpsURLConnection) getListURL.openConnection();

            con.setRequestMethod("GET");
            con.setRequestProperty("Accept" , "application/json");
            con.setDoOutput(true);

            BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream()));
            StringBuilder sb = new StringBuilder();
            String line;
            while ((line = br.readLine()) != null) {
                sb.append(line+"\n");
            }

            Gson gson = new Gson();

            return gson.fromJson(sb.toString(), MenuItem[].class);




        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }


    public int sendNewMenu(String description, String price) throws Exception {

        URL newMenu = new URL(URI + "admin/setMenuItem");

        try{
            HttpsURLConnection con = (HttpsURLConnection) newMenu.openConnection();

            con.setRequestMethod("POST");
            con.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            con.setDoOutput(true);

            OutputStream os = con.getOutputStream();
            byte[] streamline = ("description="+description+"&costs="+price+"&token="+wima.getServicetoken()).getBytes();
            os.write(streamline);

            BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream()));

            return con.getResponseCode();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return 0;
    }

    public void sendMenusOfDay(String menuItemId1, String menuItemId2, String menuItemId3, String date) throws MalformedURLException {

        URL sendDayURL = new URL(URI + "schedule/setMenuItemSchedule");

        schedulePacket sp = new schedulePacket(wima.getServicetoken());


        if(menuItemId1 != null){
            menuItemSchedule m1 = new menuItemSchedule();
            m1.setPosition("1");
            m1.setDate(date);
            m1.setMenuItemID(menuItemId1);

            sp.addToList(m1);
        }
        if(menuItemId2 != null){
            menuItemSchedule m2 = new menuItemSchedule();
            m2.setPosition("2");
            m2.setDate(date);
            m2.setMenuItemID(menuItemId2);

            sp.addToList(m2);
        }
        if(menuItemId3 != null){
            menuItemSchedule m3 = new menuItemSchedule();
            m3.setPosition("3");
            m3.setDate(date);
            m3.setMenuItemID(menuItemId3);

            sp.addToList(m3);
        }

        Gson gson = new Gson();

        System.out.println(gson.toJson(sp));

        try{
            HttpsURLConnection con = (HttpsURLConnection) sendDayURL.openConnection();

            con.setRequestMethod("POST");
            con.setRequestProperty("Content-Type", "application/json");
            con.setDoOutput(true);

            OutputStream os = con.getOutputStream();
            byte[] streamline = (gson.toJson(sp).getBytes());
            os.write(streamline);

            BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream()));


        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public menuItemSchedule[] getMenuItemSchedule(String startDate, String endDate) throws MalformedURLException {

        URL getScheduleURL = new URL(URI + "schedule/getMenuItemSchedule?startDate=" + startDate +"&endDate=" + endDate +"&token=" + wima.getServicetoken());

        try {

            HttpsURLConnection con = (HttpsURLConnection) getScheduleURL.openConnection();

            con.setRequestMethod("GET");
            con.setRequestProperty("Accept" , "application/json");
            con.setDoOutput(true);

            BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream()));
            StringBuilder sb = new StringBuilder();
            String line;
            while ((line = br.readLine()) != null) {
                sb.append(line+"\n");
            }

            Gson gson = new Gson();

            System.out.println(sb.toString());

            return gson.fromJson(sb.toString(), menuItemSchedule[].class);




        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    }
