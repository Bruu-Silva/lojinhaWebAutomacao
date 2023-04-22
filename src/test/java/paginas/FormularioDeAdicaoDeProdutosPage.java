package paginas;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FormularioDeAdicaoDeProdutosPage {
    private WebDriver navegador;

    public FormularioDeAdicaoDeProdutosPage (WebDriver navegador){
        this.navegador = navegador;
    }
    public FormularioDeAdicaoDeProdutosPage adicionarNomeProduto(String nomeProduto){
        navegador.findElement(By.id("produtonome")).sendKeys(nomeProduto);
        return this;

    }
    public FormularioDeAdicaoDeProdutosPage adicionarValorProduto(String valorProduto){
        navegador.findElement(By.name("produtovalor")).sendKeys(valorProduto);
        return this;
    }
    public FormularioDeAdicaoDeProdutosPage adicionarCoresProduto(String coresProduto){
        navegador.findElement(By.id("produtocores")).sendKeys(coresProduto);
        return this;
    }
    public ListaDeProdutosPage submeterFormularioComAdicaoDeErro(){
        navegador.findElement(By.cssSelector("button[type='submit']")).click();
        return new ListaDeProdutosPage(navegador);
    }
    public FormularioDeEdicaoDeProdutoPage submeterFormularioDeAdicaoComSucesso(){
        navegador.findElement(By.cssSelector("button[type='submit']")).click();
        return new FormularioDeEdicaoDeProdutoPage(navegador);
    }


}
