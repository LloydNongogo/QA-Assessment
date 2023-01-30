package StepDefinitions;

import Utilities.SeleniumUtilities;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;


public class WebTest extends SeleniumUtilities{
	String firstName = "";
	String lastName = "";
	String userName = "";
	String password = "";
	String customer = "";
	String role = "";
	String email = "";
	String cell = "";

	@Given("Navigate to the web tables page")
	public void navigate_to_the_web_tables_page() {
		setup();
		NavigateByURL("http://www.way2automation.com/angularjs-protractor/webtables/");
	}
	@Given("Validate that you are on the User List Table")
	public void validate_that_you_are_on_the_user_list_table() {
		String webPageTitle = getTitle();
		System.out.println("You are here: " +webPageTitle);
	}

	@Given("Click Add user")
	public void click_add_user() {
		waitElementVisible("//button[@type='add']");
		clickElementByXpath("//button[@type='add']");
	}

	@Given("Add users to the User List Table")
	public void add_users_to_the_user_list_table() throws ParseException {
		waitElementVisible("//form[@name='smartTableValidForm']");

		JSONArray arrayList = readFile("src/test/resources/testData/users.json");
		for (int i = 0; i < arrayList.size(); i++) {
			JSONObject user1 = (JSONObject) arrayList.get(i);
			firstName = (String) user1.get("firstName");
			lastName = (String) user1.get("lastName");
			userName = (String) user1.get("userName");
			password = (String) user1.get("password");
			customer = (String) user1.get("customer");
			role = (String) user1.get("role");
			email = (String) user1.get("email");
			cell = (String) user1.get("cell");

			enterTextByXpath("//input[@name='FirstName']", firstName);
			enterTextByXpath("//input[@name='LastName']", lastName);
			enterTextByXpath("//input[@name='UserName']", userName);
			enterTextByXpath("//input[@name='Password']", password);
			clickElementByXpath("//label[text()='"+customer+"']");
			selectElementFromDropdownByXpath("//select[@name='RoleId']", role);
			enterTextByXpath("//input[@name='Email']", email);
			enterTextByXpath("//input[@name='Mobilephone']", cell);
			clickElementByXpath("//button[@class='btn btn-success']");

			validateTableData("//td[text()='"+firstName+"']");
			validateTableData("//td[text()='"+lastName+"']");
			validateTableData("//td[text()='"+userName+"']");
			validateTableData("//td[text()='"+role+"']");
			validateTableData("//td[text()='"+email+"']");
			validateTableData("//td[text()='"+cell+"']");

			if(i==1){
				System.out.println("DONE!");
			}else{
				waitElementVisible("//button[@type='add']");
				clickElementByXpath("//button[@type='add']");
			}
		}
	}

	@Then("Remove the users from the table")
	public void remove_the_users_from_the_table() throws InterruptedException {

		JSONArray arrayList = readFile("src/test/resources/testData/users.json");
		for (int i = 0; i < arrayList.size(); i++) {
			JSONObject user1 = (JSONObject) arrayList.get(i);
			firstName = (String) user1.get("firstName");

			deleteUserFromTable("//td[contains(text(), '"+firstName+"')]/..//button[@ng-click='delUser()']");
			waitElementVisible("//div[@class='modal-body']");
			clickElementByXpath("//button[text()='OK']");
		}

		tearDown();
	}


}
