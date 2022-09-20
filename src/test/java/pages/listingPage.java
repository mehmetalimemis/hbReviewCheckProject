package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.basePage;

public class listingPage extends basePage {

	private final By productList = By.cssSelector("h3[data-test-id='product-card-name']");

	public listingPage(WebDriver driver, WebDriverWait wait) {
		super(driver, wait);
	}

	public void selectRandomProduct() {
		List<WebElement> elementList = getElementList(productList);
		int randomNumber = getRandomNumber(elementList.size());
		WebElement selectedProduct = elementList.get(randomNumber);
		storeData("productList_selectedProductName", selectedProduct.getText());
		selectedProduct.click();
	}

}
