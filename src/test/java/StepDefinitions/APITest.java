package StepDefinitions;

import io.cucumber.java.en.Given;
import static io.restassured.RestAssured.get;
import io.restassured.response.Response;
import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.Assert;

public class APITest{

    @Given("Perform an API request to produce a list of all dog breeds.")
    public void perform_an_api_request_to_produce_a_list_of_all_dog_breeds() {
        String URL = "https://dog.ceo/api/breeds/list/all";
        Response responseResult = get(URL);
        int statusCode = responseResult.getStatusCode();
        Assert.assertEquals(statusCode, 200);
        System.out.println("HTTP Status: " + responseResult.getStatusCode());

        String responseBodyAsString = responseResult.getBody().prettyPrint();
//        System.out.println(responseBodyAsString);
    }

    @Given("Verify retriever breed is within the list.")
    public void verify_retriever_breed_is_within_the_list() {
        String URL = "https://dog.ceo/api/breeds/list/all";
        Response responseResult = get(URL);
        String responseBodyAsString = responseResult.getBody().asString();
        Assert.assertTrue(responseBodyAsString.contains("retriever"), "retriever");
        System.out.println("Verify - retriever is within list");
        System.out.println("");
    }

    @Given("Verify a list of sub-breeds for retriever.")
    public void verify_a_list_of_sub_breeds_for_retriever() {
        String URL = "https://dog.ceo/api/breed/retriever/list";
        Response responseResult = get(URL);
        String responseBodyAsString = responseResult.getBody().asString();
        System.out.println(responseBodyAsString);

    }

    @Given("Verify you can retrieve a random image or link for the sub-breed golden")
    public void verify_you_can_retrieve_a_random_image_or_link_for_the_sub_breed_golden() {
        String URL = "https://dog.ceo/api/breed/retriever/golden/images/random";
        Response responseResult = get(URL);
        String responseBodyAsString = responseResult.getBody().asString();
        System.out.println(responseBodyAsString);
    }
}