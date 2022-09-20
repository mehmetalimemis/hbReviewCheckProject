package test;

import org.junit.Test;

import base.baseTest;
import pages.homePage;
import pages.listingPage;
import pages.loginPage;
import pages.productDetailPage;

public class reviewControl extends baseTest {

	@Test

	public void reviewTabContentControl() {

		homePage homePage = new homePage(driver, wait);
		loginPage loginPage = new loginPage(driver, wait);
		listingPage productListPage = new listingPage(driver, wait);
		productDetailPage productDetailPage = new productDetailPage(driver, wait);
		homePage.isHomePageOpen();
		homePage.gotoLoginPage();
		loginPage.isLoginPageOpen();
		loginPage.login("mehmetalimn11@gmail.com", "Abcd12345!");
		homePage.isUserLogin();
		homePage.search("iphone");
		productListPage.selectRandomProduct();
		productDetailPage.isProductDetailPageOpen();
		productDetailPage.isReviewTabOpen();
		productDetailPage.reviewSelectionControl();

	}

}