package co.com.reliquias.software.pages.mapeos;

import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.interactions.Actions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GeneralPage extends PageObject {

    private final static Logger LOGGER = LoggerFactory.getLogger(LoginPage.class);


        public WebElementFacade getButtonByText(String buttonText){
        LOGGER.info("Se busca elemento web tipo button con el texto:{}",buttonText);
        return element( String.format("//button[contains(text(),'%s')]", buttonText));
    }
}
