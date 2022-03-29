package campoDeTreinamento.suiteDeTestes;

import campoDeTreinamento.testes.CampoDeTreinamento;
import campoDeTreinamento.testes.TestesDeRegraDeNegocio;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        CampoDeTreinamento.class,
        TestesDeRegraDeNegocio.class
})
public class SuiteDeTestes {

   /* @AfterClass
    public static void FinalizaTudo(){
        DriverFactory.killDriver();
    }*/
}
