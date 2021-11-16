package br.com.alura.leilao.leiloes;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import br.com.alura.leilao.PageObject;
import br.com.alura.leilao.login.LoginPage;

public class LeiloesPage extends PageObject{

	private static final String URL_CADASTRO_LEILAO = "http://localhost:8080/leiloes/new";
	private static final String URL_LEILOES = "http://localhost:8080/leiloes";
	
	
	
	public LeiloesPage(WebDriver browser) {
		super(browser);
	}
	

	public CadastroLeilaoPage carregarFormulario() {
		this.browser.get(URL_CADASTRO_LEILAO);
		return new CadastroLeilaoPage(browser);
		
	}

	public boolean isLeilaoCadastrado(String nome, String valor, String data) {
	    WebElement linhaDaTabela = this.browser.findElement(By.cssSelector("#tabela-leiloes tbody tr:last-child"));
	    WebElement colunaNome = linhaDaTabela.findElement(By.cssSelector("td:nth-child(1)"));
	    WebElement colunaDataAbertura = linhaDaTabela.findElement(By.cssSelector("td:nth-child(2)"));
	    WebElement colunaValorInicial = linhaDaTabela.findElement(By.cssSelector("td:nth-child(3)"));

	    return colunaNome.getText().equals(nome)
	            && colunaDataAbertura.getText().equals(data) 
	            && colunaValorInicial.getText().equals(valor);
	}

	public boolean isPaginaAtual() {

		return this.browser.getCurrentUrl().equals(URL_LEILOES);
	}


}
