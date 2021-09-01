package restassuredassignments;
import org.testng.annotations.Test;
import org.testng.Assert;
import org.json.simple.JSONObject;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;


public class RestAssign6 {

		@Given("Set https request")
		@Test
		public void set_https_request() {
		   String api="http://api.exchangeratesapi.io/v1/latest?access_key=4fb75ee62f86c0674b3199081e4ab3bd";
		}

		@When("create a negative assertion scenario")
		@Test
		public void create_a_negative_assertion_scenario() {
		JSONObject request= new JSONObject();
		request.put("success", "false");
		request.put("base", "EUR");
		request.put("date", "2021-08-25");
		Response res = RestAssured.post("http://api.exchangeratesapi.io/v1/latest?access_key=4fb75ee62f86c0674b3199081e4ab3bd");
		int statuscode = res.getStatusCode();
		int expected = res.getStatusCode();
		int assigned = 200;
		Assert.assertEquals(expected, assigned);
		System.out.println("Statuscode is :" +statuscode);
		}

		@Then("print the Negative response into console")
		@Test
		public void print_the_negative_response_into_console() {
			Response res = RestAssured.post("http://api.exchangeratesapi.io/v1/latest?access_key=4fb75ee62f86c0674b3199081e4ab3bd");
			 System.out.println("Response body is" +res);
		   System.out.println("Negative response received");
		}


	}


