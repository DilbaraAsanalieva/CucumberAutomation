package tests;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.Test;

import java.util.ArrayList;

public class CashwiseAPI {
    @Test
    public void getCategories(){

        Response response =  RestAssured.get("https://reqres.in/api/users?page=2");
        System.out.println(response.statusCode());
        String first_name = response.jsonPath().get("data[0].first_name");
//        System.out.println(first_name);
        String url = response.jsonPath().get("support.url");
        System.out.println(url);

        ArrayList<String> listOfFirst_name = response.jsonPath().get("data.first_name");
        System.out.println(listOfFirst_name.toString());
        Assertions.assertFalse(listOfFirst_name.isEmpty());

        int page = response.jsonPath().get("per_page");
        System.out.println(page);

        for(int i=0; i < page;i++){
            String first_name_list = response.jsonPath().get("data["+i+"].first_name");
            Assert.assertFalse("Name is empty. Index: " +i,first_name_list.trim().isEmpty());


        }


    }
}
