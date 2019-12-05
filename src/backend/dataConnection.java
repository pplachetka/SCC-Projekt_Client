package backend;

import com.sun.xml.internal.ws.api.pipe.ContentType;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLPeerUnverifiedException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.net.URLConnection;
import java.security.cert.Certificate;
import java.util.Base64;

public class dataConnection {
    String URI;

    public dataConnection(){}


    public String loginUser(String userid, String password) throws MalformedURLException {
        StringBuilder jsonresponse = new StringBuilder();

        URL idCheckURL = new URL(URI + "speiseplan/loginuser");

        try {
            HttpsURLConnection con = (HttpsURLConnection) idCheckURL.openConnection();

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
        URL url = new URL("admin/create");

        HttpsURLConnection con = (HttpsURLConnection) url.openConnection();

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
