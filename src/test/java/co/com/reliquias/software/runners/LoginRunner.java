package co.com.reliquias.software.runners;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/features/login/inicio_sesion.feature",
        glue = "co.com.reliquias.software.definitions",//POM
        //glue = "co.com.reliquias.software.stepdefinitions",//SCREAMPLAY
        snippets = CucumberOptions.SnippetType.CAMELCASE, //navegarPaginaWWeb
        plugin = "pretty",
        tags = "@InicioSesionExitoso"
)
public class LoginRunner {
}