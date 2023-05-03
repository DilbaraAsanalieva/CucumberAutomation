package cashwise;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Test;
import utilities.APIRunner;

import java.util.HashMap;
import java.util.Map;

public class GetClients {

    @Test
    public void getSomeClients(){
        String url = "https://backend.cashwise.us/api/myaccount/clients";
        String token = "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJkaWxiYXJhNTVAZ21haWwuY29tIiwiZXhwIjoxNjgyNTEwNTAyLCJpYXQiOjE2ODE5MDU3MDJ9.5OZADdAi54oRiniJmli3UeqtBQRfO7McnooH2Jugr_wSxhP8OvS5Jx1b5LziaR8zMAeTO3IVCgh6fPWCvyCKxQ";

        Map<String,Object> parameters = new HashMap<>();
        parameters.put("isArchived",false);
        parameters.put("page",1);
        parameters.put("size",5);

        Response response = RestAssured.given().auth().oauth2(token).params(parameters).get(url);
        System.out.println(response.statusCode());
        System.out.println(response.asPrettyString());

    }
}
