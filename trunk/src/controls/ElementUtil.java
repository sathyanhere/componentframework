package controls;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import pages.WebPage;

public class ElementUtil {
	
	static WebElement findElementByXpath(String elementXpath){
		return WebPage.driver.findElement(By.xpath(elementXpath));
	}
	
	static WebElement findElementByID(String elementID){
		String []eleID= elementID.split("=");
		return WebPage.driver.findElement(By.id(eleID[1]));
		
	}
	
	static WebElement findElementByName(String elementName){
		String []elementID= elementName.split("=");
		return WebPage.driver.findElement(By.name(elementID[1]));
	}
	
	static WebElement findElementByCss(String elementCss){
		String []elementID= elementCss.split("=");
		return WebPage.driver.findElement(By.cssSelector(elementID[1]));
	}
	
	static WebElement findElementByLinkText(String elementLinkText){
		String []elementID= elementLinkText.split("=");
		return WebPage.driver.findElement(By.linkText(elementID[1]));
	}
	
	
	// new Select(driver.findElement(By.xpath("//select[@name='contactType']"))).selectByVisibleText("Unclassified");
	
	
	static Select findSelectByXpath(String elementXpath){
		return new Select(WebPage.driver.findElement(By.xpath(elementXpath)));
	}
	
	static Select findSelectByID(String elementID){
		String []eleID= elementID.split("=");
		return new Select(WebPage.driver.findElement(By.id(eleID[1])));
		
	}
	
	static Select findSelectByName(String elementName){
		String []elementID= elementName.split("=");
		return new Select(WebPage.driver.findElement(By.name(elementID[1])));
	}
	
	static Select findSelectByCss(String elementCss){
		String []elementID= elementCss.split("=");
		return new Select(WebPage.driver.findElement(By.cssSelector(elementID[1])));
	}
	
}
