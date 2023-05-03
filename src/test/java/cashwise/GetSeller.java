package cashwise;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.javafaker.Faker;
import entities.CustomResponse;
import entities.RequestBody;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

public class GetSeller {
    @Test
    public void getSellerToken() throws JsonProcessingException {
        RequestBody requestBody = new RequestBody();
        requestBody.setEmail("test@tester.com");
        requestBody.setPassword("123456");

        Response response =  RestAssured.given().contentType(ContentType.JSON).body(requestBody).post("https://backend.cashwise.us/api/myaccount/auth/login");
        ObjectMapper mapper = new ObjectMapper();
        CustomResponse customResponse = mapper.readValue(response.asString(),CustomResponse.class);
        Assert.assertEquals(200,response.statusCode());


        Response response1 =  RestAssured.given().contentType(ContentType.JSON).auth().oauth2(customResponse.getJwt_token()).get("https://backend.cashwise.us/api/myaccount/sellers/94");
        CustomResponse myResponse = mapper.readValue(response1.asString(),CustomResponse.class);

        Assert.assertNotNull("Company name is Null",myResponse.getCompany_name());
        Assert.assertNotNull(myResponse.getSeller_name());
        Assert.assertFalse(myResponse.getCompany_name().trim().isEmpty());
        Assert.assertFalse(myResponse.getSeller_name().trim().isEmpty());

    }

    @Test
    public void createSellerTest(){
        String token = "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJ0ZXN0QHRlc3Rlci5jb20iLCJleHAiOjE2ODE4MzQxMDcsImlhdCI6MTY4MTIyOTMwN30.k3vpAlbuX2Ew5nSDjS90MNSZ6MYj3IiOnDH9owO7iaZWaReujLIokAkb7v8l4D7pLCiq2P98mf1TMlZM25KBsA";
        Faker faker = new Faker();
        String companyName = faker.company().name();
        String sellerName = faker.name().fullName();
        String email = faker.internet().emailAddress();
        String phoneNum = faker.phoneNumber().cellPhone();
        String address = faker.address().city();

        RequestBody requestBody = new RequestBody();
        requestBody.setCompany_name(companyName);
        requestBody.setEmail(email);
        requestBody.setPhone_number(phoneNum);
        requestBody.setSeller_name(sellerName);
        requestBody.setAddress(address);

        Response response = RestAssured.given().auth().oauth2(token).contentType(ContentType.JSON).body(requestBody)
                .post("https://backend.cashwise.us/api/myaccount/sellers");

        Assert.assertEquals(200,response.statusCode());
        int id = response.jsonPath().get("seller_id");

        String url = "https://backend.cashwise.us/api/myaccount/sellers/"+id;
        Response response1 = RestAssured.given().auth().oauth2(token).get(url);
        Assert.assertEquals(200,response1.statusCode());
    }
    @Test
    public void deleteSeller(){
        String token = "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJ0ZXN0QHRlc3Rlci5jb20iLCJleHAiOjE2ODE4MzQxMDcsImlhdCI6MTY4MTIyOTMwN30.k3vpAlbuX2Ew5nSDjS90MNSZ6MYj3IiOnDH9owO7iaZWaReujLIokAkb7v8l4D7pLCiq2P98mf1TMlZM25KBsA";
        Response response  = RestAssured.given().auth().oauth2(token).contentType(ContentType.JSON)
                .delete("https://backend.cashwise.us/api/myaccount/sellers/97");
        Assert.assertEquals(200,response.getStatusCode());
    }
}
