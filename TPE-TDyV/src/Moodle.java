import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import org.openqa.selenium.WebElement;

public class Moodle {
	private WebDriver driver;
	private static String title = "Moodle - Facultad de Ciencias Exactas";
	private static String user = "Federico Crespi";

	@BeforeClass
	public void launchBrowser() {
		System.setProperty("webdriver.gecko.driver", "chromedriver.exe");
		this.driver = new ChromeDriver();
	}

	@Test (priority=1)
	public void loadPage() {
		driver.manage().window().maximize();
		driver.navigate().to("https://moodle.exa.unicen.edu.ar/");
		System.out.println(driver.getTitle());
		Assert.assertEquals(driver.getTitle(), title);
	}

	@Test (priority=2)
	public void login() {
		MoodleLogin logInMoodle = PageFactory.initElements(driver, MoodleLogin.class);
		logInMoodle.login("35334185", "Fede1810");
		WebDriverWait wait = new WebDriverWait(driver, 4000);
		WebElement userButton = (WebElement) wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("action-menu-toggle-1")));
		userButton.click();
		wait = new WebDriverWait(driver, 4000);
		WebElement userName = (WebElement) wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("actionmenuaction-1")));
		System.out.println(userName.getText());
		Assert.assertTrue(userName.getText().equals(user));
	}

	/*
	@Test (priority=3)
	public void searchProduct() {
		MercadoLibreBuscarProducto mercadolibrebuscar = PageFactory.initElements(driver, MercadoLibreBuscarProducto.class);
		mercadolibrebuscar.search("GPU");
		String textoAbuscar="Placa de video Nvidia MSI Ventus GeForce RTX 30 Series RTX 3080 Ti GEFORCE RTX 3080 Ti VENTUS 3X 12G OC OC Edition 12GB";
		mercadolibrebuscar.sacarCookies();
		mercadolibrebuscar.scrollear(textoAbuscar);
	}
	*/
	
	@Test (priority=4)
	public void finishTest() {
		if(driver!=null) {
			driver.close();
			driver = null;
		}
		System.out.println("Termino satisfactoriamente");
		Assert.assertNull(driver);
	}
	
}