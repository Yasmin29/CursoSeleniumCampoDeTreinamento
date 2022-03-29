package campoDeTreinamento.page;

import campoDeTreinamento.core.BasePage;

public class CampoDeTreinamentoPage extends BasePage {

    public void setNome(String texto) {
        dsl.escreve("//input[@id=\"elementosForm:nome\"]", texto);
    }

    public String getNome(){
        return dsl.vereficarAtributo("//input[@id=\"elementosForm:nome\"]", "value");
    }

    public void setSobrenome(String texto){
        dsl.escreve("//input[@id=\"elementosForm:sobrenome\"]", texto);
    }

    public void getSobrenome(String texto){
        dsl.vereficarTexto("//input[@id=\"elementosForm:sobrenome\"]");
    }

    public void setCampoSugestoes(String texto){
        dsl.escreve("//textarea[@id=\"elementosForm:sugestoes\"]", texto);
    }

    public String getCampoSugestoes(){
        return dsl.vereficarAtributo("//textarea[@id=\"elementosForm:sugestoes\"]","value");
    }

    public void setComidaFavoritaPizza(){
        dsl.clicar("//input[@name=\"elementosForm:comidaFavorita\" and @value=\"pizza\"]");
    }

    public boolean getComidaFavoritaPizza(){
        return dsl.vereficarSeFoiSelecionado("//input[@name=\"elementosForm:comidaFavorita\" and @value=\"pizza\"]");
    }

    public void setComidaFavoritaCarne(){
        dsl.clicar(("//input[@id=\"elementosForm:comidaFavorita:0\"]"));
    }

    public boolean getComidaFavoritaCarne() {
      return dsl.vereficarSeFoiSelecionado("//input[@id=\"elementosForm:comidaFavorita:0\"]");
    }

    public void setComidaFavoritaFrango(){
        dsl.clicar("//input[@id=\"elementosForm:comidaFavorita:1\"]");
    }

    public boolean getComidaFavoritaFrango(){
        return dsl.vereficarSeFoiSelecionado("//input[@id=\"elementosForm:comidaFavorita:1\"]");
    }

    public void setComidaFavoritaVegetariano(){
        dsl.clicar("//input[@id=\"elementosForm:comidaFavorita:3\"]");
    }

    public boolean getComidaFavoritaVegetariano(){
       return dsl.vereficarSeFoiSelecionado("//input[@id=\"elementosForm:comidaFavorita:3\"]");
    }

    public void setSexoFeminino(){
        dsl.clicar("//input[@name=\"elementosForm:sexo\" and @value=\"F\"]");
    }

    public boolean getSexoFeminino(){
       return dsl.vereficarSeFoiSelecionado("//input[@name=\"elementosForm:sexo\" and @value=\"F\"]");
    }

    public void setSexoMasculino(){
        dsl.clicar("//input[@id=\"elementosForm:sexo:0\"]");
    }

    public boolean getSexoMasculino(){
        return dsl.vereficarSeFoiSelecionado("//input[@id=\"elementosForm:sexo:0\"]");
    }

    public void setEscolaridade(String texto){
        dsl.selecionarCombo("//select[@id=\"elementosForm:escolaridade\"]", texto);
    }

    public String setEscolaridade(){
        return dsl.vereficarSeComboFoiSelecionado("//select[@id=\"elementosForm:escolaridade\"]");
    }

    public void setBotaoCliqueMe(){
        dsl.clicar("//input[@id=\"buttonSimple\"]");
    }

    public String getBotaoCliqueMe(){
        return dsl.vereficarAtributo("//input[@id=\"buttonSimple\"]","value");
    }

    public void setClicarEmLinkVoltar(){
        dsl.clicarEmLink("voltar");
    }

    public String getTextoDoLinkVoltar(){
        return dsl.vereficarTexto("//div[@id=\"resultado\"]");
    }

    public void setEsportes(String texto){
        //for(String valor:texto)
            dsl.selecionarCombo("//select[@id=\"elementosForm:esportes\"]", texto);
    }

    /*public String getEsportes(){
        return ;
    }*/

    public void setBotaoCadastrar(){
        dsl.clicar("//input[@id=\"elementosForm:cadastrar\"]");
    }
}

