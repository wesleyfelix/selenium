package br.com.alura.leilao.login;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginPage {

	private static final String URL_LOGIN = "http://localhost:8080/login";
	private WebDriver browser;
	
	public LoginPage() {
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		this.browser = new ChromeDriver();
		browser.get(URL_LOGIN);
	}
	
	public void fechar() {
		this.browser.quit();
	}

	public void preencheFormularioDeLogin(String username, String password) {
	    browser.findElement(By.id("username")).sendKeys(username);
	    browser.findElement(By.id("password")).sendKeys(password);
	}

	public void efetuaLogin() {
		this.browser.findElement(By.id("login-form")).submit();
	}

	public boolean isPaginaDeLogin() {
		return this.browser.getCurrentUrl().equals(URL_LOGIN);
	}

	public String getNomeUsuarioLogado() {
	    try {
	        return browser.findElement(By.id("usuario-logado")).getText();
	    } catch (NoSuchElementException e) {
	        return null;
	    }
	}

	public void navegaParaPaginaDeLances() {
		browser.get("http://localhost:8080/leiloes/2");
		
	}

	public boolean contemTexto(String texto) {
		// TODO Auto-generated method stub
		return this.browser.getPageSource().contains(texto);
	}

	public boolean isPaginaDeLoginComDadosInvalidos() {
		// TODO Auto-generated method stub
		return this.browser.getCurrentUrl().equals(URL_LOGIN+"?error");
	}
	

}
