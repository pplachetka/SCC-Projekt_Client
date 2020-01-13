package backend;

//import javax.net.ssl.HttpsURLConnection;
import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;

public class dataConnection {
    String URI;

    public dataConnection(){}


    public String loginUser(String userid, String password) throws MalformedURLException {
        StringBuilder jsonresponse = new StringBuilder();

        URL idCheckURL = new URL(URI + "speiseplan/loginuser");

        try {
            HttpURLConnection con = (HttpURLConnection) idCheckURL.openConnection();

            con.setRequestMethod("POST");
            con.setRequestProperty("ContentType", "application/x-www-form-urlencoded");
            con.setDoOutput(true);

            OutputStream os = con.getOutputStream();
            byte[] streamline = ("userid="+userid+"&password="+password).getBytes();
            os.write(streamline);

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

        URL getListURL = new URL(URI + "/admin/getMenuItemList");

        try {

            HttpURLConnection con = (HttpURLConnection) getListURL.openConnection();

            con.setRequestMethod("POST");
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


    public void sendNewMenu(String description, String price) throws Exception {

        URL newMenu = new URL(URI + "admin/setMenuItem");

        try{
            HttpURLConnection con = (HttpURLConnection) newMenu.openConnection();

            con.setRequestMethod("POST");
            con.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            con.setDoOutput(true);

            OutputStream os = con.getOutputStream();
            byte[] streamline = ("description="+description+"&costs="+price).getBytes();
            os.write(streamline);

            BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream()));


        } catch (Exception ex) {
            ex.printStackTrace();
        }



        }


    }
