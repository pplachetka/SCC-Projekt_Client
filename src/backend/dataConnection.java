package backend;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLPeerUnverifiedException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.net.URLConnection;
import java.security.cert.Certificate;
import java.util.Base64;

public class dataConnection {

    public dataConnection(){}


    public String loginUser(String username, String password) throws MalformedURLException {
        StringBuilder token = new StringBuilder();

        URL idCheckURL = new URL("login/loginuser/"+ Base64.getEncoder().encodeToString((username+":"+password).getBytes()));

        try {
            HttpsURLConnection con = (HttpsURLConnection) idCheckURL.openConnection();

            con.setRequestMethod("GET");
            con.setDoOutput(true);

            BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream()));

            String line;
            while((line = br.readLine()) != null){
               token.append(line);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return token.toString();
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
