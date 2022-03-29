package campoDeTreinamento.testes;/*
package campoDeTreinamento;

import campoDeTreinamento.page.CampoDeTreinamentoPage;
import campoDeTreinamento.core.DSL;
import com.beust.jcommander.Parameter;
import com.beust.jcommander.Parameters;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class TesteRegasDeCadastro {
    public String link = "file:///C:/Users/Yasmin/OneDrive/Documentos/campo_treinamento/componentes.html";
    WebDriver driver;
    DSL dsl;
    CampoDeTreinamentoPage page;

    @Parameter
    String nome;
    @Parameter
    String sobrenome;
    @Parameter
    String sexo;
    @Parameter
    List<String> comida;
    @Parameter
    String[] esportes;
    @Parameter
    String mensagem;

    @Before
    public void iniciliza() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        dsl = new DSL(driver);
        driver.get(link);
        page = new CampoDeTreinamentoPage(driver);
    }

    @After
    public void encerra(){
        driver.quit();
    }

    @Parameters
    public static Collection<Object[]> getColecao(){
        return Arrays.asList(new Object[][] {
                {},
                {},
        });
    }

    @Test
    public void deveValidarRegas(){
            page.setNome(nome);
            page.setSobrenome(sobrenome);
            if(sexo.equals("Feminino")) page.setSexoFeminino();
            if (sexo.equals("Masculino")) page.setSexoMasculino();
            if(comida.contains("Carne")) page.setComidaFavoritaCarne();
            if (comida.contains("Pizza")) page.setComidaFavoritaPizza();
            if (comida.contains("Vegetariano"))page.setComidaFavoritaVegetariano();
            if (comida.contains("Frango"))page.setComidaFavoritaFrango();
            page.setEsportes(esportes);
            page.setBotaoCadastrar();
            Assert.assertEquals(mensagem, dsl.vereficaTextoDoAlerta());
        }
}
*/
