package entities;

import lombok.Data;

@Data
public class RequestBody {

    private String email;
    private String password;
    private String company_name;
    private String seller_name;
    private String phone_number;
    private String address;

    private String bank_account_name;
    private String description;
    private String type_of_pay;
    private double balance;
    private Integer tags_id;
    private String client_name;







}
