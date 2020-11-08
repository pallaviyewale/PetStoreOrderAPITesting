package stepDefinations;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import static io.restassured.RestAssured.*;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import resources.APIResources;
import resources.TestDataBuild;
import resources.Utils;
import static org.junit.Assert.*;


public class PetStoreOrderStepDefination extends Utils
{
	RequestSpecification reqSpec;
	ResponseSpecification resspec;
	public Response response;
	TestDataBuild data = new TestDataBuild();
	
    @Given("^Add Store Order Payload with id \"([^\"]*)\" petid \"([^\"]*)\" and quantity \"([^\"]*)\"$")
    public void add_order_payload(int id, int petId, int quantity) {
    	   	
    	String b = TestDataBuild.getPetOrderPostPayload(id,petId, quantity);
    	reqSpec = given().header("Content-Type","application/json").body(b);
    }
    
    @When("^user calls \"([^\"]*)\" with \"([^\"]*)\" http request$")
    public void user_calls_api_with_post_http_request(String resource, String method) {

		resspec = Utils.responseSpecifications();
		 
		APIResources resourceAPI=APIResources.valueOf(resource);
			
		if(method.equalsIgnoreCase("POST"))
			response =reqSpec.when().post(resourceAPI.getResource());
		else if(method.equalsIgnoreCase("GET"))
			response =reqSpec.when().get(resourceAPI.getResource());
    }

    @Then("^the API call got success with status code 200$")
    public void the_api_call_got_success_with_status_code_200() {
    	
    	assertEquals(response.getStatusCode(),200);
    }

    @Then("^verify the order with respective fields (.+), (.+), (.+), (.+), (.+)$")
    public void verify_the_order_with_respective_fields(String id, String petid, String quantity, String status, String complete) {
    	
    	assertEquals(id,Utils.rawToJson(response,"id"));
    	assertEquals(petid,Utils.rawToJson(response,"petId"));
    	assertEquals(quantity,Utils.rawToJson(response,"quantity"));
    	assertEquals(status,Utils.rawToJson(response,"status"));
    	assertEquals(complete,Utils.rawToJson(response,"complete"));
    }

    @Then("^verify the order response header with respective fields \"([^\"]*)\", \"([^\"]*)\"$")
    public void verify_the_order_header_with_respective_fields(String allowheaders, String allowmethods) {
    	
    	assertEquals(allowheaders,response.getHeader("access-control-allow-headers"));
    	assertEquals(allowmethods,response.getHeader("access-control-allow-methods"));
    }
}
