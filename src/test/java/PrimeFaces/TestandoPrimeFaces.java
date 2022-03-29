package PrimeFaces;

import campoDeTreinamento.core.DSL;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestandoPrimeFaces {
    WebDriver driver;
    public String link = "primefaces.org/showcase/ui/input/oneMenu.xhtml?jfwid=745ea";
    DSL dsl;

    @Before
    public void inicia() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get(link);
        dsl = new DSL();
    }

    @After
    public void fechar(){
        driver.quit();
    }

    @Test
    public void quandoInterajoComOSelectBasicEntaoDeveAparecerAOpcaoEscolhida(){
        
    }
}
