package steps.db_steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.openqa.selenium.Alert;
import utilities.DBUtilities;
import utilities.Driver;

import java.sql.*;
import java.util.List;

public class DB_Steps {
    Connection connection;
    Statement statement;
    ResultSet resultSet;


    @Given("user connects to the database")
    public void user_connects_to_the_database() throws ClassNotFoundException, SQLException {
       //tries to find
        Class.forName("oracle.jdbc.driver.OracleDriver");

        DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());

        //create connection with Oracle Database
        connection = DriverManager.getConnection("jdbc:oracle:thin:@3.123.40.26:1521:CODEWISE","system","Codewise_123");

        statement = connection.createStatement();

    }
    @When("user runs {string} query")
    public void user_runs(String query) throws SQLException {
         resultSet = statement.executeQuery(query);
        DBUtilities.printResults(query);


    }
    @AfterEach

    @Then("verify if data is returned")
    public void verify_if_data_is_returned() {
        try{
        while (resultSet.next()) {
            if(resultSet.getString("first_name").equals("Steven")){
                System.out.println(resultSet.getString("first_name"));

            }
        }
        }catch(SQLException e){
                System.out.println("Error,SQL result set was not returned");
                e.printStackTrace();
            }
    }



    SQLException exception;
    @Given("user tries to connect to the database with incorrect password")
    public void user_tries_to_connect_to_the_database_with_incorrect_password() throws ClassNotFoundException, SQLException {
        Class.forName("oracle.jdbc.driver.OracleDriver");

        DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
        try {
            connection = DriverManager.getConnection("jdbc:oracle:thin:@3.123.40.26:1521:CODEWISE", "system", "Codewise_123");

        }catch (SQLException e){
            e.printStackTrace();
        }

    }

    @Then("verify user is not able to connect")
    public void verify_user_is_not_able_to_connect() {
        Assert.assertNull("The connection didn't throw exception", connection);

    }








}
