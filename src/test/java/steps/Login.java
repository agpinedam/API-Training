package steps;

import helpers.GetSystemVariables;
import io.cucumber.java.en.Given;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Login {
    private GetSystemVariables getSystemVariables = new GetSystemVariables();
    private Logger log = LoggerFactory.getLogger(Login.class);
    @Given("I have the credentials")
    public void iHaveTheCredentials() {
        String userName = getSystemVariables.getUserName();
        log.debug("Get username");
        String password = getSystemVariables.getPassword();
        log.debug("Get password");
    }
}
