import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

public class InetDisplay {
    public static void main(String[] args) {
    	try {
            URL url = new URL("https://en.wikipedia.org/wiki/CD_Projekt");
            HashMap<String, String> map = new HashMap<String, String>();
            map.put("Name", "test");
            map.put("Phone", "555-1212");
            StringBuilder sb = new StringBuilder();
            for (Map.Entry<String, String> e: map.entrySet())
                sb.append(URLEncoder.encode(e.getKey(), "UTF-8")+"="+URLEncoder.encode(e.getValue(), "UTF-8")+"&");
            sb.deleteCharAt(sb.length()-1); //get rid of extra &
            HttpURLConnection conn = (HttpURLConnection)url.openConnection();
            conn.setDoOutput(true);
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-type", "application/x-www-form-urlencoded");
            PrintWriter pout = new PrintWriter(new OutputStreamWriter(conn.getOutputStream(), "8859_1"), true);
            pout.print(sb.toString());
            pout.flush();
            
            BufferedReader rdr = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String line;
            int i=50;
            while ((line = rdr.readLine()) != null && i > 0) {
                i--;
                System.out.printf("%s\n", line);
            }
        }
        catch (Exception ex) {
            System.out.printf("Oops: %s", ex.getMessage());
        }
    }
}