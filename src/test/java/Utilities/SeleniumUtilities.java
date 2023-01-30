package Utilities;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileReader;
import java.util.concurrent.TimeUnit;

public class SeleniumUtilities {

	protected static WebDriver driver;

	public void setup() {
		System.setProperty("webdriver.chrome.driver", "webDrivers/chromedriver");
		SeleniumUtilities.driver = new ChromeDriver();
		SeleniumUtilities.driver.manage().window().maximize();
		SeleniumUtilities.driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		SeleniumUtilities.driver.manage().timeouts().setScriptTimeout(60, TimeUnit.SECONDS);
		SeleniumUtilities.driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	}

	public void tearDown() throws InterruptedException {
		SeleniumUtilities.driver.manage().deleteAllCookies();
		SeleniumUtilities.driver.close();
		SeleniumUtilities.driver =null;
	}

	public void NavigateByURL (String url) {
		driver.get(url);
	}

	public String getTitle(){
		String webPageTitle = SeleniumUtilities.driver.getTitle();
		return webPageTitle;
	}

	public void clickElementByXpath(String xpath) {
		WebElement element = driver.findElement(By.xpath(xpath));
		WebDriverWait wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
		element.click();
	}

	public void deleteUserFromTable(String xpath) {
		WebElement element = driver.findElement(By.xpath(xpath));
		WebDriverWait wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
		element.click();
	}

	public static JSONArray readFile(String path) {
		JSONParser parser = new JSONParser();
		JSONArray array = null;
		try {
			Object obj = parser.parse(new FileReader(path));
			JSONObject jsonObject = (JSONObject) obj;

			array = (JSONArray) jsonObject.get("users");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return array;
	}

	public String validateTableData(String xpath){
		WebElement element = driver.findElement(By.xpath(xpath));
		String elementText =  element.getText();
		WebDriverWait wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
		element.isDisplayed();
		return elementText;
	}

	public void enterTextByXpath(String xpath, String text) {
		WebElement element = driver.findElement(By.xpath(xpath));
		element.clear();
		element.sendKeys(text);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(text);
	}

	public void selectElementFromDropdownByXpath (String xpath, String text) {
		Select dropdown = new Select(driver.findElement(By.xpath(xpath)));
		dropdown.selectByVisibleText(text);
	}

	public void waitElementVisible (String xpath) {
		WebElement element = driver.findElement(By.xpath(xpath));
		WebDriverWait wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
		element.isDisplayed();
	}

}
