package cashwise;

import com.github.javafaker.Faker;
import entities.RequestBody;
import org.junit.Test;
import utilities.APIRunner;

public class Sellers {

    @Test
    public void createSeller() {
        String path = "/api/myaccount/sellers";
        Faker faker = new Faker();
        RequestBody requestBody = new RequestBody();
        for (int i = 0; i < 9; i++) {
            requestBody.setCompany_name(faker.company().name());
            requestBody.setSeller_name(faker.funnyName().name());
            requestBody.setEmail(faker.internet().emailAddress());
            requestBody.setPhone_number(faker.phoneNumber().phoneNumber());
            requestBody.setAddress(faker.address().city());
            APIRunner.runPOST(path, requestBody);
        }
    }
}
