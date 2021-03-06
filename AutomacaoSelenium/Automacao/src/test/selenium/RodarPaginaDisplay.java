package test.selenium;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.WebElement;

public class RodarPaginaDisplay {
	
	private WebDriver driver;

	@Before
	public void setUp(){
		
		driver = new FirefoxDriver();
		//driver.get("http://www.taketest.com.br");
		driver.get("file:///C:/Estudo/Java/Selenium/AutomacaoSelenium/Automacao/formulario/index.html");
		driver.manage().window().maximize();
		
	}
	
	@Test
	public void executaDisplay() {
		
		WebElement Radio = driver.findElement(By.id("labelStatus"));
		Radio.click();

		WebElement Enviar = driver.findElement(By.id("enviar"));
		Enviar.submit();
		
		WebElement StatusNome = driver.findElement(By.id("statusNome"));
		assertTrue(StatusNome.isDisplayed()); // verifica se � exibido na pagina
		
		WebElement StatusCpf = driver.findElement(By.id("statusCpf"));
		assertTrue(StatusCpf.isDisplayed());
		
		WebElement StatusTelefone = driver.findElement(By.id("statusTelefone"));
		assertTrue(StatusTelefone.isDisplayed());
		
		WebElement StatusCelular = driver.findElement(By.id("statusCelular"));
		assertTrue(StatusCelular.isDisplayed());
		
		WebElement StatusEmail = driver.findElement(By.id("statusEmail"));
		assertTrue(StatusEmail.getText().contains("E-mail deve ser preenchido.")); // verifica se cont�m o texto
		
	}
	
	@After
	public void fechaPagina(){
		
		driver.quit();
		
	}

}
