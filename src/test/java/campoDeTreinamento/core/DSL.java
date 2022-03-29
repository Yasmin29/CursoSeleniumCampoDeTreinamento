package campoDeTreinamento.core;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

import static campoDeTreinamento.core.DriverFactory.getDriver;

public class DSL {

    public void procurarElemento(String xpath){
        getDriver().findElement(By.xpath(xpath));
    }

    public void escreve(String xpath, String texto) {
        getDriver().findElement(By.xpath(xpath)).sendKeys(texto);
    }

    public void clicar(String xpath){
        getDriver().findElement(By.xpath(xpath)).click();
    }

    public void clicarEmLink(String elemento) {
        getDriver().findElement(By.linkText(elemento)).click();
    }

    public void trocarParaAlert(){
        getDriver().switchTo().alert();
    }

    public void aceitarAlerta(){
        getDriver().switchTo().alert().accept();
    }

    public void recusarAlerta(){
        getDriver().switchTo().alert().dismiss();
    }

    public String vereficaTextoDoAlerta(){
        Alert alert = getDriver().switchTo().alert();
        return alert.getText();
    }

    public void escreveNoAlerta(String texto){
        getDriver().switchTo().alert().sendKeys(texto);
    }

    public void selecionarCombo(String xpath, String texto){
        WebElement element = getDriver().findElement(By.xpath(xpath));
        Select combo = new Select(element);
        combo.selectByVisibleText(texto);
    }

    public String vereficarSeComboFoiSelecionado(String xpath){
        WebElement element = getDriver().findElement(By.xpath(xpath));
        Select combo = new Select(element);
        return combo.getFirstSelectedOption().getText();
    }

    public String vereficarAtributo(String xpath, String atributo){
        return getDriver().findElement(By.xpath(xpath)).getAttribute(atributo);
    }

    public String vereficarTexto(String xpath){
        return getDriver().findElement(By.xpath(xpath)).getText();
    }

    public boolean vereficarSeFoiSelecionado(String xpath){
        return getDriver().findElement(By.xpath(xpath)).isSelected();
    }

    //************ JS *****************
    public Object comandoJS(String comando, Object... elemento){
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        return js.executeScript(comando,elemento);
    }

    //*********Tabela**********
    public void clicarBotaoTabela(String colunaBusca, String valor, String colunaBotao, String idTabela) {
        WebElement tabela = getDriver().findElement(By.xpath("//table[@id=\"elementosForm:tableUsuarios\"]"));
        int idColuna = obterIndiceDaColuna(colunaBusca, tabela);
        int idLinha = obterIndiceLinha(valor, tabela, idColuna);
        int idColunaBotao = obterIndiceDaColuna(colunaBotao, tabela);

        WebElement celula = tabela.findElement(By.xpath(".//tr["+idLinha+"]/td["+idColunaBotao+"]"));
        celula.findElement(By.xpath(".//input")).click();
    }

        protected int obterIndiceLinha(String valor, WebElement tabela, int idColuna){
        List<WebElement> linhas = tabela.findElements(By.xpath("/tbody/tr/td["+idColuna+"]"));
        int idLinha = -1;
        for(int i = 0; i<linhas.size(); i++ ){
            if(linhas.get(i).getText().equals(valor)){
                idLinha = i + 1;
                break;
            }
        }
        return idLinha;

    }
    protected int obterIndiceDaColuna(String coluna, WebElement tabela){
        List<WebElement> colunas = tabela.findElements(By.xpath(".//th"));
        int idColuna = -1;
        for(int i = 0; i<colunas.size(); i++ ){
            if(colunas.get(i).getText().equals(coluna)){
                idColuna = i + 1;
                break;
            }
        }
        return idColuna;
    }
}
