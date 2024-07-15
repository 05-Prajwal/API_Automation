package StepDefinations;


import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.example.Configure;
import org.junit.Assert;

import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.config;

public class API_Triggering {

    public int Status_code;
    public RequestSpecification Request;
    public Response Response;

    @Given("I Triggered the URL")
    public void I_Triggered_the_URL() {
        try {
            RestAssured.baseURI = Configure.config.getProperty("URL");
            System.out.println("Connection Done");
        } catch (Exception e) {
            System.out.println("Exception: " + e);
            Assert.assertFalse("URL Triggering failed", true);
        }

    }

    @When("I want the list of {word}")
    public void i_want_the_list_of(String s) {
        try {
            Request = RestAssured.given();
            Response = Request.get(s);
            System.out.println("Api triggered");
        } catch (Exception e) {
            System.out.println("Exception: " + e);
            Assert.assertFalse("Request Triggering failed", true);
        }

    }

    @Then("Validate the users list")
    public void Validate_the_users_list(DataTable table){
        try {
            Status_code = Response.getStatusCode();
            String Response_body = Response.getBody().asString();
            System.out.println(Response_body);

            JsonPath jsnp = Response.jsonPath();

            List<Map<String,String>> data= table.asMaps();
            System.out.println(data.get(1).get("id"));

            Assert.assertEquals(data.get(0).get("id"),jsnp.get("id[0]").toString());
            Assert.assertEquals(data.get(1).get("id"),jsnp.get("id[1]").toString());
            Assert.assertEquals(data.get(0).get("name"),jsnp.get("firstName[0]"));
            Assert.assertEquals(data.get(1).get("name"),jsnp.get("firstName[1]"));

        } catch (Exception e) {
            System.out.println("Exception: " + e);
            Assert.assertFalse("Response validation failed", true);
        }

    }

    @Then("Validate the subjects list")
    public void Validate_the_subjects_list(DataTable table){
        try {
            Status_code = Response.getStatusCode();
            String Response_body = Response.getBody().asString();
            System.out.println(Response_body);

            JsonPath jsnp = Response.jsonPath();

            List<Map<String,String>> data= table.asMaps();
            System.out.println(data.get(1).get("id"));

            Assert.assertEquals(data.get(0).get("id"),jsnp.get("id[0]").toString());
            Assert.assertEquals(data.get(1).get("id"),jsnp.get("id[1]").toString());
            Assert.assertEquals(data.get(0).get("Subject"),jsnp.get("name[0]"));
            Assert.assertEquals(data.get(1).get("Subject"),jsnp.get("name[1]"));

        } catch (Exception e) {
            System.out.println("Exception: " + e);
            Assert.assertFalse("Response validation failed", true);
        }

    }
}
