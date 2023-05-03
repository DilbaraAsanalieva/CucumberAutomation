package cashwise;

import com.github.javafaker.Faker;
import entities.RequestBody;
import org.apiguardian.api.API;
import org.junit.Test;
import utilities.APIRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class BankAccount {

    @Test
    public void createBankAccount(){
        List<String> payTypes = new ArrayList<>();
        payTypes.add("ELECTRONIC_MONEY_TRANSFER");
        payTypes.add("BANK");
        payTypes.add("CASH");
        Random random = new Random();

        String path = "/api/myaccount/bankaccount";
        Faker faker = new Faker();
        RequestBody requestBody = new RequestBody();
        for(int i = 0; i<2;i++){

            requestBody.setBank_account_name(faker.company().name());
            requestBody.setDescription(faker.shakespeare().hamletQuote());
            int index = random.nextInt(payTypes.size());
            requestBody.setType_of_pay(payTypes.get(index));
            requestBody.setBalance(1500);
            APIRunner.runPOST(path,requestBody);
            System.out.println(APIRunner.getCustomResponse().getBank_account_name());
        }
    }

    @Test
    public void deleteBankAccount(){
        String path = "/api/myaccount/bankaccount/1213";
        APIRunner.runDELETE(path);
    }
    @Test
    public void deleteBankAccounts(){
        String bankAccountPath = "/api/myaccount/bankaccount";
        APIRunner.runGetList(bankAccountPath);
        for(int i = 0; i< APIRunner.getResponseList().length;i++){
            int balance = APIRunner.getResponseList()[i].getBalance();
            if(balance>1000 && balance<2000 ){
                String id = APIRunner.getResponseList()[i].getId();
                String path = "/api/myaccount/bankaccount/"+id;
                APIRunner.runDELETE(path);
            }
        }
        System.out.println("After Deletion");
        APIRunner.runGetList(bankAccountPath);
        for(int i = 0; i < APIRunner.getResponseList().length;i++){
//            System.out.println("Bank name: "+ APIRunner.getResponseList()[i].getBank_account_name());
//            System.out.println("Balance: "+ APIRunner.getResponseList()[i].getBalance());
            System.out.println();
        }
    }
}
