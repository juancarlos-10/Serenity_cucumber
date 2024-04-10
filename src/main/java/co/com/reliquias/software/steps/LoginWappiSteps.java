package co.com.reliquias.software.steps;

import co.com.reliquias.software.pages.interacciones.GeneralInteraction;
import co.com.reliquias.software.pages.interacciones.MainPageInteraction;
import co.com.reliquias.software.pages.mapeos.LoginPage;
import co.com.reliquias.software.pages.mapeos.MainPage;
import co.com.reliquias.software.pages.mapeos.wappi.LoginWappiPage;
import co.com.reliquias.software.pages.mapeos.wappi.MainWappiPage;
import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Step;
import org.fluentlenium.core.annotation.Page;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

public class LoginWappiSteps {

    private static final Logger LOGGER = LoggerFactory.getLogger(LoginWappiSteps.class);
    private static final String URL_INICIO_SESION = "https://automation-wappi.vercel.app/login";

    @Page
    private LoginWappiPage loginWappiPage;

    @Page
    private MainWappiPage mainWappiPage;
    @Page
    private GeneralInteraction generalInteraction;


    @Step("User open login page")
    public void openLoginPage(){
        generalInteraction.openPage(URL_INICIO_SESION);
        LOGGER.info("User open login page");
    }



    @Step("enter credentials")
    public void enterCredentials(String username, String password){
        Serenity.setSessionVariable("username").to(username);
        Serenity.setSessionVariable("password").to(password);
        loginWappiPage.inputUserName.type(username);
        loginWappiPage.inputPassword.type(password);
        LOGGER.atInfo().setMessage("enter credentials con username:{} and password:{}").addArgument(username).addArgument(password).log();
    }

    @Step("access to system")
    public void accessSystem(){
//        loginPage.btnLogin.waitUntilClickable().click();
        loginWappiPage.btnLogin.waitUntilClickable().click();
    }

    @Step("validate successful login")
    public void validateSuccessfulLogin(){
        final String mensajeError = "Login was unsuccessful";
        String username = Serenity.sessionVariableCalled("username");
        String password = Serenity.sessionVariableCalled("password");
        assertThat(mensajeError, mainWappiPage.txtTitleMainPage.waitUntilVisible().getText(), is(equalTo("Ofertas")));
        LOGGER.info("Sesion con usuario '{}' y contraseña '{}'",username, password);

    }

}
