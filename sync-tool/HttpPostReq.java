import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.entity.StringEntity;

public class HttpPostReq {

    public static void main(String[] args) {

        HttpClient httpClient = HttpClientBuilder.create().build(); //Use this instead

        try {
            HttpPost request = new HttpPost("http://88.177.205.85/archibook/cloud/api.php/e34a2154179b291826b06d2c80db04b38899ac4208c564ab7cf6d481ad1585eb");
            StringEntity params =new StringEntity("{\"1\":{\"name\":\"test389\",\"password\":\"5123\",\"mail\":\"ahb@hgvgh\"}}");

            request.addHeader("content-type", "application/json");
            request.addHeader("Accept","application/json");
            request.setEntity(params);
            HttpResponse response = httpClient.execute(request);

            // handle response here...
        }catch (Exception ex) {
            // handle exception here
        }
    }






}
