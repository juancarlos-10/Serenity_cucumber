package co.com.reliquias.software.definitions;

import co.com.reliquias.software.models.ProfileModel;
import co.com.reliquias.software.pages.mapeos.wappi.LoginWappiPage;
import co.com.reliquias.software.steps.LoginWappiSteps;
import co.com.reliquias.software.steps.UpdateProfileWappiSteps;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.DataTableType;
import io.cucumber.java.Transpose;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Map;

public class UpdateProfileDefinitions {

    private static final Logger LOGGER = LoggerFactory.getLogger(UpdateProfileDefinitions.class);
    @Steps
    private LoginWappiSteps loginWappiSteps;

    @Steps
    private UpdateProfileWappiSteps updateProfileWappiSteps;

    @Dado("que el usuario inicia sesión con las credenciales")
    public void IniciaSesion(@Transpose DataTable dataTable) {
        Map<String, String> informacionIniciarSesion = dataTable.asMap();
        informacionIniciarSesion.forEach((key, value)->LOGGER.info("k:{}, v:{}", key, value));

        loginWappiSteps.openLoginPage();
        loginWappiSteps.enterCredentials(informacionIniciarSesion.get("usuario"), informacionIniciarSesion.get("claveAcceso"));
        loginWappiSteps.accessSystem();
        loginWappiSteps.validateSuccessfulLogin();

    }

    @Cuando("actualiza la información del perfil")
//    public void actualizaLaInformaciónPerfil(@Transpose Map<String, String> informacionPerfil) {
    public void actualizaLaInformaciónPerfil(@Transpose ProfileModel informacionPerfil) {
        LOGGER.info("Inicia la actualizacion del perfil");
        //informacionPerfil.forEach((key, value)->LOGGER.info("k:{}, v:{}", key, value));
        LOGGER.info(informacionPerfil.toString());
        updateProfileWappiSteps.goToUpdateProfileForm();
        updateProfileWappiSteps.updateInformation(informacionPerfil);
    }

    @Entonces("debería ver el mensaje")
    public void validarActualizacionExitosa(List<String> mensajesEsperados) {
        LOGGER.info(mensajesEsperados.toString());
        updateProfileWappiSteps.validarActualizacion(mensajesEsperados);
    }

    @DataTableType
    public ProfileModel defineProfileModel(@Transpose Map<String, String> entry){
        return new ProfileModel(
                entry.get("nombre"),
                entry.get("apellido"),
                entry.get("fechaNacimiento"),
                entry.get("pais"),
                entry.get("genero")
        );
    }
}
