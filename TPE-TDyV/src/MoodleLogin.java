import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MoodleLogin {
	private final WebDriver driver;
	
	public MoodleLogin(WebDriver driver) {
		this.driver = driver;
	}
	
	public void login(String username, String password) {
		WebDriverWait wait = new WebDriverWait(driver, 4000);
		WebElement userButton = (WebElement) wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("username")));
		userButton.sendKeys(username);
		WebElement passwordButton = (WebElement) wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("password")));
		passwordButton.sendKeys(password);
		WebElement IngresarButton = (WebElement) wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"boxForm\"]/div/form[1]/div[3]/button")));
		IngresarButton.click();
	}
}
