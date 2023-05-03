package tests;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

public class Mouse {

    @Test


    public void singleUser(){
        Response  response = RestAssured.get("https://reqres.in/api/users/2");
        System.out.println(response.statusCode());
//        System.out.println(response.asString());

        String email = response.jsonPath().get("data.email");
//        System.out.println(email);
        int id = response.jsonPath().get("data.id");
        String text = response.jsonPath().get("support.text");
        String avatar = response.jsonPath().get("data.avatar");
//        System.out.println(id);
//        System.out.println(text);

        Assert.assertFalse(email.isEmpty());
        Assert.assertTrue(email.trim().endsWith("reqres.in"));




        Assert.assertTrue(id>=0);

        Assert.assertTrue(avatar.trim().endsWith(".jpeg")||avatar.trim().endsWith(".jpg")||avatar.trim().endsWith(".png"));

        Assert.assertEquals("To keep ReqRes free, contributions towards server costs are appreciated!", text);









    }
}
