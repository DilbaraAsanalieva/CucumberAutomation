package steps;

import entities.RequestBody;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apiguardian.api.API;
import utilities.APIRunner;
import utilities.Config;
import utilities.Driver;

import java.util.HashMap;
import java.util.Map;

public class ClientCreateAPI {

    Map<String, String> apiMapData = new HashMap<>();




    @Given("User hits and POST a client {string}")
    public void user_hits_and_post_a_client(String string, io.cucumber.datatable.DataTable dataTable) {
        // Write code here that turns the phrase above into concrete actions
        // For automatic transformation, change DataTable to one of
        // E, List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or
        // Map<K, List<V>>. E,K,V must be a String, Integer, Float,
        // Double, Byte, Short, Long, BigInteger or BigDecimal.
        //
        // For other transformations you can register a DataTableType.

        apiMapData = dataTable.asMap(String.class,String.class);

        RequestBody requestBody = new RequestBody();
        requestBody.setCompany_name(apiMapData.get("company_name"));
        requestBody.setClient_name(apiMapData.get("client_name"));
        requestBody.setEmail(apiMapData.get("email"));
        requestBody.setPhone_number(apiMapData.get("phone_number"));
        requestBody.setAddress(apiMapData.get("address"));
        requestBody.setTags_id(Integer.valueOf(apiMapData.get("tags_name")));
//        APIRunner.runPOST(endPoint,requestBody);
    }
    @When("user navigates to CashWise APP guest page")
    public void user_navigates_to_cash_wise_app_guest_page() {
        Driver.getDriver().get(Config.getValue("cashwiseBackend"));

    }
    @When("User login to CashWise APP")
    public void user_login_to_cash_wise_app() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @When("Navigate to Clients Page")
    public void navigate_to_clients_page() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @Then("Verify client details between UI and API")
    public void verify_client_details_between_ui_and_api() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

}
