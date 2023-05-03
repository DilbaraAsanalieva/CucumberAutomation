package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import utilities.APIRunner;

import java.util.HashMap;
import java.util.Map;

public class GetAllClients_steps {
    @Given("user hits get all clients API {string} {string} {string} {string}")
    public void user_hits_get_all_clients_api(String path, String isArchived, String page, String size) {
        Map<String, Object> params = new HashMap<>();
        params.put("isArchived",isArchived);
        params.put("page",page);
        params.put("size",size);
        APIRunner.runGET(path,params);

    }

    @Then("user verifies that total number of clients should be {string}")
    public void user_verifies_that_total_number_of_clients_should_be(String string) {
        APIRunner.getCustomResponse().getResponses().size();
    }
}
