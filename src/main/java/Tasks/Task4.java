package Tasks;

import kong.unirest.json.JSONObject;

import javax.net.ssl.HttpsURLConnection;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

public class Task4 {
    public static String getFieldResultFromGetRequest(String urlAddress, String key, String field) {
        var requestResult = getRequestResult(urlAddress);
        var object = new JSONObject(requestResult);
        return object.getJSONObject(key).getString(field);
    }

    private static String getRequestResult(String urlAddress) {
        try {
            var requestResult = new StringBuilder();
            var url = new URL(urlAddress);
            var connection = (HttpsURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            try (var reader = new BufferedReader(
                    new InputStreamReader(connection.getInputStream()))) {
                for (String line; (line = reader.readLine()) != null; ) {
                    requestResult.append(line);
                }
            }
            return requestResult.toString();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
