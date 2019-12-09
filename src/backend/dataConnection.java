package backend;

//import javax.net.ssl.HttpsURLConnection;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

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


    public void sendNewMenu(menu m) throws Exception {


        boolean success;
        URL url = new URL(URI + "admin/create");

        HttpURLConnection con = (HttpURLConnection) url.openConnection();

        con.setRequestMethod("GET");
        con.setDoOutput(true);

        try{
            BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream()));

            StringBuilder sb = new StringBuilder();
            String jsonline;

            while((jsonline = br.readLine()) != null){
                sb.append(jsonline);
            }

            if(sb.toString() != null)
                success = true;


        } catch (Exception ex) {
            ex.printStackTrace();
        }



        }


    }
