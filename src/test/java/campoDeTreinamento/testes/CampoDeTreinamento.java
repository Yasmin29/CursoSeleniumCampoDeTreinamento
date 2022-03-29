package campoDeTreinamento.testes;

import campoDeTreinamento.core.BaseTeste;
import campoDeTreinamento.core.DSL;
import campoDeTreinamento.page.CampoDeTreinamentoPage;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

import static campoDeTreinamento.core.DriverFactory.getDriver;

public class CampoDeTreinamento extends BaseTeste {

    public String link = "file:///C:/Users/Yasmin/OneDrive/Documentos/campo_treinamento/componentes.html";
    DSL dsl;
    CampoDeTreinamentoPage page;
    @Before
    public void inicia() {

        getDriver().get(link);
        dsl = new DSL();
        page = new CampoDeTreinamentoPage();
    }

    @Test
    public void inserirNome(){
        page.setNome("Yasmin");
        Assert.assertEquals("Yasmin",page.getNome());
    }

    @Test
    public void inserirSugestoes(){
        page.setCampoSugestoes("Bom dia\n Boa Tarde\n Boa noite");
        Assert.assertEquals("Bom dia\n Boa Tarde\n Boa noite", page.getCampoSugestoes());
    }

    @Test
    public void quandoMarcoAOpcaoPizzaEntaoDevePermanecerMarcado(){
        page.setComidaFavoritaPizza();
        Assert.assertTrue(page.getComidaFavoritaPizza());
    }

    @Test
    public void quandoMarcoAOpcaoFemininoEntaoDevepermanecerMarcado(){
        page.setSexoFeminino();
        Assert.assertTrue(page.getSexoFeminino());
    }

    @Test
    public void quandoClicoEmUmaOpcaoDoSelectEntaoAOpcaoDeveAparecerNaCaixa(){
        page.setEscolaridade("2o grau completo");
        Assert.assertEquals("2o grau completo", page.setEscolaridade());

    }
    @Test
    public void quandoInterajoComUmBotaoEntaoEleDeveRetornarUmValorObrigada() {
        page.setBotaoCliqueMe();
        Assert.assertEquals("Obrigado!", page.getBotaoCliqueMe());
    }

    @Test
    public void quandoInterajoComUmLinkVoltarDeveAparecerUmTexto(){
        page.setClicarEmLinkVoltar();
        page.getTextoDoLinkVoltar();
        /*driver.findElement(By.linkText("voltar")).click();
        Assert.assertEquals("Voltou!", driver.findElement(By.xpath("//div[@id=\"resultado\"]")).getText());*/
    }

    @Test
    public void quandoConfirmoOAlertaEntaoDeveRetornarTextoConfirmado(){
        getDriver().findElement(By.xpath("//input[@id=\"confirm\"]")).click();
        dsl.aceitarAlerta();
        Assert.assertEquals("Confirmado", dsl.vereficaTextoDoAlerta());
    }

    @Test
    public void quandoCanceloOConfirmSimplesEntaoDeveRetornarTextoNegado(){
        getDriver().findElement(By.xpath("//input[@id=\"confirm\"]")).click();
        Alert alert = getDriver().switchTo().alert();
        alert.dismiss();
        Assert.assertEquals("Negado", alert.getText());
    }

    @Test
    public void quandoConfirmoOValorDoAlertDePromptEntaoDeveRetornarMensagens(){
        getDriver().findElement(By.xpath("//input[@id=\"prompt\"]")).click();
        dsl.trocarParaAlert();
        dsl.escreveNoAlerta("9");
        dsl.aceitarAlerta();
        //Assert.assertEquals("Era 9?", alert.getText());
        dsl.aceitarAlerta();
        //Assert.assertEquals(":D", alert.getText());
    }

    @Test
    public void quandoFacoUmCadastroEntaoDeveRetornarAsInformacoesCadastradas() {
        page.setNome("Yasmin");
        page.setSobrenome("Lippert");
        page.setSexoFeminino();
        page.setComidaFavoritaVegetariano();
        page.setEscolaridade("Doutorado");
        page.setEsportes("Karate");
        page.setEsportes("Corrida");
        page.setCampoSugestoes("Eu nao sou boa em esportes");
        page.setBotaoCadastrar();

        WebElement element = getDriver().findElement(By.xpath("//div[@id=\"resultado\"]"));

        Assert.assertEquals("Cadastrado", element.getText());
        Assert.assertEquals("Nome:Yasmin", element.getText());
    }
    @Test
    public void quandoFacoUmaMultiplaEscolhaNoSelectDeEsportesEntaoAmbasDevemSeManterMarcadas(){
        WebElement element1 = getDriver().findElement(By.xpath("//select[@id=\"elementosForm:esportes\"]"));
        Select combo1 = new Select(element1);
        combo1.selectByVisibleText("Karate");
        combo1.selectByVisibleText("Corrida");
        List<WebElement> elementosSelecionados = combo1.getAllSelectedOptions();

        Assert.assertEquals(2, elementosSelecionados.size());
    }

    @Test
    public void dadoQueInterajoComOBotaoFrameEntaoApareceAlertComMensagem(){
        //trocar para o ifreme, e depois troco para o Alert para pegar o texto.
        getDriver().switchTo().frame("frame1");
        getDriver().findElement(By.xpath("//input[@id=\"frameButton\"]")).click();
        Alert alert = getDriver().switchTo().alert();
        Assert.assertEquals("Frame OK!", alert.getText());
        alert.accept();
        //voltar para a pagina padrao
        getDriver().switchTo().defaultContent();
        Assert.assertEquals("Campo de Treinamento", getDriver().findElement(By.xpath("//h3[\"Campo de Treinamento\"]")).getText());
    }

    @Test
    public void usandoScrollComJs(){
        WebElement element = getDriver().findElement(By.xpath("//iframe[@id=\"frame2\"]"));
        dsl.comandoJS("window.scrollBy(0,arguments)", element.getLocation().y);
        getDriver().switchTo().frame(element);
        dsl.clicar("//input[@id=\"frameButton\"]");
        Assert.assertEquals("Frame OK!", dsl.vereficaTextoDoAlerta());
    }

    @Test
    public void deveClicarNoBotaoDaTabelo(){
        dsl.clicarBotaoTabela("Nome", "Francisco","Botao","elementosForm:tableUsuarios");
    }

}
