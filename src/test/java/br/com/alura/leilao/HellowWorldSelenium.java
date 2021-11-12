package br.com.alura.leilao;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HellowWorldSelenium {

	@Test
	public void hello () {
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		WebDriver browser = new ChromeDriver();
		browser.get("http://localhost:8080/leiloes");
		
		browser.quit();
	}
}
