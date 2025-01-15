package StepDefinitions;
import Utils.DatabaseUtils;
import io.cucumber.java.en.Given;

import java.sql.Array;
import java.sql.Connection;
import io.cucumber.java.en.Then;
import static org.junit.Assert.*;
import io.cucumber.java.en.When;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;


public class DBSteps {
    private Connection connection;
    private ResultSet resultSet;


    @Given("SQLite Database connection is set up")
    public void sqlite_database_connection_is_set_up() {
        try {
            // Establish the connection to SQLite database
            connection = DatabaseUtils.getConnection();
            System.out.println("Database connection established.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @When("I hit the query {string}")
    public void i_hit_the_query(String query) {
        try {
            // Execute the query
            Statement statement = connection.createStatement();
            resultSet = statement.executeQuery(query);
            System.out.println("Query executed: " + query);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Then("I validate the received query response")
    public void i_validate_the_received_query_response() {
        try {
            // Validate the query result
            if (resultSet.next()) {
                String name = resultSet.getString("Name");
             //   assertEquals("Alice", name);  // Validate that the name matches 'Alice'
                System.out.println("Query result: Name = " + name);
            } else {
                fail("No user found with the name 'Alice'");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Then("I close the DB connection")
    public void i_close_the_db_connection() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
                System.out.println("Database connection closed.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
