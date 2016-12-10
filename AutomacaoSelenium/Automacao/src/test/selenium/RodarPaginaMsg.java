package test.selenium;



import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.WebElement;


public class RodarPaginaMsg {

	private WebDriver driver;
	
	@Before
	public void setUp(){
		driver = new FirefoxDriver();
		//driver.get("http://www.taketest.com.br");
		driver.get("file:///C:/Estudo/Java/Selenium/AutomacaoSelenium/Automacao/formulario/index.html");
		driver.manage().window().maximize();
	}
	
	
	@Test
	public void executaMensagem() throws InterruptedException {
		
		WebElement Radio = driver.findElement(By.id("mensagem"));
		Radio.click();

		WebElement Enviar = driver.findElement(By.id("enviar"));
		Enviar.submit();

		Thread.sleep(5000);
		driver.switchTo().alert().accept();
		
	}
	
	@After
	public void fechaPagina(){
		driver.quit();
	}

}
