package campoDeTreinamento.core;

import org.junit.After;
import org.junit.Rule;
import org.junit.rules.TestName;

import java.io.IOException;

import static campoDeTreinamento.core.DriverFactory.killDriver;

public class BaseTeste {
    @Rule
    public TestName testeNome = new TestName();
    @After
    public void finaliza() throws IOException {

        /*TakesScreenshot screenshot = (TakesScreenshot) getDriver();
        File arquivo = screenshot.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(arquivo, new File("target" + File.separator + "screenshot" +
                File.separator + testeNome.getMethodName() + ".jpg"));*/

        killDriver();

        /*if (Propriedades.FEHCHAR_BROWSER) {
            killDriver();
        }*/
    }
}
