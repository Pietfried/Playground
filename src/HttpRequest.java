
import java.io.DataOutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class HttpRequest {

    public static void main(String[] args) throws Exception {

        URL url = new URL("http://maps.googleapis.com/maps/api/geocode/json?");
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");
        
        Map<String, String> parameters = new HashMap<>();
        parameters.put("address", "Cecilienkoog 16, Reußenköge");
         
        System.out.println(ParameterStringBuilder.getParamsString(parameters));
        
        con.setDoOutput(true);
        DataOutputStream out = new DataOutputStream(con.getOutputStream());
        out.writeBytes(ParameterStringBuilder.getParamsString(parameters));
        out.flush();
        out.close();
        
        
        
        
    }
}
