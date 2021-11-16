package br.com.alura.leilao.login;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import br.com.alura.leilao.PageObject;
import br.com.alura.leilao.leiloes.LeiloesPage;

public class LoginPage extends PageObject {

	private static final String URL_LOGIN = "http://localhost:8080/login";
	
	
	public LoginPage() {
		super(null);
		browser.get(URL_LOGIN);
	}
	
	public void preencheFormularioDeLogin(String username, String password) {
	    browser.findElement(By.id("username")).sendKeys(username);
	    browser.findElement(By.id("password")).sendKeys(password);
	}

	public LeiloesPage efetuaLogin() {
		this.browser.findElement(By.id("login-form")).submit();
		return new LeiloesPage(browser);
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
