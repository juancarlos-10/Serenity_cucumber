package co.com.reliquias.software.runners;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/features/update_profile/actualizar_perfil.feature",
        glue = "co.com.reliquias.software.definitions",//POM
        snippets = CucumberOptions.SnippetType.CAMELCASE, //navegarPaginaWWeb
        plugin = "pretty",
        tags = "@ActualizarProfileBasico"
)
public class UpdateProfileRunner {
}