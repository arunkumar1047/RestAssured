package restassuredassignments;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;



public class RestAssign7 {
	
		@Given("Sets http request")
		@Test
		public void sets_http_request() {
			String api="http://api.exchangeratesapi.io/v1/latest?access_key=4fb75ee62f86c0674b3199081e4ab3bd";
		}

		@When("To get date & Time")
		@Test
		public void to_get_date_time() {
			JSONObject request= new JSONObject();
			request.put("success", "false");
			request.put("base", "EUR");
			request.put("date", "2021-08-25");
			Response res = RestAssured.post("http://api.exchangeratesapi.io/v1/latest?access_key=4fb75ee62f86c0674b3199081e4ab3bd");
			System.out.println(res.getBody());
		  }

		@Then("print the response in the console")
		@Test
		public void print_the_response_in_the_console() {
		Response res = RestAssured.post("http://api.exchangeratesapi.io/v1/latest?access_key=4fb75ee62f86c0674b3199081e4ab3bd");
		System.out.println("Response body is :" +res);
		System.out.println("response received");
		}


	}

