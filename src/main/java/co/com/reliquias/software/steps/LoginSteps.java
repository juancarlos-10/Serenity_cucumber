package co.com.reliquias.software.steps;

import co.com.reliquias.software.pages.interacciones.MainPageInteraction;
import co.com.reliquias.software.pages.mapeos.LoginPage;
import co.com.reliquias.software.pages.mapeos.MainPage;
import net.thucydides.core.annotations.Step;
import org.fluentlenium.core.annotation.Page;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

public class LoginSteps {

    private static final Logger LOGGER = LoggerFactory.getLogger(LoginSteps.class);

    @Page
    private MainPage mainPage;

    @Page
    private LoginPage loginPage;


    @Page
    private MainPageInteraction mainPageInteraction;

    @Step("User open login page")
    public void openLoginPage(){
        loginPage.open();
        LOGGER.info("User open login page");
    }

    @Step("clear user and password fields")
    public void clearFieldSLogin(){
        loginPage.inputUserName.type("");
        loginPage.inputPassword.type("");

    }

    @Step("enter credentials")
    public void enterCredentials(String username, String password){
        loginPage.inputUserName.type(username);
        loginPage.inputPassword.type(password);
        LOGGER.atInfo().setMessage("enter credentials con username:{} and password:{}").addArgument(username).addArgument(password).log();
    }

    @Step("access to system")
    public void accessSystem(){
//        loginPage.btnLogin.waitUntilClickable().click();
        loginPage.getButtonByText("Sign In").waitUntilClickable().click();
    }

    @Step("validate successful login")
    public void validateSuccessfulLogin(){
        final String mensajeError = "Login was unsuccessful";
        assertThat(mensajeError, mainPageInteraction.getTitleMainPage(), is(equalTo("Dashboard")));
        mainPageInteraction.scrollToElement(mainPage.getButtonByText("Add"));
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

}
