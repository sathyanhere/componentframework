package controls;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import utils.Events;

public class ElementUtil {

	WebDriver driver;
	Events events;
	public ElementUtil(WebDriver webDriver) {
		driver = webDriver;
		events=new Events(driver);
	}

	public WebElement findElement(By by) {
		return driver.findElement(by);
	}

	public Select findSelect(By by) {
		return new Select(driver.findElement(by));
	}
	
	public WebElement findElementByLinkText(String elementLinkText) {
		String[] elementID = elementLinkText.split("=");
		return driver.findElement(By.linkText(elementID[1]));
	}

	public By byXpath(String elementXpath) {
		return By.xpath(elementXpath);
	}

	public By byID(String elementID) {
		String[] eleID = elementID.split("=");
		return By.id(eleID[1]);

	}

	public By byName(String elementName) {
		String[] elementID = elementName.split("=");
		return By.name(elementID[1]);
	}

	public By byCss(String elementCss) {
		String[] elementID = elementCss.split("=");
		return By.cssSelector(elementID[1]);
	}

	public By byLinkText(String elementLinkText) {
		String[] elementID = elementLinkText.split("=");
		return By.linkText(elementID[1]);
	}

	public By selectByXpath(String elementXpath) {
		return By.xpath(elementXpath);
	}

	public By selectByID(String elementID) {
		String[] eleID = elementID.split("=");
		return By.id(eleID[1]);

	}

	public By selectByName(String elementName) {
		String[] elementID = elementName.split("=");
		return By.name(elementID[1]);
	}

	public By selectByCss(String elementCss) {
		String[] elementID = elementCss.split("=");
		return By.cssSelector(elementID[1]);
	}
	
	public void click(WebElement webElement) throws IOException{
		 events.click(webElement);
	 }
	
	 public void type(WebElement webElement, String text) throws IOException {
		 events.type(webElement, text);
	 }
	 
	 public void select(Select selectField,
				int index) throws IOException {
		 events.select(selectField, index);
	 }
	 
	 public void selectByValue(Select selectField, String value) throws IOException {
		 events.selectByValue(selectField, value);
	 }
	 
	 public void selectByText(Select selectField,
				String selectString) throws IOException {
		 events.selectByText(selectField, selectString);
	 }
	 
	 public void check(WebElement webElement)
		throws IOException {
		 events.check(webElement);
	 }
	 public void unCheck(WebElement webElement)
		throws IOException {
		 events.unCheck(webElement);
	 }
	 
	 public void choose(WebElement webElement)
		throws IOException {
		 events.choose(webElement);
	 }
}
