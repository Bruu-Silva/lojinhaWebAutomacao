package modulos.produtos;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import paginas.LoginPage;
import java.time.Duration;


@DisplayName("Testes WEB do módulo de produtos")
public class ProdutosTest {
    private WebDriver navegador;

    @BeforeEach
    public void beforeEach() {
        // Abrir o browser
        System.setProperty("webdriver.chrome.driver", "C:\\Drivers\\chromedriver_win32\\chromedriver.exe");
        this.navegador = new ChromeDriver();

        // Vou maximizar a tela
        this.navegador.manage().window().maximize();

        //Vou definir um tempo de espera padrão de 5 segundos
        this.navegador.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        // Navegar para a página da Lojinha WEB
        this.navegador.get("http://165.227.93.41/lojinha-web/v2/");

    }

    @Test
    @DisplayName("Não é permitido registrar produto com valor igual a zero")
    public void testNaoEPermitidoRegistrarProdutoComValorIgualAZero(){

        String mensagemApresentada = new LoginPage(navegador)
                .informarASenha("admin")
                .informarOUsuario("admin")
                .submeterFormularioDeLogin()
                .adicionarProduto()
                .adicionarNomeProduto("LapTop da Xuxa")
                .adicionarValorProduto("000")
                .adicionarCoresProduto("Rosa, Azul")
                .submeterFormularioComAdicaoDeErro()
                .capturarMensagemApresentada();


        Assertions.assertEquals("O valor do produto deve estar entre R$ 0,01 e R$ 7.000,00",mensagemApresentada);

    }

    @Test
    @DisplayName("Validar mensagem de erro ao cadastrar produtos com valor acima de 7000.00")
    public void testProibidoValorAcimaDeSeteMil(){
        String mensagemApresentada = new LoginPage(navegador)
                .informarASenha("admin")
                .informarOUsuario("admin")
                .submeterFormularioDeLogin()
                .adicionarProduto()
                .adicionarNomeProduto("Ursinho de Pelúcia bilú")
                .adicionarValorProduto("700001")
                .adicionarCoresProduto("Azul, Amarelo")
                .submeterFormularioComAdicaoDeErro()
                .capturarMensagemApresentada();

        Assertions.assertEquals("O valor do produto deve estar entre R$ 0,01 e R$ 7.000,00",mensagemApresentada);

    }

    @Test
    @DisplayName("Validar o sucesso na inclusão de um novo produto com valor de 0,01 ")
    public void testInclusaoDeNovoProdutoComValorDeUmCentavo(){
        String mensagemApresentada = new LoginPage(navegador)
                .informarOUsuario("admin")
                .informarASenha("admin")
                .submeterFormularioDeLogin()
                .adicionarProduto()
                .adicionarNomeProduto("caneta")
                .adicionarValorProduto("001")
                .adicionarCoresProduto("preto, branco, Amarelo")
                .submeterFormularioDeAdicaoComSucesso()
                .capturarMensagemApresentadaDeSucesso();

        Assertions.assertEquals("Produto adicionado com sucesso",mensagemApresentada);

    }

    @Test
    @DisplayName("Validar o sucesso na inclusão de um novo produto com valor de 7000,00 ")
    public void testInclusaoDeProdutoComValorDeSeteMil(){
        String mensagemApresentada = new LoginPage(navegador)
                .informarOUsuario("admin")
                .informarASenha("admin")
                .submeterFormularioDeLogin()
                .adicionarProduto()
                .adicionarNomeProduto("Ar condicionado")
                .adicionarValorProduto("700000")
                .adicionarCoresProduto("branco")
                .submeterFormularioDeAdicaoComSucesso()
                .capturarMensagemApresentadaDeSucesso();
        Assertions.assertEquals("Produto adicionado com sucesso",mensagemApresentada);
    }


    @AfterEach
    public void afterEach(){
        //Vou fechar o navegador
        navegador.quit();
    }
}
