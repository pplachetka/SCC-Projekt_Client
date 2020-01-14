package backend;

import javax.net.ssl.HttpsURLConnection;
import com.google.gson.Gson;

import javax.net.ssl.HttpsURLConnection;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;

public class dataConnection {
    String URI = "https://speiseplan.ddns.net/speiseplan/endpoint/";

    public dataConnection(){}


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
            dataOutputStream.writeBytes("userId="+userid+"&password="+password);
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

        URL getListURL = new URL(URI + "admin/getMenuItemList");

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
            byte[] streamline = ("Description="+description+"&Costs="+price).getBytes();
            os.write(streamline);

            BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream()));


        } catch (Exception ex) {
            ex.printStackTrace();
        }



        }


    }
