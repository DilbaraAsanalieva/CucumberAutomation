package entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.restassured.response.Response;
import lombok.Data;
import utilities.Config;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true) //ignore the one which one is not matching
public class CustomResponse {
    private static CustomResponse customResponse;

    private String jwt_token;

    private String message;

    private String company_name;
    private String seller_name;
    private boolean income;

    private String bank_account_name;
    private String id;
    private int balance;
    private String phone_number;
    private String email;
    private String jsonString;
    private int statusCode;
    private List<Universal> responses;
    private int category_id;
    private Integer tags_id;
    private String client_name;





}
