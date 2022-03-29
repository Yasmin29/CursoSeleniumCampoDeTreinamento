package campoDeTreinamento.testes;

import campoDeTreinamento.core.DSL;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class TestesDeRegraDeNegocio {

    public String link = "file:///C:/Users/Yasmin/OneDrive/Documentos/campo_treinamento/componentes.html";
    WebDriver driver;
    DSL dsl;

    @Before
    public void iniciliza() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        dsl = new DSL();
        driver.get(link);
    }

    @After
    public void encerra(){
        driver.quit();
    }

    @Test
    public void dadoQueCampoNomeEhObrigatorioEntaoQuandoNaoPreenchidoDeveRetornarMensagem(){
        driver.findElement(By.xpath("//input[@id=\"elementosForm:cadastrar\"]")).click();
        Alert alert = driver.switchTo().alert();
        Assert.assertEquals("Nome eh obrigatorio", alert.getText());
    }

    @Test
    public void quandoCadastroSemPreencherOCampoSobrenomeEntaoRetornaUmaMensagemAmigavel(){
        driver.findElement(By.xpath("//input[@id=\"elementosForm:nome\"]")).sendKeys("Yasmin");
        driver.findElement(By.xpath("//input[@id=\"elementosForm:cadastrar\"]")).click();
        Alert alert = driver.switchTo().alert();
        Assert.assertEquals("Sobrenome eh obrigatorio", alert.getText());
    }

    @Test
    public void quandoCadastroSelecionandoOqueEhEsporteEOutraOpcaoEntaoRetornaUmaMensagemAmigavel(){
        driver.findElement(By.xpath("//input[@id=\"elementosForm:nome\"]")).sendKeys("Yasmin");
        driver.findElement(By.xpath("//input[@id=\"elementosForm:sobrenome\"]")).sendKeys("Silva");
        driver.findElement(By.xpath("//input[@id=\"elementosForm:sexo:1\"]")).click();
        WebElement element = driver.findElement(By.xpath("//select[@id=\"elementosForm:esportes\"]"));
        Select select = new Select(element);
        select.selectByVisibleText("O que eh esporte?");
        select.selectByVisibleText("Karate");
        driver.findElement(By.xpath("//input[@id=\"elementosForm:cadastrar\"]")).click();
        Alert alert = driver.switchTo().alert();
        Assert.assertEquals("Voce faz esporte ou nao?", alert.getText());
    }
}
