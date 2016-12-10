package test.selenium;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.WebElement;


public class RodarPagina {

	
	private WebDriver driver;
	
	@Before
	public void setUp(){
		driver = new FirefoxDriver();
		//driver.get("http://www.taketest.com.br");
		driver.get("file:///C:/Estudo/Java/Selenium/AutomacaoSelenium/Automacao/formulario/index.html");
		driver.manage().window().maximize();
	}
	
	
	@Test
	public void preencheFormulario(){
		
		WebElement Nome = driver.findElement(By.id("nome"));
		Nome.sendKeys("Marcos Willian de Souza");
		
		WebElement Cpf = driver.findElement(By.id("cpf"));
		Cpf.sendKeys("10108147886");
		
		WebElement Telefone = driver.findElement(By.id("telefone"));
		Telefone.sendKeys("1138389090");
		
		WebElement Celular = driver.findElement(By.id("celular"));
		Celular.sendKeys("11989891010");
		
		WebElement Email = driver.findElement(By.id("email"));
		Email.sendKeys("marcosws@ymail.com");
		
		WebElement Radio = driver.findElement(By.id("labelStatus"));
		Radio.click();
		
		WebElement Enviar = driver.findElement(By.id("enviar"));
		Enviar.submit();

	}
	
	@After
	public void fechaPagina(){
		driver.quit();
	}
	

}
