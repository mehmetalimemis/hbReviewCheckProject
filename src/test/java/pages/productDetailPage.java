package pages;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.basePage;

public class productDetailPage extends basePage {
	private Logger logger = Logger.getLogger(productDetailPage.class);

	private final By productNameLabel = By.id("product-name");
	private final By productReviewsTab = By.id("productReviewsTab");
	private final By goodReview = By.cssSelector("thumbsUp.hermes-ReviewCard-module-lOsa4wAwncdp3GgzpaaV");
	private final By thanksMessageText = By.className("hermes-ReviewCard-module-eFtSSTU4lYZLCnzHtzca");
	private final By reviewTabTitleContent = By.xpath("//*[@id=\"productReviewsTab\"]/text()");

	public productDetailPage(WebDriver driver, WebDriverWait wait) {
		super(driver, wait);
	}

	public void isProductDetailPageOpen() {
		changeWindow(1);
		String productListPageProductName = getData("productList_selectedProductName");
		String productDetailPageProductName = getText(productNameLabel);
		storeData("productDetail_selectedProductName", productDetailPageProductName);
		Assert.assertTrue(productListPageProductName.equals(productDetailPageProductName));
		logger.info("Ürün detay sayfası başarılı şekilde açılmıştır.");
	}

	public void isReviewTabOpen() {
		click(productReviewsTab);
	}

	public void reviewSelectionControl() {
		String reviewTabTitle = getText(reviewTabTitleContent);
		String reviewTabTitleText = ("Değerlendirmeler (0)");
		Assert.assertTrue(reviewTabTitle.equals(reviewTabTitleText));
		logger.info("Ürün için değerlendirme yapılmamıştır.");

		click(goodReview);
		String thanksMessageContent = getText(thanksMessageText);
		String thanksMessage = ("Teşekkür Ederiz.");
		Assert.assertTrue(thanksMessageContent.equals(thanksMessage));
		logger.info("Yorum değerlendirmeniz başarılı bir şekilde yapılmıştır.");
	}
}
