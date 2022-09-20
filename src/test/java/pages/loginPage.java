package pages;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.basePage;

public class loginPage extends basePage {

	private Logger logger = Logger.getLogger(loginPage.class);

	private final By emailTextBox = By.id("txtUserName");
	private final By passwordTextBox = By.id("txtPassword");
	private final By loginButton = By.id("btnLogin");
	private final By passwordLoginButton = By.id("btnEmailSelect");

	public loginPage(WebDriver driver, WebDriverWait wait) {
		super(driver, wait);
	}

	public void isLoginPageOpen() {
		boolean isLoginPageOpen = getPageTitle().equals("Üye Giriş Sayfası & Üye Ol - Hepsiburada")
				&& isDisplayed(emailTextBox);
		Assert.assertTrue(isLoginPageOpen);
		logger.info("Login sayfası başarılı şekilde açılmıştır.");
	}

	public void login(String email, String password) {
		write(emailTextBox, email);
		click(loginButton);
		write(passwordTextBox, password);
		click(passwordLoginButton);
	}

}