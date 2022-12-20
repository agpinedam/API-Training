package helpers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GetSystemVariables {
    private String userName;
    private String password;
    private final Logger log = LoggerFactory.getLogger(GetSystemVariables.class);

    public GetSystemVariables() {
        setUserName();
        setPassword();
    }

    public String getUserName() {
        return userName;
    }

    private void setPassword() {
        this.password = System.getenv("password");
        isVariableNull(this.password, "password");
    }

    public String getPassword() {
        return password;
    }

    private void setUserName() {
        this.userName= System.getenv("username");
        isVariableNull(this.userName, "username");
    }

    private void isVariableNull(String variable, String variableName){
        if(variable == null){
            log.warn("The value of the system environment variable "+ variableName +" is null");
        }else {
            log.debug("The variable "+ variableName + "was found");
        }
    }
}
