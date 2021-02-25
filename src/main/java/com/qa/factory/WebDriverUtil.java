package com.qa.factory;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverUtil {
	/**
	 * wait for element status based on visibility
	 * 
	 * @param driver
	 */
	// WebDriver driver;
	// WebDriverCommonLib wlib = new WebDriverCommonLib();

	public static void waitForElementStatus(WebElement element) {
		WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), 60);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	public static void waitForElementVisiblity(WebElement element) {
		WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), 60);
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	public static void waitForElementJavaScript(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) DriverFactory.getDriver();
		js.executeScript("arguments[0].click();", element);
	}

	public static void passTheValueUsingJavaScript(WebElement element,String value) {
		JavascriptExecutor jse = (JavascriptExecutor) DriverFactory.getDriver();
		jse.executeScript("arguments[0].value='" + value + "';", element);
	}

	/**
	 * wait for title based on availability
	 * 
	 *
	 */

	public static void waitForTitleContain(String title) {
		WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), 20);
		wait.until(ExpectedConditions.titleContains(title));
	}

	/**
	 * wait for element load
	 *
	 */
	public static void waitForElement() {
		DriverFactory.getDriver().manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}

	/**
	 * used to select content of the dropdown based on text
	 * 
	 * 
	 */
	public static void selectText(WebElement element, String text) {
		Select sel = new Select(element);
		sel.selectByVisibleText(text);
	}

	/**
	 * used to select content of the dropdown based on index
	 * 
	 * 
	 */
	public static void selectIndex(WebElement element, int index) {
		Select sel = new Select(element);
		sel.selectByIndex(index);
	}

	/**
	 * used to take mouse cursor on the element
	 * 
	 *
	 */
	public static void moveToElement(WebElement element) {
		Actions ac = new Actions(DriverFactory.getDriver());
		ac.moveToElement(element).perform();
	}

	/**
	 * use to rightclick by mouse
	 *
	 * 
	 */
	public static void rightClick(WebElement element) {
		Actions ac = new Actions(DriverFactory.getDriver());
		ac.contextClick(element).perform();
	}

	/**
	 * use to double click by mouse
	 *
	 *
	 */
	public static void doubleClick(WebElement element) {
		Actions ac = new Actions(DriverFactory.getDriver());
		ac.doubleClick(element).perform();
	}

	/**
	 * used to drag and drop element
	 * 
	 * 
	 * 
	 */
	public static void dragandDrops(WebElement src, WebElement desti) {
		Actions ac = new Actions(DriverFactory.getDriver());
		ac.dragAndDrop(src, desti).perform();
	}

	/**
	 * used to switch to any window based in page title
	 * 
	 * 
	 */
	public static void switchToNewTab(String pageTitle) {
		Set<String> setlist = DriverFactory.getDriver().getWindowHandles();
		Iterator<String> it = setlist.iterator();

		while (it.hasNext()) {
			DriverFactory.getDriver().switchTo().window(it.next());
			String actPageTitle = DriverFactory.getDriver().getTitle();

			if (actPageTitle.contains(pageTitle)) {
				break;
			}
		}
	}

	/**
	 * used to click on alert
	 *
	 */
	public static void acceptAlert() {
		DriverFactory.getDriver().switchTo().alert().accept();
	}

	/**
	 * used to click dismis on alert
	 *
	 */
	public static void cancelAlert() {
		DriverFactory.getDriver().switchTo().alert().dismiss();
	}

	/**
	 * used to get title of webpage
	 * 
	 *
	 */
	public static String getTitlePage() {
		String title = DriverFactory.getDriver().getTitle();
		return title;
	}

	public static void select1(WebElement element, String text) {
		Select sel = new Select(element);
		sel.selectByVisibleText(text);
	}

	public static void select(String value, WebElement element) {
		Select sel = new Select(element);
		sel.selectByValue(value);
	}

	public static void select1(WebElement element, int index) {
		Select sel = new Select(element);
		sel.selectByIndex(index);
	}

}
